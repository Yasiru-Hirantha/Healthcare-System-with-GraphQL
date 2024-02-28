package com.hsenid.HealthcareSystemwithgraphql.controller;

import com.hsenid.HealthcareSystemwithgraphql.dto.PatientDTO;
import com.hsenid.HealthcareSystemwithgraphql.entity.Patient;
import com.hsenid.HealthcareSystemwithgraphql.service.PatientService;
import com.hsenid.HealthcareSystemwithgraphql.util.ApiResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;



@Controller
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @MutationMapping
    public ApiResponse createPatient(@Argument PatientDTO patientDTO) {
        String details = patientService.savePatient(patientDTO);
        return new ApiResponse(201, details, null, null);
    }
    @QueryMapping
    public ApiResponse searchPatientByName(@Argument String name){
        List<Patient> patientList =patientService.searchPatient(name);
        return new ApiResponse(200,"Ok",patientList,null);
    }

    @MutationMapping
    public ApiResponse updatePatientById(@Argument PatientDTO patientDTO, @Argument int id) {
        String details = patientService.updatePatient(patientDTO, id);
        return new ApiResponse(204, details, null, null);
    }

    @MutationMapping
    public ApiResponse deletePatientById(@Argument int id) {
        String details = patientService.deletePatient(id);
        return new ApiResponse(204, details, null, null);
    }

    @QueryMapping
    public ApiResponse findAllPatient() {
        List<Patient> patientList = new ArrayList<>();
        patientList = patientService.findAll();
        return new ApiResponse(200, "Ok", patientList, null);
    }

}
