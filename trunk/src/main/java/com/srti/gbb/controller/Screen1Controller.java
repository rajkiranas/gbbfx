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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
        private TextField txtReligion;
        
        @FXML
        private ComboBox cmbMaritalStatus;
        
        @FXML
        private ComboBox cmbChildren;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getGendersFromProperty();
        getReligionsFromProperty();
        populateMaritalStatus();
        populateHeightFeets();
        populateHeightInches();
        consolidateRadioButtonsInToggleGroup();
    }    

    /**
     * Initializes the controller class.
     * @param screenParent
     */
        @Override
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
             
              UIUtils.showAlert("sc1_msg_enter_name", GlobalConstants.Lbl_Alert);
    
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtName.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_name", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(txtAge.getText() ==null || txtAge.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_age", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtAge.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_age", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(Integer.parseInt(txtAge.getText())>Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.MaxAge)))
         {
              UIUtils.showAlert("sc1_msg_greater_age", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(cmbGenderList.getValue()==null || cmbGenderList.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_gender", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbReligionList.getValue()==null || cmbReligionList.getValue().toString().trim().equals(GlobalConstants.emptyString))&& (txtReligion.getText() ==null || txtReligion.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_sel_or_enter_religion", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbReligionList.getValue()!=null) && (!txtReligion.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_either_sel_or_enter_religion", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbMaritalStatus.getValue()==null || cmbMaritalStatus.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_marital_status", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((!cmbChildren.isDisabled()) && (cmbChildren.getValue()==null || cmbChildren.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_sel_children", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
//         else if(txtMobile.getText() ==null || txtMobile.getText().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_enter_mobile", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(!GbbValidator.isValidPhoneNumber(txtMobile.getText()))
//         {
//              UIUtils.showAlert("sc1_msg_valid_mobile", GlobalConstants.Lbl_Alert);  
//    
//             isValid=false;
//         }
//         else if(txtEmail.getText() ==null || txtEmail.getText().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_enter_email", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(!GbbValidator.isValidEmail(txtEmail.getText()))
//         {
//              UIUtils.showAlert("sc1_msg_valid_email", GlobalConstants.Lbl_Alert);  
//    
//             isValid=false;
//         }
//         else if(cmbOccupation.getValue()==null || cmbOccupation.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_occu", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(cmbIncome.getValue()==null || cmbIncome.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_income", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
         
         return isValid;
     }

    
    private void getReligionsFromProperty() {
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

    
    private void getGendersFromProperty() 
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
    
    
    

    private void setPersonalInformation() {
        PersonalInformationBean pi = new PersonalInformationBean();
        pi.setName(txtName.getText());
        pi.setAge(Integer.parseInt(txtAge.getText()));
        pi.setGender(cmbGenderList.getValue().toString());
        if(cmbReligionList.getValue()!=null)
        {
            pi.setReligion(cmbReligionList.getValue().toString());
        }
        else
        {
            pi.setReligion(txtReligion.getText().trim());
        }
        pi.setMaritalStatus(cmbMaritalStatus.getValue().toString());
        
        if(!cmbChildren.isDisabled())
            pi.setNoOfChildren(Integer.parseInt(cmbChildren.getValue().toString()));
//        pi.setMobile(Long.parseLong(txtMobile.getText()));
//        pi.setEmail(txtEmail.getText());
//        pi.setOrganization(txtOrganization.getText());
//        pi.setOccupation(cmbOccupation.getValue().toString());
//        pi.setIncome(cmbIncome.getValue().toString());
        System.out.println("1****pi="+pi);
        navigator.getUserInfo().setPi(pi);
    }
    
    private void populateHeightFeets() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Height_Feets_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightFeets.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                    cmbHeightFeets.getItems().addAll(gen);
            }
        }
       
    }
    
    
    private void populateHeightInches() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightInches.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.getProperty((GlobalConstants.Twelve))))
                 cmbHeightInches.getItems().addAll(gen);
            }
        }
       
    }
    
    @FXML
    private TextField txtWaist;
    
    @FXML
    private TextField txtHip;
    
    @FXML
    private TextField txtBp;
    
    @FXML
    private TextField txtHaemoglobin;
    
    @FXML
    private TextField txtToeCm;
    
    @FXML
    private RadioButton radCanTouch;
    
    @FXML
    private RadioButton radCannotTouch;
    
    @FXML
    private RadioButton radCanGoBeyond;
    
    final ToggleGroup group = new ToggleGroup();
    
        
private boolean validatePhysicalParametersForm()
     {
         
         boolean isValid=true;
          if(cmbHeightFeets.getValue()==null || cmbHeightFeets.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_feet", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbHeightInches.getValue()==null || cmbHeightInches.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_inches", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(txtWeight.getText() ==null || txtWeight.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_weight", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtWeight.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_weight", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtHip.getText() ==null || txtHip.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_hip", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isValidNumber(txtHip.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_hip", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtWaist.getText() ==null || txtWaist.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_waist", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isValidNumber(txtWaist.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_waist", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtBp.getText() !=null 
                  && !txtBp.getText().trim().equals(GlobalConstants.emptyString)
                  && !GbbValidator.isValidNumber(txtBp.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_bp", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          else if(txtHaemoglobin.getText() !=null 
                  && !txtHaemoglobin.getText().trim().equals(GlobalConstants.emptyString)
                  && !GbbValidator.isValidNumber(txtHaemoglobin.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_haemoglobin", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
           else if(!radCanTouch.isSelected() && !radCannotTouch.isSelected() && !radCanGoBeyond.isSelected())
         {
             UIUtils.showAlert("sc1_msg_enter_toe_option", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          else if(txtToeCm.getText() ==null || txtToeCm.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_toe_cm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtToeCm.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_toe_cm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          
         return isValid;
     }
    private void setPhysicalParameters() {
        PhysicalParameters phy = new PhysicalParameters();
        phy.setFeets(Integer.valueOf(cmbHeightFeets.getValue().toString()));
        phy.setInches(Integer.valueOf(cmbHeightInches.getValue().toString()));
        phy.setWeight(Integer.parseInt(txtWeight.getText()));
        
        phy.setHip(Integer.parseInt(txtHip.getText()));
        
        if(!txtWaist.getText().equals(GlobalConstants.emptyString))
            phy.setWaist(Integer.parseInt(txtWaist.getText()));
        
        if(!txtBp.getText().equals(GlobalConstants.emptyString))
            phy.setBp(Integer.parseInt(txtBp.getText()));
        
        phy.setHaemoglobin(Integer.parseInt(txtHaemoglobin.getText()));
        
        if(radCanTouch.isSelected())
        {
            phy.setToeTouching(radCanTouch.getText());
        }
        else if(radCannotTouch.isSelected())
        {
            phy.setToeTouching(radCannotTouch.getText());
        }
        else if(radCanGoBeyond.isSelected())
        {
            phy.setToeTouching(radCanGoBeyond.getText());
        }
        
        phy.setToeTouchingCm(Integer.parseInt(txtToeCm.getText()));
        
        System.out.println("2****phy="+phy);
        navigator.getUserInfo().setPhysicalParams(phy);
    }

    
    private void populateMaritalStatus() {
         String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Marital_Status_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbMaritalStatus.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbMaritalStatus.getItems().addAll(gen);
            }
        }
    }
    
    
    @FXML
    private void populateChildren() 
    {
        if (cmbMaritalStatus.getValue() != null
                && !cmbMaritalStatus.getValue().toString().trim().equals(GlobalConstants.emptyString)
                && !cmbMaritalStatus.getValue().toString().equals(GlobalConstants.getProperty(GlobalConstants.Lbl_Single_Status)))
        {
            cmbChildren.setDisable(false);
            String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
            String[] list = genderList.split(GlobalConstants.COMMA);
            if (cmbChildren.getItems().size() == 0) {
                for (String gen : list) {
                    //if(!gen.equals(GlobalConstants.Zero))
                    cmbChildren.getItems().addAll(gen);
                }
            }
        }
        else
        {
            cmbChildren.setDisable(true);
        }
    }

    private void consolidateRadioButtonsInToggleGroup() {
        radCanTouch.setToggleGroup(group);
        radCannotTouch.setToggleGroup(group);
        radCanGoBeyond.setToggleGroup(group);
    }
}
