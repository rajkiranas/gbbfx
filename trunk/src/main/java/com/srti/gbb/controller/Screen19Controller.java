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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen19Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    private List<String> incidenceList = new ArrayList<String>();
    
    @FXML
    private TextField txtIncidenceName;
    
    
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
        navigator.navigateTo(ScreensFramework.screen5ID);
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        if(txtIncidenceName.getText()!=null && !txtIncidenceName.getText().equals(GlobalConstants.emptyString))
        {
           if(validateIncidenceForm())
           {
                    addToIncidenceList(getIncidenceFromCurrentForm());
                    clearFamilyMemberForm();
                    showPreviousLink();
                    recordUserResponse();
                    setIncidenceData();
                    navigateToNextScreen();
           }
        }
        else
        {
            recordUserResponse();
            setIncidenceData();
            navigateToNextScreen();
            
        }
    }
            
    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.screen6ID);
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
            previousCounter=incidenceList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        String incidence = incidenceList.get(previousCounter);
        
        txtIncidenceName.setText(incidence);
    }
    
    @FXML
    private void addIncidence(ActionEvent event) 
    {
        if(validateIncidenceForm())
        {
            addToIncidenceList(getIncidenceFromCurrentForm());
            
            clearFamilyMemberForm();
            showPreviousLink();
        }
    }
    
    private String getIncidenceFromCurrentForm()
    {
        return txtIncidenceName.getText();
    }
    private void clearFamilyMemberForm()
    {
        txtIncidenceName.setText(GlobalConstants.emptyString);
    }
    
    private void addToIncidenceList(String incidence) 
    {
        if(incidenceList.contains(incidence))
        {
            incidenceList.remove(incidence);
            incidenceList.add(incidence);
        }
        else
        {
            incidenceList.add(incidence);
        }
    }
    
    private boolean validateIncidenceForm() 
    {
        boolean isValid=true;
        
        if(txtIncidenceName.getText()==null || txtIncidenceName.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc19_msg_enter_incidence_name", GlobalConstants.Lbl_Alert);
        }
        else if(!GbbValidator.isValidName(txtIncidenceName.getText()))
        {
            isValid=false;
            UIUtils.showAlert("sc19_msg_invalid_incidence", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private void setIncidenceData() {
        System.out.println("***incidenceList="+incidenceList);
        navigator.getUserInfo().setIncidenceList(incidenceList);
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
            addToIncidenceList(chkInc1.getText());
        
        if(chkInc2.isSelected())
            addToIncidenceList(chkInc2.getText());
        
        if(chkInc3.isSelected())
            addToIncidenceList(chkInc3.getText());
        
        if(chkInc4.isSelected())
            addToIncidenceList(chkInc4.getText());
        
        if(chkInc5.isSelected())
            addToIncidenceList(chkInc5.getText());
        
        if(chkInc6.isSelected())
            addToIncidenceList(chkInc6.getText());
        
        if(chkInc7.isSelected())
            addToIncidenceList(chkInc7.getText());
        
        if(chkInc8.isSelected())
            addToIncidenceList(chkInc8.getText());
        
        if(chkInc9.isSelected())
            addToIncidenceList(chkInc9.getText());
        
        if(chkInc10.isSelected())
            addToIncidenceList(chkInc10.getText());
        
        if(chkInc11.isSelected())
            addToIncidenceList(chkInc11.getText());
        
        if(chkInc12.isSelected())
            addToIncidenceList(chkInc12.getText());
        
        if(chkInc13.isSelected())
            addToIncidenceList(chkInc13.getText());
        
        if(chkInc14.isSelected())
            addToIncidenceList(chkInc14.getText());
        
        if(chkInc15.isSelected())
            addToIncidenceList(chkInc15.getText());
        
        if(chkInc16.isSelected())
            addToIncidenceList(chkInc16.getText());
        
        if(chkInc17.isSelected())
            addToIncidenceList(chkInc17.getText());
        
        if(chkInc18.isSelected())
            addToIncidenceList(chkInc18.getText());
    }
}