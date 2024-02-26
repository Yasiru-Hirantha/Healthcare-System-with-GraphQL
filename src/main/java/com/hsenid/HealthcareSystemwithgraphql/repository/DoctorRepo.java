package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor,Integer> {
    Doctor findDoctorByDoctorId(int id);

    boolean existsByDoctorId(int id);

    void deleteByDoctorId(int id);
}
