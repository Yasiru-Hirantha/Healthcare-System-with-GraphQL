package com.hsenid.HealthcareSystemwithgraphql.service.impl;

import com.hsenid.HealthcareSystemwithgraphql.dto.DoctorDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.repository.DoctorRepo;
import com.hsenid.HealthcareSystemwithgraphql.service.DoctorService;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public String saveDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor(
                doctorDTO.doctorId(),
                doctorDTO.doctorName(),
                doctorDTO.specialization(),
                doctorDTO.doctorContactNumber(),
                doctorDTO.channellingFee(),
                doctorDTO.conditionOrDisease(),
                doctorDTO.patientsPerDay()
        );
        doctorRepo.save(doctor);
        return "Successfully saved doctor id: " + doctorDTO.doctorId();
    }

    @Override
    public String updateDoctorById(DoctorDTO doctorDTO, String doctorId) {
        if (doctorRepo.existsById(doctorId)) {
            List<Doctor> doctorList = doctorRepo.findDoctorByDoctorId(doctorId);
            Doctor doctor=doctorList.get(0);
            doctor.setDoctorName(doctorDTO.doctorName());
            doctor.setSpecialization(doctorDTO.specialization());
            doctor.setDoctorContactNumber(doctorDTO.doctorContactNumber());
            doctor.setChannellingFee(doctorDTO.channellingFee());
            doctor.setConditionOrDisease(doctorDTO.conditionOrDisease());
            doctor.setPatientsPerDay(doctorDTO.patientsPerDay());
            doctorRepo.save(doctor);
            return "Successfully updated doctor id: " + doctorDTO.doctorId();
        } else return "invalid doctor id: " + doctorDTO.doctorId();
    }

    @Override
    public String deleteDoctor(String doctorId) {
        if (doctorRepo.existsById(doctorId)) {
            doctorRepo.deleteById(doctorId);
            return "Successfully deleted doctor id: " + doctorId;
        } else return "invalid doctor id: " + doctorId;
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctorList=doctorRepo.findAll();
        if(doctorList.size()>0){
            return doctorList;
        }else throw new RuntimeException("Error");

    }

    @Override
    public List<Doctor> searchDoctor(String name) {
        List<Doctor> doctorList=doctorRepo.findDoctorByDoctorName(name);
        if(doctorList.size()>0){
            return doctorList;
        }
        else throw new RuntimeException("No doctor with the name :"+name+" found!");
    }

    @Override
    public List<Doctor> findDoctor(String doctorId) {
        List<Doctor> doctorList=null;
        if(doctorRepo.existsByDoctorId(doctorId)){
            doctorList=doctorRepo.findDoctorByDoctorId(doctorId);
            return doctorList;
        }else throw new RuntimeException("No doctor with the doctorId :"+doctorId+" found!");

    }
}
