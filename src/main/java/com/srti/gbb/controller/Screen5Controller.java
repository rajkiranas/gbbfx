/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.FamilyEducation;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen5Controller implements Initializable, ControlledScreen {

    private List<FamilyEducation> familyList;
    private List<FamilyEducation> familyMembersList = new ArrayList<FamilyEducation>();
    private ScreensNavigator navigator;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateFamilyMembers();
        populateHighestQualification();
        populateOccupation();
        populateProfession();
        populateIncome();
    }  
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void populateFamilyMemberTypes(Event event) {
    }

    

    @FXML
    private void addFamilyMember(ActionEvent event) 
    {
        if(validateEducationFormForFamilyMember())
        {
            familyMembersList.add(getFamilyEducationBeanForCurrentForm());
            clearFamilyForm();
        }
    }
    
    private FamilyEducation getFamilyEducationBeanForCurrentForm()
    {
        FamilyEducation bean = new FamilyEducation();
        bean.setFamilyMember(cmbFM1.getValue().toString());
        bean.setHighestQualification(cmbFMHQ.getValue().toString());
        bean.setOccupation(cmbFMOccupation.getValue().toString());
        bean.setProfession(cmbFMProfession.getValue().toString());
        bean.setIncome(cmbFMIncome.getValue().toString());
        return bean;
    }
    private void clearFamilyForm()
    {
        cmbFM1.getSelectionModel().clearSelection();
        
        cmbFMHQ.getSelectionModel().clearSelection();
        cmbFMOccupation.getSelectionModel().clearSelection();
        cmbFMProfession.getSelectionModel().clearSelection();
        cmbFMIncome.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void goToScreen4(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen4ID);
    }

    @FXML
    private void goToScreen6(ActionEvent event) 
    {
            familyList = new ArrayList<FamilyEducation>();
            
            if(cmbFM1.getValue()!=null || 
                cmbFMHQ.getValue()!=null || 
                cmbFMOccupation.getValue()!=null || 
                cmbFMProfession.getValue()!=null || 
                cmbFMIncome.getValue()!=null)
            {
                if(validateEducationFormForFamilyMember() && validateFatherMotherForm())
                {
                    familyMembersList.add(getFamilyEducationBeanForCurrentForm());
                    insertFatherMotherDataInList();
                    setFamilyEducationData();
                    navigator.navigateTo(ScreensFramework.screen6ID);
                }
            }
            else if(validateFatherMotherForm())
            {
                insertFatherMotherDataInList();
                setFamilyEducationData();
                navigator.navigateTo(ScreensFramework.screen6ID);
            }
        
    }

    @FXML
    private ComboBox cmbFM1;
    
    
    private void populateFamilyMembers() 
    {
         String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Family_Member_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFM1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFM1.getItems().addAll(gen);                    
            }
        }
    }
    
    
    @FXML
    private ComboBox cmbFatherHQ;
    
    @FXML
    private ComboBox cmbMotherHQ;
    
    @FXML
    private ComboBox cmbFMHQ;
    
    private void populateHighestQualification() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Highest_Education_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbFatherHQ.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFatherHQ.getItems().addAll(gen);                    
            }
        }
        
        if(cmbMotherHQ.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbMotherHQ.getItems().addAll(gen);                    
            }
        }
        
        if(cmbFMHQ.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFMHQ.getItems().addAll(gen);                    
            }
        }
        
    }
    
    
    @FXML
    private ComboBox cmbFatherOccupation;
    
    @FXML
    private ComboBox cmbMotherOccupation;
    
    @FXML
    private ComboBox cmbFMOccupation;

    private void populateOccupation() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbFatherOccupation.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFatherOccupation.getItems().addAll(gen);                    
            }
        }
        
        if(cmbMotherOccupation.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbMotherOccupation.getItems().addAll(gen);                    
            }
        }
        
        if(cmbFMOccupation.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFMOccupation.getItems().addAll(gen);                    
            }
        }
        
        
    }

    
    @FXML
    private ComboBox cmbFatherProfession;
    
    @FXML
    private ComboBox cmbMotherProfession;
    
    @FXML
    private ComboBox cmbFMProfession;
    
    
    private void populateProfession() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Profession_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbFatherProfession.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals("Housewife"))
                    cmbFatherProfession.getItems().addAll(gen);                    
            }
        }
        
        if(cmbMotherProfession.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbMotherProfession.getItems().addAll(gen);                    
            }
        }
        
        if(cmbFMProfession.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFMProfession.getItems().addAll(gen);                    
            }
        }
        
    }

    
    @FXML
    private ComboBox cmbFatherIncome;
    
    @FXML
    private ComboBox cmbMotherIncome;
    
    @FXML
    private ComboBox cmbFMIncome;
    
    
    private void populateIncome() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Income_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbFatherIncome.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFatherIncome.getItems().addAll(gen);                    
            }
        }
        
        if(cmbMotherIncome.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbMotherIncome.getItems().addAll(gen);                    
            }
        }
        
        if(cmbFMIncome.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFMIncome.getItems().addAll(gen);                    
            }
        }
        
    }

    private boolean validateEducationFormForFamilyMember() {
        boolean isValid=true;
        if(cmbFM1.getValue()==null || cmbFM1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select family member", "Alert");
        }
        else if(cmbFMHQ.getValue()==null || cmbFMHQ.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification for family member", "Alert");
        }
        else if(cmbFMOccupation.getValue()==null || cmbFMOccupation.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation for family member", "Alert");
        }
        else if(cmbFMProfession.getValue()==null || cmbFMProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession for family member", "Alert");
        }
        else if(cmbFMIncome.getValue()==null || cmbFMIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income for family member", "Alert");
        }
        return isValid;
    }

    private boolean validateFatherMotherForm() 
    {
        boolean isValid=true;
        if(cmbFatherHQ.getValue()==null || cmbFatherHQ.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification for father", "Alert");
        }
        else if(cmbFatherOccupation.getValue()==null || cmbFatherOccupation.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation for father", "Alert");
        }
        else if(cmbFatherProfession.getValue()==null || cmbFatherProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession for father", "Alert");
        }
        else if(cmbFatherIncome.getValue()==null || cmbFatherIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income for father", "Alert");
        }
        else if(cmbMotherHQ.getValue()==null || cmbMotherHQ.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification for mother", "Alert");
        }
        else if(cmbMotherOccupation.getValue()==null || cmbMotherOccupation.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation for mother", "Alert");
        }
        else if(cmbMotherProfession.getValue()==null || cmbMotherProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession for mother", "Alert");
        }
        else if(cmbMotherIncome.getValue()==null || cmbMotherIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income for mother", "Alert");
        }
        return isValid;
    }

    private void insertFatherMotherDataInList() {
        FamilyEducation bean = new FamilyEducation();
        bean.setFamilyMember("Father");
        bean.setHighestQualification(cmbFatherHQ.getValue().toString());
        bean.setOccupation(cmbFatherOccupation.getValue().toString());
        bean.setProfession(cmbFatherProfession.getValue().toString());
        bean.setIncome(cmbFatherIncome.getValue().toString());
        
        familyList.add(bean);
        
        bean.setFamilyMember("Mother");
        bean.setHighestQualification(cmbMotherHQ.getValue().toString());
        bean.setOccupation(cmbMotherOccupation.getValue().toString());
        bean.setProfession(cmbMotherProfession.getValue().toString());
        bean.setIncome(cmbMotherIncome.getValue().toString());
        
        familyList.add(bean);
    }

    private void setFamilyEducationData() 
    {
        System.out.println("$$$$familyMembersList="+familyMembersList.size());
        System.out.println("$$$$=familyList"+familyList.size());
        for(FamilyEducation member : familyMembersList)
        {
            familyList.add(member);
        }
        
        System.out.println("$$$$=familyList"+familyList.size());
        if(navigator.getUserInfo().getFamilyEducationList()==null)
        {
            navigator.getUserInfo().setFamilyEducationList(familyList);
        }
    }
}
