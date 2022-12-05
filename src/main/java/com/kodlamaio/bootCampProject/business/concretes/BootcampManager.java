package com.kodlamaio.bootCampProject.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootCampProject.business.constants.MessagesForBootcamp;
import com.kodlamaio.bootCampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetAllBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.BootcampRepository;
import com.kodlamaio.bootCampProject.entities.Bootcamp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = bootcampRepository.findAll();
		List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream()
				.map(bootcamp -> modelMapperService.forResponse().map(bootcamps, GetAllBootcampResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses);
	}

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest createRequest) {
		Bootcamp bootcamp = modelMapperService.forRequest().map(createRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		CreateBootcampResponse bootcampResponse = modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(bootcampResponse, MessagesForBootcamp.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateRequest) {
		checkIfBootcampExistById(updateRequest.getId());
		checkIfInstructorExistsById(updateRequest.getInstructorId());
		Bootcamp bootcamp = modelMapperService.forRequest().map(updateRequest, Bootcamp.class);
		bootcampRepository.save(bootcamp);
		UpdateBootcampResponse bootcampResponse = modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(bootcampResponse, MessagesForBootcamp.BootcampUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBootcampExistById(id);
		bootcampRepository.deleteById(id);
		return new SuccessResult(MessagesForBootcamp.BootcampDeleted);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		checkIfBootcampExistById(id);
		Bootcamp bootcamp = bootcampRepository.findById(id).orElse(null);
		GetBootcampResponse bootcampResponse = modelMapperService.forResponse().map(bootcamp, GetBootcampResponse.class);
		return new SuccessDataResult<GetBootcampResponse>(bootcampResponse);
	}
	
	/// Rules For External Requests \\\
	
//	public void checkIfBootcampActivated(CreateBootcampRequest createRequest) {
//		if(createRequest.getState().equals(BootcampState.Closed)) {
//			throw new BusinessException(MessagesForBootcamp.BootcampNotActivated);
//		}
//	}
	
	public void checkIfBootcampActivated(int id) {
		Bootcamp checkBootcamp = bootcampRepository.findById(id).get();
		if(checkBootcamp.getState().getId() == 2) {
			throw new BusinessException(MessagesForBootcamp.BootcampNotActivated);
		}
	}
	
	/// Domain Rules \\\
	
	private void checkIfBootcampExistById(int id) {
		if (!bootcampRepository.existsById(id)) {
			throw new BusinessException(MessagesForBootcamp.BootcampDoesNotExistById);
		}
	}
	
	private void checkIfInstructorExistsById(int id) {
		instructorService.getById(id);
	}

}
