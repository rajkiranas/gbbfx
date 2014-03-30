/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

/**
 *
 * @author rajkirans
 */
public class FamilyEducation 
{
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

    @Override
    public String toString() {
        return "FamilyEducation{" + "familyMember=" + familyMember + ", highestQualification=" + highestQualification + ", occupation=" + occupation + ", profession=" + profession + ", income=" + income + ", isDeceased=" + isDeceased + '}';
    }

    
    
}
