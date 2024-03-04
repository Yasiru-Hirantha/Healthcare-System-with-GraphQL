package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.dto.AppointmentDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Appointment;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;

import java.util.List;

public interface ReceptionService {
    List<Doctor> findSpecialist(String conditionOrDisease);

    List<Doctor> findSpecialDoctor(String specialization);

    String createNewAppointment(AppointmentDTO appointmentDTO);

    String updateAppointment(String appointmentId, String date, String time);

    String deleteAppointment(String appointmentId);

    List<Appointment> findAppointment(String doctorId);
}
