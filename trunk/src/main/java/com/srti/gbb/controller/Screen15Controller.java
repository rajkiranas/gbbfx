/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.ColourBean;
import com.srti.gbb.bean.IdolBean;
import com.srti.gbb.bean.TasteBean;
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
 * @author rajkiran
 */
public class Screen15Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    private List<IdolBean> idolList = new ArrayList<IdolBean>();
    
    @FXML
    private TextField txtIdolName;
    
    @FXML
    private Hyperlink linkShowPrevious;
    
    @FXML
    private CheckBox chkRed;
    
    @FXML
    private CheckBox chkOrange;
    
    @FXML
    private CheckBox chkYellow;
    
    @FXML
    private CheckBox chkGreen;
    
    @FXML
    private CheckBox chkBlue;
    
    @FXML
    private CheckBox chkViolet;
    
    @FXML
    private CheckBox chkWhite;
    
    @FXML
    private CheckBox chkSweet;
    
    @FXML
    private CheckBox chkSour;
    
    @FXML
    private CheckBox chkSalty;
    
    @FXML
    private CheckBox chkPungent;
    
    @FXML
    private CheckBox chkBitter;
    
    @FXML
    private CheckBox chkAstringent;
    

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
    private void addIdolAndClearForm(ActionEvent event) 
    {
        if(validateIdolForm())
        {
            addIdolToList(getIdolBeanForCurrentForm());
            clearIdolForm();
            showPreviousLink();
        }
    }
    
    
    private void clearIdolForm()
    {
        txtIdolName.setText(GlobalConstants.emptyString);
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen8ID);
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        //filled form
        if(!txtIdolName.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateIdolForm() && validateColourForm() && validateTasteForm())
            {
                addIdolToList(getIdolBeanForCurrentForm());
                setIdolData();
                setColourData();
                setTasteData();
                navigateToNextScreen();
            }
        }
        else if(!idolList.isEmpty())
        {
            
            if(validateColourForm() && validateTasteForm())
            {
                setIdolData();
                setColourData();
                setTasteData();
                navigateToNextScreen();
            }
            
        }
        else
        {
            UIUtils.showAlert("sc15_msg_enter_atleast_one_idol_name", GlobalConstants.Lbl_Alert);  
        }
    }
    
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
            previousCounter=idolList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        IdolBean idol = idolList.get(previousCounter);
        
        String name = idol.getIdolName();
        txtIdolName.setText(name);
            
    }

    
    private void addIdolToList(IdolBean h) {
        if (idolList.contains(h)) 
        {
            idolList.remove(h);
            idolList.add(h);
        } else 
        {
            idolList.add(h);
        }
    }

    private boolean validateIdolForm() {
        boolean isValid=true;
         if(txtIdolName.getText() ==null || txtIdolName.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc15_msg_enter_idol_name", GlobalConstants.Lbl_Alert);
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtIdolName.getText()))
         {
              UIUtils.showAlert("sc15_msg_enter_valid_idol_name", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         return isValid;
    }

    private IdolBean getIdolBeanForCurrentForm() {
        IdolBean b = new IdolBean();
        b.setIdolName(txtIdolName.getText());
        return b;
    }

    private void setIdolData() {
        System.out.println("***idolList="+idolList);
        navigator.getUserInfo().setIdolList(idolList);
    }

    private boolean validateColourForm() {
        boolean isValid=false;
        if(chkRed.isSelected() || chkOrange.isSelected() || chkYellow.isSelected() || chkGreen.isSelected() || chkBlue.isSelected() || chkViolet.isSelected() || chkWhite.isSelected())
        {
            isValid=true;
        }
        else
        {
            UIUtils.showAlert("sc15_msg_sel_atleast_one_colour_name", GlobalConstants.Lbl_Alert);  
        }
        return isValid;
    }

    private boolean validateTasteForm() {
        boolean isValid=false;
        if(chkSweet.isSelected() || chkSour.isSelected() || chkSalty.isSelected() || chkPungent.isSelected() || chkBitter.isSelected() || chkAstringent.isSelected())
        {
            isValid=true;
        }
        else
        {
            UIUtils.showAlert("sc15_msg_sel_atleast_one_taste_name", GlobalConstants.Lbl_Alert);  
        }
        return isValid;
    }

    private void setColourData() {
        ColourBean c = new ColourBean();
        c.setRed(chkRed.isSelected());
        c.setOrange(chkOrange.isSelected());
        c.setYellow(chkYellow.isSelected());
        c.setGreen(chkGreen.isSelected());
        c.setBlue(chkBlue.isSelected());
        c.setViolate(chkViolet.isSelected());
        c.setWhite(chkWhite.isSelected());
        System.out.println("***color="+c);
        navigator.getUserInfo().setColour(c);
    }

    private void setTasteData() {
        TasteBean t = new TasteBean();
        t.setSweet(chkSweet.isSelected());
        t.setSour(chkSour.isSelected());
        t.setSalty(chkSalty.isSelected());
        t.setPungent(chkPungent.isSelected());
        t.setBitter(chkBitter.isSelected());
        t.setAstringent(chkAstringent.isSelected());
        System.out.println("***taste="+t);
        navigator.getUserInfo().setTaste(t);
    }

    private void navigateToNextScreen() {
        navigator.navigateTo(ScreensFramework.screen9ID);
    }
}
