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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen5Controller implements Initializable, ControlledScreen {

    private List<FamilyEducation> familyList;
    private List<FamilyEducation> familyMembersList = new ArrayList<FamilyEducation>();
    private ScreensNavigator navigator;
    
    @FXML
    private CheckBox chkDeceasedFather;
    
    @FXML
    private CheckBox chkDeceasedMother;
    
    @FXML
    private CheckBox chkDeceasedFM;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideShowPreviousLink();
        populateFamilyMembers();
        populateHighestQualification();
        //populateOccupation();
        populateProfession();
        populateIncome();
    }  
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

//    @FXML
//    private void populateFamilyMemberTypes(Event event) {
//    }

    

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
    
    
    @FXML
    private TextField txtNameFather;
    
    @FXML
    private TextField txtNameMother;
    
    @FXML
    private TextField txtNameFM;
    
    private FamilyEducation getFamilyMemberBeanForCurrentForm()
    {
        FamilyEducation bean = new FamilyEducation();
        bean.setFamilyMember(cmbFM1.getValue().toString());
        bean.setHighestQualification(cmbFMHQ.getValue().toString());
        //bean.setOccupation(cmbFMOccupation.getValue().toString());
        bean.setName(txtNameFM.getText());
        bean.setProfession(cmbFMProfession.getValue().toString());
        bean.setIncome(cmbFMIncome.getValue().toString());
        bean.setIsDeceased(chkDeceasedFM.isSelected());
        return bean;
    }
    private void clearFamilyMemberForm()
    {
        cmbFM1.getSelectionModel().clearSelection();
        
        cmbFMHQ.getSelectionModel().clearSelection();
        //cmbFMOccupation.getSelectionModel().clearSelection();
        txtNameFM.setText(GlobalConstants.emptyString);
        cmbFMProfession.getSelectionModel().clearSelection();
        cmbFMIncome.getSelectionModel().clearSelection();
        chkDeceasedFM.setSelected(false);
        
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
                //cmbFMOccupation.getValue()!=null || 
                    !txtNameFM.getText().equals(GlobalConstants.emptyString) ||
                cmbFMProfession.getValue()!=null || 
                cmbFMIncome.getValue()!=null ||
                    chkDeceasedFM.isSelected())
            {
                if(validateForFamilyMemberForm() && validateFatherForm() && validateMotherForm())
                {
                    addToFamilyMembersList(getFamilyMemberBeanForCurrentForm());
                    insertFatherMotherDataInList();
                    setFamilyEducationData();
                    navigateToNextScreen();
                }
            }
            else if(validateFatherForm() && validateMotherForm())
            {
                insertFatherMotherDataInList();
                setFamilyEducationData();
                navigateToNextScreen();
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
    private void manageOccuAndProfForHouseWife()
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
        String[] occuList =  genderList.split(GlobalConstants.COMMA);
        
        String profList = GlobalConstants.getProperty(GlobalConstants.Profession_Options);
        String[] list =  profList.split(GlobalConstants.COMMA);
        
        if (cmbFM1.getValue()!=null && cmbFM1.getValue().toString().equals(MU.getMsg("Lbl_Brother"))) 
        {
//            cmbFMOccupation.getItems().clear();
//            if (cmbFMOccupation.getItems().size() == 0) {
//                for (String gen : occuList) {
//                    if (!gen.equals(MU.getMsg("Lbl_Housewife"))) {
//                        cmbFMOccupation.getItems().addAll(gen);
//                    }
//                }
//            }
            
            cmbFMProfession.getItems().clear();
            if(cmbFMProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                    if (!gen.equals(MU.getMsg("Lbl_Housewife"))) {
                        cmbFMProfession.getItems().addAll(gen);
                    }
                        
                }
            }

        }
        else
        {
//            cmbFMOccupation.getItems().clear();
//            if (cmbFMOccupation.getItems().size() == 0) {
//                for (String gen : occuList) {
//                    
//                        cmbFMOccupation.getItems().addAll(gen);
//                    
//                }
//            }
            
            cmbFMProfession.getItems().clear();
            if(cmbFMProfession.getItems().size()==0)
            {
                for(String gen : list)
                {
                        cmbFMProfession.getItems().addAll(gen);
                }
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
    
    
//    @FXML
//    private ComboBox cmbFatherOccupation;
//    
//    @FXML
//    private ComboBox cmbMotherOccupation;
//    
//    @FXML
//    private ComboBox cmbFMOccupation;

//    private void populateOccupation() 
//    {
//        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
//        String[] list =  genderList.split(GlobalConstants.COMMA);
//        
//        if(cmbFatherOccupation.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                if(!gen.equals(MU.getMsg("Lbl_Housewife")))
//                    cmbFatherOccupation.getItems().addAll(gen);                    
//            }
//        }
//        
//        if(cmbMotherOccupation.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                    cmbMotherOccupation.getItems().addAll(gen);                    
//            }
//        }
//        
//        if(cmbFMOccupation.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                    cmbFMOccupation.getItems().addAll(gen);                    
//            }
//        }
//    }

    
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
                if(!gen.equals(MU.getMsg("Lbl_Housewife")))
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

    private boolean validateForFamilyMemberForm() {
        boolean isValid=true;
        if(cmbFM1.getValue()==null || cmbFM1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc5_msg_sel_family_member", GlobalConstants.Lbl_Alert);
        }
        else if(txtNameFM.getText()==null || txtNameFM.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc5_msg_enter_fm_name", GlobalConstants.Lbl_Alert);
        }
        else if(cmbFMHQ.getValue()==null || cmbFMHQ.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc5_msg_sel_fm_qual", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbFMOccupation.getValue()==null || cmbFMOccupation.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc5_msg_sel_fm_occu", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbFMProfession.getValue()==null || cmbFMProfession.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc5_msg_sel_fm_prof", GlobalConstants.Lbl_Alert);
        }
        else if(cmbFMIncome.getValue()==null || cmbFMIncome.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc5_msg_sel_fm_income", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private boolean validateFatherForm() 
    {
        boolean isValid=true;
//        if (!chkDeceasedFather.isSelected()) 
//        {
            if (txtNameFather.getText() == null || txtNameFather.getText().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_enter_father_name", GlobalConstants.Lbl_Alert);
            } 
            else if (cmbFatherHQ.getValue() == null || cmbFatherHQ.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_father_qual", GlobalConstants.Lbl_Alert);
            } 
//            else if (cmbFatherOccupation.getValue() == null || cmbFatherOccupation.getValue().toString().equals(GlobalConstants.emptyString)) 
//            {
//                isValid = false;
//                UIUtils.showAlert("sc5_msg_sel_father_occu", GlobalConstants.Lbl_Alert);
//            }
            else if (cmbFatherProfession.getValue() == null || cmbFatherProfession.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_father_prof", GlobalConstants.Lbl_Alert);
            } else if (cmbFatherIncome.getValue() == null || cmbFatherIncome.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_father_income", GlobalConstants.Lbl_Alert);
            }
        //}
        return isValid;
    }
    
    private boolean validateMotherForm() 
    {
        boolean isValid=true;
//        if (!chkDeceasedMother.isSelected()) 
//        {
            if (txtNameMother.getText() == null || txtNameMother.getText().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_enter_mother_name", GlobalConstants.Lbl_Alert);
            } 
            else if (cmbMotherHQ.getValue() == null || cmbMotherHQ.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_mother_qual", GlobalConstants.Lbl_Alert);
            } 
//            else if (cmbMotherOccupation.getValue() == null || cmbMotherOccupation.getValue().toString().equals(GlobalConstants.emptyString)) 
//            {
//                isValid = false;
//                UIUtils.showAlert("sc5_msg_sel_mother_occu", GlobalConstants.Lbl_Alert);
//            }
            else if (cmbMotherProfession.getValue() == null || cmbMotherProfession.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_mother_prof", GlobalConstants.Lbl_Alert);
            } else if (cmbMotherIncome.getValue() == null || cmbMotherIncome.getValue().toString().equals(GlobalConstants.emptyString)) 
            {
                isValid = false;
                UIUtils.showAlert("sc5_msg_sel_mother_income", GlobalConstants.Lbl_Alert);
            }
        //}
        return isValid;
    }

    private void insertFatherMotherDataInList() 
    {
        FamilyEducation bean = new FamilyEducation();
//        if (!chkDeceasedFather.isSelected()) 
//        {
            bean.setHighestQualification(cmbFatherHQ.getValue().toString());
            //bean.setOccupation(cmbFatherOccupation.getValue().toString());
            bean.setName(txtNameFather.getText());
            bean.setProfession(cmbFatherProfession.getValue().toString());
            bean.setIncome(cmbFatherIncome.getValue().toString());
        //}
        
        String lblFather = MU.getMsg("Lbl_Father");
        lblFather=lblFather.substring(0, lblFather.length()-1);
        bean.setFamilyMember(lblFather);
        
        bean.setIsDeceased(chkDeceasedFather.isSelected());
        familyList.add(bean);
        
        bean = new FamilyEducation();
//        if (!chkDeceasedMother.isSelected()) 
//        {
            bean.setHighestQualification(cmbMotherHQ.getValue().toString());
            //bean.setOccupation(cmbMotherOccupation.getValue().toString());
            bean.setName(txtNameMother.getText());
            bean.setProfession(cmbMotherProfession.getValue().toString());
            bean.setIncome(cmbMotherIncome.getValue().toString());
        //}

        String lblMother = MU.getMsg("Lbl_Mother");
        lblMother=lblMother.substring(0, lblMother.length()-1);
        bean.setFamilyMember(lblMother);
        bean.setIsDeceased(chkDeceasedMother.isSelected());
        familyList.add(bean);
    }

    private void setFamilyEducationData() 
    {
        System.out.println("$$$$familyMembersList="+familyMembersList);
        System.out.println("previouse$$$$=familyList"+familyList);
        for(FamilyEducation member : familyMembersList)
        {
            familyList.add(member);
        }
        
        System.out.println("after$$$$=familyList"+familyList);
//        if(navigator.getUserInfo().getFamilyEducationList()==null)
//        {
            navigator.getUserInfo().setFamilyEducationList(familyList);
        //}
    }
    
//    @FXML
//    private void toggleFatherCombos(ActionEvent event) 
//    {
//        if(chkDeceasedFather.isSelected())
//         {
//             
//             cmbFatherHQ.setDisable(true);
//             //cmbFatherOccupation.setDisable(true);
//             txtNameFather.setDisable(true);
//             cmbFatherProfession.setDisable(true);
//             cmbFatherIncome.setDisable(true);
//         }
//         else
//         {
//             cmbFatherHQ.setDisable(false);
//             //cmbFatherOccupation.setDisable(false);
//             txtNameFather.setDisable(false);
//             cmbFatherProfession.setDisable(false);
//             cmbFatherIncome.setDisable(false);
//             
//         }
//        
//    }
//    
//    @FXML
//    private void toggleMotherCombos(ActionEvent event) 
//    {
//        if(chkDeceasedMother.isSelected())
//         {
//             
//             cmbMotherHQ.setDisable(true);
//             //cmbMotherOccupation.setDisable(true);
//             txtNameMother.setDisable(true);
//             cmbMotherProfession.setDisable(true);
//             cmbMotherIncome.setDisable(true);
//         }
//         else
//         {
//             cmbMotherHQ.setDisable(false);
//             //cmbMotherOccupation.setDisable(false);
//             txtNameMother.setDisable(false);
//             cmbMotherProfession.setDisable(false);
//             cmbMotherIncome.setDisable(false);
//             
//         }
//    }
    
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
            previousCounter=familyMembersList.size()-1;
        }
        else
        {
            previousCounter--;        
        }
            
        FamilyEducation member = familyMembersList.get(previousCounter);
        
        String m = member.getFamilyMember();
        String fQual = member.getHighestQualification();
        String fOccu = member.getOccupation();
        String fProfession = member.getProfession();
        String fIncome = member.getIncome();            
        
        
        cmbFM1.getSelectionModel().select(m);
        cmbFMHQ.getSelectionModel().select(fQual);
        //cmbFMOccupation.getSelectionModel().select(fOccu);
        txtNameFM.setText(member.getName());
        cmbFMProfession.getSelectionModel().select(fProfession);
        cmbFMIncome.getSelectionModel().select(fIncome);        
        chkDeceasedFM.setSelected(member.isIsDeceased());
    }

    private void navigateToNextScreen() 
    {
        if(navigator.getUserInfo().getPi().getMaritalStatus()!=null && !navigator.getUserInfo().getPi().getMaritalStatus().equals(GlobalConstants.getProperty(GlobalConstants.Lbl_Single_Status)))
        {
            navigator.navigateTo(ScreensFramework.screen18ID);
        }
        else
        {
            //navigator.navigateTo(ScreensFramework.Screen_FriendList);
            navigator.navigateTo(ScreensFramework.screen7ID);
        }
    }

    private void addToFamilyMembersList(FamilyEducation familyMemberBeanForCurrentForm) 
    {
        if(familyMembersList.contains(familyMemberBeanForCurrentForm))
        {
            familyMembersList.remove(familyMemberBeanForCurrentForm);
            familyMembersList.add(familyMemberBeanForCurrentForm);
        }
        else
        {
            familyMembersList.add(familyMemberBeanForCurrentForm);
        }
    }
}
