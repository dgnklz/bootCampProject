package com.kodlamaio.bootCampProject.business.requests.applicant;

import lombok.Data;

@Data
public class DeleteApplicantRequest{
	private int userId;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
}