/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author rajkirans
 */
public class PropertyBean  implements Serializable
{
    private String propertyType;
    private boolean isOwned;
    private boolean isRented;
    private int approxAreaSqFt;
    private int approxAreaAcres;
    private int membersInHouse;
    private long outstandingLoan;

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isIsOwned() {
        return isOwned;
    }

    public void setIsOwned(boolean isOwned) {
        this.isOwned = isOwned;
    }

    public boolean isIsRented() {
        return isRented;
    }

    public void setIsRented(boolean isRented) {
        this.isRented = isRented;
    }

    public int getApproxAreaSqFt() {
        return approxAreaSqFt;
    }

    public void setApproxAreaSqFt(int approxArea) {
        this.approxAreaSqFt = approxArea;
    }

    public int getMembersInHouse() {
        return membersInHouse;
    }

    public void setMembersInHouse(int membersInHouse) {
        this.membersInHouse = membersInHouse;
    }

    public long getOutstandingLoan() {
        return outstandingLoan;
    }

    public void setOutstandingLoan(long outstandingLoan) {
        this.outstandingLoan = outstandingLoan;
    }

    @Override
    public String toString() {
        return "PropertyBean{" + "propertyType=" + propertyType + ", isOwned=" + isOwned + ", isRented=" + isRented + ", approxAreaSqFt=" + approxAreaSqFt + ", approxAreaAcres=" + approxAreaAcres + ", membersInHouse=" + membersInHouse + ", outstandingLoan=" + outstandingLoan + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.propertyType);
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
        final PropertyBean other = (PropertyBean) obj;
        if (!Objects.equals(this.propertyType, other.propertyType)) {
            return false;
        }
        return true;
    }

    /**
     * @return the approxAreaAcres
     */
    public int getApproxAreaAcres() {
        return approxAreaAcres;
    }

    /**
     * @param approxAreaAcres the approxAreaAcres to set
     */
    public void setApproxAreaAcres(int approxAreaAcres) {
        this.approxAreaAcres = approxAreaAcres;
    }
    
    
    
}
