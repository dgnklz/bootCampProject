package com.kodlamaio.bootCampProject.business.requests.bootcamp;

import java.time.LocalDate;

import com.kodlamaio.bootCampProject.entities.constants.BootcampState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBootcampRequest {
	private int id;
	private String name;
	private int instructorId;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private BootcampState state;
}
