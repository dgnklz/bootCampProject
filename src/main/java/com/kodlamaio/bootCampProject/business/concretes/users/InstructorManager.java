package com.kodlamaio.bootCampProject.business.concretes.users;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlamaio.bootCampProject.business.constants.users.MessagesForInstructor;
import com.kodlamaio.bootCampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootCampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootCampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetAllInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.GetInstructorResponse;
import com.kodlamaio.bootCampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootCampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.users.InstructorRepository;
import com.kodlamaio.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InstructorManager implements InstructorService {
	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		List<Instructor> instructors = instructorRepository.findAll();
		List<GetAllInstructorResponse> instructorResponses = instructors.stream()
				.map(instructor -> modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.toList();
		return new SuccessDataResult<List<GetAllInstructorResponse>>(instructorResponses);
	}

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest createRequest) {
		checkIfInstructorExistsByNationalId(createRequest.getNationalIdentity());
		Instructor instructor = modelMapperService.forRequest().map(createRequest, Instructor.class);
		instructorRepository.save(instructor);
		CreateInstructorResponse instructorResponse = modelMapperService.forResponse().map(instructor,CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(instructorResponse,MessagesForInstructor.InstructorCreated);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest updateRequest) {
		checkIfInstructorExistById(updateRequest.getUserId());
		Instructor instructor = modelMapperService.forRequest().map(updateRequest, Instructor.class);
		instructorRepository.save(instructor);
		UpdateInstructorResponse instructorResponse = modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(instructorResponse,MessagesForInstructor.InstructorUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfInstructorExistById(id);
		instructorRepository.deleteById(id);
		return new SuccessResult(MessagesForInstructor.InstructorDeleted);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		checkIfInstructorExistById(id);
		Instructor instructor = instructorRepository.findById(id).orElse(null);
		GetInstructorResponse instructorResponse = modelMapperService.forResponse().map(instructor,GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(instructorResponse);
	}

	/// Domain Rules \\\

	private void checkIfInstructorExistsByNationalId(String nationalIdentity) {
		Instructor checkInstructor = instructorRepository.findByNationalIdentity(nationalIdentity);
		if (checkInstructor != null) {
			throw new BusinessException(MessagesForInstructor.InstructorExistsByNationalIdentity);
		}
	}

	private Instructor checkIfInstructorExistById(int id) {
		if (!instructorRepository.existsById(id)) {
			throw new BusinessException(MessagesForInstructor.InstructorDoesNotExistById);
		}
		return null;
	}
	
}
