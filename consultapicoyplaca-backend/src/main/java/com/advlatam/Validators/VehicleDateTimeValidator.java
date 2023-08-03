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
    
    private final String LicensePlateFormat = "^[A-Z]{3}[-]\\d{3,4}$";

    @Override
    public Map<String, String> validateVehicleDateTime(VehicleDateTime vehicleDateTime) {
        Map<String, String> errorsList = new HashMap<>();
        
        String licensePlateValidationMessage = this.validateLicensePlate(vehicleDateTime.getLicensePlate());
        String dateTimeValidationMessage = this.validateDateTime(vehicleDateTime.getDateTime());
        
        if (!licensePlateValidationMessage.isEmpty()) {
            errorsList.put("LicensePlate", licensePlateValidationMessage);
        }
        if (!dateTimeValidationMessage.isEmpty()) {
            errorsList.put("DateTime", dateTimeValidationMessage);
        }
                
        return errorsList;
    }

    @Override
    public String validateLicensePlate(String licensePlate) {
        String licensePlateErrorMessage = "";
        if (licensePlate.trim().isEmpty()) {
            licensePlateErrorMessage = "Este campo es obligatorio.";
        } else if (!Pattern.matches(this.LicensePlateFormat, licensePlate)) {
            licensePlateErrorMessage = "Por favor, introduzca un número de placa válido (AAA-0000, AAA-000).";
        }
        return licensePlateErrorMessage;
    }

    @Override
    public String validateDateTime(String dateTime) {
        String dateTimeErrorMessage = "";
        
        try {
            LocalDateTime parsedDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
            if (parsedDateTime.isBefore(LocalDateTime.now())) {
                dateTimeErrorMessage = "Por facor, selecciona una fecha y hora posterior a la actual.";
            }
        } catch (Exception e) {
            dateTimeErrorMessage = "Por favor, seleccione una fecha y hora.";
        }
        
        return dateTimeErrorMessage;
    }
    
}
