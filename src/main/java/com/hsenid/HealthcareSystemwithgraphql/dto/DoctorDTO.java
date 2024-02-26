package com.hsenid.HealthcareSystemwithgraphql.dto;

import java.util.ArrayList;
import java.util.List;

public record DoctorDTO(int doctorId, String doctorName, String specialization, ArrayList<String> doctorContactNumber, double channellingFee, ArrayList<String> conditionOrDisease, int patientsPerDay) {
}
