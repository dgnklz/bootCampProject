package com.kodlamaio.bootCampProject.business.requests.employee;

import lombok.Data;

@Data
public class DeleteEmployeeRequest{
	private int userId;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
}
