package com.Project.Doctor.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Project.Doctor.Payloads.DoctorDTO;
import com.Project.Doctor.Payloads.apiResponse;
import com.Project.Doctor.Service.DoctorService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("api/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/")
	public ResponseEntity<DoctorDTO> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO)
	{
		DoctorDTO createDoctorDTO=this.doctorService.createDoctor(doctorDTO);
		return new ResponseEntity<>(createDoctorDTO,HttpStatus.CREATED);
	}
	
	
	//update-PUT
	@PutMapping("/{dId}")
	
	public ResponseEntity<DoctorDTO> updateDoctor(@Valid @RequestBody DoctorDTO doctorDTO, @PathVariable Long dId)
	{
		
		DoctorDTO updatedDoctor =this.doctorService.updateDoctor(doctorDTO, dId);
		return ResponseEntity.ok(updatedDoctor);
	}
	
	//delete
	@DeleteMapping("/{doctorId}")
	public ResponseEntity<apiResponse> deleteDoctor(@PathVariable("doctorId")Long dId){
		this.doctorService.deleteDoctor(dId);
		return new ResponseEntity<apiResponse>(new apiResponse("user Deleted",true),HttpStatus.OK);
	}
	
	
	//get - all patients
	@GetMapping("/")
	public ResponseEntity<List<DoctorDTO>> getAllDoctor(){
		return ResponseEntity.ok(this.doctorService.getAllDoctor());
	}
	
	//for single user 
	@GetMapping("/{dId}")
	public ResponseEntity<DoctorDTO> getSingleDoctor(@PathVariable Long dId){
		return ResponseEntity.ok(this.doctorService.getDoctorById(dId));
	}
	
	

}
