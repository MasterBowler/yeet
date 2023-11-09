package com.bezkoder.integrate.spring.react.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_report")
public class StudentReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "transportation_means")
	private String transportationMeans;

	@Column(name = "month")
	private String month;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_student_report_to_student"))
	private Student student;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_student_report_to_report"))
	private Report report;

	public StudentReport() {

		//
	}

	public StudentReport(Student student, Report report) {

		this.student = student;
		this.report = report;
	}

	public long getId() {

		return id;
	}

	public String getTransportationMeans() {

		return transportationMeans;
	}

	public void setTransportationMeans(String transportationMeans) {

		this.transportationMeans = transportationMeans;
	}

	public String getMonth() {

		return month;
	}

	public void setMonth(String month) {

		this.month = month;
	}

	public Report getReport() {

		return report;
	}

	public void setReport(Report report) {

		this.report = report;
	}

	public Student getStudent() {

		return student;
	}

	public void setStudent(Student student) {

		this.student = student;
	}
}
