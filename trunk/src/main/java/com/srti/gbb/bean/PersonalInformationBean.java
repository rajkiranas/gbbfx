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
public class PersonalInformationBean  implements Serializable
{
    private String name;
    private int age;
    private String gender;
    private String religion;
    private long mobile;
    private String email;
    private String organization;
    private String occupation;
    private String income;
    private String qualification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the income
     */
    public String getIncome() {
        return income;
    }

    /**
     * @param income the income to set
     */
    public void setIncome(String income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "PersonalInformationBean{" + "name=" + name + ", age=" + age + ", gender=" + gender + ", religion=" + religion + ", mobile=" + mobile + ", email=" + email + ", organization=" + organization + ", occupation=" + occupation + ", income=" + income + '}';
    }

    /**
     * @return the qualification
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @param qualification the qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    
    
}
