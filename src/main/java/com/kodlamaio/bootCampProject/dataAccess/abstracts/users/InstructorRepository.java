package com.kodlamaio.bootCampProject.dataAccess.abstracts.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.bootCampProject.entities.users.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	Instructor findByNationalIdentity(String nationalIdentity);
}
