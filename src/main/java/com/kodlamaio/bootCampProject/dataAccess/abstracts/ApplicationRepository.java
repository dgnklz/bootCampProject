package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.applications.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer>{
	Application findByApplicantId(int applicantId);
}
