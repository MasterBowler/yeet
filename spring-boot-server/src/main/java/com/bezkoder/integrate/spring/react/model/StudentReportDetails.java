package com.bezkoder.integrate.spring.react.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_report_details")
public class StudentReportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "date")
	private Date date;

	@Column(name = "timeframe")
	private String timeframe;

	@Column(name = "assistance")
	private String assistance;

	@Column(name = "teaching_project")
	private String teachingProject;

	@Column(name = "class_teaching")
	private String classTeaching;

	@Column(name = "portfolio")
	private String portfolio;

	@Column(name = "workshop")
	private String workshop;

	@Column(name = "extracurriculars")
	private String extracurriculars;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_student_report_details_to_student_report"))
	private StudentReport studentReport;

	public StudentReportDetails() {

		//
	}

	public StudentReportDetails(Date date, String timeframe, StudentReport studentReport) {

		this.date = date;
		this.timeframe = timeframe;
		this.studentReport = studentReport;
	}

	public long getId() {

		return id;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public String getTimeframe() {

		return timeframe;
	}

	public void setTimeframe(String timeframe) {

		this.timeframe = timeframe;
	}

	public String getAssistance() {

		return assistance;
	}

	public void setAssistance(String assistance) {

		this.assistance = assistance;
	}

	public String getTeachingProject() {

		return teachingProject;
	}

	public void setTeachingProject(String teachingProject) {

		this.teachingProject = teachingProject;
	}

	public String getClassTeaching() {

		return classTeaching;
	}

	public void setClassTeaching(String classTeaching) {

		this.classTeaching = classTeaching;
	}

	public String getPortfolio() {

		return portfolio;
	}

	public void setPortfolio(String portfolio) {

		this.portfolio = portfolio;
	}

	public String getWorkshop() {

		return workshop;
	}

	public void setWorkshop(String workshop) {

		this.workshop = workshop;
	}

	public String getExtracurriculars() {

		return extracurriculars;
	}

	public void setExtracurriculars(String extracurriculars) {

		this.extracurriculars = extracurriculars;
	}

	public StudentReport getStudentReport() {

		return studentReport;
	}

	public void setStudentReport(StudentReport studentReport) {

		this.studentReport = studentReport;
	}
}
