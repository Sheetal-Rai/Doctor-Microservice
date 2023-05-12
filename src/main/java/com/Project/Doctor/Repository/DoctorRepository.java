package com.Project.Doctor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.Doctor.Entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
