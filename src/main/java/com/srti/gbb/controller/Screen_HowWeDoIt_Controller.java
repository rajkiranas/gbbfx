/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.controller.ControlledScreen;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

/**
 * FXML Controller class
 *
 * @author sonderaj
 */
public class Screen_HowWeDoIt_Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    
    
    @FXML
    private Insets x1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToScreen0(ActionEvent event) {
    }

    @FXML
    private void goToScreen2(ActionEvent event) {
    }
    
}
