package com.capgemini.mbrt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.mbrt.model.Report;

@Repository
public interface ReportRepository  extends JpaRepository<Report, Long> {
	 
	}


