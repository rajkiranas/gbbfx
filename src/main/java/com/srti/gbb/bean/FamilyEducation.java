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
public class FamilyEducation 
{
    private String name;
    private String familyMember;
    private String highestQualification;
    private String occupation;
    private String profession;
    private String income;
    private boolean isDeceased;

    public String getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(String familyMember) {
        this.familyMember = familyMember;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }


    public boolean isIsDeceased() {
        return isDeceased;
    }

    public void setIsDeceased(boolean isDeceased) {
        this.isDeceased = isDeceased;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final FamilyEducation other = (FamilyEducation) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FamilyEducation{" + "name=" + name + ", familyMember=" + familyMember + ", highestQualification=" + highestQualification + ", occupation=" + occupation + ", profession=" + profession + ", income=" + income + ", isDeceased=" + isDeceased + '}';
    }
    

}
