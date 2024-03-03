package com.hsenid.HealthcareSystemwithgraphql.controller;

import com.hsenid.HealthcareSystemwithgraphql.dto.DoctorDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import com.hsenid.HealthcareSystemwithgraphql.service.DoctorService;
import com.hsenid.HealthcareSystemwithgraphql.util.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    private static final Logger logInfo=LoggerFactory.getLogger(DoctorController.class);

    @MutationMapping
    public ApiResponse createDoctor(@Argument DoctorDTO doctorDTO) {
        String details = doctorService.saveDoctor(doctorDTO);
        logInfo.info("New doctor was added");
        return new ApiResponse(201, details, null, null,null);
    }
    @QueryMapping
    public ApiResponse searchDoctorByName(@Argument String name){
        List<Doctor> doctorList=doctorService.searchDoctor(name);
        return new ApiResponse(200,doctorList.isEmpty()?"No doctor from this name":"Ok",null,doctorList,null);
    }

    @MutationMapping
    public ApiResponse updateDoctorById(@Argument DoctorDTO doctorDTO, @Argument String doctorId) {
        String details = doctorService.updateDoctorById(doctorDTO, doctorId);
        return new ApiResponse(204, details, null, null,null);
    }

    @MutationMapping
    public ApiResponse deleteDoctorById(@Argument String doctorId) {
        String details = doctorService.deleteDoctor(doctorId);
        return new ApiResponse(204, details, null, null,null);
    }

    @QueryMapping
    public ApiResponse findAllDoctor() {
        List<Doctor> doctorList = doctorService.findAll();
        return new ApiResponse(200, doctorList.isEmpty()?"No doctors saved in the database":"Ok", null, doctorList,null );
    }
    @QueryMapping
    public ApiResponse findDoctorById(@Argument String doctorId){
        List<Doctor> doctorList=doctorService.findDoctor(doctorId);
        return new ApiResponse(200, doctorList.isEmpty()?"No doctor with the doctorId :"+doctorId+" found!":"Ok", null, doctorList,null );
    }


}
