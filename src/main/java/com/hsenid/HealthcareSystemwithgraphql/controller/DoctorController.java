package com.hsenid.HealthcareSystemwithgraphql.controller;

import com.hsenid.HealthcareSystemwithgraphql.dto.DoctorDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.service.DoctorService;
import com.hsenid.HealthcareSystemwithgraphql.util.ApiResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @MutationMapping
    public ApiResponse createDoctor(@Argument DoctorDTO doctorDTO) {
        String details = doctorService.saveDoctor(doctorDTO);
        return new ApiResponse(201, details, null, null);
    }

    @MutationMapping
    public ApiResponse updateDoctorById(@Argument DoctorDTO doctorDTO, @Argument int id) {
        System.out.println(doctorDTO.doctorName());
        String details = doctorService.updateDoctorById(doctorDTO, id);
        return new ApiResponse(204, details, null, null);
    }

    @MutationMapping
    public ApiResponse deleteDoctorById(@Argument int id) {
        String details = doctorService.deleteDoctor(id);
        return new ApiResponse(204, details, null, null);
    }

    @QueryMapping
    public ApiResponse findAllDoctor() {
        List<Doctor> doctorList = new ArrayList<>();
        doctorList = doctorService.findAll();
        return new ApiResponse(200, "Ok", null, doctorList);
    }


}
