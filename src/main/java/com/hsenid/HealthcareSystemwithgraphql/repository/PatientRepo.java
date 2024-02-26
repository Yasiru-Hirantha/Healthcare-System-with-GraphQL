package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends MongoRepository<Patient,Integer> {
    Patient findPatientByPatientId(int id);

    boolean existsByPatientId(int id);

    void deleteByPatientId(int id);
}
