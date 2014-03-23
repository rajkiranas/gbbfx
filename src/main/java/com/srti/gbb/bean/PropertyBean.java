/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

/**
 *
 * @author rajkirans
 */
public class PropertyBean 
{
    private String propertyType;
    private boolean isOwned;
    private boolean isRented;
    private int approxArea;
    private int membersInHouse;
    private int outstandingLoan;

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

    public int getApproxArea() {
        return approxArea;
    }

    public void setApproxArea(int approxArea) {
        this.approxArea = approxArea;
    }

    public int getMembersInHouse() {
        return membersInHouse;
    }

    public void setMembersInHouse(int membersInHouse) {
        this.membersInHouse = membersInHouse;
    }

    public int getOutstandingLoan() {
        return outstandingLoan;
    }

    public void setOutstandingLoan(int outstandingLoan) {
        this.outstandingLoan = outstandingLoan;
    }

    @Override
    public String toString() {
        return "PropertyBean{" + "propertyType=" + propertyType + ", isOwned=" + isOwned + ", isRented=" + isRented + ", approxArea=" + approxArea + ", membersInHouse=" + membersInHouse + ", outstandingLoan=" + outstandingLoan + '}';
    }
    
    
    
}
