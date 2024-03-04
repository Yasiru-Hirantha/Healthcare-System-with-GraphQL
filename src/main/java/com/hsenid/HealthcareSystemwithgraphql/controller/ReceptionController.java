package com.hsenid.HealthcareSystemwithgraphql.controller;

import com.hsenid.HealthcareSystemwithgraphql.dto.AppointmentDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Appointment;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.service.ReceptionService;
import com.hsenid.HealthcareSystemwithgraphql.util.ApiResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReceptionController {
    private final ReceptionService receptionService;

    public ReceptionController(ReceptionService receptionService) {
        this.receptionService = receptionService;
    }

    @QueryMapping
    public ApiResponse searchSpecialist(@Argument String conditionOrDisease) {
        List<Doctor> doctor = receptionService.findSpecialist(conditionOrDisease);
        return new ApiResponse(200, doctor.isEmpty() ? "No specialist available" : "Ok", null, doctor, null);

    }

    @QueryMapping
    public ApiResponse searchSpecialization(@Argument String specialization) {
        List<Doctor> doctor = receptionService.findSpecialDoctor(specialization);
        return new ApiResponse(200, doctor.isEmpty() ? "No specialist available" : "Ok", null, doctor, null);

    }

    @MutationMapping
    public ApiResponse createAppointment(@Argument AppointmentDTO appointmentDTO) {
        String details = receptionService.createNewAppointment(appointmentDTO);
        return new ApiResponse(201, details, null, null, null);

    }

    @MutationMapping
    public ApiResponse updateAppointment(@Argument String appointmentId, @Argument String date, @Argument String time) {
        String details = receptionService.updateAppointment(appointmentId, date, time);
        return new ApiResponse(204, details, null, null, null);
    }

    @MutationMapping
    public ApiResponse deleteAppointment(@Argument String appointmentId) {
        String details = receptionService.deleteAppointment(appointmentId);
        return new ApiResponse(204, details.isEmpty() ? "Oops! Wrong appointmentId: " + appointmentId : details, null, null, null);
    }
    @QueryMapping
    public ApiResponse getAppointmentByDoctor(@Argument String doctorId){
        List<Appointment> appointmentList=receptionService.findAppointment(doctorId);
        return new ApiResponse(200,appointmentList.isEmpty()?"No appointments for the doctorId: "+doctorId+" for now":"Ok",null,null,appointmentList);
    }


}
