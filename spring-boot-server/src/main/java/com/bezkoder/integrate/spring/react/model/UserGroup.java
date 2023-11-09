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
@Table(name = "user_group")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_group_to_permission_set"))
	private PermissionSet permissionSet;

	public UserGroup() {

		//
	}

	public UserGroup(String name, PermissionSet permissionSet) {

		this.name = name;
		this.permissionSet = permissionSet;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public long getId() {

		return id;
	}

	public PermissionSet getPermissionSet() {

		return permissionSet;
	}

	public void setPermissionSet(PermissionSet permissionSet) {

		this.permissionSet = permissionSet;
	}
}

