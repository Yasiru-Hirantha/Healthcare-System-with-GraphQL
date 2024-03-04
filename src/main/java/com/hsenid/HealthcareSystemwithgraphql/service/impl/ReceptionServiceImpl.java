package com.hsenid.HealthcareSystemwithgraphql.service.impl;

import com.hsenid.HealthcareSystemwithgraphql.dto.AppointmentDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Appointment;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import com.hsenid.HealthcareSystemwithgraphql.repository.AppointmentRepo;
import com.hsenid.HealthcareSystemwithgraphql.repository.DoctorRepo;
import com.hsenid.HealthcareSystemwithgraphql.service.DoctorService;
import com.hsenid.HealthcareSystemwithgraphql.service.PatientService;
import com.hsenid.HealthcareSystemwithgraphql.service.ReceptionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionServiceImpl implements ReceptionService {
    private final DoctorRepo doctorRepo;
    private final AppointmentRepo appointmentRepo;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ReceptionServiceImpl(DoctorRepo doctorRepo, AppointmentRepo appointmentRepo, DoctorService doctorService, PatientService patientService) {
        this.doctorRepo = doctorRepo;
        this.appointmentRepo = appointmentRepo;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public List<Doctor> findSpecialist(String conditionOrDisease) {
        List<Doctor> specialist = new ArrayList<>();
        List<Doctor> doctors = doctorRepo.findAll();
        for (Doctor doctor : doctors) {

            List<String> conditions = doctor.getConditionOrDisease();
            if (conditions.contains(conditionOrDisease)) {
                specialist.add(doctor);
            }
        }
        return specialist;
    }

    @Override
    public List<Doctor> findSpecialDoctor(String specialization) {
        List<Doctor> doctorList = doctorRepo.findDoctorBySpecialization(specialization);
        return doctorList;
    }

    @Override
    public String createNewAppointment(AppointmentDTO appointmentDTO) {
        List<Patient> patients = patientService.findPatient(appointmentDTO.patientId());
        List<Doctor> doctorList = findSpecialist(patients.get(0).getIllness().get(0));
        int count = 0;
        if (doctorList.size() > 0) {
            String doctorId = doctorList.get(0).getDoctorId();
            List<Appointment> apointmentList = findAppointment(doctorId);
            String slot = appointmentDTO.date() + appointmentDTO.time();
            for (Appointment appointments : apointmentList) {
                String slot2 = appointments.getDate() + appointments.getTime();
                if (slot.equals(slot2)) {
                    count += 1;
                    return "Time slot already reserved :" + appointmentDTO.date() + "=>" + appointmentDTO.time();
                }
            }
            if (count == 0) {
                Appointment appointment = new Appointment(
                        doctorService.findDoctor(doctorId),
                        patientService.findPatient(appointmentDTO.patientId()),
                        appointmentDTO.date(),
                        appointmentDTO.time()
                );
                appointmentRepo.save(appointment);
                return "Appointment id :" + appointment.getAppointmentId() + " saved";
            }
            return "Time slot already reserved :" + appointmentDTO.date() + "=>" + appointmentDTO.time();

        } else {
            return "No specialist available";
        }

    }

    @Override
    public String updateAppointment(String appointmentId, String date, String time) {
        if (appointmentRepo.existsById(appointmentId)) {
            Appointment appointment = appointmentRepo.findAppointmentByAppointmentId(appointmentId);
            appointment.setDate(date);
            appointment.setTime(time);
            appointmentRepo.save(appointment);
            return "Appointment updated for appointmentId: " + appointmentId;
        } else throw new RuntimeException("Invalid appointmentId :" + appointmentId);
    }

    @Override
    public String deleteAppointment(String appointmentId) {
        if (appointmentRepo.existsById(appointmentId)) {
            appointmentRepo.deleteById(appointmentId);
            return "Successfully deleted appointmentId :" + appointmentId;
        } else return null;
    }

    @Override
    public List<Appointment> findAppointment(String doctorId) {
        List<Appointment> appointmentList = appointmentRepo.findAppointmentByDoctor(doctorId);
        return appointmentList;
    }
}
