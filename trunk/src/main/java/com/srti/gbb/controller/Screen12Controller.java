/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.AddressBean;
import com.srti.gbb.bean.PersonalInformationBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen12Controller implements Initializable, ControlledScreen {

     private ScreensNavigator navigator;
     
    /**
     * Initializes the controller class.
     */
     @FXML
     private TextField txtHouse;
     @FXML
     private TextField txtArea;
     @FXML
     private TextField txtCity;
     @FXML
     private TextField txtPincode;
     @FXML
     private ComboBox cmbCountry;
     @FXML
     private ComboBox cmbState;
     
     
    @FXML
    private TextField txtMobile;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtOrganization;
    @FXML
    private ComboBox cmbQual;
    @FXML
    private ComboBox cmbOccupation;
    @FXML
    private ComboBox cmbIncome;
     
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateCountryList();
        populateOccupation();
        populateIncome();
        populateHighestQualification();
        //manageOccuAndProfForHouseWife();
    }    
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void goToScreen0(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen1ID);
    }

    @FXML
    private void goToScreen2(ActionEvent event) {
        if(validateOccupationForm() && validateAddressForm())
        {
            setOccupationData();
            setAddressData();
            navigator.navigateTo(ScreensFramework.Screen_Physiological);
        }
    }
    
    private boolean validateOccupationForm()
     {
         
         boolean isValid=true;
         if(txtMobile.getText() ==null || txtMobile.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_mobile", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidPhoneNumber(txtMobile.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_mobile", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(txtEmail.getText() ==null || txtEmail.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_email", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidEmail(txtEmail.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_email", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(cmbOccupation.getValue()==null || cmbOccupation.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_occu", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbQual.getValue()==null || cmbQual.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_sel_qual", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }         
         else if(cmbIncome.getValue()==null || cmbIncome.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_income", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         
         return isValid;
     }
    
    private boolean validateAddressForm()
     {
         
         boolean isValid=true;
         if(txtHouse.getText() ==null || txtHouse.getText().trim().equals(GlobalConstants.emptyString))
         {
             
              UIUtils.showAlert("sc12_msg_enter_house_info", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         
         else if(txtArea.getText() ==null || txtArea.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_enter_area_info", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         
         else if(cmbCountry.getValue()==null || cmbCountry.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_sel_country", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbState.getValue()==null || cmbState.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_sel_state", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(txtCity.getText() ==null || txtCity.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_enter_city", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(txtPincode.getText() ==null || txtPincode.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc12_msg_enter_pincode", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtPincode.getText()))
         {
              UIUtils.showAlert("sc12_msg_invalid_pincode", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(!GbbValidator.isValidPincode(txtPincode.getText()))
         {
              UIUtils.showAlert("sc12_msg_six_digit_pincode", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         
         return isValid;
     }

    private void populateCountryList() {     
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Country_List_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbCountry.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbCountry.getItems().addAll(gen);                    
            }
        }        
    
    }
    
    @FXML
    private void populateStatesList() {     
        
        String country = cmbCountry.getSelectionModel().getSelectedItem().toString();
        String stateList = GlobalConstants.getProperty(country+"_States");
        String[] list =  stateList.split(GlobalConstants.COMMA);
        
        if(cmbState.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbState.getItems().addAll(gen);                    
            }
        }        
    
    }

    private void setAddressData() 
    {
        AddressBean address = new AddressBean();
        address.setHouse(txtHouse.getText().trim());
        address.setArea(txtArea.getText().trim());
        address.setCountry(cmbCountry.getValue().toString().trim());
        address.setState(cmbState.getValue().toString().trim());
        address.setCity(txtCity.getText().trim());
        address.setPincode(Integer.parseInt(txtPincode.getText().trim()));
//        if(navigator.getUserInfo().getAddress()==null)
//        {
        System.out.println("***address="+address);
            navigator.getUserInfo().setAddress(address);
        //}
        //System.out.println("address***="+navigator.getUserInfo().getAddress());
    }
    
    
    private void populateHighestQualification() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Highest_Education_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbQual.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbQual.getItems().addAll(gen);                    
            }
        }
    }
    
    private void populateOccupation() 
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
    
    
    private void populateIncome() 
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

    private void setOccupationData() {
        PersonalInformationBean pi = navigator.getUserInfo().getPi();
        if(pi==null)
        {
            pi = new PersonalInformationBean();
        }
        
        pi.setMobile(Long.parseLong(txtMobile.getText()));
        pi.setEmail(txtEmail.getText());
        pi.setOrganization(txtOrganization.getText());
        pi.setOccupation(cmbOccupation.getValue().toString());
        pi.setIncome(cmbIncome.getValue().toString());
        pi.setQualification(cmbQual.getValue().toString());
        
        System.out.println("1****pi="+pi);
        navigator.getUserInfo().setPi(pi);
    }
    
    
    @FXML
    private void manageOccuAndProfForHouseWife()
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
//        if(cmbOccupation.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                 cmbOccupation.getItems().addAll(gen);
//            }
//        }
        
        if (navigator!=null && navigator.getUserInfo().getPi().getGender()!=null && navigator.getUserInfo().getPi().getGender().equals(MU.getMsg("Lbl_Male"))) 
        {
            
            cmbOccupation.getItems().clear();
            if(cmbOccupation.getItems().size()==0)
            {
                for(String gen : list)
                {
                    if (!gen.equals(MU.getMsg("Lbl_Housewife"))) {
                        cmbOccupation.getItems().addAll(gen);
                    }
                        
                }
            }

        }
        else
        {
            
            cmbOccupation.getItems().clear();
            if(cmbOccupation.getItems().size()==0)
            {
                for(String gen : list)
                {
                        cmbOccupation.getItems().addAll(gen);
                }
            }
            
        }
        
        
    }
    
    
}
