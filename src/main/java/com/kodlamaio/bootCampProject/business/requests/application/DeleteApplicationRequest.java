package com.kodlamaio.bootCampProject.business.requests.application;

import com.kodlamaio.bootCampProject.entities.constants.ApplicationState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicationRequest {
	private int id;
	private int applicantId;
	private int bootcampId;
	private ApplicationState state;
}
