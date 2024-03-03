package com.hsenid.HealthcareSystemwithgraphql.dto;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record PatientDTO(String patientId, String patientName, ArrayList<String> patientContactNumber, int age,
                         ArrayList<String> illness) {
}
