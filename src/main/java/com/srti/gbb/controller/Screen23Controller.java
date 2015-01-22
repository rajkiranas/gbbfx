/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen23Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        navigator = screenPage;
    }
    
    @FXML
    private void goToPreviousScreen(ActionEvent event) {
        //navigator.navigateTo(ScreensFramework.Screen_Hospitalization);
        if(!navigator.getUserInfo().getSelfIllnessList().isEmpty())
            {
                navigator.navigateTo(ScreensFramework.Screen_Illness_Quantification);
            }
            else
            {
               navigator.navigateTo(ScreensFramework.Screen_Illness);
            }
    }
    
    @FXML
    private void goToNextScreen(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }
}
