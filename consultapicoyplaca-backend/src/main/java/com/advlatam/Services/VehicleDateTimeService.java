/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.advlatam.Services;

import com.advlatam.Constants.VehicleDateTimeRestrictionsTable;
import com.advlatam.Models.VehicleDateTime;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Armijos
 */

@Service
public class VehicleDateTimeService {
    
    public HashMap<String, String> CheckAbleVehicleDateTime(VehicleDateTime vehicleDateTime) {
        HashMap<String,String> ableCheckMessage = new HashMap<>();
        
        String licensePlate = vehicleDateTime.getLicensePlate();
        LocalDateTime parsedDateTime = LocalDateTime.parse(vehicleDateTime.getDateTime(), DateTimeFormatter.ISO_DATE_TIME);
        
        Character lastDigit = licensePlate.charAt(licensePlate.length()-1);
        DayOfWeek dayOfWeekTest = parsedDateTime.getDayOfWeek();
        LocalTime time = parsedDateTime.toLocalTime();
        
        // Use of Service for checking "Pico y Placa" restrictions

        // Checking if license plate has restriction on date based on last digit
        boolean testDate = dayOfWeekTest==VehicleDateTimeRestrictionsTable.NUMBER_DATE_RESTRICTION.get(lastDigit);
        // Checking if license plate has restriction on Day time span
        boolean testTimeDay = (time.isAfter(VehicleDateTimeRestrictionsTable.DAY_RESTRICTION_START) && time.isBefore(VehicleDateTimeRestrictionsTable.DAY_RESTRICTION_END));
        // Checking if license plate has restriction on Night time span
        boolean testTimeNight = (time.isAfter(VehicleDateTimeRestrictionsTable.NIGHT_RESTRICTION_START) && time.isBefore(VehicleDateTimeRestrictionsTable.NIGHT_RESTRICTION_END));
        
        // Conditions for checking vechicle availability on "Pico y Placa" Day - Hour
        if (testDate && (testTimeDay || testTimeNight)) {
            ableCheckMessage.put("isNotAble", "NO puede circular ");
        } else {
            ableCheckMessage.put("isAble", "SI puede circular ");
        }
        
        return ableCheckMessage;
    }

}
