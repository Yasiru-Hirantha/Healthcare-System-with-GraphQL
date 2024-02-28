package com.hsenid.HealthcareSystemwithgraphql.controller;

import com.hsenid.HealthcareSystemwithgraphql.entity.Doctor;
import com.hsenid.HealthcareSystemwithgraphql.service.ReceptionService;
import com.hsenid.HealthcareSystemwithgraphql.util.ApiResponse;
import org.springframework.graphql.data.method.annotation.Argument;
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
    public ApiResponse searchSpecialist(@Argument String conditionOrDisease){
        List<Doctor> doctor= receptionService.findSpecialist(conditionOrDisease);
        return new ApiResponse(200,"Ok",null,doctor);

    }
    @QueryMapping
    public ApiResponse searchSpecialization(@Argument String specialization){
        List<Doctor> doctor= receptionService.findSpecialDoctor(specialization);
        return new ApiResponse(200,"Ok",null,doctor);

    }

}
