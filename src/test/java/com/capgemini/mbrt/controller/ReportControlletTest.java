package com.capgemini.mbrt.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import java.time.LocalDate;
import java.util.Optional;

import com.capgemini.mbrt.bean.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.capgemini.mbrt.exception.ReportFoundException;
import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.service.ReportService;

@RunWith(MockitoJUnitRunner.class)

public class ReportControlletTest {
	
	@InjectMocks
    ReportController reportController;

	@Mock
	private ReportService reportService;
	
	@Test
	public void createReportTest() throws ReportFoundException {
		Report reportToCreate = new Report(123L,"Card control1", "card control desc1", "barclays1", "Bhavesh", "phase1",
				"succesfully deliverd", "report generation", "good", "no", "amit", LocalDate.now(), LocalDate.now());
		Report report = new Report(123L, "Card control1", "card control desc1", "barclays1", "Bhavesh", "phase1",
				"succesfully deliverd", "report generation", "good", "no", "amit", LocalDate.now(), LocalDate.now());
		
		Optional<Report> optionalReport = Optional.empty(); 
		when(reportService.findReportOfCurrentMonthByCreatedBy(reportToCreate.getCreatedBy())).thenReturn(optionalReport);
		ResponseEntity<Response> responseEntity = reportController.creatreReport(report);
        //assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		
	}

	@Test(expected = ReportFoundException.class)
	public void createReportWhenReportCreatedExistsbyUserTest() throws ReportFoundException {
		Report reportToCreate = new Report(123L,"Card control1", "card control desc1", "barclays1", "Bhavesh", "phase1",
				"succesfully deliverd", "report generation", "good", "no", "amit", LocalDate.now(), LocalDate.now());
		
		Optional<Report> optionalReport = Optional.of(reportToCreate); 

		when(reportService.findReportOfCurrentMonthByCreatedBy(reportToCreate.getCreatedBy())).thenReturn(optionalReport);

		ResponseEntity<Response> responseEntity = reportController.creatreReport(reportToCreate);
       
		
	}
	
}
