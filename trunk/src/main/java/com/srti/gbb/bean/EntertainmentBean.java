/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.bean;

import java.util.Objects;

/**
 *
 * @author rajkiran
 */
public class EntertainmentBean 
{
   private String entertainement;

    /**
     * @return the entertainement
     */
    public String getEntertainement() {
        return entertainement;
    }

    /**
     * @param entertainement the entertainement to set
     */
    public void setEntertainement(String entertainement) {
        this.entertainement = entertainement;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.entertainement);
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
        final EntertainmentBean other = (EntertainmentBean) obj;
        if (!Objects.equals(this.entertainement, other.entertainement)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntertainmentBean{" + "entertainement=" + entertainement + '}';
    }
    
    
   
}
