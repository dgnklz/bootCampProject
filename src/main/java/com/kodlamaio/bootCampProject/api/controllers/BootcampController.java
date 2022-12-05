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

import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {
	private BootcampService bootcampService;

	@GetMapping("/get/getAll")
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		return bootcampService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest createRequest) {
		return bootcampService.add(createRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateBootcampResponse> update(@RequestBody UpdateBootcampRequest updateRequest) {
		return bootcampService.update(updateRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return bootcampService.delete(id);
	}

	@GetMapping("/get/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
		return bootcampService.getById(id);
	}
}
