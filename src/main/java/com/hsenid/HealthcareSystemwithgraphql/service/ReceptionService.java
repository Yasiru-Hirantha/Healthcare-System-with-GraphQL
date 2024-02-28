package com.hsenid.HealthcareSystemwithgraphql.service;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;

import java.util.List;

public interface ReceptionService {
    List<Doctor> findSpecialist(String conditionOrDisease);

    List<Doctor> findSpecialDoctor(String specialization);
}
