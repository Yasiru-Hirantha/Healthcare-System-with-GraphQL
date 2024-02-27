package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor, Integer> {
    Doctor findDoctorByDoctorId(int id);

    boolean existsByDoctorId(int id);

    void deleteByDoctorId(int id);

    boolean existsDoctorByDoctorName(String name);

    List<Doctor> findDoctorByDoctorName(String name);
}
