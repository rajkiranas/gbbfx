/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.IllnessBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
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
    
    private Set<String> specialDiseasesSet = new HashSet<String>();
    
    
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
        populateSpecialDiseases();
    }    

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        if(cmbIntensity.getValue()!=null ||
                cmbFrequency.getValue()!=null ||
                cmbDuration.getValue()!=null ||
                cmbLastsForDays.getValue()!=null ||
                cmbSinceYears.getValue()!=null ||
                cmbLossOfManDays.getValue()!=null)
        {
            validateAndUpdateSelfIllnessQuantificationDetails();
        }
        
        if(counterMap.size()==navigator.getUserInfo().getSelfIllnessList().size())
        {
            navigateToNextScreen();
        }
        else
        {
            UIUtils.showAlert("sc22_msg_fill_all_disease_dtls", GlobalConstants.Lbl_Alert);
        }
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.Screen_Illness);
    }

    @FXML
    private void setFormData(MouseEvent event) 
    {
        enableDisableOptionsAccordingToDisease();
        IllnessBean b =getIllnessBeanForSelectionFromNavigator();
        
        //System.out.println("***="+cmbIntensity.getItems().contains(String.valueOf(b.getIntensity())));
        
        if(cmbIntensity.getItems().contains(String.valueOf(b.getIntensity())))
            cmbIntensity.getSelectionModel().select(String.valueOf(b.getIntensity()));
        else
            cmbIntensity.getSelectionModel().clearSelection();
        
        if(cmbFrequency.getItems().contains(String.valueOf(b.getFrequency())))
            cmbFrequency.getSelectionModel().select(String.valueOf(b.getFrequency()));
        else
            cmbFrequency.getSelectionModel().clearSelection();
        
        if(cmbDuration.getItems().contains(String.valueOf(b.getDuration())))
            cmbDuration.getSelectionModel().select(String.valueOf(b.getDuration()));
        else
            cmbDuration.getSelectionModel().clearSelection();
        
        if(cmbLastsForDays.getItems().contains(String.valueOf(b.getLastsForDays())))
            cmbLastsForDays.getSelectionModel().select(String.valueOf(b.getLastsForDays()));
        else
            cmbLastsForDays.getSelectionModel().clearSelection();
        
        if(cmbSinceYears.getItems().contains(String.valueOf(b.getSinceYears())))
            cmbSinceYears.getSelectionModel().select(String.valueOf(b.getSinceYears()));
        else
            cmbSinceYears.getSelectionModel().clearSelection();
        
        if(cmbLossOfManDays.getItems().contains(String.valueOf(b.getLossOfManDays())))
            cmbLossOfManDays.getSelectionModel().select(String.valueOf(b.getLossOfManDays()));
        else
            cmbLossOfManDays.getSelectionModel().clearSelection();
    }


    @FXML
    private void recordSelfIllnessQuantificationDetails(ActionEvent event) 
    {
        validateAndUpdateSelfIllnessQuantificationDetails();
    }
    
    private void validateAndUpdateSelfIllnessQuantificationDetails()
    {
        if(validate())
        {
            updateSelfIllnessBean();
            
            updateCounter();
            
            clearForm();
        }
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
                    if(!gen.equals(GlobalConstants.Zero_Number))
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
                if(!gen.equals(GlobalConstants.Zero_Number))
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
                if(!gen.equals(GlobalConstants.Zero_Number))
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

    private boolean validate() {
        boolean isValid = true;
        
        if (listSelfIllness.getSelectionModel().getSelectedItems().size()==0) 
        {
            isValid = false;
            UIUtils.showAlert("sc22_msg_sel_illness", GlobalConstants.Lbl_Alert);
        }
        else if(!cmbIntensity.isDisabled() && (cmbIntensity.getValue()==null || cmbIntensity.getValue().toString().equals(GlobalConstants.emptyString)))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_intensity", GlobalConstants.Lbl_Alert);
        }
        else if(!cmbFrequency.isDisabled() && (cmbFrequency.getValue()==null || cmbFrequency.getValue().toString().equals(GlobalConstants.emptyString)))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_frequency", GlobalConstants.Lbl_Alert);
        }
        else if(!cmbDuration.isDisabled() && (cmbDuration.getValue()==null || cmbDuration.getValue().toString().equals(GlobalConstants.emptyString)))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_duration", GlobalConstants.Lbl_Alert);
        }
        else if(!cmbLastsForDays.isDisabled() && (cmbLastsForDays.getValue()==null || cmbLastsForDays.getValue().toString().equals(GlobalConstants.emptyString)))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_lastsfordays", GlobalConstants.Lbl_Alert);
        }
        else if(cmbSinceYears.getValue()==null || cmbSinceYears.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_since_years", GlobalConstants.Lbl_Alert);
        }
        else if(cmbLossOfManDays.getValue()==null || cmbLossOfManDays.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc22_msg_sel_loss_of_man_days", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }
    
    private IllnessBean getIllnessBeanForSelectionFromNavigator()
    {
        List<IllnessBean> illList  = navigator.getUserInfo().getSelfIllnessList();
            String selection = (String) listSelfIllness.getSelectionModel().getSelectedItem();
            IllnessBean dummy  = new IllnessBean();
            dummy.setIllness(selection);
            int index = illList.indexOf(dummy);
            
            IllnessBean b = illList.get(index);
            return b;
    }

    private void updateSelfIllnessBean() 
    {
            IllnessBean b =getIllnessBeanForSelectionFromNavigator();
            
            if(!cmbIntensity.isDisabled())
                b.setIntensity(Short.valueOf(cmbIntensity.getValue().toString()));
            
            if(!cmbFrequency.isDisabled())
                b.setFrequency(Short.valueOf(cmbFrequency.getValue().toString()));
            
            if(!cmbDuration.isDisabled())
                b.setDuration(Float.valueOf(cmbDuration.getValue().toString()));
            
            if(!cmbLastsForDays.isDisabled())
                b.setLastsForDays(Short.valueOf(cmbLastsForDays.getValue().toString()));
            
            b.setSinceYears(Short.valueOf(cmbSinceYears.getValue().toString()));
            b.setLossOfManDays(Short.valueOf(cmbLossOfManDays.getValue().toString()));
            
            System.out.println("****illList="+navigator.getUserInfo().getSelfIllnessList());
    }

    private void clearForm() {
        listSelfIllness.getSelectionModel().clearSelection();
        cmbIntensity.getSelectionModel().clearSelection();
        cmbFrequency.getSelectionModel().clearSelection();
        cmbDuration.getSelectionModel().clearSelection();
        cmbLastsForDays.getSelectionModel().clearSelection();
        cmbSinceYears.getSelectionModel().clearSelection();
        cmbLossOfManDays.getSelectionModel().clearSelection();        
    }

    private HashMap counterMap = new HashMap();
    private void updateCounter() 
    {
        String sel = (String) listSelfIllness.getSelectionModel().getSelectedItem();
        counterMap.put(sel,sel);
    }

    private void navigateToNextScreen() {
        //navigator.navigateTo(ScreensFramework.Screen_Hospitalization);
        //navigator.navigateTo(ScreensFramework.Screen_Welcome_Prakruti_Nidaan);
        navigator.navigateTo(ScreensFramework.Screen_Illness_Graph);
    }

    
    
    private void enableDisableOptionsAccordingToDisease() 
    {
        String sel = (String) listSelfIllness.getSelectionModel().getSelectedItem();
        if(specialDiseasesSet.contains(sel))
        {
            cmbIntensity.setDisable(true);
            cmbFrequency.setDisable(true);
            cmbDuration.setDisable(true);
            cmbLastsForDays.setDisable(true);
        }
        else
        {
            cmbIntensity.setDisable(false);
            cmbFrequency.setDisable(false);
            cmbDuration.setDisable(false);
            cmbLastsForDays.setDisable(false);
        }
    }

    private void populateSpecialDiseases() {
        if(specialDiseasesSet.isEmpty())
        {
           String specialDiseases = MU.getMsg("Special_Diseases");
           String[] list1 =  specialDiseases.split(GlobalConstants.COMMA);
           
               for(String d : list1)
               {
                   specialDiseasesSet.add(d);
               }
        }
    }
}
