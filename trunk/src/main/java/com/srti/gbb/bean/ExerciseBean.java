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
public class ExerciseBean 
{
    private int exercisePerWeek;
    private String exerciseType;
    private int durationPerDay;

    public int getExercisePerWeek() {
        return exercisePerWeek;
    }

    public void setExercisePerWeek(int exercisePerWeek) {
        this.exercisePerWeek = exercisePerWeek;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public int getDurationPerDay() {
        return durationPerDay;
    }

    public void setDurationPerDay(int durationPerWeek) {
        this.durationPerDay = durationPerWeek;
    }
    
    
    
}
