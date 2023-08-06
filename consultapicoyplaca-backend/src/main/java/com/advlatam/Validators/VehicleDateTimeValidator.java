/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.advlatam.Validators;

import com.advlatam.Models.VehicleDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Armijos
 */

@Service
public class VehicleDateTimeValidator implements IVehicleDateTimeValidator {
    
    // License plate format validation (AAA-000 and AAA-0000)
    private final String LicensePlateFormat = "^[A-Z]{3}[-]\\d{3,4}$";

    @Override
    public Map<String, String> validateVehicleDateTime(VehicleDateTime vehicleDateTime) {
        Map<String, String> errorsList = new HashMap<>();
        
        String licensePlateValidationMessage = this.validateLicensePlate(vehicleDateTime.getLicensePlate());
        String dateTimeValidationMessage = this.validateDateTime(vehicleDateTime.getDateTime());
        
        // Validation of License plate
        if (!licensePlateValidationMessage.isEmpty()) {
            errorsList.put("LicensePlate", licensePlateValidationMessage);
        }
        // Validation of Date and Time
        if (!dateTimeValidationMessage.isEmpty()) {
            errorsList.put("DateTime", dateTimeValidationMessage);
        }
                
        // Map of validation (Empty if no errors found, One or two values if any field has validation errors)
        return errorsList;
    }

    // Validation of License Plate
    @Override
    public String validateLicensePlate(String licensePlate) {
        String licensePlateErrorMessage = "";
        // Empty validation of License Plate value
        if (licensePlate.trim().isEmpty()) {
            licensePlateErrorMessage = "Este campo es obligatorio.";
        } 
        // Acceptable format validation of License Plate value 
        else if (!Pattern.matches(this.LicensePlateFormat, licensePlate)) {
            licensePlateErrorMessage = "Escriba una placa válida.";
        }
        return licensePlateErrorMessage;
    }

    // Validation of Date and Time
    @Override
    public String validateDateTime(String dateTime) {
        String dateTimeErrorMessage = "";
        
        try {
            // Acceptable and valid format of Date from String
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
            // Checking if input date and time is at least current date and time
            if (parsedDateTime.isBefore(LocalDateTime.now())) {
                dateTimeErrorMessage = "Escriba una fecha y hora válida.";
            }
        } catch (Exception e) {
            dateTimeErrorMessage = "Este campo es obligatorio.";
        }
        
        return dateTimeErrorMessage;
    }
    
}
