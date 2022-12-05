package com.kodlamaio.bootCampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootCampProject.entities.applications.Application;
import com.kodlamaio.bootCampProject.entities.evaluations.Blacklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {
	@Column(name = "about")
	private String about;
	
	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "applicant")
	private List<Blacklist> blacklists;
}

/*
private int userId;
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
private String nationalIdentity;
private String email;
private String password;
private String about;
*/