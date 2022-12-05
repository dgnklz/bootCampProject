package com.kodlamaio.bootCampProject.business.concretes.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.users.EmployeeService;
import com.kodlamaio.bootCampProject.business.constants.users.MessagesForEmployee;
import com.kodlamaio.bootCampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.users.EmployeeRepository;
import com.kodlamaio.bootCampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<GetAllEmployeeResponse> employeeResponses = employees.stream()
				.map(employee -> modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(employeeResponses);
	}

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createRequest) {
		checkIfEmployeeExistsByNationalId(createRequest.getNationalIdentity());
		Employee employee = modelMapperService.forRequest().map(createRequest, Employee.class);
		employeeRepository.save(employee);
		CreateEmployeeResponse employeeResponse = modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(employeeResponse, MessagesForEmployee.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateRequest) {
		checkIfEmployeeExistById(updateRequest.getUserId());
		Employee employee = modelMapperService.forRequest().map(updateRequest, Employee.class);
		employeeRepository.save(employee);
		UpdateEmployeeResponse employeeResponse = modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(employeeResponse, MessagesForEmployee.EmployeeUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfEmployeeExistById(id);
		Employee employee = employeeRepository.findById(id).get();
		employeeRepository.delete(employee);
		return new SuccessResult(MessagesForEmployee.EmployeeDeleted);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		checkIfEmployeeExistById(id);
		Employee employee = employeeRepository.findById(id).get();
		GetEmployeeResponse employeeResponse = modelMapperService.forResponse().map(employee,
				GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(employeeResponse);
	}

	/// Domain Rules \\\

	private void checkIfEmployeeExistsByNationalId(String nationalId) {
		Employee checkEmployee = employeeRepository.findByNationalIdentity(nationalId);
		if (checkEmployee != null) {
			throw new BusinessException(MessagesForEmployee.EmployeeExistsByNationalIdentity);
		}
	}

	private void checkIfEmployeeExistById(int id) {
		if (!employeeRepository.existsById(id)) {
			throw new BusinessException(MessagesForEmployee.EmployeeDoesNotExistById);
		}
	}
	
}
