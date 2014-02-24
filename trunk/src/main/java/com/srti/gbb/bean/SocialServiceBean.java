/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.bean;

/**
 *
 * @author rajkiran
 */
public class SocialServiceBean 
{
    private float approxAmtCash;
    private float approxAmtKind;
    private float approxAmtService;
    private int cashPerWeek;
    private int kindPerWeek;
    private int socialServicePerWeek;
    private String areaOfWork;

    public float getApproxAmtCash() {
        return approxAmtCash;
    }

    public void setApproxAmtCash(float approxAmtCash) {
        this.approxAmtCash = approxAmtCash;
    }

    public float getApproxAmtKind() {
        return approxAmtKind;
    }

    public void setApproxAmtKind(float approxAmtKind) {
        this.approxAmtKind = approxAmtKind;
    }

    public float getApproxAmtService() {
        return approxAmtService;
    }

    public void setApproxAmtService(float approxAmtService) {
        this.approxAmtService = approxAmtService;
    }

    public int getCashPerWeek() {
        return cashPerWeek;
    }

    public void setCashPerWeek(int cashPerWeek) {
        this.cashPerWeek = cashPerWeek;
    }

    public int getKindPerWeek() {
        return kindPerWeek;
    }

    public void setKindPerWeek(int kindPerWeek) {
        this.kindPerWeek = kindPerWeek;
    }

    public int getSocialServicePerWeek() {
        return socialServicePerWeek;
    }

    public void setSocialServicePerWeek(int socialServicePerWeek) {
        this.socialServicePerWeek = socialServicePerWeek;
    }

    /**
     * @return the areaOfWork
     */
    public String getAreaOfWork() {
        return areaOfWork;
    }

    /**
     * @param areaOfWork the areaOfWork to set
     */
    public void setAreaOfWork(String areaOfWork) {
        this.areaOfWork = areaOfWork;
    }
    
    
    
    
}
