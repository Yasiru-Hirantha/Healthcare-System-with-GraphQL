package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.dto.PatientDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PatientService {
    String savePatient(PatientDTO patientDTO);

    String updatePatient(PatientDTO patientDTO,int id);

    String deletePatient(int id);

    List<Patient>  findAll();
}
