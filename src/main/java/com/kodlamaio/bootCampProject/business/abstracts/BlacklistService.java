package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

public interface BlacklistService {
	DataResult<List<GetAllBlacklistResponse>> getAll();
	DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createRequest);
	DataResult<UpdateBlacklistResponse> update(UpdateBlacklistRequest updateRequest);
	Result delete(int id);
	DataResult<GetBlacklistResponse> getById(int id);
	DataResult<GetBlacklistResponse> getByApplicantId(int applicantId);
	
	/// Rules For External Requests \\\
	public void checkIfApplicantInBlacklistById(int id);
}
