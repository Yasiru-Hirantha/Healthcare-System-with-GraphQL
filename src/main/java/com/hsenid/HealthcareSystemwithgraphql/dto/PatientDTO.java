package com.hsenid.HealthcareSystemwithgraphql.dto;

import java.util.ArrayList;
import java.util.Date;

public record PatientDTO(int patientId, String patientName, ArrayList<String> patientContactNumber, int age,ArrayList<String> illness) {
}
