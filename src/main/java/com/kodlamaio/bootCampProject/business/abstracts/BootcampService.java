package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface BootcampService {
	DataResult<List<GetAllBootcampResponse>> getAll();
	DataResult<CreateBootcampResponse> add(CreateBootcampRequest createRequest);
	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateRequest);
	Result delete(int id);
	DataResult<GetBootcampResponse> getById(int id);
	public void checkIfBootcampActivated(int id);
}
