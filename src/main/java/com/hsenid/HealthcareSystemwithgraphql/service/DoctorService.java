package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.dto.DoctorDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;

import java.util.List;

public interface DoctorService {
    String saveDoctor(DoctorDTO doctorDTO);

    String updateDoctorById(DoctorDTO doctorDTO, int id);

    String deleteDoctor(int id);

    List<Doctor> findAll();
}
