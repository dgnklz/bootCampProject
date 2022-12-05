package com.kodlamaio.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface ApplicantService {
	DataResult<List<GetAllApplicantResponse>> getAll();
	DataResult<CreateApplicantResponse> add(CreateApplicantRequest createRequest);
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateRequest);
	Result delete(int id);
	DataResult<GetApplicantResponse> getById(int id);
}