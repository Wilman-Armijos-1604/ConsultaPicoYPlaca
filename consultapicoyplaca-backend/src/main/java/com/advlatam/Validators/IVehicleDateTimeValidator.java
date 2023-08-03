/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.advlatam.Validators;

import com.advlatam.Models.VehicleDateTime;
import java.util.Map;

/**
 *
 * @author Wilman Armijos
 */
public interface IVehicleDateTimeValidator {
    
    public Map<String, String> validateVehicleDateTime(VehicleDateTime vehicleDateTime);
    
    public String validateLicensePlate(String licensePlate);
    
    public String validateDateTime(String dateTime);
    
}
