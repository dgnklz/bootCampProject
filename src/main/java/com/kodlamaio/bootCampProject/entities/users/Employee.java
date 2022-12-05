package com.kodlamaio.bootCampProject.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
	@Column(name = "position")
	private String position;
}

/*
private int userId;
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
private String nationalIdentity;
private String email;
private String password;
private String position;
*/