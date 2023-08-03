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
import org.springframework.stereotype.Service;

/**
 *
 * @author Wilman Armijos
 */

@Service
public class VehicleDateTimeService {
    
    public String CheckAbleVehicleDateTime(VehicleDateTime vehicleDateTime) {
        String AbleCheckmessage;
        
        String licensePlate = vehicleDateTime.getLicensePlate();
        LocalDateTime parsedDateTime = LocalDateTime.parse(vehicleDateTime.getDateTime(), DateTimeFormatter.ISO_DATE_TIME);
        
        Character lastDigit = licensePlate.charAt(licensePlate.length()-1);
        DayOfWeek dayOfWeekTest = parsedDateTime.getDayOfWeek();
        LocalTime time = parsedDateTime.toLocalTime();
        
        boolean testDate = dayOfWeekTest==VehicleDateTimeRestrictionsTable.NUMBER_DATE_RESTRICTION.get(lastDigit);
        boolean testTimeDay = (time.isAfter(VehicleDateTimeRestrictionsTable.DAY_RESTRICTION_START) && time.isBefore(VehicleDateTimeRestrictionsTable.DAY_RESTRICTION_END));
        boolean testTimeNight = (time.isAfter(VehicleDateTimeRestrictionsTable.NIGHT_RESTRICTION_START) && time.isBefore(VehicleDateTimeRestrictionsTable.NIGHT_RESTRICTION_END));
        
        if (testDate && (testTimeDay || testTimeNight)) {
            AbleCheckmessage = " no puede circular ";
        } else {
            AbleCheckmessage = " puede circular ";
        }
        
        return AbleCheckmessage;
    }

}
