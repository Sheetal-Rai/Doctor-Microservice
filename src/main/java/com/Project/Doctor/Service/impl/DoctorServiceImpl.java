package com.Project.Doctor.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.Doctor.Entity.Doctor;
import com.Project.Doctor.Exception.ResourceNotFoundException;
import com.Project.Doctor.Payloads.DoctorDTO;
import com.Project.Doctor.Service.DoctorService;
import com.Project.Doctor.Repository.*;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
		Doctor doctor=this.dtoToDoctor(doctorDTO);
		Doctor savedDoctor=this.doctorRepo.save(doctor);
		return this.doctorToDTO(savedDoctor);
		
	}

	@Override
	public DoctorDTO updateDoctor(DoctorDTO doctorDTO, Long id) {
		
		Doctor doctor =this.doctorRepo.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Doctor","id",id));
		
      doctor.setFirst_name(doctorDTO.getFirst_name());
      doctor.setLast_name(doctorDTO.getLast_name());
      
      doctor.setEmail(doctorDTO.getEmail());
      doctor.setPassword(doctorDTO.getPassword());
      
      Doctor updatedDoctor = this.doctorRepo.save(doctor);
      DoctorDTO doctorDTO1 =this.doctorToDTO(updatedDoctor);
		return doctorDTO1;
		
	
	}

	@Override
	public DoctorDTO getDoctorById(Long id) {
		Doctor doctor=this.doctorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("doctor", "id", id));
		return this.doctorToDTO(doctor);
	}

	@Override
	public List<DoctorDTO> getAllDoctor() {
		List<Doctor> doctors=this.doctorRepo.findAll();
		List<DoctorDTO> doctorDTOs= doctors.stream().map(doctor->this.doctorToDTO(doctor)).collect(Collectors.toList());
		return doctorDTOs;
	}

	@Override
	public void deleteDoctor(Long id) {
		Doctor doctor=this.doctorRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("doctor", "id", id));
		 this.doctorRepo.delete(doctor);
	}
	
	
	private Doctor dtoToDoctor(DoctorDTO doctorDTO) {
		Doctor doctor = this.modelMapper.map(doctorDTO, Doctor.class);
	
		return doctor;
		
	}
	
	public DoctorDTO doctorToDTO(Doctor doctor)
	{
		DoctorDTO doctorDTO=this.modelMapper.map(doctor, DoctorDTO.class);
		
//		patientDTO.setId(patient.getId());
//		patientDTO.setFirst_name(patient.getFirst_name());
//		patientDTO.setLast_name(patient.getFirst_name());
//		patientDTO.setPassword(patient.getPassword());
//		patientDTO.setAddress(patient.getAddress());
//		patientDTO.setEmail(patient.getEmail());
		return doctorDTO;
	}

	
	

	

}
