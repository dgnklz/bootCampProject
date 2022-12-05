package com.kodlamaio.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface InstructorService {
	DataResult<List<GetAllInstructorResponse>> getAll();
	DataResult<CreateInstructorResponse> add(CreateInstructorRequest createRequest);
	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateRequest);
	Result delete(int id);
	DataResult<GetInstructorResponse> getById(int id);
}