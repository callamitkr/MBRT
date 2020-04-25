package com.capgemini.mbrt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.mbrt.model.Report;
import com.capgemini.mbrt.repository.ReportRepository;
@Service
public class ReportSeviceImpl implements ReportService{
	@Autowired
    ReportRepository repository;
	@Override
	public Report createReport(Report report) {
		return repository.save(report);
		
	}

	@Override
	public Report updateReport(Report report) {
		return repository.save(report);
	}

	@Override
	public List<Report> geAallgetReports() {
		
		return repository.findAll();
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
