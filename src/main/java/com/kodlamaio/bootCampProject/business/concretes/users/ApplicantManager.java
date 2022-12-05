package com.kodlamaio.bootCampProject.business.concretes.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlamaio.bootCampProject.business.constants.users.MessagesForApplicant;
import com.kodlamaio.bootCampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.users.ApplicantRepository;
import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		List<Applicant> applicants = applicantRepository.findAll();
		List<GetAllApplicantResponse> applicantResponses = applicants.stream()
				.map(applicant -> modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllApplicantResponse>>(applicantResponses);
	}

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest createRequest) {
		checkIfApplicantExistsByNationalId(createRequest.getNationalIdentity());
		Applicant applicant = modelMapperService.forRequest().map(createRequest, Applicant.class);
		applicantRepository.save(applicant);
		CreateApplicantResponse applicantResponse = modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(applicantResponse, MessagesForApplicant.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateRequest) {
		checkIfApplicantExistById(updateRequest.getUserId());
		Applicant applicant = modelMapperService.forRequest().map(updateRequest, Applicant.class);
		applicantRepository.save(applicant);
		UpdateApplicantResponse applicantResponse = modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(applicantResponse, MessagesForApplicant.ApplicantUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicantExistById(id);
		Applicant applicant = applicantRepository.findById(id).get();
		applicantRepository.delete(applicant);
		return new SuccessResult(MessagesForApplicant.ApplicantDeleted);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		checkIfApplicantExistById(id);
		Applicant applicant = applicantRepository.findById(id).get();
		GetApplicantResponse applicantResponse = modelMapperService.forResponse().map(applicant,
				GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(applicantResponse);
	}

	/// Domain Rules \\\

	private void checkIfApplicantExistsByNationalId(String nationalIdentity) {
		Applicant checkApplicant = applicantRepository.findByNationalIdentity(nationalIdentity);
		if (checkApplicant != null) {
			throw new BusinessException(MessagesForApplicant.ApplicantExistsByNationalIdentiy);
		}
	}

	private void checkIfApplicantExistById(int id) {
		if (!applicantRepository.existsById(id)) {
			throw new BusinessException(MessagesForApplicant.ApplicantDoesNotExistById);
		}
	}

}
