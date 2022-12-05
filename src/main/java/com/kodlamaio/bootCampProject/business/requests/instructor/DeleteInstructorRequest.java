package com.kodlamaio.bootCampProject.business.requests.instructor;

import lombok.Data;

@Data
public class DeleteInstructorRequest{
	private int userId;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
}
