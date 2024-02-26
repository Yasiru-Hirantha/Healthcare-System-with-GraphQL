package com.hsenid.HealthcareSystemwithgraphql.service.impl;

import com.hsenid.HealthcareSystemwithgraphql.dto.PatientDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import com.hsenid.HealthcareSystemwithgraphql.repository.PatientRepo;
import com.hsenid.HealthcareSystemwithgraphql.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public String savePatient(PatientDTO patientDTO) {
        Patient patient=new Patient(
                patientDTO.patientId(),
                patientDTO.patientName(),
                patientDTO.patientContactNumber(),
                patientDTO.age(),
                patientDTO.illness()
        );
        patientRepo.save(patient);
        return "Successfully saved patient :"+patientDTO.patientId();
    }

    @Override
    public String updatePatient(PatientDTO patientDTO,int id) {
        if(patientRepo.existsById(id)){
            Patient patient=patientRepo.findPatientByPatientId(id);
            patient.setPatientName(patientDTO.patientName());
            patient.setPatientContactNumber(patientDTO.patientContactNumber());
            patient.setAge(patientDTO.age());
            patient.setIllness(patientDTO.illness());
            patientRepo.save(patient);
            return "Successfully updated patient :"+id;
        }else return "Invalid patient id: "+id;


    }

    @Override
    public String deletePatient(int id) {
        if(patientRepo.existsByPatientId(id)){
            patientRepo.deleteByPatientId(id);
            return "Successfully deleted patient :"+id;
        }else {
            return "Invalid student id :"+id;
        }

    }
    @Override
    public List<Patient> findAll() {
        return patientRepo.findAll();
    }
}
