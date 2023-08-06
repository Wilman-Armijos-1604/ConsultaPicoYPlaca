/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.advlatam.Controllers;

import com.advlatam.Models.VehicleDateTime;
import com.advlatam.Services.VehicleDateTimeService;
import com.advlatam.Validators.VehicleDateTimeValidator;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilman Armijos
 */

@RestController
// CORS is set to recieve any origin, based on IP defined for FrontEnd to be called (localhost or specific IPv4)
@CrossOrigin("*")
public class VehicleDateTimeController {
    
    private final VehicleDateTimeValidator vehicleDateTimeValidator;
    private final VehicleDateTimeService vehicleDateTimeService;
    
    public VehicleDateTimeController(VehicleDateTimeValidator vehicleDateTimeValidator, VehicleDateTimeService vehicleDateTimeService) {
        this.vehicleDateTimeValidator = vehicleDateTimeValidator;
        this.vehicleDateTimeService = vehicleDateTimeService;
    }

    @PostMapping("/VehicleDateTimeCheck")
    public ResponseEntity<?> CheckAbleVehicleDateTime(@RequestBody VehicleDateTime vehicleDateTimeRequest) {
        
        // HTTP Code set OK
        HttpStatus httpStatus = HttpStatus.OK;
        Object body = null;
        
        Map<String, String> validations = vehicleDateTimeValidator.validateVehicleDateTime(vehicleDateTimeRequest);
        
        // If there are any errors, then just validation messages are sent
        if (!validations.isEmpty()) {
            body = validations;
        } 
        // If no errors were found, then the corresponding response message is sent based in input data
        else {
            body = vehicleDateTimeService.CheckAbleVehicleDateTime(vehicleDateTimeRequest);
        }
        
        return ResponseEntity.status(httpStatus).body(body);
    }
}
