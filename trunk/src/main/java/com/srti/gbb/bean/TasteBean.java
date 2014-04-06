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
public class TasteBean 
{
    private boolean sweet;
    private boolean sour;
    private boolean salty;
    private boolean pungent;
    private boolean bitter;
    private boolean astringent;

    public boolean isSweet() {
        return sweet;
    }

    public void setSweet(boolean sweet) {
        this.sweet = sweet;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    public boolean isSalty() {
        return salty;
    }

    public void setSalty(boolean salty) {
        this.salty = salty;
    }

    public boolean isPungent() {
        return pungent;
    }

    public void setPungent(boolean pungent) {
        this.pungent = pungent;
    }

    public boolean isBitter() {
        return bitter;
    }

    public void setBitter(boolean bitter) {
        this.bitter = bitter;
    }

    public boolean isAstringent() {
        return astringent;
    }

    public void setAstringent(boolean astringent) {
        this.astringent = astringent;
    }

    @Override
    public String toString() {
        return "TasteBean{" + "sweet=" + sweet + ", sour=" + sour + ", salty=" + salty + ", pungent=" + pungent + ", bitter=" + bitter + ", astringent=" + astringent + '}';
    }
    
}
