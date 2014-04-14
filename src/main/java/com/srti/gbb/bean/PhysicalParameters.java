/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.bean;

import java.io.Serializable;

/**
 *
 * @author rajkiran
 */
public class PhysicalParameters  implements Serializable
{
    private int feets;
    private int inches;
    private float weight;
    private float hip;
    private float waist;
    private float bp;
    private float haemoglobin;
    private String toeTouching;
    private float toeTouchingCm;
    
    private int looseMotionsPerWeek;
    private int constipationsPerWeek;

    public int getFeets() {
        return feets;
    }

    public void setFeets(int feets) {
        this.feets = feets;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLooseMotionsPerWeek() {
        return looseMotionsPerWeek;
    }

    public void setLooseMotionsPerWeek(int looseMotionsPerWeek) {
        this.looseMotionsPerWeek = looseMotionsPerWeek;
    }

    public int getConstipationsPerWeek() {
        return constipationsPerWeek;
    }

    public void setConstipationsPerWeek(int constipationsPerWeek) {
        this.constipationsPerWeek = constipationsPerWeek;
    }

    public float getHip() {
        return hip;
    }

    public void setHip(float hip) {
        this.hip = hip;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getBp() {
        return bp;
    }

    public void setBp(float bp) {
        this.bp = bp;
    }

    public float getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(float haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public String getToeTouching() {
        return toeTouching;
    }

    public void setToeTouching(String toeTouching) {
        this.toeTouching = toeTouching;
    }

    public float getToeTouchingCm() {
        return toeTouchingCm;
    }

    public void setToeTouchingCm(float toeTouchingCm) {
        this.toeTouchingCm = toeTouchingCm;
    }

    @Override
    public String toString() {
        return "PhysicalParameters{" + "feets=" + feets + ", inches=" + inches + ", weight=" + weight + ", hip=" + hip + ", waist=" + waist + ", bp=" + bp + ", haemoglobin=" + haemoglobin + ", toeTouching=" + toeTouching + ", toeTouchingCm=" + toeTouchingCm + ", looseMotionsPerWeek=" + looseMotionsPerWeek + ", constipationsPerWeek=" + constipationsPerWeek + '}';
    }
    
}
