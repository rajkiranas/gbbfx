/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen20Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    private List<String> personalityList = new ArrayList<String>();
    
    @FXML
    private TextField txtPersonality;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideShowPreviousLink();
    }
    
     @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen19ID);
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        if(txtPersonality.getText()!=null && !txtPersonality.getText().equals(GlobalConstants.emptyString))
        {
           if(validatePersonalityForm())
           {
                    addToPersonalityList(getPersonalityFromCurrentForm());
                    clearPersonalityForm();
                    showPreviousLink();
                    recordUserResponse();
                    setPersonalityData();
                    navigateToNextScreen();
           }
        }
        else
        {
            recordUserResponse();
            setPersonalityData();
            navigateToNextScreen();
            
        }
    }
            
    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.screen9ID);
    }

    @FXML
    Hyperlink linkShowPrevious;
     
     
    
    private void hideShowPreviousLink() {
        linkShowPrevious.setVisible(false);
    }
    
    private void showPreviousLink() {
        linkShowPrevious.setVisible(true);
    }
 
    private int previousCounter=0;
    
     @FXML
    private void showPrevious()
    {
        if(previousCounter==0)
        {
            previousCounter=personalityList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        String personality = personalityList.get(previousCounter);
        
        txtPersonality.setText(personality);
    }
    
    @FXML
    private void addPersonality(ActionEvent event) 
    {
        if(validatePersonalityForm())
        {
            addToPersonalityList(getPersonalityFromCurrentForm());
            
            clearPersonalityForm();
            showPreviousLink();
        }
    }
    
    private String getPersonalityFromCurrentForm()
    {
        return txtPersonality.getText();
    }
    private void clearPersonalityForm()
    {
        txtPersonality.setText(GlobalConstants.emptyString);
    }
    
    private void addToPersonalityList(String incidence) 
    {
        if(personalityList.contains(incidence))
        {
            personalityList.remove(incidence);
            personalityList.add(incidence);
        }
        else
        {
            personalityList.add(incidence);
        }
    }
    
    private boolean validatePersonalityForm() 
    {
        boolean isValid=true;
        
        if(txtPersonality.getText()==null || txtPersonality.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc20_msg_enter_personality_name", GlobalConstants.Lbl_Alert);
        }
        else if(!GbbValidator.isValidName(txtPersonality.getText()))
        {
            isValid=false;
            UIUtils.showAlert("sc20_msg_invalid_personality", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private void setPersonalityData() {
        System.out.println("***personalityList="+personalityList);
        navigator.getUserInfo().setPersonalityList(personalityList);
    }

    @FXML
    private CheckBox chkInc1;
    @FXML
    private CheckBox chkInc2;
    @FXML
    private CheckBox chkInc3;
    @FXML
    private CheckBox chkInc4;
    @FXML
    private CheckBox chkInc5;
    @FXML
    private CheckBox chkInc6;
    @FXML
    private CheckBox chkInc7;
    @FXML
    private CheckBox chkInc8;
    @FXML
    private CheckBox chkInc9;
    @FXML
    private CheckBox chkInc10;
    @FXML
    private CheckBox chkInc11;
    @FXML
    private CheckBox chkInc12;
    @FXML
    private CheckBox chkInc13;
    @FXML
    private CheckBox chkInc14;
    @FXML
    private CheckBox chkInc15;
    @FXML
    private CheckBox chkInc16;
    @FXML
    private CheckBox chkInc17;
    @FXML
    private CheckBox chkInc18;
    private void recordUserResponse() {
        if(chkInc1.isSelected())
            addToPersonalityList(chkInc1.getText());
        
        if(chkInc2.isSelected())
            addToPersonalityList(chkInc2.getText());
        
        if(chkInc3.isSelected())
            addToPersonalityList(chkInc3.getText());
        
        if(chkInc4.isSelected())
            addToPersonalityList(chkInc4.getText());
        
        if(chkInc5.isSelected())
            addToPersonalityList(chkInc5.getText());
        
        if(chkInc6.isSelected())
            addToPersonalityList(chkInc6.getText());
        
        if(chkInc7.isSelected())
            addToPersonalityList(chkInc7.getText());
        
        if(chkInc8.isSelected())
            addToPersonalityList(chkInc8.getText());
        
        if(chkInc9.isSelected())
            addToPersonalityList(chkInc9.getText());
        
        if(chkInc10.isSelected())
            addToPersonalityList(chkInc10.getText());
        
        if(chkInc11.isSelected())
            addToPersonalityList(chkInc11.getText());
        
        if(chkInc12.isSelected())
            addToPersonalityList(chkInc12.getText());
        
        if(chkInc13.isSelected())
            addToPersonalityList(chkInc13.getText());
        
        if(chkInc14.isSelected())
            addToPersonalityList(chkInc14.getText());
        
        if(chkInc15.isSelected())
            addToPersonalityList(chkInc15.getText());
        
        if(chkInc16.isSelected())
            addToPersonalityList(chkInc16.getText());
        
        if(chkInc17.isSelected())
            addToPersonalityList(chkInc17.getText());
        
        if(chkInc18.isSelected())
            addToPersonalityList(chkInc18.getText());
    }
    
    @FXML
    private HBox addOwnHbox;
    @FXML
    private AnchorPane optionsPane;
    @FXML
    private CheckBox chkNone;
    
    @FXML
    private void toggleInputs(Event e)
    {
        if(chkNone.isSelected())
        {
            optionsPane.setDisable(true);
            addOwnHbox.setDisable(true);
        }
        else
        {
            optionsPane.setDisable(false);
            addOwnHbox.setDisable(false);
        }
    }
}