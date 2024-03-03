package com.hsenid.HealthcareSystemwithgraphql.dto;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;

import java.util.Date;
import java.util.List;

public record AppointmentDTO(String doctorId, String  patientId, String date, String time) {

}
