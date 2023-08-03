/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.advlatam.Models;

/**
 *
 * @author Wilman Armijos
 */
public class VehicleDateTime {
    
    private String licensePlate;
    private String dateTime;

    public VehicleDateTime(String licensePlate, String dateTime) {
        this.licensePlate = licensePlate;
        this.dateTime = dateTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

}
