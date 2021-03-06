package com.capgemini.mbrt.service;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.capgemini.mbrt.controller.ReportController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.repository.ReportRepository;
@Service
public class ReportSeviceImpl implements ReportService{
	private static final Logger logger = LoggerFactory.getLogger(ReportSeviceImpl.class);
	@Autowired
    ReportRepository repository;
	@Override
	public Report createReport(Report report) {
		 report.setCreatedDate(LocalDate.now());
		 return  repository.save(report);
	}

	@Override
	public Optional<Report> findReportOfCurrentMonthByCreatedBy(String userId) {
		return repository.findReportOfCurrentMonthByCreatedBy(userId);
	}

	@Override
	public Report updateReport(Report report) {
		return repository.save(report);
	}

	@Override
	public List<Report> getReportsByMonthYear(int month,int year) {
		return repository.getReportsByMonthYear(month,year);
	}

	@Override
	public List<Report> getReportsBetweenDates(LocalDate startDate, LocalDate endDate) {
		return repository.findByCreatedDateBetween(startDate,endDate);
	}

	@Override
	public Optional<Report> findReortById(Long reportId) {
		
		return repository.findById(reportId);
	}

	@Override
	public void deleteReport(Report report) {
		 repository.delete(report);
	}


}
