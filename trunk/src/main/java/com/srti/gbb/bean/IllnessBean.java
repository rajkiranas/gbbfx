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
public class IllnessBean  implements Serializable
{
    private String illness;
    private boolean isHospitalized;
    private short intensity;
    private short frequency;
    private String duration;
    private short lastsForDays;
    private short sinceYears;
    private short lossOfManDays;

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public boolean isIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(boolean isHospitalized) {
        this.isHospitalized = isHospitalized;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.illness);
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
        final IllnessBean other = (IllnessBean) obj;
        if (!Objects.equals(this.illness, other.illness)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IllnessBean{" + "illness=" + illness + ", isHospitalized=" + isHospitalized + ", intensity=" + intensity + ", frequency=" + frequency + ", duration=" + duration + ", lastsForDays=" + lastsForDays + ", sinceYears=" + sinceYears + ", lossOfManDays=" + lossOfManDays + '}';
    }

    

    public short getIntensity() {
        return intensity;
    }

    public void setIntensity(short intensity) {
        this.intensity = intensity;
    }

    public short getFrequency() {
        return frequency;
    }

    public void setFrequency(short frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public short getLastsForDays() {
        return lastsForDays;
    }

    public void setLastsForDays(short lastsForDays) {
        this.lastsForDays = lastsForDays;
    }

    public short getSinceYears() {
        return sinceYears;
    }

    public void setSinceYears(short sinceYears) {
        this.sinceYears = sinceYears;
    }

    public short getLossOfManDays() {
        return lossOfManDays;
    }

    public void setLossOfManDays(short lossOfManDays) {
        this.lossOfManDays = lossOfManDays;
    }
    
    
}
