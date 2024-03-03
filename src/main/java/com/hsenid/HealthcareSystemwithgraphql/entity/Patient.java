package com.hsenid.HealthcareSystemwithgraphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Patient {
    @Id
    private String patientId;
    private String patientName;
    private ArrayList<String> patientContactNumber;
    private int age;
    private ArrayList<String> illness;




}
