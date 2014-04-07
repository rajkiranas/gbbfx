/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

import java.io.Serializable;

/**
 *
 * @author rajkirans
 */
public class AddictionBean  implements Serializable
{
    private String addiction;
    private int frequencyPerWeek;

    public String getAddiction() {
        return addiction;
    }

    public void setAddiction(String addiction) {
        this.addiction = addiction;
    }

    public int getFrequencyPerWeek() {
        return frequencyPerWeek;
    }

    public void setFrequencyPerWeek(int frequencyPerWeek) {
        this.frequencyPerWeek = frequencyPerWeek;
    }

    @Override
    public String toString() {
        return "AddictionBean{" + "addiction=" + addiction + ", frequencyPerWeek=" + frequencyPerWeek + '}';
    }
    
    
}
