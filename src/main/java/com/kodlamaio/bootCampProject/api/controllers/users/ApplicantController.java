package com.kodlamaio.bootCampProject.api.controllers.users;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
	private ApplicantService applicantService;
	@GetMapping("/get/getAll")
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		return applicantService.getAll();
	}
	@PostMapping("/add")
	public DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest createRequest) {
		return applicantService.add(createRequest);
	}
	@PutMapping("/update")
	public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateRequest) {
		return applicantService.update(updateRequest);
	}
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return applicantService.delete(id);
	}
	@GetMapping("/get/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	}
}
