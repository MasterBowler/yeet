package com.bezkoder.integrate.spring.react.model;

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
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "sid")
	private String sid;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_student_to_user"))
	private User user;

	@Column(name = "university_name")
	private String universityName;

	@Column(name = "degree_name")
	private String degreeName;

	@Column(name = "specialty_name")
	private String specialtyName;

	@Column(name = "year")
	private String year;

	@Column(name = "group_code")
	private String groupCode;

	public Student() {

		//
	}

	public Student(String sid, User user) {

		this.sid = sid;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {

		this.sid = sid;
	}

	public String getUniversityName() {

		return universityName;
	}

	public void setUniversityName(String universityName) {

		this.universityName = universityName;
	}

	public String getDegreeName() {

		return degreeName;
	}

	public void setDegreeName(String degreeName) {

		this.degreeName = degreeName;
	}

	public String getSpecialtyName() {

		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {

		this.specialtyName = specialtyName;
	}

	public String getYear() {

		return year;
	}

	public void setYear(String year) {

		this.year = year;
	}

	public String getGroupCode() {

		return groupCode;
	}

	public void setGroupCode(String groupCode) {

		this.groupCode = groupCode;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public User getUser() {

		return user;
	}
}
