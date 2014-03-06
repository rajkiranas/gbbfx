/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.PrayersBean;
import com.srti.gbb.bean.SocialServiceBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen7Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    
    @FXML
    private Color x1;
    
    @FXML
    private ComboBox cmbPrayIndividual;
    
    @FXML
    private ComboBox cmbPrayFamily;
    
    @FXML
    private ComboBox cmbPrayCommunity;
    
    @FXML
    private ComboBox cmbTimesPerWeekCash;
    
    @FXML
    private ComboBox cmbTimesPerWeekKind;
    
    @FXML
    private ComboBox cmbTimesPerWeekService;
    
    @FXML
    private CheckBox chkIsRegularPray;
    
    @FXML
    private CheckBox chkSocialService;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populatePrayersPerWeekOptions();
        populateSocialServicePerWeek();
    }    
    
    private void populateSocialServicePerWeek() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbTimesPerWeekCash.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbTimesPerWeekCash.getItems().addAll(gen);                    
            }
        }
        
        if(cmbTimesPerWeekKind.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbTimesPerWeekKind.getItems().addAll(gen);                    
            }
        }
        
        if(cmbTimesPerWeekService.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbTimesPerWeekService.getItems().addAll(gen);                    
            }
        }
        
        cmbTimesPerWeekCash.setDisable(true);
        cmbTimesPerWeekKind.setDisable(true);
        cmbTimesPerWeekService.setDisable(true);
        txtAmtCash.setDisable(true);
        txtAmtKind.setDisable(true);
        txtAmtService.setDisable(true);
        txtAreaOfWork.setDisable(true);
    }
    
    private void populatePrayersPerWeekOptions() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbPrayIndividual.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbPrayIndividual.getItems().addAll(gen);                    
            }
        }
        
        if(cmbPrayFamily.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbPrayFamily.getItems().addAll(gen);                    
            }
        }
        
        if(cmbPrayCommunity.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbPrayCommunity.getItems().addAll(gen);                    
            }
        }
        
        
        cmbPrayIndividual.setDisable(true);
        cmbPrayFamily.setDisable(true);
        cmbPrayCommunity.setDisable(true);
    }
    
    @FXML
    private void togglePrayerCombos(ActionEvent event) 
    {
         if(chkIsRegularPray.isSelected())
         {
             cmbPrayIndividual.setDisable(false);
             cmbPrayFamily.setDisable(false);
             cmbPrayCommunity.setDisable(false);
         }
         else
         {
             cmbPrayIndividual.setDisable(true);
             cmbPrayFamily.setDisable(true);
             cmbPrayCommunity.setDisable(true);
         }
    }
    
    @FXML
    private void toggleSocialServiceCombos(ActionEvent event) 
    {
         if(chkSocialService.isSelected())
         {
             cmbTimesPerWeekCash.setDisable(false);
            cmbTimesPerWeekKind.setDisable(false);
            cmbTimesPerWeekService.setDisable(false);
            txtAmtCash.setDisable(false);
            txtAmtKind.setDisable(false);
            txtAmtService.setDisable(false);
            txtAreaOfWork.setDisable(false);
         }
         else
         {
            cmbTimesPerWeekCash.setDisable(true);
            cmbTimesPerWeekKind.setDisable(true);
            cmbTimesPerWeekService.setDisable(true);
            txtAmtCash.setDisable(true);
            txtAmtKind.setDisable(true);
            txtAmtService.setDisable(true);
            txtAreaOfWork.setDisable(true);
         }
    }

    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    
    
    @FXML
    private void goToScreen6(ActionEvent event) 
    {
         navigator.navigateTo(ScreensFramework.screen6ID);
    }

    @FXML
    private void goToScreen8(ActionEvent event) 
    {
        if(validatePrayerForm() && validateSocialServiceForm())
        {
            if(chkIsRegularPray.isSelected())
            {
               PrayersBean pray = new PrayersBean();
               pray.setRegularPray(chkIsRegularPray.isSelected());
               pray.setIndividualPrayerPerWeek(Integer.parseInt(cmbPrayIndividual.getValue().toString()));
               pray.setFamilyPrayerPerWeek(Integer.parseInt(cmbPrayFamily.getValue().toString()));
               pray.setCommunityPrayerPerWeek(Integer.parseInt(cmbPrayCommunity.getValue().toString()));
               if(navigator.getUserInfo().getPrayers()==null)
               {
                   navigator.getUserInfo().setPrayers(pray);
               }
            }
            
            if(chkSocialService.isSelected())
            {
                   SocialServiceBean ss = new SocialServiceBean();
                   ss.setApproxAmtCash(Float.parseFloat(txtAmtCash.getText()));
                   ss.setApproxAmtKind(Float.parseFloat(txtAmtKind.getText()));
                   ss.setApproxAmtService(Float.parseFloat(txtAmtService.getText()));
                   ss.setCashPerWeek(Integer.parseInt(cmbTimesPerWeekCash.getValue().toString()));
                   ss.setKindPerWeek(Integer.parseInt(cmbTimesPerWeekKind.getValue().toString()));
                   ss.setSocialServicePerWeek(Integer.parseInt(cmbTimesPerWeekService.getValue().toString()));
                   ss.setAreaOfWork(txtAreaOfWork.getText());
                   if(navigator.getUserInfo().getSocialService()==null)
                   {
                       navigator.getUserInfo().setSocialService(ss);
                   }
            }
            navigator.navigateTo(ScreensFramework.screen8ID);
        }
    }

    private boolean validatePrayerForm() 
    {
        boolean isValid = true;
        if(chkIsRegularPray.isSelected())
         {
             if (cmbPrayIndividual.getValue() == null || cmbPrayIndividual.getValue().toString().equals(GlobalConstants.emptyString)) 
             {
                 isValid = false;
                 UIUtils.showAlert("Please select individual prayer value", "Alert");
             } else if (cmbPrayFamily.getValue() == null || cmbPrayFamily.getValue().toString().equals(GlobalConstants.emptyString)) 
             {
                 isValid = false;
                 UIUtils.showAlert("Please select family prayer value", "Alert");
             } else if (cmbPrayCommunity.getValue() == null || cmbPrayCommunity.getValue().toString().equals(GlobalConstants.emptyString)) 
             {
                 isValid = false;
                 UIUtils.showAlert("Please select community prayer value", "Alert");
             }
         }
         return isValid;
    }
    
    @FXML
    private TextField txtAmtCash;
    
    @FXML
    private TextField txtAmtKind;
    
    @FXML
    private TextField txtAmtService;
    
    @FXML
    private TextField txtAreaOfWork;
    
    private boolean validateSocialServiceForm() 
    {
        boolean isValid = true;
        if(chkSocialService.isSelected())
        {
            if(txtAmtCash.getText()==null || txtAmtCash.getText().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please enter approximate amount for cash service", "Alert");
           }
            else if(!GbbValidator.isValidNumber(txtAmtCash.getText()))
           {
               isValid=false;
               UIUtils.showAlert("Invalid approximate amount for cash service", "Alert");
           }
            else if(cmbTimesPerWeekCash.getValue()==null || cmbTimesPerWeekCash.getValue().toString().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please select cash service per week", "Alert");
           }
            else if(txtAmtKind.getText()==null || txtAmtKind.getText().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please enter approximate amount for kind service", "Alert");
           }
            else if(!GbbValidator.isValidNumber(txtAmtKind.getText()))
           {
               isValid=false;
               UIUtils.showAlert("Invalid approximate amount for kind service", "Alert");
           }
            else if(cmbTimesPerWeekKind.getValue()==null || cmbTimesPerWeekKind.getValue().toString().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please select kind service per week", "Alert");
           }
            else if(txtAmtService.getText()==null || txtAmtService.getText().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please enter approximate amount for social service", "Alert");
           }
            else if(!GbbValidator.isValidNumber(txtAmtService.getText()))
           {
               isValid=false;
               UIUtils.showAlert("Invalid approximate amount for social service", "Alert");
           }
            else if(cmbTimesPerWeekService.getValue()==null || cmbTimesPerWeekService.getValue().toString().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please select social service per week", "Alert");
           }
            else if(txtAreaOfWork.getText()==null || txtAreaOfWork.getText().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("Please enter area of work", "Alert");
           }
       }
         return isValid;
    }
    
}
