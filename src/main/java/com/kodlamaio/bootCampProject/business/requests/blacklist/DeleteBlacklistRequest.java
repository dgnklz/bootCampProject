package com.kodlamaio.bootCampProject.business.requests.blacklist;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteBlacklistRequest {
	int id;
	int applicantId;
	String reason;
	LocalDate date;
}
