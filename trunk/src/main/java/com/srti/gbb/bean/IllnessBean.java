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
        return "IllnessBean{" + "illness=" + illness + ", isHospitalized=" + isHospitalized + '}';
    }
    
    
}
