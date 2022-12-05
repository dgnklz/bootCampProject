package com.kodlamaio.bootCampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootCampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootCampProject.business.constants.MessagesForApplication;
import com.kodlamaio.bootCampProject.business.constants.users.MessagesForApplicant;
import com.kodlamaio.bootCampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.bootCampProject.entities.applications.Application;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationManager implements ApplicationService {
	private ApplicationRepository applicationRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;
	private BootcampService bootcampService;
	private BlacklistService blacklistService;

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Application> applications = applicationRepository.findAll();
		List<GetAllApplicationResponse> applicationResponses = applications.stream()
				.map(application -> modelMapperService.forResponse().map(applications, GetAllApplicationResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicationResponse>>(applicationResponses);
	}

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest createRequest) {
		checkIfBootcampActivated(createRequest.getBootcampId());
		checkIfApplicantAppliedBefore(createRequest.getApplicantId());
		checkIfApplicantExistsById(createRequest.getApplicantId());
		checkIfApplicantIsInBlacklist(createRequest.getApplicantId());
		checkIfBootcampExistsById(createRequest.getBootcampId());
		Application application = modelMapperService.forRequest().map(createRequest, Application.class);
		applicationRepository.save(application);
		CreateApplicationResponse applicationResponse = modelMapperService.forResponse().map(application,
				CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(applicationResponse,
				MessagesForApplication.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateRequest) {
		checkIfApplicationExistById(updateRequest.getId());
		Application application = modelMapperService.forRequest().map(updateRequest, Application.class);
		applicationRepository.save(application);
		UpdateApplicationResponse applicationResponse = modelMapperService.forResponse().map(application,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(applicationResponse,
				MessagesForApplication.ApplicationUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicationExistById(id);
		applicationRepository.deleteById(id);
		return new SuccessResult(MessagesForApplication.ApplicationDeleted);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		checkIfApplicationExistById(id);
		Application application = applicationRepository.findById(id).orElse(null);
		GetApplicationResponse applicationResponse = modelMapperService.forResponse().map(application,
				GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(applicationResponse);
	}

	/// Domain Rules \\\

	private Application checkIfApplicationExistById(int id) {
		if (!applicationRepository.existsById(id)) {
			throw new BusinessException(MessagesForApplication.ApplicationDoesNotExistById);
		}
		return null;
	}

	private void checkIfApplicantExistsById(int id) {
		applicantService.getById(id);
	}

	private void checkIfBootcampExistsById(int id) {
		bootcampService.getById(id);
	}
	
	private void checkIfApplicantAppliedBefore(int applicantId) {
		if(applicationRepository.findByApplicantId(applicantId) != null){
			throw new BusinessException(MessagesForApplicant.ApplicantAppliedBefore);
		}
	}

	private void checkIfApplicantIsInBlacklist(int id){
		blacklistService.checkIfApplicantInBlacklistById(id);
	}
	
	private void checkIfBootcampActivated(int id) {
		bootcampService.checkIfBootcampActivated(id);
	}
	
}
