package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends MongoRepository<Doctor, String> {
    List<Doctor> findDoctorByDoctorId(String doctorId);

    boolean existsByDoctorId(String doctorId);

    List<Doctor> findDoctorByDoctorName(String doctorName);

    List<Doctor> findDoctorBySpecialization(String specialization);


}
