/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.AveragePerformanceBean;
import com.srti.gbb.bean.EducationBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen4Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    private List<EducationBean> educationList = new ArrayList<EducationBean>();
    private List<String> listFacultyStream=new ArrayList<String>();
    
    @FXML
    private Color x1;
    @FXML
    private ComboBox cmbFacultyStream;
    @FXML
    private Button btnAddSchool;
    
    @FXML
    private TextField txtSchool;
    
    @FXML
    private TextField txtClassDegree;
    
    @FXML
    private TextField txtMedium;
    
    @FXML
    private TextField txtBoardUni;
    
    @FXML
    private TextField txtSubjects;
    
    @FXML
    private TextField txtAvgSchoolPer;
    
    @FXML
    private TextField txtNoOfSchoolRepeats;
    
    @FXML
    private TextField txtAvgCollegePer;
    
    @FXML
    private TextField txtNoOfCollegeRepeats;
    
    @FXML
    private TextField txtSubRepeatsCollege;
    
    @FXML
    private TextField txtAvgPgPer;
    
    @FXML
    private TextField txtNoOfPgRepeats;
    
    @FXML
    private TextField txtSubRepeatsPG;
    
    @FXML
    private TextField txtFacultyStream;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideShowPreviousLink();
    }    

    @FXML
    private void populateFacultyStreams(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Faculty_Stream_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFacultyStream.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFacultyStream.getItems().addAll(gen);                    
            }
        }
        
        if(listFacultyStream.isEmpty())
        {
            listFacultyStream.addAll(Arrays.asList(list));
        }
    }
    
//    @FXML
//    private void setInputPrompt(Event e)
//    {
//        cmbFacultyStream.setPromptText("Faculty");
//    }

    @FXML
    private void addSchoolAndClearForm(ActionEvent event) 
    {
        if(validateEducationForm())
        {
            addToEducationList(getEducationBeanForCurrentForm());
            clearEducationForm();
            showPreviousLink();
        }
    }
    
    private EducationBean getEducationBeanForCurrentForm()
    {
        EducationBean bean = new EducationBean();
        
        bean.setSchoolName(txtSchool.getText().trim());
        bean.setClassDegree(txtClassDegree.getText().trim());
        bean.setMedium(txtMedium.getText().trim());
        if(cmbFacultyStream.getValue()!=null && !cmbFacultyStream.getValue().toString().equals(GlobalConstants.emptyString))
        {
            bean.setFacultyStream(cmbFacultyStream.getValue().toString().trim());
        }
        else
        {
            bean.setFacultyStream(txtFacultyStream.getText().trim());
        }
        
        bean.setBoardUniveristy(txtBoardUni.getText().trim());
        bean.setSubjects(txtSubjects.getText().trim());
        return bean;
    }
    private void clearEducationForm()
    {
        txtSchool.setText(GlobalConstants.emptyString);
        txtClassDegree.setText(GlobalConstants.emptyString);
        cmbFacultyStream.getSelectionModel().clearSelection();
        txtFacultyStream.setText(GlobalConstants.emptyString);
        txtMedium.setText(GlobalConstants.emptyString);
        txtBoardUni.setText(GlobalConstants.emptyString);
        txtSubjects.setText(GlobalConstants.emptyString);
    }

    @FXML
    private void goToScreen3(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen3ID);
    }

    @FXML
    private void goToScreen5(ActionEvent event) 
    {
        //filled form
        if(!txtSchool.getText().trim().equals(GlobalConstants.emptyString) || 
                !txtClassDegree.getText().trim().equals(GlobalConstants.emptyString) || 
                !txtMedium.getText().trim().equals(GlobalConstants.emptyString) || 
                cmbFacultyStream.getValue()!=null || 
                !txtBoardUni.getText().trim().equals(GlobalConstants.emptyString) || 
                !txtSubjects.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateEducationForm() && validateAvgPerformanceForm())
            {
                addToEducationList(getEducationBeanForCurrentForm());
                setEducationData();
                setAvgPerformanceData();
                navigator.navigateTo(ScreensFramework.screen5ID);
            }
        }
        else
        {
            //empty form
            if(educationList.isEmpty())
            {
                UIUtils.showAlert("Please provide education details", "Alert");
            }
            else if(validateAvgPerformanceForm())
            {
                setEducationData();
                setAvgPerformanceData();
                navigator.navigateTo(ScreensFramework.screen5ID);                
            }
            
        }
    }
    
    private boolean validateEducationForm()
     {
         
         boolean isValid=true;
         
            if(txtSchool.getText()==null || txtSchool.getText().trim().equals(GlobalConstants.emptyString))
            {
                UIUtils.showAlert("Please enter school/college name", "Alert"); 
                isValid=false;
            }
            else if(!GbbValidator.isValidName(txtSchool.getText()))
            {
                UIUtils.showAlert("Invalid school/college name", "Alert"); 
                isValid=false;
            }
            else if(txtClassDegree.getText()==null || txtClassDegree.getText().trim().equals(GlobalConstants.emptyString))
            {
                UIUtils.showAlert("Please enter class/degree", "Alert"); 
                isValid=false;
            }
            else if(txtMedium.getText()==null || txtMedium.getText().trim().equals(GlobalConstants.emptyString))
            {
                UIUtils.showAlert("Please enter medium of learning", "Alert"); 
                isValid=false;
            }
            else if(!GbbValidator.isValidName(txtMedium.getText()))
            {
                UIUtils.showAlert("Invalid medium", "Alert"); 
                isValid=false;
            }
            else if((cmbFacultyStream.getValue() ==null || cmbFacultyStream.getValue().toString().trim().equals(GlobalConstants.emptyString)) && (txtFacultyStream.getText() ==null || txtFacultyStream.getText().trim().equals(GlobalConstants.emptyString)))
            {
                UIUtils.showAlert("Please select or enter faculty", "Alert"); 
                isValid=false;
            }
            else if ((cmbFacultyStream.getValue() != null && !cmbFacultyStream.getValue().toString().equals(GlobalConstants.emptyString)) && (!txtFacultyStream.getText().trim().equals(GlobalConstants.emptyString))) 
            {
             UIUtils.showAlert("Please either select or enter the faculty", "Alert");
             isValid = false;
            }
            else if(txtBoardUni.getText()==null || txtBoardUni.getText().trim().equals(GlobalConstants.emptyString))
            {
                UIUtils.showAlert("Please enter board/university", "Alert"); 
                isValid=false;
            }
            else if(!GbbValidator.isValidName(txtBoardUni.getText()))
            {
                UIUtils.showAlert("Invalid board/university", "Alert"); 
                isValid=false;
            }
            else if(txtSubjects.getText()==null || txtSubjects.getText().trim().equals(GlobalConstants.emptyString))
            {
                UIUtils.showAlert("Please enter subject(s) learned", "Alert"); 
                isValid=false;
            }
         
         
         return isValid;
     }
    private boolean validateAvgPerformanceForm()
     {
         
         boolean isValid=true;
         if(txtAvgSchoolPer.getText()==null || txtAvgSchoolPer.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter average school percentage", "Alert"); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtAvgSchoolPer.getText()))
         {
             UIUtils.showAlert("Invalid average school percentage", "Alert"); 
             isValid=false;
         }
         
         else if(txtNoOfSchoolRepeats.getText()==null || txtNoOfSchoolRepeats.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter no. of repeats in school", "Alert"); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtNoOfSchoolRepeats.getText()))
         {
             UIUtils.showAlert("Invalid no. of repeats in school", "Alert"); 
             isValid=false;
         }
         else if(!txtAvgCollegePer.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtAvgCollegePer.getText()))
         {
             UIUtils.showAlert("Invalid avg college percentage", "Alert"); 
             isValid=false;
         }
         else if(!txtNoOfCollegeRepeats.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtNoOfCollegeRepeats.getText()))
         {
             UIUtils.showAlert("Invalid no. of college repeats", "Alert"); 
             isValid=false;
         }
         else if(!txtSubRepeatsCollege.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtSubRepeatsCollege.getText()))
         {
             UIUtils.showAlert("Invalid no. of subject repeats in college", "Alert"); 
             isValid=false;
         }
         
         else if(!txtAvgPgPer.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtAvgPgPer.getText()))
         {
             UIUtils.showAlert("Invalid avg percentage in pg", "Alert"); 
             isValid=false;
         }
         
         else if(!txtNoOfPgRepeats.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtNoOfPgRepeats.getText()))
         {
             UIUtils.showAlert("Invalid no. of repeats in post graduation", "Alert"); 
             isValid=false;
         }
         else if(!txtSubRepeatsPG.getText().equals(GlobalConstants.emptyString) && !GbbValidator.isValidNumber(txtSubRepeatsPG.getText()))
         {
             UIUtils.showAlert("Invalid no. of subject repeats in post graduation", "Alert"); 
             isValid=false;
         }
         
         return isValid;
     }

    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    private void setEducationData() 
    {
        navigator.getUserInfo().setEducationList(educationList);        
    }

    private void setAvgPerformanceData() 
    {
        AveragePerformanceBean performance = new AveragePerformanceBean();
        performance.setAvgSchoolPercentage(Float.valueOf(txtAvgSchoolPer.getText()));
        performance.setNoOfSchoolRepeats(Integer.parseInt(txtNoOfSchoolRepeats.getText()));
        
        if(!txtAvgCollegePer.getText().equals(GlobalConstants.emptyString))
            performance.setAvgCollegePercentage(Float.valueOf(txtAvgCollegePer.getText()));
        
        if(!txtNoOfCollegeRepeats.getText().equals(GlobalConstants.emptyString))
            performance.setNoOfCollegeRepeats(Integer.parseInt(txtNoOfCollegeRepeats.getText()));
        
        if(!txtSubRepeatsCollege.getText().equals(GlobalConstants.emptyString))
            performance.setNoOfSubjectRepeatsInCollege(Integer.parseInt(txtSubRepeatsCollege.getText()));
        
        if(!txtAvgPgPer.getText().equals(GlobalConstants.emptyString))
            performance.setAvgPGPercentage(Float.valueOf(txtAvgPgPer.getText()));
        
        if(!txtNoOfPgRepeats.getText().equals(GlobalConstants.emptyString))
            performance.setNoOfPGRepeats(Integer.parseInt(txtNoOfPgRepeats.getText()));
        
        if(!txtSubRepeatsPG.getText().equals(GlobalConstants.emptyString))
            performance.setNoOfSubjectRepeatsInPG(Integer.parseInt(txtSubRepeatsPG.getText()));
        
        
        navigator.getUserInfo().setAvgPerformanceBean(performance);
    }
    
    @FXML
    Hyperlink linkShowPrevious;
    
    private void hideShowPreviousLink() {
        linkShowPrevious.setVisible(false);
    }
    
    private void showPreviousLink() {
        linkShowPrevious.setVisible(true);
    }
    
    private int previousCounter=0;
    
    @FXML
    private void showPrevious()
    {
        if(previousCounter==0)
        {
            previousCounter=educationList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        EducationBean school = educationList.get(previousCounter);
        
        String name = school.getSchoolName();
        String classDegree = school.getClassDegree();
        String medium = school.getMedium();
        String stream = school.getFacultyStream();
        String boardUni = school.getBoardUniveristy();
        String subjects = school.getSubjects();
        
        txtSchool.setText(name);
        txtClassDegree.setText(classDegree);
        txtMedium.setText(medium);
        txtBoardUni.setText(boardUni);
        txtSubjects.setText(subjects);
        
        if (listFacultyStream.contains(stream)) 
        {
            cmbFacultyStream.getSelectionModel().select(stream);
            txtFacultyStream.setText(GlobalConstants.emptyString);
        } else 
        {
            txtFacultyStream.setText(stream);
            cmbFacultyStream.getSelectionModel().clearSelection();
        }
    }

    private void addToEducationList(EducationBean h) {
        if (educationList.contains(h)) 
        {
            educationList.remove(h);
            educationList.add(h);
        } else 
        {
            educationList.add(h);
        }
    }
}
