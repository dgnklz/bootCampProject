package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.evaluations.Blacklist;

public interface BlacklistRepository extends JpaRepository<Blacklist, Integer>{
	Blacklist findByApplicantId(int id);
}
