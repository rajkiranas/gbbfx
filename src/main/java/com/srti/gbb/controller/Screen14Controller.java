/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.PersonalInformationBean;
import com.srti.gbb.bean.PhysicalParameters;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen14Controller implements Initializable, ControlledScreen  {

        private ScreensNavigator navigator;
        
        @FXML
        private ComboBox cmbLooseMotions;
        
        @FXML
        private ComboBox cmbConstipations;
        
        @FXML
        private TextField txtReligion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateLooseMotionsCombo();
        populateConstipationsCombo();
    }    

    /**
     * Initializes the controller class.
     */
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }
    

    
    @FXML
        private void goToPreviousScreen(ActionEvent event){
       navigator.navigateTo(ScreensFramework.screen13ID);
    }

     @FXML
     private void goToNextScreen(ActionEvent event)
     {
         if(validatePhysicalParametersForm())
         {
             setPhysicalParameters();
            navigator.navigateTo(ScreensFramework.screen11ID);
         }   
     }
     
     
    
    private void populateLooseMotionsCombo() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbLooseMotions.getItems().size()==0)
        {
            for(String gen : list)
            {
                cmbLooseMotions.getItems().addAll(gen);
            }
            
        }
        
       
    }
   
    
    private void populateConstipationsCombo() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbConstipations.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbConstipations.getItems().addAll(gen);
            }
        }
    }
        
private boolean validatePhysicalParametersForm()
     {
         
         boolean isValid=true;
         if(cmbLooseMotions.getValue()==null || cmbLooseMotions.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_lm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbConstipations.getValue()==null || cmbConstipations.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_consti", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         
         return isValid;
     }
    private void setPhysicalParameters() {
        PhysicalParameters phy = navigator.getUserInfo().getPhysicalParams();
        phy.setLooseMotionsPerWeek(Integer.valueOf(cmbLooseMotions.getValue().toString()));
        phy.setConstipationsPerWeek(Integer.valueOf(cmbConstipations.getValue().toString()));
        System.out.println("2****phy="+phy);
        navigator.getUserInfo().setPhysicalParams(phy);
    }        
        
        
}
