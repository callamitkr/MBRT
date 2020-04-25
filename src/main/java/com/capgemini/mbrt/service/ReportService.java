package com.capgemini.mbrt.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.mbrt.model.Report;

public interface ReportService {
	
	List<Report>geAallgetReports();
	Report createReport(Report report);
	Report updateReport(Report report);
	Optional<Report> findReortById(Long reportId);
    void deleteReport(Report report);
}
