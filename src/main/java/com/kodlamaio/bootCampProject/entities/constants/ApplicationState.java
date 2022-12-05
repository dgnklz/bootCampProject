package com.kodlamaio.bootCampProject.entities.constants;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootCampProject.entities.applications.Application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aplicationStates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	int id;
	
	@Column(name = "applicationStateName")
	private String applicationStateName;
	
	@OneToMany(mappedBy = "state")
	private List<Application> aplications;
}
