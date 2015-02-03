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
 * @author sonderaj
 */
public class MenuBannerController implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToHome(ActionEvent event) 
    {
        ScreensFramework.getDummyNavigator().navigateTo(ScreensFramework.Screen_Home);
    }

    @FXML
    private void goToHowWeDoIt(ActionEvent event) {
    }

    @FXML
    private void goToWhatYouGet(ActionEvent event) {
    }

    @FXML
    private void goToGetStarted(ActionEvent event) 
    {
        ScreensFramework.getDummyNavigator().navigateTo(ScreensFramework.screen0ID);
    }

    @FXML
    private void goToAboutUs(ActionEvent event) {
    }

    @FXML
    private void goToContactUs(ActionEvent event) {
    }
    
}
