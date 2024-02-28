package com.hsenid.HealthcareSystemwithgraphql.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Patient {
    @Id
    private int patientId;
    private String patientName;
    private ArrayList<String> patientContactNumber;
    private int age;
    private ArrayList<String> illness;




}
