/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen9Controller implements Initializable, ControlledScreen  {
    private ScreensNavigator navigator;
    
    @FXML
    private Color x1;
    @FXML
    private CheckBox chkHouseOwned;
    @FXML
    private CheckBox chkHouseRented;
    @FXML
    private CheckBox chkLandOwned;
    @FXML
    private CheckBox chkLandRented;
    @FXML
    private TextField txtLandApproxArea;
    @FXML
    private TextField txtLandMembers;
    @FXML
    private TextField txtLandLoan;
    @FXML
    private TextField txtHouseLoan;
    @FXML
    private TextField txtHouseApproxArea;
    @FXML
    private TextField txtHouseMembers;
    @FXML
    private ComboBox cmbVehicleType;
    @FXML
    private TextField txtVehicleNumbers;
    @FXML
    private Button btnAddVehicle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateVehicleTypes();
    }
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    private void populateVehicleTypes() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Vehicle_Type_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbVehicleType.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbVehicleType.getItems().addAll(gen);                    
            }
        }        
    }
    
    @FXML
    private void goToScreen8(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen8ID);
    }

    @FXML
    private void goToScreen10(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }

    @FXML
    private void addVehiclesToList(ActionEvent event) {
    }
    
}
