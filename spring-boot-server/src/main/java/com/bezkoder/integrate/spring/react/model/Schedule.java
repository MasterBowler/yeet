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
@Table(name = "schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_schedule_to_class"))
	private Class className;

	@Column(name = "start_date_and_time")
	private Date startDateAndTime;

	@Column(name = "end_date_and_time")
	private Date endDateAndTime;

	@Column(name = "description")
	private String description;

	public Schedule() {

		//
	}

	public Schedule(Class className, Date startDateAndTime, Date endDateAndTime, String description) {

		this.className = className;
		this.startDateAndTime = startDateAndTime;
		this.endDateAndTime = endDateAndTime;
		this.description = description;
	}

	public long getId() {

		return id;
	}

	public Class getClassName() {

		return className;
	}

	public void setClassName(Class className) {

		this.className = className;
	}

	public Date getStartDateAndTime() {

		return startDateAndTime;
	}

	public void setStartDateAndTime(Date startDateAndTime) {

		this.startDateAndTime = startDateAndTime;
	}

	public Date getEndDateAndTime() {

		return endDateAndTime;
	}

	public void setEndDateAndTime(Date endDateAndTime) {

		this.endDateAndTime = endDateAndTime;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}
}