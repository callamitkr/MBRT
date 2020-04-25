package com.capgemini.mbrt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="REPORTS")
public class Report {
	@Id
    @GeneratedValue
	private Long reportId;
	@Column(name="project_Name")
	@NotEmpty(message = "Project name must not be empty")
	private String projectName;
	@Column(name="project_Desc")
	private String projectDesc;

	@Column(name="bu")
	@NotEmpty(message = "BU must not be empty")
	private String bu;
	@Column(name="phase")
	@NotEmpty(message = "Phase must not be empty")
	private String phase;

	public Report(Long reportId, @NotEmpty(message = "Project name must not be empty") String projectName, String projectDesc, @NotEmpty(message = "BU must not be empty") String bu, @NotEmpty(message = "Phase must not be empty") String phase) {
		this.reportId = reportId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.bu = bu;
		this.phase = phase;
	}

	public Long getReportId() {
		return reportId;
	}
	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", projectName=" + projectName + ", projectDesc=" + projectDesc
				+ ", bu=" + bu + ", phase=" + phase + "]";
	}
	
	
	

}
