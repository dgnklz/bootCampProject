package com.kodlamaio.bootCampProject.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootCampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootCampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootCampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootCampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/blacklists")
public class BlacklistController {
	BlacklistService blacklistService;

	@GetMapping("/get/getAll")
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		return blacklistService.getAll();
	}

	@PostMapping("/add")
	public DataResult<CreateBlacklistResponse> add(@RequestBody CreateBlacklistRequest createRequest) {
		return blacklistService.add(createRequest);
	}

	@PutMapping("/update")
	public DataResult<UpdateBlacklistResponse> update(@RequestBody UpdateBlacklistRequest updateRequest) {
		return blacklistService.update(updateRequest);
	}

	@DeleteMapping("/delete/{id}")
	public Result delete(int id) {
		return blacklistService.delete(id);
	}

	@GetMapping("/get/{id}")
	public DataResult<GetBlacklistResponse> getById(int id) {
		return blacklistService.getById(id);
	}

	@GetMapping("/get/applicant/{id}")
	public DataResult<GetBlacklistResponse> getByApplicantId(int applicantId) {
		return blacklistService.getByApplicantId(applicantId);
	}
}
