package com.kodlamaio.bootCampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.bootCampProject.entities.users.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	Applicant findByNationalIdentity(String nationalIdentity);
}
