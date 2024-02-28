package com.hsenid.HealthcareSystemwithgraphql.service.impl;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.repository.DoctorRepo;
import com.hsenid.HealthcareSystemwithgraphql.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionServiceImpl implements ReceptionService {
    private final DoctorRepo doctorRepo;

    public ReceptionServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public List<Doctor> findSpecialist(String conditionOrDisease) {
        List<Doctor> specialist=new ArrayList<>();
        List<Doctor> doctors=doctorRepo.findAll();
        for (Doctor doctor : doctors) {

           List<String> conditions= doctor.getConditionOrDisease();
           if (conditions.contains(conditionOrDisease)){
               specialist.add(doctor);
           }
        }return specialist;


    }

    @Override
    public List<Doctor> findSpecialDoctor(String specialization) {
        List<Doctor> doctorList=doctorRepo.findDoctorBySpecialization(specialization);
        return doctorList;
    }
}
