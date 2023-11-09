package com.bezkoder.integrate.spring.react.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "report")
public class Report {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_from_report_to_user"))
	private User user;

	public Report() {

		//
	}

	public Report(User user) {

		this.user = user;
	}

	public long getId() {

		return id;
	}

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}
}
