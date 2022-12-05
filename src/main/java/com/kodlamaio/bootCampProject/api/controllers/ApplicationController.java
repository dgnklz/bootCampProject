package com.kodlamaio.bootCampProject.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootCampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	private ApplicationService applicationService;

	@GetMapping("/get/getAll")
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		return applicationService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest createRequest) {
		return applicationService.add(createRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest updateRequest) {
		return applicationService.update(updateRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return applicationService.delete(id);
	}

	@GetMapping("/get/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return applicationService.getById(id);
	}
}
