package com.Project.Doctor.Service;

import java.util.List;

import com.Project.Doctor.Payloads.DoctorDTO;


public interface DoctorService {
	 
		DoctorDTO createDoctor(DoctorDTO doctor);
		
		DoctorDTO updateDoctor(DoctorDTO doctor, Long id);
		
		DoctorDTO getDoctorById(Long id);
		
		List<DoctorDTO> getAllDoctor();
		
		 void deleteDoctor (Long id);
	

}

