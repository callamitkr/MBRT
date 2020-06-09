package com.capgemini.mbrt.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.capgemini.mbrt.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.mbrt.exception.ReportFoundException;
import com.capgemini.mbrt.exception.ReportNotFoundException;
import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.service.ReportService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/mbrt")
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
	ReportService reportService;

	@GetMapping("/getReportsByMonthYear/{month}/{year}")
	public ResponseEntity<List<Report>> getReportsByMonthYear(@PathVariable("month") int month, @PathVariable("year") int year) {
		List<Report> listOfReport = new ArrayList<>();
		logger.info("Inside getReportsByMonthYear year Controller");
		listOfReport  = reportService.getReportsByMonthYear(month, year);
		return new ResponseEntity<>(listOfReport ,HttpStatus.OK);
	}

	@PostMapping("/createReport")
	public ResponseEntity<Response> creatreReport(@Validated @RequestBody Report newReport) throws ReportFoundException {
		logger.info("Inside createReport Controller");
		Optional<Report> existingReport = reportService.findReportOfCurrentMonthByCreatedBy(newReport.getCreatedBy());
		if (existingReport.isPresent()) {
			throw new ReportFoundException("You have already created report for Current month");
		}
		logger.info("Report found : {}", existingReport);
		Report saveReport = reportService.createReport(newReport);
		logger.info("Report saved with reportId : {}",saveReport.getReportId());
		return new ResponseEntity<>(new Response("Report Created", HttpStatus.CREATED),HttpStatus.CREATED);
	}

	@PutMapping("/updateReport")
	public ResponseEntity<Response> updateReport(@Validated @RequestBody Report report)
			throws ReportNotFoundException, ReportFoundException {
		logger.info("Inside updateReport Controller");
		Optional<Report> existingReport = reportService.findReportOfCurrentMonthByCreatedBy(report.getCreatedBy());
		if (existingReport.isPresent()) {
			report.setReportId(existingReport.get().getReportId());
			report.setCreatedDate(existingReport.get().getCreatedDate());
		} else {
			throw new ReportNotFoundException("You have not created report for current month");
		}
		reportService.updateReport(report);
		return new ResponseEntity<>(new Response("Report Created",HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);

	}


	@GetMapping("/getReport/{userId}")
	public ResponseEntity<Report> getReportByUserId(@PathVariable(value = "userId") String userId)
			throws ReportNotFoundException, ReportFoundException {
		logger.info("Inside getReportByUserId Controller");
		Report report = reportService.findReportOfCurrentMonthByCreatedBy(userId)
				.orElseThrow(() -> new ReportNotFoundException("You have not created report for current month"));
		return ResponseEntity.ok().body(report);
	}
}
