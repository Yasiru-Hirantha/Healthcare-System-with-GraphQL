package com.hsenid.HealthcareSystemwithgraphql.dto;

import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public record DoctorDTO(String doctorId, String doctorName, String specialization, ArrayList<String> doctorContactNumber,
                        double channellingFee, ArrayList<String> conditionOrDisease, int patientsPerDay) {
}
