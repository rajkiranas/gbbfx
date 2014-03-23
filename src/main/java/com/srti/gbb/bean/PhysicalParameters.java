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
public class PhysicalParameters 
{
    private int feets;
    private int inches;
    private int weight;
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

    @Override
    public String toString() {
        return "PhysicalParameters{" + "feets=" + feets + ", inches=" + inches + ", weight=" + weight + ", looseMotionsPerWeek=" + looseMotionsPerWeek + ", constipationsPerWeek=" + constipationsPerWeek + '}';
    }
    
    
    
}
