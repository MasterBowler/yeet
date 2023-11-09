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
@Table(name = "highschool_professor_report")
public class HighschoolProfessorReport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_hs_professor_report_to_report"))
	private Report report;

	@Column(name = "month")
	private String month;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_hs_professor_report_to_hs_professor"))
	private HighschoolProfessor highschoolProfessor;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_hs_professor_report_to_class"))
	private Class className;

	public HighschoolProfessorReport() {

		//
	}

	public HighschoolProfessorReport(Report report, String month, HighschoolProfessor highschoolProfessor, Class className) {

		this.highschoolProfessor = highschoolProfessor;
		this.report = report;
		this.month = month;
		this.className = className;
	}

	public long getId() {

		return id;
	}

	public Report getReport() {

		return report;
	}

	public void setReport(Report report) {

		this.report = report;
	}

	public String getMonth() {

		return month;
	}

	public void setMonth(String month) {

		this.month = month;
	}

	public HighschoolProfessor getHighschoolProfessor() {

		return highschoolProfessor;
	}

	public void setHighschoolProfessor(HighschoolProfessor highschoolProfessor) {

		this.highschoolProfessor = highschoolProfessor;
	}

	public Class getClassName() {

		return className;
	}

	public void setClassName(Class className) {

		this.className = className;
	}
}
