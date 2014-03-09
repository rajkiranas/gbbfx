/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

import java.util.Objects;

/**
 *
 * @author rajkirans
 */
public class VehicleBean {
    private String vehicleType;
    private int numberOfVehicles;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.vehicleType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VehicleBean other = (VehicleBean) obj;
        if (!Objects.equals(this.vehicleType, other.vehicleType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VehicleBean{" + "vehicleType=" + vehicleType + ", numberOfVehicles=" + numberOfVehicles + '}';
    }
    
    
    
}
