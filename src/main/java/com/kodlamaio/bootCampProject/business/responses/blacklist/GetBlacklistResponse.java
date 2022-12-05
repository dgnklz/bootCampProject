package com.kodlamaio.bootCampProject.business.responses.blacklist;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBlacklistResponse {
	int applicantId;
	String reason;
	LocalDate date;
}
