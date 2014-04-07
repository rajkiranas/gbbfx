/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author sateri
 */
public class AllergyBean  implements Serializable
{
    private String allergyName;

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.allergyName);
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
        final AllergyBean other = (AllergyBean) obj;
        if (!Objects.equals(this.allergyName, other.allergyName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AllergyBean{" + "allergyName=" + allergyName + '}';
    }
    
    
    
}
