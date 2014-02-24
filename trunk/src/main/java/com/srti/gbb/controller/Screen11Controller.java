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
        setNextQuestionsAndAnswersToLabels();
    }
    
        @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    

    @FXML
    private void goToScreen10(ActionEvent event) 
    {
        if(qC==0)
        {
            navigator.navigateTo(ScreensFramework.screen9ID);
            
            
        }
        else
        {
            setPreviousQuestionsAndAnswersToLabels();
        }
    }

    @FXML
    private void goToScreen12(ActionEvent event) 
    {
        setNextQuestionsAndAnswersToLabels();
    }

    private int qC=0;
    
    private String Q="Q";   

    private void setNextQuestionsAndAnswersToLabels() 
    {
        
            qC++;
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            qC++;
                    
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            qC++;
                    
            q3.setText(GlobalConstants.getProperty(Q+qC));
            
            q3o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
    }
    
    private void setPreviousQuestionsAndAnswersToLabels() 
    {
//        if(qC>3)
//        {
//            qC=qC-3;
//        }
            
            q3.setText(GlobalConstants.getProperty(Q+qC));
            
            q3o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
        
    }
    
}
