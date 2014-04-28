/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.IllnessBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen22Controller implements Initializable, ControlledScreen {
    
     private ScreensNavigator navigator;
     
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator = screenPage;
    }

    @FXML
    private ComboBox cmbIntensity;
    
    @FXML
    private ComboBox cmbFrequency;
    
    @FXML
    private ComboBox cmbDuration;
    
    @FXML
    private ComboBox cmbLastsForDays;
    
    @FXML
    private ComboBox cmbSinceYears;
    
    @FXML
    private ComboBox cmbLossOfManDays;
    
    @FXML
    private ListView listSelfIllness;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateIntensity();
        populateFrequency();
        populateDuration();
        populateLastsFor();
        populateSinceYears();
        populateLossOfManDays();
    }    

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen13ID);
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen10ID);
    }

    @FXML
    private void manageMultipleSelectionsSelf(MouseEvent event) {
    }

    @FXML
    private void listSelfDiseases(ContextMenuEvent event) {
    }

    @FXML
    private void recordSelfIllnessQuantificationDetails(ActionEvent event) {
    }

    private void populateIntensity() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
            String[] list = genderList.split(GlobalConstants.COMMA);
            if (cmbIntensity.getItems().size() == 0) {
                for (String gen : list) {
                    if(!gen.equals(GlobalConstants.Zero_Number) 
                            && !gen.equals(GlobalConstants.Eleven_Number)
                            && !gen.equals(GlobalConstants.Twelve_Number))
                    {
                        cmbIntensity.getItems().addAll(gen);
                    }
                }
            }
    }

    private void populateFrequency() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
            String[] list = genderList.split(GlobalConstants.COMMA);
            
            
            if (cmbFrequency.getItems().size() == 0) {
                for (String gen : list) 
                {                    
                    if(!gen.equals(GlobalConstants.Zero_Number))
                        cmbFrequency.getItems().addAll(gen);                    
                }
            }
    }

    private void populateDuration() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        String[] list1 =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbDuration.getItems().size()==0)
        {
            for(String gen : list1)
            {
                if(!gen.equals(GlobalConstants.Zero_Number))
                {
                    cmbDuration.getItems().addAll(gen); 
                }
                    cmbDuration.getItems().addAll(gen+".15"); 
                    cmbDuration.getItems().addAll(gen+".30"); 
                    cmbDuration.getItems().addAll(gen+".45"); 
            }
        }
    }

    private void populateLastsFor() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
            String[] list = genderList.split(GlobalConstants.COMMA);
            if (cmbLastsForDays.getItems().size() == 0) {
                for (String gen : list) {
                        cmbLastsForDays.getItems().addAll(gen);
                }
            }
    }

    private void populateSinceYears() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        String[] list1 =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbSinceYears.getItems().size()==0)
        {
            for(String gen : list1)
            {
                    cmbSinceYears.getItems().addAll(gen); 
            }
        }
    }

    private void populateLossOfManDays() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        String[] list1 =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbLossOfManDays.getItems().size()==0)
        {
            for(String gen : list1)
            {
                    cmbLossOfManDays.getItems().addAll(gen); 
            }
        }
    }
    
    @FXML
    private void populateIllnessListView() {
        
        if(navigator.getUserInfo().getSelfIllnessList().size() != listSelfIllness.getItems().size())
        {
            listSelfIllness.getItems().removeAll(listSelfIllness.getItems());
            
            for(IllnessBean bean : navigator.getUserInfo().getSelfIllnessList())
            {
                listSelfIllness.getItems().addAll(bean.getIllness());
            }
           // listSelfIllness.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        
    }
    
}
