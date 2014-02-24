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
public class PrayersBean 
{
    private boolean regularPray;
    private int individualPrayerPerWeek;
    private int familyPrayerPerWeek;
    private int communityPrayerPerWeek;

    public boolean isRegularPray() {
        return regularPray;
    }

    public void setRegularPray(boolean regularPray) {
        this.regularPray = regularPray;
    }

    public int getIndividualPrayerPerWeek() {
        return individualPrayerPerWeek;
    }

    public void setIndividualPrayerPerWeek(int individualPrayerPerWeek) {
        this.individualPrayerPerWeek = individualPrayerPerWeek;
    }

    public int getFamilyPrayerPerWeek() {
        return familyPrayerPerWeek;
    }

    public void setFamilyPrayerPerWeek(int familyPrayerPerWeek) {
        this.familyPrayerPerWeek = familyPrayerPerWeek;
    }

    public int getCommunityPrayerPerWeek() {
        return communityPrayerPerWeek;
    }

    public void setCommunityPrayerPerWeek(int communityPrayerPerWeek) {
        this.communityPrayerPerWeek = communityPrayerPerWeek;
    }
    
    
    
}
