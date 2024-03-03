package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.dto.PatientDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;

import java.util.List;


public interface PatientService {
    String savePatient(PatientDTO patientDTO);

    String updatePatient(PatientDTO patientDTO, String patientId);

    String deletePatient(String patientId);

    List<Patient> findAll();

    List<Patient> searchPatient(String name);

    List<Patient> findPatient(String patientId);
}
