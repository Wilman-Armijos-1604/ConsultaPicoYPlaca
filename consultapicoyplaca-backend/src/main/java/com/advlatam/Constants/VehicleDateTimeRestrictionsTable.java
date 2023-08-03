/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.advlatam.Constants;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Map;

/**
 *
 * @author Wilman Armijos
 */
public class VehicleDateTimeRestrictionsTable {
    
    public static final Map<Character, DayOfWeek> NUMBER_DATE_RESTRICTION = Map.of(
            '0', DayOfWeek.MONDAY,
            '1', DayOfWeek.MONDAY,
            '2', DayOfWeek.TUESDAY,
            '3', DayOfWeek.TUESDAY,
            '4', DayOfWeek.WEDNESDAY,
            '5', DayOfWeek.WEDNESDAY,
            '6', DayOfWeek.THURSDAY,
            '7', DayOfWeek.THURSDAY,
            '8', DayOfWeek.FRIDAY,
            '9', DayOfWeek.FRIDAY
    );
    
    public static final LocalTime DAY_RESTRICTION_START = LocalTime.of(6, 0);
    public static final LocalTime DAY_RESTRICTION_END = LocalTime.of(9, 30);
    public static final LocalTime NIGHT_RESTRICTION_START = LocalTime.of(16, 0);
    public static final LocalTime NIGHT_RESTRICTION_END = LocalTime.of(20, 0);
    
}
