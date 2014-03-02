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
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField txtAvgPgPer;
    
    @FXML
    private TextField txtNoOfPgRepeats;
    
    @FXML
    private TextField txtFacultyStream;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }
    
    @FXML
    private void setInputPrompt(Event e)
    {
        cmbFacultyStream.setPromptText("Faculty");
    }

    @FXML
    private void addSchoolAndClearForm(ActionEvent event) 
    {
        if(validateEducationForm())
        {
            educationList.add(getEducationBeanForCurrentForm());
            clearEducationForm();
        }
    }
    
    private EducationBean getEducationBeanForCurrentForm()
    {
        EducationBean bean = new EducationBean();
        
        bean.setSchoolName(txtSchool.getText().trim());
        bean.setClassDegree(txtClassDegree.getText().trim());
        bean.setMedium(txtMedium.getText().trim());
        if(cmbFacultyStream.getValue()!=null)
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
        cmbFacultyStream.setValue(GlobalConstants.emptyString);
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
                !cmbFacultyStream.getValue().toString().trim().equals(GlobalConstants.emptyString) || 
                !txtBoardUni.getText().trim().equals(GlobalConstants.emptyString) || 
                !txtSubjects.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateEducationForm() && validateAvgPerformanceForm())
            {
                educationList.add(getEducationBeanForCurrentForm());
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
            else if ((cmbFacultyStream.getValue() != null) && (!txtFacultyStream.getText().trim().equals(GlobalConstants.emptyString))) 
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
        
        if(!txtAvgPgPer.getText().equals(GlobalConstants.emptyString))
            performance.setAvgPGPercentage(Float.valueOf(txtAvgPgPer.getText()));
        
        if(!txtNoOfPgRepeats.getText().equals(GlobalConstants.emptyString))
            performance.setNoOfPGRepeats(Integer.parseInt(txtNoOfPgRepeats.getText()));
        
        navigator.getUserInfo().setAvgPerformanceBean(performance);
    }
    
}
