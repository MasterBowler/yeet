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
@Table(name = "highschool_professor_report_details")
public class HighschoolProfessorReportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "criterion_number")
	private String criterionNumber;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_highschool_professor_report_details_to_student"))
	private Student student;

	@Column(name = "date")
	private Date date;

	@Column(name = "classes")
	private String classes;

	@Column(name = "teaching_project")
	private String teachingProject;

	@Column(name = "portfolio")
	private String portofolio;

	@Column(name = "workshop")
	private String workshop;

	@Column(name = "extracurriculars")
	private String extracurriculars;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_hs_professor_report_details_to_hs_professor_report"))
	private HighschoolProfessorReport highschoolProfessorReport;

	public HighschoolProfessorReportDetails() {

		//
	}

	public HighschoolProfessorReportDetails(String criterionNumber, Student student, Date date, HighschoolProfessorReport highschoolProfessorReport) {

		this.criterionNumber = criterionNumber;
		this.student = student;
		this.date = date;
		this.highschoolProfessorReport = highschoolProfessorReport;
	}

	public long getId() {

		return id;
	}

	public String getCriterionNumber() {

		return criterionNumber;
	}

	public void setCriterionNumber(String criterionNumber) {

		this.criterionNumber = criterionNumber;
	}

	public Student getStudent() {

		return student;
	}

	public void setStudent(Student student) {

		this.student = student;
	}

	public Date getDate() {

		return date;
	}

	public void setDate(Date date) {

		this.date = date;
	}

	public String getClasses() {

		return classes;
	}

	public void setClasses(String classes) {

		this.classes = classes;
	}

	public String getTeachingProject() {

		return teachingProject;
	}

	public void setTeachingProject(String teachingProject) {

		this.teachingProject = teachingProject;
	}

	public String getPortofolio() {

		return portofolio;
	}

	public void setPortofolio(String portofolio) {

		this.portofolio = portofolio;
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

	public HighschoolProfessorReport getHighschoolProfessorReport() {

		return highschoolProfessorReport;
	}

	public void setHighschoolProfessorReport(HighschoolProfessorReport highschoolProfessorReport) {

		this.highschoolProfessorReport = highschoolProfessorReport;
	}
}
