/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.AddressBean;
import com.srti.gbb.controller.ControlledScreen;
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
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateCountryList();
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
        if(validateAddressForm())
        {
            setAddressData();
            navigator.navigateTo(ScreensFramework.screen2ID);
        }
    }
    
    private boolean validateAddressForm()
     {
         
         boolean isValid=true;
         if(txtHouse.getText() ==null || txtHouse.getText().trim().equals(GlobalConstants.emptyString))
         {
             
              UIUtils.showAlert("Please enter house information", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert));  
    
             isValid=false;
         }
         
         else if(txtArea.getText() ==null || txtArea.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter area information", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)); 
             isValid=false;
         }
         
         else if(cmbCountry.getValue()==null || cmbCountry.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select country", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)); 
             isValid=false;
         }
         else if(cmbState.getValue()==null || cmbState.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select state", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)); 
             isValid=false;
         }
         else if(txtCity.getText() ==null || txtCity.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter city information", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)); 
             isValid=false;
         }
         else if(txtPincode.getText() ==null || txtPincode.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter pin code", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtPincode.getText()))
         {
              UIUtils.showAlert("Please enter valid pincode", GlobalConstants.getProperty(GlobalConstants.Lbl_Alert));  
    
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
        if(navigator.getUserInfo().getAddress()==null)
        {
            navigator.getUserInfo().setAddress(address);
        }
        //System.out.println("address***="+navigator.getUserInfo().getAddress());
    }
    
    
}
