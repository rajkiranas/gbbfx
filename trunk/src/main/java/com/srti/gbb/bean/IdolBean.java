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
public class IdolBean  implements Serializable
{
    private String idolName;

    public String getIdolName() {
        return idolName;
    }

    public void setIdolName(String idolName) {
        this.idolName = idolName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idolName);
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
        final IdolBean other = (IdolBean) obj;
        if (!Objects.equals(this.idolName, other.idolName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "IdolBean{" + "idolName=" + idolName + '}';
    }
}
