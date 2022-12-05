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

import com.kodlamaio.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootCampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
	private InstructorService instructorService;

	@GetMapping("/get/getAll")
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		return instructorService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest createRequest) {
		return instructorService.add(createRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest updateRequest) {
		return instructorService.update(updateRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}

	@GetMapping("/get/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id) {
		return instructorService.getById(id);
	}
}