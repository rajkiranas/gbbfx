/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.AllergyBean;
import com.srti.gbb.bean.IdolBean;
import com.srti.gbb.bean.PhysicalParameters;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen14Controller implements Initializable, ControlledScreen  {

        private ScreensNavigator navigator;
        private List<AllergyBean> allergyList = new ArrayList<AllergyBean>();
        
        @FXML
        private ComboBox cmbLooseMotions;
        
        @FXML
        private ComboBox cmbConstipations;
        
        @FXML
        private TextField txtAllergyName;
        
        @FXML
        private Hyperlink linkShowPrevious;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hideShowPreviousLink();
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
         if(!txtAllergyName.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateAllergyForm() && validatePhysicalParametersForm())
            {
                addAllergyToList(getAllergyBeanForCurrentForm());
                setAllergyData();
                setPhysicalParameters();
                navigateToNextScreen();
            }
            
        }
         else //if(!allergyList.isEmpty())
         {
             if(validatePhysicalParametersForm())
            {
                setAllergyData();
                setPhysicalParameters();
                navigateToNextScreen();
            }   
         }
//         else
//        {
//            UIUtils.showAlert("sc14_msg_enter_atleast_one_allergy_name", GlobalConstants.Lbl_Alert);  
//        }
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
        if(phy==null)
        {
            phy=new PhysicalParameters();
        }
        phy.setLooseMotionsPerWeek(Integer.valueOf(cmbLooseMotions.getValue().toString()));
        phy.setConstipationsPerWeek(Integer.valueOf(cmbConstipations.getValue().toString()));
        System.out.println("2****phy="+phy);
        navigator.getUserInfo().setPhysicalParams(phy);
    }        

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
            previousCounter=allergyList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        AllergyBean a = allergyList.get(previousCounter);
        
        String allergyName = a.getAllergyName();
        txtAllergyName.setText(allergyName);
            
    }
    
        private void addAllergyToList(AllergyBean h) {
        if (allergyList.contains(h)) 
        {
            allergyList.remove(h);
            allergyList.add(h);
        } else 
        {
            allergyList.add(h);
        }
    }
        
    @FXML
    private void addAllergyAndClearForm(ActionEvent event) 
    {
        if(validateAllergyForm())
        {
            addAllergyToList(getAllergyBeanForCurrentForm());
            clearAllergyForm();
            showPreviousLink();
        }
    }
    
    private boolean validateAllergyForm() {
        boolean isValid=true;
         if(txtAllergyName.getText() ==null || txtAllergyName.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc14_msg_enter_allergy_name", GlobalConstants.Lbl_Alert);
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtAllergyName.getText()))
         {
              UIUtils.showAlert("sc14_msg_enter_valid_allergy_name", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         return isValid;
    }
    
    private void clearAllergyForm()
    {
        txtAllergyName.setText(GlobalConstants.emptyString);
    }
    
        private AllergyBean getAllergyBeanForCurrentForm() {
        AllergyBean b = new AllergyBean();
        b.setAllergyName(txtAllergyName.getText());
        return b;
    }

    private void setAllergyData() {
        System.out.println("****allergyList="+allergyList);
        navigator.getUserInfo().setAllergyList(allergyList);
    }

    private void navigateToNextScreen() {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }
}
