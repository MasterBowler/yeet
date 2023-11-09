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
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "email_address")
	private String emailAddress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password_hash")
	private String passwordHash;

	@Column(name = "creation_date")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_to_user_group"))
	private UserGroup userGroup;

	public User() {

		//
	}

	public User(String emailAddress, String firstName, String lastName, String passwordHash, Date creationDate) {

		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
		this.creationDate = creationDate;
	}

	public long getId() {

		return id;
	}

	public String getEmailAddress() {

		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {

		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {

		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {

		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getPasswordHash() {

		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {

		this.passwordHash = passwordHash;
	}

	public Date getCreationDate() {

		return creationDate;
	}

	public void setCreationDate(Date creationDate) {

		this.creationDate = creationDate;
	}

	public UserGroup getUserGroup() {

		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {

		this.userGroup = userGroup;
	}
}