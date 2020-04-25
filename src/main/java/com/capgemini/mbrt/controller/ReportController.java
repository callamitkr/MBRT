package com.capgemini.mbrt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.mbrt.exception.ReportNotFoundException;
import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.service.ReportService;

import javax.validation.Valid;

@RestController
@RequestMapping("/mbrt")
public class ReportController {
	
	@Autowired
    ReportService reportService;
	
	@GetMapping("/getAllreports")
	public List<Report> getAllReport() {
		return reportService.geAallgetReports();
	}

	@GetMapping("/getReport/{id}")
	public ResponseEntity<Report> getReportById(@PathVariable(value = "id") Long reportId)throws ReportNotFoundException {
		Report report = reportService.findReortById(reportId).orElseThrow(()-> new ReportNotFoundException("Report id is not valid : "+reportId ));
		return ResponseEntity.ok().body(report);
	}

	@PostMapping("/createReport")
	 public  Report creatreReport(@Valid @RequestBody Report report){
         return reportService.createReport(report);
	}

	@PutMapping("/updateReport/{id}")
	public ResponseEntity <Report> updateReport(@PathVariable(value = "id") Long reportId, @Valid @RequestBody Report report) throws ReportNotFoundException {
		Report report1 =
			reportService.findReortById(reportId) .orElseThrow(() -> new
					ReportNotFoundException("Report id is not valid : "+reportId));
		report.setReportId(reportId);
		reportService.updateReport(report);
		return ResponseEntity.ok(report);
	}


	  @DeleteMapping("/deleteReport/{id}")
	  public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long reportId) throws ReportNotFoundException {
		Report report1 =  reportService.findReortById(reportId) .orElseThrow(() -> new
	  	ReportNotFoundException("Report id is not valid : "+reportId));

		  reportService.deleteReport(report1);
		  Map< String, Boolean > response = new HashMap< >();
		  response.put("deleted", Boolean.TRUE); return response;
	}
}
