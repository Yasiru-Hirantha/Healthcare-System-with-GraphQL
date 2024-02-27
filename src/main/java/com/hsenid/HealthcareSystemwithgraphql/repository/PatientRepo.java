package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepo extends MongoRepository<Patient, Integer> {
    Patient findPatientByPatientId(int id);

    boolean existsByPatientId(int id);

    void deleteByPatientId(int id);

    List<Patient> findByPatientName(String name);

    boolean existsPatientByPatientName(String name);
}
