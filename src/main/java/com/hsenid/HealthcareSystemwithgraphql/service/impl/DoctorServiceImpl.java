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
        return "Successfully saved docor id: " + doctorDTO.doctorId();
    }

    @Override
    public String updateDoctorById(DoctorDTO doctorDTO, int id) {
        if (doctorRepo.existsByDoctorId(id)) {
            Doctor doctor = doctorRepo.findDoctorByDoctorId(id);
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
    public String deleteDoctor(int id) {
        if (doctorRepo.existsByDoctorId(id)) {
            doctorRepo.deleteByDoctorId(id);
            return "Successfully deleted doctor id: " + id;
        } else return "invalid doctor id: " + id;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepo.findAll();
    }
}
