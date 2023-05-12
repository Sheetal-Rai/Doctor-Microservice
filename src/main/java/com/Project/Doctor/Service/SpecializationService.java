package com.Project.Doctor.Service;

import java.util.List;

import com.Project.Doctor.Entity.Specialization;
import com.Project.Doctor.Payloads.SpecializationDTO;

public interface SpecializationService {

	Specialization createSpecialization(SpecializationDTO spe);
	
	Specialization updateSpecialization(SpecializationDTO spe,Long id);
	
	Specialization getSpecializationById(SpecializationDTO speDTO);
	
	List<SpecializationDTO> getSpecializations();
	
	
	
	void deleteSpecialization(Long id);
	
	
}
