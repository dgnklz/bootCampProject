package com.kodlamaio.bootCampProject.business.responses.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
	private int userId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String nationalIdentity;
	private String email;
	private String password;
	private String position;
}
