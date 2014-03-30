/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.bean;

import java.util.Objects;

/**
 *
 * @author rajkirans
 */
public class EducationBean 
{
    private String schoolName;
    private String classDegree;
    private String medium;
    private String facultyStream;
    private String boardUniveristy;
    private String subjects;

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassDegree() {
        return classDegree;
    }

    public void setClassDegree(String classDegree) {
        this.classDegree = classDegree;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getFacultyStream() {
        return facultyStream;
    }

    public void setFacultyStream(String facultyStream) {
        this.facultyStream = facultyStream;
    }

    public String getBoardUniveristy() {
        return boardUniveristy;
    }

    public void setBoardUniveristy(String boardUniveristy) {
        this.boardUniveristy = boardUniveristy;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.schoolName);
        hash = 89 * hash + Objects.hashCode(this.classDegree);
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
        final EducationBean other = (EducationBean) obj;
        if (!Objects.equals(this.schoolName, other.schoolName)) {
            return false;
        }
        if (!Objects.equals(this.classDegree, other.classDegree)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EducationBean{" + "schoolName=" + schoolName + ", classDegree=" + classDegree + ", medium=" + medium + ", facultyStream=" + facultyStream + ", boardUniveristy=" + boardUniveristy + ", subjects=" + subjects + '}';
    }

    
    
    
    
}
