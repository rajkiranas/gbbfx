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
public class MealTypeBean {
 private String diet;
 private int nonVegPerWeek;
 private String foodType;
 private int fruitsPerWeek;
 private int eatingOutPerWeek;

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int getNonVegPerWeek() {
        return nonVegPerWeek;
    }

    public void setNonVegPerWeek(int nonVegPerWeek) {
        this.nonVegPerWeek = nonVegPerWeek;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getFruitsPerWeek() {
        return fruitsPerWeek;
    }

    public void setFruitsPerWeek(int fruitsPerWeek) {
        this.fruitsPerWeek = fruitsPerWeek;
    }

    public int getEatingOutPerWeek() {
        return eatingOutPerWeek;
    }

    public void setEatingOutPerWeek(int eatingOutPerWeek) {
        this.eatingOutPerWeek = eatingOutPerWeek;
    }

    @Override
    public String toString() {
        return "MealTypeBean{" + "diet=" + diet + ", nonVegPerWeek=" + nonVegPerWeek + ", foodType=" + foodType + ", fruitsPerWeek=" + fruitsPerWeek + ", eatingOutPerWeek=" + eatingOutPerWeek + '}';
    }
 
 
}
