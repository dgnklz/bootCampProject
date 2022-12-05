package com.kodlamaio.bootCampProject.api.controllers.users;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootCampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	@GetMapping("/get/getAll")
	DataResult<List<GetAllEmployeeResponse>> getAll() {
		return employeeService.getAll();
	}
	@PostMapping("/add")
	DataResult<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest createRequest) {
		return employeeService.add(createRequest);
	}
	@PutMapping("/update")
	DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateRequest) {
		return employeeService.update(updateRequest);
	}
	@DeleteMapping("/delete/{id}")
	Result delete(@PathVariable int id) {
		return employeeService.delete(id);
	}
	@GetMapping("/get/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return employeeService.getById(id);
	}
}
