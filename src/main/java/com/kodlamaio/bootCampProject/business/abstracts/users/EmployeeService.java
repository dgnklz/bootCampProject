package com.kodlamaio.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface EmployeeService {
	DataResult<List<GetAllEmployeeResponse>> getAll();
	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createRequest);
	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateRequest);
	Result delete(int id);
	DataResult<GetEmployeeResponse> getById(int id);
}
