package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends MongoRepository<Patient, String> {


    boolean existsByPatientId(String patientId);

    void deleteByPatientId(String patientId);

    List<Patient> findByPatientName(String patientName);

    boolean existsPatientByPatientName(String patientName);

    List<Patient> findPatientsByPatientId(String patientId);
}
