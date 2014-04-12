/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.FamilyEducation;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen18Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateHighestQualification();
        //populateProfession();
        populateIncome();
        populateChildGender();
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
        if(validateSpouseInformation())
        {
            setSpouseData();
            navigateToNextScreen();
        }
    }
    
            
            
    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.screen6ID);
    }

    @FXML
    private TextField txtSpouseName;
    
    @FXML
    private ComboBox cmbSpouseQual;
    
    @FXML
    private ComboBox cmbSpouseProfession;
    
    @FXML
    private ComboBox cmbSpouseIncome;
    
    @FXML
    private CheckBox chkIsSpouseDeceased;
    
    
    
    @FXML
    private TextField txtChildName;
    
    @FXML
    private ComboBox cmbChildGender;
    
    @FXML
    private ComboBox cmbChildQual;
    
    @FXML
    private ComboBox cmbChildProfession;
    
    @FXML
    private ComboBox cmbChildIncome;
    
    @FXML
    private CheckBox chkIsChildDeceased;
    
    private boolean validateSpouseInformation() 
    {
        boolean isValid=true;
        if(txtSpouseName.getText()==null || txtSpouseName.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_enter_name_wife", GlobalConstants.Lbl_Alert);
        }
        else if(cmbSpouseQual.getValue()==null || cmbSpouseQual.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_enter_qual_wife", GlobalConstants.Lbl_Alert);
        }
        else if(cmbSpouseProfession.getValue()==null || cmbSpouseProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_enter_prof_wife", GlobalConstants.Lbl_Alert);
        }
        else if(cmbSpouseIncome.getValue()==null || cmbSpouseIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_enter_income_wife", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private void setSpouseData() {
        
        FamilyEducation m = new FamilyEducation();
        if(navigator.getUserInfo().getPi().getGender().equals(MU.getMsg("Lbl_Male")))
        {
            m.setFamilyMember(GlobalConstants.getProperty(GlobalConstants.Lbl_Wife));
        }
        else
        {
            m.setFamilyMember(GlobalConstants.getProperty(GlobalConstants.Lbl_Husband));
        }
        
        m.setName(txtSpouseName.getText());
        m.setHighestQualification(cmbSpouseQual.getValue().toString());
        m.setProfession(cmbSpouseProfession.getValue().toString());
        m.setIncome(cmbSpouseIncome.getValue().toString());
        m.setIsDeceased(chkIsSpouseDeceased.isSelected());
        navigator.getUserInfo().setSpouse(m);
    }

    private void populateHighestQualification() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Highest_Education_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbSpouseQual.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbSpouseQual.getItems().addAll(gen);                    
            }
        }
        
        
        if(cmbChildQual.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbChildQual.getItems().addAll(gen);                    
            }
        }
    }

    @FXML
    private void populateProfession() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Profession_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(navigator.getUserInfo().getPi().getGender().equals(MU.getMsg("Lbl_Male")))
        {
            if(cmbSpouseProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                    if(!gen.equals(MU.getMsg("Lbl_Housewife")))
                        cmbSpouseProfession.getItems().addAll(gen);                    
                }
            }
            
        }
        else
        {
            if(cmbSpouseProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                    //if(!gen.equals(MU.getMsg("Lbl_Housewife")))
                        cmbSpouseProfession.getItems().addAll(gen);                    
                }
            }
        }
        
    }

    private void populateIncome() {
                String genderList = GlobalConstants.getProperty(GlobalConstants.Income_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbSpouseIncome.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbSpouseIncome.getItems().addAll(gen);                    
            }
        }
        
        
        if(cmbChildIncome.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbChildIncome.getItems().addAll(gen);                    
            }
        }
        
        
    }
    
    private void populateChildGender() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.GenderList);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbChildGender.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(MU.getMsg("Lbl_Housewife")))
                    cmbChildGender.getItems().addAll(gen);                    
            }
        }
    }
    
   
    @FXML
     private void setProfessionChild() 
     {
        String profList = GlobalConstants.getProperty(GlobalConstants.Profession_Options);
        String[] list =  profList.split(GlobalConstants.COMMA);
        
        if (cmbChildGender.getValue()!=null && cmbChildGender.getValue().toString().equals(MU.getMsg("Lbl_Male"))) 
        {
            cmbChildProfession.getItems().clear();
            if(cmbChildProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                    if (!gen.equals(MU.getMsg("Lbl_Housewife"))) {
                        cmbChildProfession.getItems().addAll(gen);
                    }
                }
            }
        }
        else
        {
            cmbChildProfession.getItems().clear();
            if(cmbChildProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                        cmbChildProfession.getItems().addAll(gen);
                }
            }
            
        }
    }
}