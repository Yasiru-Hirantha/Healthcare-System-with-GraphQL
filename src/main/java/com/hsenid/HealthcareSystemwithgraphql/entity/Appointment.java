package com.hsenid.HealthcareSystemwithgraphql.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Appointment {
    @Id
    private String appointmentId;
    @DBRef
    private List<Doctor> doctor;
    @DBRef
    private List<Patient> patient;
    private String date;

    private String time;

    public Appointment(List<Doctor> doctor, List<Patient> patient, String date, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
    }
}
