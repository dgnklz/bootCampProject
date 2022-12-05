package com.kodlamaio.bootCampProject.business.responses.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationResponse {
	private int applicantId;
	private int bootcampId;
	private int state;
}