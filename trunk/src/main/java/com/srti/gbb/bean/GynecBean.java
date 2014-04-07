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
public class GynecBean  implements Serializable
{
    private boolean irregularMenses;
    private boolean painfulMenses;
    private boolean heavyMenses;
    private int menopauseHysterectomyAtAge;

    public boolean isIrregularMenses() {
        return irregularMenses;
    }

    public void setIrregularMenses(boolean irregularMenses) {
        this.irregularMenses = irregularMenses;
    }

    public boolean isPainfulMenses() {
        return painfulMenses;
    }

    public void setPainfulMenses(boolean painfulMenses) {
        this.painfulMenses = painfulMenses;
    }

    public boolean isHeavyMenses() {
        return heavyMenses;
    }

    public void setHeavyMenses(boolean heavyMenses) {
        this.heavyMenses = heavyMenses;
    }

    public int getMenopauseHysterectomyAtAge() {
        return menopauseHysterectomyAtAge;
    }

    public void setMenopauseHysterectomyAtAge(int menopauseHysterectomyAtAge) {
        this.menopauseHysterectomyAtAge = menopauseHysterectomyAtAge;
    }

    @Override
    public String toString() {
        return "GynecBean{" + "irregularMenses=" + irregularMenses + ", painfulMenses=" + painfulMenses + ", heavyMenses=" + heavyMenses + ", menopauseHysterectomyAtAge=" + menopauseHysterectomyAtAge + '}';
    }
    
    
    
    
}
