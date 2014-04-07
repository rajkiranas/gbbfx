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
public class LifestyleBean  implements Serializable
{
    private float wakeupTime;
    private float sleepTime;
    private int afternoonSleepPerWeek;
    private int lateNightsPerWeek;

    public float getWakeupTime() {
        return wakeupTime;
    }

    public void setWakeupTime(float wakeupTime) {
        this.wakeupTime = wakeupTime;
    }

    public float getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(float sleepTime) {
        this.sleepTime = sleepTime;
    }

    public int getAfternoonSleepPerWeek() {
        return afternoonSleepPerWeek;
    }

    public void setAfternoonSleepPerWeek(int afternoonSleepPerWeek) {
        this.afternoonSleepPerWeek = afternoonSleepPerWeek;
    }

    public int getLateNightsPerWeek() {
        return lateNightsPerWeek;
    }

    public void setLateNightsPerWeek(int lateNightsPerWeek) {
        this.lateNightsPerWeek = lateNightsPerWeek;
    }

    @Override
    public String toString() {
        return "LifestyleBean{" + "wakeupTime=" + wakeupTime + ", sleepTime=" + sleepTime + ", afternoonSleepPerWeek=" + afternoonSleepPerWeek + ", lateNightsPerWeek=" + lateNightsPerWeek + '}';
    }
    
    
    
}
