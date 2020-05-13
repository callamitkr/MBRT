package com.capgemini.mbrt.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.capgemini.mbrt.exception.ReportFoundException;
import com.capgemini.mbrt.model.Report;

public interface ReportService {
	
	List<Report>getReportsByMonthYear(int month,int year);
	List<Report>getReportsBetweenDates(LocalDate startDate, LocalDate endDate);
	Report createReport(Report report);
	Optional<Report> findReportOfCurrentMonthByCreatedBy(String userId) throws ReportFoundException;
	Report updateReport(Report report);
	Optional<Report> findReortById(Long reportId);
    void deleteReport(Report report);
}
