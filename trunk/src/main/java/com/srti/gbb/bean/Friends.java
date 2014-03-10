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
public class Friends 
{
    private String friendName;
    private String highestQualification;
    private String occupation;
    private String profession;
    private String income;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.friendName);
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
        final Friends other = (Friends) obj;
        if (!Objects.equals(this.friendName, other.friendName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Friends{" + "friendName=" + friendName + ", highestQualification=" + highestQualification + ", occupation=" + occupation + ", profession=" + profession + ", income=" + income + '}';
    }
    
    
    
}
