/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.AllergyBean;
import com.srti.gbb.bean.PhysicalParameters;
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
import javafx.geometry.Point2D;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen14Controller implements Initializable, ControlledScreen  {

        private ScreensNavigator navigator;
        private List<AllergyBean> allergyList = new ArrayList<AllergyBean>();
        
        @FXML
        private ComboBox cmbLooseMotions;
        
        @FXML
        private ComboBox cmbConstipations;
        
        @FXML
        private TextField txtAllergyName;
        
        @FXML
        private Hyperlink linkShowPrevious;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hideShowPreviousLink();
        // TODO
        populateLooseMotionsCombo();
        populateConstipationsCombo();
        populateHeightFeets();
        populateHeightInches();
        consolidateRadioButtonsInToggleGroup();
    }    

    /**
     * Initializes the controller class.
     */
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }
    

    
    @FXML
        private void goToPreviousScreen(ActionEvent event){
       //navigator.navigateTo(ScreensFramework.screen13ID);
            navigator.navigateTo(ScreensFramework.screen12ID);
    }

     @FXML
     private void goToNextScreen(ActionEvent event)
     {
         if(!txtAllergyName.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateAllergyForm() && validatePhysicalParametersForm())
            {
                addAllergyToList(getAllergyBeanForCurrentForm());
                setAllergyData();
                setPhysicalParameters();
                navigateToNextScreen();
            }
            
        }
         else //if(!allergyList.isEmpty())
         {
             if(validatePhysicalParametersForm())
            {
                setAllergyData();
                setPhysicalParameters();
                navigateToNextScreen();
            }   
         }
//         else
//        {
//            UIUtils.showAlert("sc14_msg_enter_atleast_one_allergy_name", GlobalConstants.Lbl_Alert);  
//        }
     }
     
     
    
    private void populateLooseMotionsCombo() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbLooseMotions.getItems().size()==0)
        {
            for(String gen : list)
            {
                cmbLooseMotions.getItems().addAll(gen);
            }
            
        }
        
       
    }
   
    
    private void populateConstipationsCombo() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbConstipations.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbConstipations.getItems().addAll(gen);
            }
        }
    }
        
//private boolean validatePhysicalParametersForm()
//     {
//         
//         boolean isValid=true;
//         if(cmbLooseMotions.getValue()==null || cmbLooseMotions.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_lm", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//          else if(cmbConstipations.getValue()==null || cmbConstipations.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_consti", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         
//         return isValid;
//     }
    
//    private void setPhysicalParameters() {
//        PhysicalParameters phy = navigator.getUserInfo().getPhysicalParams();
//        if(phy==null)
//        {
//            phy=new PhysicalParameters();
//        }
//        phy.setLooseMotionsPerWeek(Integer.valueOf(cmbLooseMotions.getValue().toString()));
//        phy.setConstipationsPerWeek(Integer.valueOf(cmbConstipations.getValue().toString()));
//        System.out.println("2****phy="+phy);
//        navigator.getUserInfo().setPhysicalParams(phy);
//    }        

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
            previousCounter=allergyList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        AllergyBean a = allergyList.get(previousCounter);
        
        String allergyName = a.getAllergyName();
        txtAllergyName.setText(allergyName);
            
    }
    
        private void addAllergyToList(AllergyBean h) {
        if (allergyList.contains(h)) 
        {
            allergyList.remove(h);
            allergyList.add(h);
        } else 
        {
            allergyList.add(h);
        }
    }
        
    @FXML
    private void addAllergyAndClearForm(ActionEvent event) 
    {
        if(validateAllergyForm())
        {
            addAllergyToList(getAllergyBeanForCurrentForm());
            clearAllergyForm();
            showPreviousLink();
        }
    }
    
    private boolean validateAllergyForm() {
        boolean isValid=true;
         if(txtAllergyName.getText() ==null || txtAllergyName.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc14_msg_enter_allergy_name", GlobalConstants.Lbl_Alert);
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtAllergyName.getText()))
         {
              UIUtils.showAlert("sc14_msg_enter_valid_allergy_name", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         return isValid;
    }
    
    private void clearAllergyForm()
    {
        txtAllergyName.setText(GlobalConstants.emptyString);
    }
    
        private AllergyBean getAllergyBeanForCurrentForm() {
        AllergyBean b = new AllergyBean();
        b.setAllergyName(txtAllergyName.getText());
        return b;
    }

    private void setAllergyData() {
        System.out.println("****allergyList="+allergyList);
        navigator.getUserInfo().setAllergyList(allergyList);
    }

    private void navigateToNextScreen() {
        //navigator.navigateTo(ScreensFramework.screen11ID);
        //navigator.navigateTo(ScreensFramework.screen2ID);
        navigator.navigateTo(ScreensFramework.ScreenPhysiologicalGraph);
    }
    
    
        @FXML
        private ComboBox cmbHeightFeets;
        
        @FXML
        private ComboBox cmbHeightInches;
        
        @FXML
        private TextField txtWeight;
        
        @FXML
        private Label lblSign;
    
        @FXML
        private TextField txtWaist;

        @FXML
        private TextField txtHip;

        @FXML
        private TextField txtBpSystolic;

        @FXML
        private TextField txtBpDiastolic;

        @FXML
        private TextField txtHaemoglobin;

        @FXML
        private TextField txtToeCm;

        @FXML
        private RadioButton radCanTouch;

        @FXML
        private RadioButton radCannotTouch;

        @FXML
        private RadioButton radCanGoBeyond;

        final ToggleGroup group = new ToggleGroup();

        
//        @FXML
//        private Tooltip howToMeasureTooltip;
        
//        @FXML
//        private HBox hipHbox;
        
        @FXML
        private Hyperlink lnkHowToMeasure;
        
        private void populateHeightFeets() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Height_Feets_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightFeets.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                    cmbHeightFeets.getItems().addAll(gen);
            }
        }
       
    }
    
    
    private void populateHeightInches() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHeightInches.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.getProperty((GlobalConstants.Twelve))))
                 cmbHeightInches.getItems().addAll(gen);
            }
        }
       
    }
        
         @FXML
    private void showToolTip(Event e)
    {
//        System.out.println("showing");
        Point2D p = lnkHowToMeasure.localToScene(0.0, 0.0);
        lnkHowToMeasure.getTooltip().show(lnkHowToMeasure, p.getX() + lnkHowToMeasure.getScene().getX() + lnkHowToMeasure.getScene().getWindow().getX(),
        p.getY() + lnkHowToMeasure.getScene().getY() + lnkHowToMeasure.getScene().getWindow().getY());
        
        lnkHowToMeasure.getTooltip().setAutoHide(true);
        
        //howToMeasureTooltip.show(howToMeasureTooltip);
            
//        try {
//                Thread.sleep(5000);
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            }
//        
//        System.out.println("hiding");
//        lnkHowToMeasure.getTooltip().hide();
    }
    
    @FXML
    private void hideToolTip(Event e)
    {
        System.out.println("hiding");
        lnkHowToMeasure.getTooltip().hide();
    }
    
    
    private boolean validatePhysicalParametersForm()
     {
         
         boolean isValid=true;
          if(cmbHeightFeets.getValue()==null || cmbHeightFeets.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_feet", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbHeightInches.getValue()==null || cmbHeightInches.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_inches", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(txtWeight.getText() ==null || txtWeight.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_weight", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtWeight.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_weight", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isNumLesserThanOffset(txtWeight.getText(),500))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_weight", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtHip.getText() ==null || txtHip.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_hip", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isValidNumber(txtHip.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_hip", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isNumLesserThanOffset(txtHip.getText(),150))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_hip", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtWaist.getText() ==null || txtWaist.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_waist", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isValidNumber(txtWaist.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_waist", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isNumLesserThanOffset(txtWaist.getText(),150))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_waist", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtBpSystolic.getText() !=null 
                  && !txtBpSystolic.getText().trim().equals(GlobalConstants.emptyString)
                  && !GbbValidator.isValidNumber(txtBpSystolic.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_bp", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(txtBpDiastolic.getText() !=null 
                  && !txtBpDiastolic.getText().trim().equals(GlobalConstants.emptyString)
                  && !GbbValidator.isValidNumber(txtBpDiastolic.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_bp", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          else if(txtHaemoglobin.getText() !=null 
                  && !txtHaemoglobin.getText().trim().equals(GlobalConstants.emptyString)
                  && !GbbValidator.isValidNumber(txtHaemoglobin.getText())
                  && !GbbValidator.isNumLesserThanOffset(txtHaemoglobin.getText(),25))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_haemoglobin", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
           else if(!radCanTouch.isSelected() && !radCannotTouch.isSelected() && !radCanGoBeyond.isSelected())
         {
             UIUtils.showAlert("sc1_msg_enter_toe_option", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          else if(txtToeCm.getText() ==null || txtToeCm.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_toe_cm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtToeCm.getText()))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_toe_cm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(!GbbValidator.isNumLesserThanOffset(txtToeCm.getText(),10))
         {
             UIUtils.showAlert("sc1_msg_enter_valid_toe_cm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbLooseMotions.getValue()==null || cmbLooseMotions.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_lm", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbConstipations.getValue()==null || cmbConstipations.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_consti", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          
          
         return isValid;
     }
    private void setPhysicalParameters() 
    {
        PhysicalParameters phy = new PhysicalParameters();
        phy.setFeets(Integer.valueOf(cmbHeightFeets.getValue().toString()));
        phy.setInches(Integer.valueOf(cmbHeightInches.getValue().toString()));
        phy.setWeight(Float.parseFloat(txtWeight.getText()));
        
        phy.setHip(Float.parseFloat(txtHip.getText()) * 2.54f);
        
        if(!txtWaist.getText().equals(GlobalConstants.emptyString))
            phy.setWaist(Float.parseFloat(txtWaist.getText()) * 2.54f);
        
        if(!txtBpSystolic.getText().equals(GlobalConstants.emptyString))
            phy.setBpSystolic(Float.parseFloat(txtBpSystolic.getText()));
        
        if(!txtBpDiastolic.getText().equals(GlobalConstants.emptyString))
            phy.setBpDiastolic(Float.parseFloat(txtBpDiastolic.getText()));
        
        if(!txtHaemoglobin.getText().equals(GlobalConstants.emptyString))
            phy.setHaemoglobin(Float.parseFloat(txtHaemoglobin.getText()));
        
        if(radCanTouch.isSelected())
        {
            phy.setToeTouching(radCanTouch.getText());
        }
        else if(radCannotTouch.isSelected())
        {
            phy.setToeTouching(radCannotTouch.getText());
        }
        else if(radCanGoBeyond.isSelected())
        {
            phy.setToeTouching(radCanGoBeyond.getText());
        }
        
        phy.setToeTouchingCm(Float.parseFloat(txtToeCm.getText()));
        
        phy.setLooseMotionsPerWeek(Integer.valueOf(cmbLooseMotions.getValue().toString()));
        phy.setConstipationsPerWeek(Integer.valueOf(cmbConstipations.getValue().toString()));
        
        System.out.println("2****phy="+phy);
        navigator.getUserInfo().setPhysicalParams(phy);
    }
    
        private void consolidateRadioButtonsInToggleGroup() {
        radCanTouch.setToggleGroup(group);
        radCannotTouch.setToggleGroup(group);
        radCanGoBeyond.setToggleGroup(group);
    }
    
    @FXML
    private void manageCentimeterBoxCan() 
    {
        lblSign.setText(GlobalConstants.emptyString);
        txtToeCm.setText(GlobalConstants.Zero_Number);
        txtToeCm.setDisable(true);
    }
    
    @FXML
    private void manageCentimeterBoxCannot() 
    {
        lblSign.setText(GlobalConstants.hyphen);
        txtToeCm.setText(GlobalConstants.emptyString);
        txtToeCm.setDisable(false);
    }
    
    @FXML
    private void manageCentimeterBoxBeyond() 
    {
        lblSign.setText(GlobalConstants.plus);
        txtToeCm.setText(GlobalConstants.emptyString);
        txtToeCm.setDisable(false);
    }
}
