package com.kodlamaio.bootCampProject.business.requests.applicant;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicantRequest{
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	@Size(min = 11, max = 11, message = "national identity must be 11 numbers")
	private String nationalIdentity;
	@Email
	private String email;
	private String password;
	private String about;
}
