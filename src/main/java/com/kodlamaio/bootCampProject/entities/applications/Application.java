package com.kodlamaio.bootCampProject.entities.applications;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.kodlamaio.bootCampProject.entities.Bootcamp;
import com.kodlamaio.bootCampProject.entities.constants.ApplicationState;
import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name="bootcampId")
	@OnDelete (action = OnDeleteAction.CASCADE)
	private Bootcamp bootcamp;
	
	@ManyToOne
	@JoinColumn(name="applicationStateId")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private ApplicationState state;
}

/*
private int id;
private int applicantId;
private int bootcampId;
private int stateId;
*/