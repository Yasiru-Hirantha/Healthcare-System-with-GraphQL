package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.dto.DoctorDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;

import java.util.List;

public interface DoctorService {
    String saveDoctor(DoctorDTO doctorDTO);

    String updateDoctorById(DoctorDTO doctorDTO, String doctorId);

    String deleteDoctor(String doctorId);

    List<Doctor> findAll();

    List<Doctor> searchDoctor(String name);

    List<Doctor> findDoctor(String doctorId);
}
