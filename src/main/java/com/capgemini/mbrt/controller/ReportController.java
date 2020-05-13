package com.capgemini.mbrt.controller;

import com.capgemini.mbrt.exception.ReportFoundException;
import com.capgemini.mbrt.exception.ReportNotFoundException;
import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/mbrt")
public class ReportController {
	private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

	@Autowired
    ReportService reportService;
	
	@GetMapping("/getReportsByMonthYear/{month}/{year}")
	public List<Report> getReportsByMonthYear(@PathVariable("month") int month, @PathVariable("year") int year) {
		logger.info("Inside getReportsByMonthYear year Controller");
		return reportService.getReportsByMonthYear(month,year);
	}

	@GetMapping("/getReportsBetweenDates")
	public List<Report> getReportsBetweenDates(@RequestParam("startDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate endDate) {
		logger.info("Inside getReportsBetweenDates method Started{} {} ",startDate,endDate);
		return reportService.getReportsBetweenDates(startDate,endDate);
	}

	@PostMapping("/createReport")
	 public  ResponseEntity<String> creatreReport(@Valid @RequestBody Report newReport) throws ReportFoundException {
		logger.info("Inside createReport Controller");
		Optional<Report> existReport = reportService.findReportOfCurrentMonthByCreatedBy(newReport.getCreatedBy());
		if(existReport.isPresent())
		        throw  new ReportFoundException("You have already created report for Current month");
		logger.info("Report found :{}",existReport);
		reportService.createReport(newReport);
         return ResponseEntity.ok("Report created Successfully");
	}

	@PutMapping("/updateReport/{id}")
	public ResponseEntity <Report> updateReport(@PathVariable(value = "id") Long reportId, @Valid @RequestBody Report report) throws ReportNotFoundException {
		logger.info("Inside updateReport Controller");
		Report oldreport =
			reportService.findReortById(reportId).orElseThrow(() -> new
					ReportNotFoundException("Report id is not valid : "+reportId));
		report.setReportId(reportId);
		reportService.updateReport(report);
		return ResponseEntity.ok(report);
	}

	@GetMapping("/getReport/{id}")
	public ResponseEntity<Report> getReportById(@PathVariable(value = "id") Long reportId)throws ReportNotFoundException {
		logger.info("Inside getReport Controller");
		Report report = reportService.findReortById(reportId).orElseThrow(()-> new ReportNotFoundException("Report id is not valid : "+reportId ));
		return ResponseEntity.ok().body(report);
	}

	@DeleteMapping("/deleteReport/{id}")
	public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long reportId) throws ReportNotFoundException {
		  logger.info("Inside deleteReport Controller");
		Report report1 =  reportService.findReortById(reportId) .orElseThrow(() -> new
	  	ReportNotFoundException("Report id is not valid : "+reportId));
		  reportService.deleteReport(report1);
		  Map< String, Boolean > response = new HashMap< >();
		  response.put("deleted", Boolean.TRUE); return response;
	}
}
