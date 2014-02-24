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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen11Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    
    @FXML
    private Color x1;
    @FXML
    private Label q1;
    @FXML
    private CheckBox q1o1;
    @FXML
    private CheckBox q1o2;
    @FXML
    private CheckBox q1o3;
    @FXML
    private Label q2;
    @FXML
    private CheckBox q2o1;
    @FXML
    private CheckBox q2o2;
    @FXML
    private CheckBox q2o3;
    @FXML
    private Label q3;
    @FXML
    private CheckBox q3o1;
    @FXML
    private CheckBox q3o2;
    @FXML
    private CheckBox q3o3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
        @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    

    @FXML
    private void goToScreen10(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen9ID);
    }

    @FXML
    private void goToScreen12(ActionEvent event) 
    {
        getNextQuestions();
    }

    int questionCounter=4;
    int ansCounter=1;
    String Q="Q";
    String O="O";
    
    private void getNextQuestions() {
        
        q1.setText(GlobalConstants.getProperty(Q+questionCounter));
        
        q1o1.setText(GlobalConstants.getProperty(Q+questionCounter+GlobalConstants.underscore+O+ansCounter));
        ansCounter++;
        
        q1o2.setText(GlobalConstants.getProperty(Q+questionCounter+GlobalConstants.underscore+O+ansCounter));
        ansCounter++;
        
        q1o3.setText(GlobalConstants.getProperty(Q+questionCounter+GlobalConstants.underscore+O+ansCounter));
        ansCounter=1;
        
    }
    
}
