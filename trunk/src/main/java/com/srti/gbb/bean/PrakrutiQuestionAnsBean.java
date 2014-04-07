/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author rajkirans
 */
public class PrakrutiQuestionAnsBean  implements Serializable
{
    private String question;
    private String ans1;
    private String ans1b;
    private String ans1c;
    private String ans2;
    private String ans2b;
    private String ans2c;
    private String ans3;
    private String ans3b;
    private String ans3c;
    
    private boolean opt1Checked;
    private boolean opt2Checked;
    private boolean opt3Checked;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrakrutiQuestionAnsBean other = (PrakrutiQuestionAnsBean) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

    public String getAns1b() {
        return ans1b;
    }

    public void setAns1b(String ans1b) {
        this.ans1b = ans1b;
    }

    public String getAns1c() {
        return ans1c;
    }

    public void setAns1c(String ans1c) {
        this.ans1c = ans1c;
    }

    public String getAns2b() {
        return ans2b;
    }

    public void setAns2b(String ans2b) {
        this.ans2b = ans2b;
    }

    public String getAns2c() {
        return ans2c;
    }

    public void setAns2c(String ans2c) {
        this.ans2c = ans2c;
    }

    public String getAns3b() {
        return ans3b;
    }

    public void setAns3b(String ans3b) {
        this.ans3b = ans3b;
    }

    public String getAns3c() {
        return ans3c;
    }

    public void setAns3c(String ans3c) {
        this.ans3c = ans3c;
    }


    public boolean isOpt1Checked() {
        return opt1Checked;
    }

    public void setOpt1Checked(boolean opt1Checked) {
        this.opt1Checked = opt1Checked;
    }

    public boolean isOpt2Checked() {
        return opt2Checked;
    }

    public void setOpt2Checked(boolean opt2Checked) {
        this.opt2Checked = opt2Checked;
    }

    public boolean isOpt3Checked() {
        return opt3Checked;
    }

    public void setOpt3Checked(boolean opt3Checked) {
        this.opt3Checked = opt3Checked;
    }

    @Override
    public String toString() {
        return "PrakrutiQuestionAnsBean{" + "question=" + question + ", ans1=" + ans1 + ", ans1b=" + ans1b + ", ans1c=" + ans1c + ", ans2=" + ans2 + ", ans2b=" + ans2b + ", ans2c=" + ans2c + ", ans3=" + ans3 + ", ans3b=" + ans3b + ", ans3c=" + ans3c + ", opt1Checked=" + opt1Checked + ", opt2Checked=" + opt2Checked + ", opt3Checked=" + opt3Checked + '}';
    }
    
    
}
