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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen18Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    private List<FamilyEducation> childrenList = new ArrayList<FamilyEducation>();
    
    
    
    
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
        if(cmbChildGender.getValue()!=null || 
                cmbChildQual.getValue()!=null || 
                //cmbFMOccupation.getValue()!=null || 
                    !txtChildName.getText().equals(GlobalConstants.emptyString) ||
                cmbChildProfession.getValue()!=null || 
                cmbChildIncome.getValue()!=null ||
                    chkIsChildDeceased.isSelected())
            {
                if(validateForFamilyMemberForm())
                {
                    addToFamilyMembersList(getFamilyMemberBeanForCurrentForm());
                    clearFamilyMemberForm();
                    showPreviousLink();
                }
            }
        
        if((childrenList.size()==navigator.getUserInfo().getPi().getNoOfChildren() || childrenList.size()>navigator.getUserInfo().getPi().getNoOfChildren())
                && validateSpouseInformation())
        {
            setFamilyEducationData();
            setSpouseData();
            navigateToNextScreen();
            
        }
        else
        {
            UIUtils.showAlert("sc18_msg_enter_correct_child_no", GlobalConstants.Lbl_Alert);
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
        System.out.println("****Spouse="+m);
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
        
        // this is opposite case - male profile will fill up form for his spouse
        //and female profile will fillup for her spouse
        if(navigator.getUserInfo().getPi().getGender().equals(MU.getMsg("Lbl_Male")))
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
        else
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
    
     @FXML
    Hyperlink linkShowPrevious;
     
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
            previousCounter=childrenList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        FamilyEducation member = childrenList.get(previousCounter);
        
        String m = member.getFamilyMember();
        String fQual = member.getHighestQualification();
        String fProfession = member.getProfession();
        String fIncome = member.getIncome();            
        
        if(m.equals(MU.getMsg("Lbl_Son")))   
        {
           cmbChildGender.getSelectionModel().select(MU.getMsg("Lbl_Male"));
        }
        else
        {
            cmbChildGender.getSelectionModel().select(MU.getMsg("Lbl_Female"));
        }
        cmbChildQual.getSelectionModel().select(fQual);
        txtChildName.setText(member.getName());
        cmbChildProfession.getSelectionModel().select(fProfession);
        cmbChildIncome.getSelectionModel().select(fIncome);        
        chkIsChildDeceased.setSelected(member.isIsDeceased());
    }
    
    @FXML
    private void addFamilyMember(ActionEvent event) 
    {
        if(validateForFamilyMemberForm())
        {
            addToFamilyMembersList(getFamilyMemberBeanForCurrentForm());
            
            clearFamilyMemberForm();
            showPreviousLink();
        }
    }
    
    private FamilyEducation getFamilyMemberBeanForCurrentForm()
    {
        FamilyEducation bean = new FamilyEducation();
        
        if(cmbChildGender.getValue().toString().equals(MU.getMsg("Lbl_Male")))
        {
            bean.setFamilyMember(MU.getMsg("Lbl_Son"));
        }
        else
        {
            bean.setFamilyMember(MU.getMsg("Lbl_Daughter"));
        }
        
        bean.setHighestQualification(cmbChildQual.getValue().toString());
        bean.setName(txtChildName.getText());
        bean.setProfession(cmbChildProfession.getValue().toString());
        bean.setIncome(cmbChildIncome.getValue().toString());
        bean.setIsDeceased(chkIsChildDeceased.isSelected());
        return bean;
    }
    private void clearFamilyMemberForm()
    {
        cmbChildGender.getSelectionModel().clearSelection();
        
        cmbChildQual.getSelectionModel().clearSelection();
        txtChildName.setText(GlobalConstants.emptyString);
        cmbChildProfession.getSelectionModel().clearSelection();
        cmbChildIncome.getSelectionModel().clearSelection();
        chkIsChildDeceased.setSelected(false);
    }
    
    private void addToFamilyMembersList(FamilyEducation familyMemberBeanForCurrentForm) 
    {
        if(childrenList.contains(familyMemberBeanForCurrentForm))
        {
            childrenList.remove(familyMemberBeanForCurrentForm);
            childrenList.add(familyMemberBeanForCurrentForm);
        }
        else
        {
            childrenList.add(familyMemberBeanForCurrentForm);
        }
    }
    
    private boolean validateForFamilyMemberForm() 
    {
        boolean isValid=true;
        
        if(txtChildName.getText()==null || txtChildName.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_enter_child_name", GlobalConstants.Lbl_Alert);
        }
        else if(cmbChildGender.getValue()==null || cmbChildGender.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_sel_child_gender", GlobalConstants.Lbl_Alert);
        } 
        else if(cmbChildQual.getValue()==null || cmbChildQual.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_sel_child_qual", GlobalConstants.Lbl_Alert);
        }
        else if(cmbChildProfession.getValue()==null || cmbChildProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_sel_child_prof", GlobalConstants.Lbl_Alert);
        }
        else if(cmbChildIncome.getValue()==null || cmbChildIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc18_msg_sel_child_income", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private void setFamilyEducationData() {
        System.out.println("***childrenList="+childrenList);
        navigator.getUserInfo().setChildrenList(childrenList);
    }
}