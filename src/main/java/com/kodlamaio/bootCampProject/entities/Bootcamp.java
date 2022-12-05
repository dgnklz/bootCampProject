package com.kodlamaio.bootCampProject.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.kodlamaio.bootCampProject.entities.applications.Application;
import com.kodlamaio.bootCampProject.entities.constants.BootcampState;
import com.kodlamaio.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bootcamps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bootcamp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="instructorId")
	private Instructor instructor;
	
	@Column(name = "dateStart")
	private LocalDate dateStart;
	
	@Column(name = "dateEnd")
	private LocalDate dateEnd;
	
	@ManyToOne
	@JoinColumn(name="bootcampStateId")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private BootcampState state;
	
	@OneToMany(mappedBy = "bootcamp")
	private List<Application> applications;
}

/*
private int id;
private String name;
private int instructorId;
private LocalDate dateStart;
private LocalDate dateEnd;
private int stateId;
*/