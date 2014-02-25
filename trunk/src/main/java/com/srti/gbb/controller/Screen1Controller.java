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
public class Screen1Controller implements Initializable, ControlledScreen  {

        private ScreensNavigator navigator;
        
        @FXML
        private TextField txtName;
        
        @FXML
        private TextField txtAge;
        
        @FXML
        private TextField txtMobile;
        
        @FXML
        private TextField txtEmail;
        
        @FXML
        private TextField txtOrganization;
        
        @FXML
        private ComboBox cmbOccupation;
        
        @FXML
        private ComboBox cmbIncome;
        
        @FXML
        private ComboBox cmbGenderList;
        
        @FXML
        private ComboBox cmbReligionList;

        @FXML
        private ComboBox cmbHeightFeets;
        
        @FXML
        private ComboBox cmbHeightInches;
        
        @FXML
        private TextField txtWeight;
        
        @FXML
        private ComboBox cmbLooseMotions;
        
        @FXML
        private ComboBox cmbConstipations;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /**
     * Initializes the controller class.
     */
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }
    
    @FXML
    private void setAgeLimit(KeyEvent e)
    {
        txtAge.setPrefColumnCount(3);
    }
    
    @FXML
        private void goToScreen0(ActionEvent event){
       navigator.navigateTo(ScreensFramework.screen0ID);
    }

     @FXML
     private void goToScreen2(ActionEvent event)
     {
         if(validatePersonalInformationForm() && validatePhysicalParametersForm())
         {
             setPersonalInformation();
             setPhysicalParameters();
            navigator.navigateTo(ScreensFramework.screen12ID);
         }
         
         //ValidationUtils.forceValidate(txtName, ValidationMode.ON_FOCUS_LOST);
            
                /* ImageView asteriskImage = new ImageView("/img/red_asterisk.gif");
                Label label = new Label ( "Required",asteriskImage);
                System.out.println("bingo!!!!!");
                Decorator d = new Decorator(label,Pos.TOP_RIGHT);
                
                DecorationUtils.install(txtName, d); */
            
     }
     
     
     private boolean validatePersonalInformationForm()
     {
         
         boolean isValid=true;
         if(txtName.getText() ==null || txtName.getText().trim().equals(GlobalConstants.emptyString))
         {
             
              UIUtils.showAlert("Please enter name", "Alert");  
    
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtName.getText()))
         {
              UIUtils.showAlert("Please enter valid name", "Alert");  
    
             isValid=false;
         }
         else if(txtAge.getText() ==null || txtAge.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter age", "Alert"); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtAge.getText()))
         {
              UIUtils.showAlert("Please enter valid age", "Alert");  
    
             isValid=false;
         }
         else if(Integer.parseInt(txtAge.getText())>Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.MaxAge)))
         {
              UIUtils.showAlert("Age cannot be greater than "+GlobalConstants.getProperty(GlobalConstants.MaxAge), "Alert");  
    
             isValid=false;
         }
         else if(cmbGenderList.getValue()==null || cmbGenderList.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select gender", "Alert"); 
             isValid=false;
         }
         else if(cmbReligionList.getValue()==null || cmbReligionList.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select religion", "Alert"); 
             isValid=false;
         }
         else if(txtMobile.getText() ==null || txtMobile.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter mobile", "Alert"); 
             isValid=false;
         }
         else if(!GbbValidator.isValidPhoneNumber(txtMobile.getText()))
         {
              UIUtils.showAlert("Please enter valid mobile", "Alert");  
    
             isValid=false;
         }
         else if(txtEmail.getText() ==null || txtEmail.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter email", "Alert"); 
             isValid=false;
         }
         else if(!GbbValidator.isValidEmail(txtEmail.getText()))
         {
              UIUtils.showAlert("Please enter valid email", "Alert");  
    
             isValid=false;
         }
         else if(cmbOccupation.getValue()==null || cmbOccupation.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select occupation", "Alert"); 
             isValid=false;
         }
         else if(cmbIncome.getValue()==null || cmbIncome.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select income", "Alert"); 
             isValid=false;
         }
         
         return isValid;
     }

    @FXML
    private void getReligionsFromProperty(Event event) {
        String genderList = GlobalConstants.getProperty(GlobalConstants.ReligionList);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbReligionList.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbReligionList.getItems().addAll(gen);
            }
        }
       
    }

    @FXML
    private void getGendersFromProperty(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.GenderList);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbGenderList.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbGenderList.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private void populateOccupation(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbOccupation.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbOccupation.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private void populateIncome(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Income_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbIncome.getItems().size()==0)
        {
            for(String gen : list)
            {

                 cmbIncome.getItems().addAll(gen);
            }
        }
    }

    private void setPersonalInformation() {
        PersonalInformationBean pi = new PersonalInformationBean();
        pi.setName(txtName.getText());
        pi.setAge(Integer.parseInt(txtAge.getText()));
        pi.setGender(cmbGenderList.getValue().toString());
        pi.setReligion(cmbReligionList.getValue().toString());
        pi.setMobile(Long.parseLong(txtMobile.getText()));
        pi.setEmail(txtEmail.getText());
        pi.setOrganization(txtOrganization.getText());
        pi.setOccupation(cmbOccupation.getValue().toString());
        pi.setIncome(cmbIncome.getValue().toString());
        navigator.getUserInfo().setPi(pi);
    }
    
    
    
        
        
        
         @FXML
    private void populateHeightFeets(Event event) {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightFeets.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.Zero))
                    cmbHeightFeets.getItems().addAll(gen);
            }
        }
       
    }
    
    @FXML
    private void populateHeightInches(Event event) {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightInches.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.Zero))
                 cmbHeightInches.getItems().addAll(gen);
            }
        }
       
    }
    
    @FXML
    private void populateLooseMotionsCombo(Event event) {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
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
   
    @FXML
    private void populateConstipationsCombo(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
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
          if(cmbHeightFeets.getValue()==null || cmbHeightFeets.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select feets", "Alert"); 
             isValid=false;
         }
         else if(cmbHeightInches.getValue()==null || cmbHeightInches.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select inches", "Alert"); 
             isValid=false;
         }
         else if(txtWeight.getText() ==null || txtWeight.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter weight", "Alert"); 
             isValid=false;
         }
          else if(cmbLooseMotions.getValue()==null || cmbLooseMotions.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select loose motions value", "Alert"); 
             isValid=false;
         }
          else if(cmbConstipations.getValue()==null || cmbConstipations.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select constipation value", "Alert"); 
             isValid=false;
         }
         
         return isValid;
     }
    private void setPhysicalParameters() {
        PhysicalParameters phy = new PhysicalParameters();
        phy.setFeets(Integer.valueOf(cmbHeightFeets.getValue().toString()));
        phy.setInches(Integer.valueOf(cmbHeightInches.getValue().toString()));
        phy.setWeight(Integer.parseInt(txtWeight.getText()));
        phy.setLooseMotionsPerWeek(Integer.valueOf(cmbLooseMotions.getValue().toString()));
        phy.setConstipationsPerWeek(Integer.valueOf(cmbConstipations.getValue().toString()));
        navigator.getUserInfo().setPhysicalParams(phy);
    }        
        
        
}
