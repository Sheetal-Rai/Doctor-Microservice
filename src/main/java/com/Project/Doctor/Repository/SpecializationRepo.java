package com.Project.Doctor.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Doctor.Entity.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Long> {
	

	List<Specialization> findByDoctor(Specialization spe); 
	
}
	