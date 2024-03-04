package com.hsenid.HealthcareSystemwithgraphql.repository;

import com.hsenid.HealthcareSystemwithgraphql.entity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends MongoRepository<Appointment,String> {
    Appointment findAppointmentByAppointmentId(String appointmentId);


    List<Appointment> findAppointmentByDoctor(String doctorId);
}
