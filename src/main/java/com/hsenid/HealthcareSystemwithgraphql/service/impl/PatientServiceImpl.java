package com.hsenid.HealthcareSystemwithgraphql.service.impl;

import com.hsenid.HealthcareSystemwithgraphql.dto.PatientDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import com.hsenid.HealthcareSystemwithgraphql.repository.DoctorRepo;
import com.hsenid.HealthcareSystemwithgraphql.repository.PatientRepo;
import com.hsenid.HealthcareSystemwithgraphql.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;

    }

    @Override
    public String savePatient(PatientDTO patientDTO) {

        Patient patient = new Patient(
                patientDTO.patientId(),
                patientDTO.patientName(),
                patientDTO.patientContactNumber(),
                patientDTO.age(),
                patientDTO.illness()

        );
        patientRepo.save(patient);
        return "Successfully saved patient :" + patientDTO.patientId();
    }

    @Override
    public String updatePatient(PatientDTO patientDTO, String patientId) {
        if (patientRepo.existsById(patientId)) {
            List<Patient> patientList = patientRepo.findPatientsByPatientId(patientId);
            Patient patient=patientList.get(0);
            patient.setPatientName(patientDTO.patientName());
            patient.setPatientContactNumber(patientDTO.patientContactNumber());
            patient.setAge(patientDTO.age());
            patient.setIllness(patientDTO.illness());
            patientRepo.save(patient);
            return "Successfully updated patient :" + patientId;
        } else return "Invalid patient id: " + patientId;
    }

    @Override
    public String deletePatient(String patientId) {
        if (patientRepo.existsByPatientId(patientId)) {
            patientRepo.deleteByPatientId(patientId);
            return "Successfully deleted patient :" + patientId;
        } else {
            return "Invalid student id :" + patientId;
        }

    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = patientRepo.findAll();
        if (patientList.size() > 0) {
            return patientList;
        } else throw new RuntimeException("Error");

    }

    @Override
    public List<Patient> searchPatient(String name) {
        List<Patient> patientList = patientRepo.findByPatientName(name);
        if (patientList.size() > 0) {
            return patientList;
        } else throw new RuntimeException("No patient with the name :" + name + " was found!");
    }
    @Override
    public List<Patient> findPatient(String patientId) {
        List<Patient> patientList=null;
        if(patientRepo.existsByPatientId(patientId)){
            patientList=patientRepo.findPatientsByPatientId(patientId);
            return patientList;
        }else throw new RuntimeException("Invalid patientId :"+patientId);

    }
}
