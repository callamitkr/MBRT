package com.capgemini.mbrt.model;


import java.time.LocalDate;

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
	@Column(name="projectName")
	@NotEmpty(message = "Project name must not be empty")
	private String projectName;
	@Column(name="projectDesc")
	private String projectDesc;
	@Column(name="barclaysPm")
    private String barclaysPm;
	@Column(name="bu")
	@NotEmpty(message = "BU must not be empty")
	private String bu;
	@Column(name="phase")
	@NotEmpty(message = "Phase must not be empty")
	private String phase;
	@Column(name="keyMilestone")
	@NotEmpty(message = "Key Milestone must not be empty")
	private String keyMilestone;
	@Column(name="keyHighlights")
	@NotEmpty(message = "Key Highlights must not be empty")
	private String keyHighlights;
	@Column(name="barclaysFeedback")
	@NotEmpty(message = "Barclays Feedback must not be empty")
	private String 	barclaysFeedback;
	@Column(name="issueRoadblock")
	@NotEmpty(message = "Issue Roadblock must not be empty")
	private String issueRoadblock;
	@Column(name="createdBy")
	@NotEmpty(message = "Created By must not be empty")
	private String createdBy;
	@Column(name="createdDate")
	private LocalDate createdDate;
	public Report(){

	}

	public Report(Long reportId, String projectName, String projectDesc, String barclaysPm, String bu, String phase, String keyMilestone, String keyHighlights, String barclaysFeedback, String issueRoadblock, String createdBy, LocalDate createdDate) {
		this.reportId = reportId;
		this.projectName = projectName;
		this.projectDesc = projectDesc;
		this.barclaysPm = barclaysPm;
		this.bu = bu;
		this.phase = phase;
		this.keyMilestone = keyMilestone;
		this.keyHighlights = keyHighlights;
		this.barclaysFeedback = barclaysFeedback;
		this.issueRoadblock = issueRoadblock;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
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

	public String getBarclaysPm() {
		return barclaysPm;
	}

	public void setBarclaysPlPm(String barclaysPm) {
		this.barclaysPm = barclaysPm;
	}

	public String getKeyMilestone() {
		return keyMilestone;
	}

	public void setKeyMileStoneGag(String keyMilestone) {
		this.keyMilestone = keyMilestone;
	}

	public String getKeyHighlights() {
		return keyHighlights;
	}

	public void setKeyHighlights(String keyHighlights) {
		this.keyHighlights = keyHighlights;
	}

	public String getBarclaysFeedback() {
		return barclaysFeedback;
	}

	public void setBarclaysFeedback(String barclaysFeedback) {
		this.barclaysFeedback = barclaysFeedback;
	}

	public String getIssueRoadblock() {
		return issueRoadblock;
	}

	public void setIssueRoadBlock(String issueRoadblock) {
		this.issueRoadblock = issueRoadblock;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Report{" +
				"reportId=" + reportId +
				", projectName='" + projectName + '\'' +
				", projectDesc='" + projectDesc + '\'' +
				", barclaysPlPm='" + barclaysPm + '\'' +
				", bu='" + bu + '\'' +
				", phase='" + phase + '\'' +
				", keyMileStoneGag='" + keyMilestone + '\'' +
				", keyHighlights='" + keyHighlights + '\'' +
				", barclaysFeedback='" + barclaysFeedback + '\'' +
				", issueRoadBlock='" + issueRoadblock + '\'' +
				", createdBy='" + createdBy + '\'' +
				", createdDate=" + createdDate +
				'}';
	}
}
