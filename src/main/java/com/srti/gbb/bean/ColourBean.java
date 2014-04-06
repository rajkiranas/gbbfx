/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.bean;

/**
 *
 * @author sateri
 */
public class ColourBean 
{
    private boolean red;
    private boolean orange;
    
    private boolean yellow;
    private boolean green;
    
    private boolean blue;
    private boolean violate;
    
    private boolean white;

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public boolean isOrange() {
        return orange;
    }

    public void setOrange(boolean orange) {
        this.orange = orange;
    }

    public boolean isYellow() {
        return yellow;
    }

    public void setYellow(boolean yellow) {
        this.yellow = yellow;
    }

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public boolean isBlue() {
        return blue;
    }

    public void setBlue(boolean blue) {
        this.blue = blue;
    }

    public boolean isViolate() {
        return violate;
    }

    public void setViolate(boolean violate) {
        this.violate = violate;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    @Override
    public String toString() {
        return "ColourBean{" + "red=" + red + ", orange=" + orange + ", yellow=" + yellow + ", green=" + green + ", blue=" + blue + ", violate=" + violate + ", white=" + white + '}';
    }
    
}
