package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface ApplicationService {
	DataResult<List<GetAllApplicationResponse>> getAll();
	DataResult<CreateApplicationResponse> add(CreateApplicationRequest createRequest);
	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateRequest);
	Result delete(int id);
	DataResult<GetApplicationResponse> getById(int id);
}
