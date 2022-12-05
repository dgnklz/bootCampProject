package com.kodlamaio.bootCampProject.entities.evaluations;

import java.time.LocalDate;

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

import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blacklists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blacklist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "applicantId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Applicant applicant;
	
	@Column(name = "reason")
	private String reason;
	
	@Column(name = "date")
	private LocalDate Date;
}

/*
int id;
int applicantId;
String reason;
LocalDate date;
*/