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
    private int weight;
    private int hip;
    private int waist;
    private int bp;
    private int haemoglobin;
    private String toeTouching;
    private int toeTouchingCm;
    
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public int getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(int haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public String getToeTouching() {
        return toeTouching;
    }

    public void setToeTouching(String toeTouching) {
        this.toeTouching = toeTouching;
    }

    public int getToeTouchingCm() {
        return toeTouchingCm;
    }

    public void setToeTouchingCm(int toeTouchingCm) {
        this.toeTouchingCm = toeTouchingCm;
    }

    @Override
    public String toString() {
        return "PhysicalParameters{" + "feets=" + feets + ", inches=" + inches + ", weight=" + weight + ", hip=" + hip + ", waist=" + waist + ", bp=" + bp + ", haemoglobin=" + haemoglobin + ", toeTouching=" + toeTouching + ", toeTouchingCm=" + toeTouchingCm + ", looseMotionsPerWeek=" + looseMotionsPerWeek + ", constipationsPerWeek=" + constipationsPerWeek + '}';
    }
    
}
