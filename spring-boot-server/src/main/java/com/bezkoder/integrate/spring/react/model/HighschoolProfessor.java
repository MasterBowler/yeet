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
@Table(name = "highschool_professor")
public class HighschoolProfessor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_hs_professor_to_user"))
	private User user;

	@Column(name = "highschool_name")
	private String highschoolName;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "teaching_degree")
	private String teachingDegree;

	public HighschoolProfessor() {

		//
	}

	public HighschoolProfessor(User user, String highschoolName, Date startDate, String teachingDegree) {

		this.user = user;
		this.highschoolName = highschoolName;
		this.startDate = startDate;
		this.teachingDegree = teachingDegree;
	}

	public long getId() {

		return id;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public User getUser() {

		return user;
	}

	public String getHighschoolName() {

		return highschoolName;
	}

	public void setHighschoolName(String highschoolName) {

		this.highschoolName = highschoolName;
	}

	public Date getStartDate() {

		return startDate;
	}

	public void setStartDate(Date startDate) {

		this.startDate = startDate;
	}

	public String getTeachingDegree() {

		return teachingDegree;
	}

	public void setTeachingDegree(String teachingDegree) {

		this.teachingDegree = teachingDegree;
	}
}
