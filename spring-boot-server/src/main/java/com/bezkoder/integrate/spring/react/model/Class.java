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
@Table(name = "class")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_class_to_highschool_professor"))
	private HighschoolProfessor highschoolProfessor;

	@Column(name = "maximum_attendance")
	private int maximumAttendance;

	@Column(name = "current_attendance")
	private int currentAttendance;

	public Class() {

		//
	}

	public Class(String name, HighschoolProfessor highschoolProfessor, String description) {

		this.name = name;
		this.highschoolProfessor = highschoolProfessor;
		this.description = description;
	}

	public long getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public HighschoolProfessor getHighschoolProfessor() {

		return highschoolProfessor;
	}

	public void setHighschoolProfessor(HighschoolProfessor highschoolProfessor) {

		this.highschoolProfessor = highschoolProfessor;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public int getMaximumAttendance() {

		return maximumAttendance;
	}

	public void setMaximumAttendance(int maximumAttendance) {

		this.maximumAttendance = maximumAttendance;
	}

	public int getCurrentAttendance() {

		return currentAttendance;
	}

	public void setCurrentAttendance(int currentAttendance) {

		this.currentAttendance = currentAttendance;
	}
}

