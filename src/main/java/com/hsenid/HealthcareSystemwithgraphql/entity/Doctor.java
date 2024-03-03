package com.hsenid.HealthcareSystemwithgraphql.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Doctor {
    @Id
    private String doctorId;
    private String doctorName;
    private String specialization;
    private ArrayList<String> doctorContactNumber;
    private double channellingFee;
    private ArrayList<String> conditionOrDisease;
    private int patientsPerDay;



}
