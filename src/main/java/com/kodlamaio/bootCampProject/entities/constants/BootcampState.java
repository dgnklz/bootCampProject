package com.kodlamaio.bootCampProject.entities.constants;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootCampProject.entities.Bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bootcampStates")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootcampState {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	int id;
	
	@Column(name = "bootcampStateName")
	private String bootcampStateName;
	
	@OneToMany(mappedBy = "state")
	private List<Bootcamp> bootcamps;
}
