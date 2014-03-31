/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.Friends;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen6Controller implements Initializable, ControlledScreen {

    private List<Friends> friendsList;
    private List<Friends> friendsListForAddition = new ArrayList<Friends>();
    private ScreensNavigator navigator;
    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideShowPreviousLink();
        populateHighestQualification();
//        populateOccupation();
        populateProfession();
        populateIncome();
    }     

    @FXML
    private void goToScreen5(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen5ID);
    }

    @FXML
    private void goToScreen7(ActionEvent event) 
    {
        friendsList = new ArrayList<Friends>();
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        if(!txtFrnd1.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd1.getValue()!=null ||
  //              cmbOccupationFrnd1.getValue()!=null ||
                cmbProfessionFrnd1.getValue()!=null ||
                cmbIncomeFrnd1.getValue()!=null)
        {
            if(validateFriend1())
            {
                addFriend1ToList();
                f1=true;
            }
            else
            {
                f1=false;
            }
            
        }
        
        if(!txtFrnd2.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd2.getValue()!=null ||
    //            cmbOccupationFrnd2.getValue()!=null ||
                cmbProfessionFrnd2.getValue()!=null ||
                cmbIncomeFrnd2.getValue()!=null)
        {
            if(validateFriend2())
            {
                addFriend2ToList();
                f2=true;
            }
            else
            {
                f2=false;
            }
        }
        
        if(!txtFrnd3.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd3.getValue()!=null ||
      //          cmbOccupationFrnd3.getValue()!=null ||
                cmbProfessionFrnd3.getValue()!=null ||
                cmbIncomeFrnd3.getValue()!=null)
        {
            if(validateFriend3())
            {
                addFriend3ToList();
                f3=true;
            }
            else
            {
                f3=false;
            }
        }
        
        
        if((f1 && f2 && f3) || !friendsListForAddition.isEmpty())
        {
            setFriendsData();
            navigator.navigateTo(ScreensFramework.screen7ID);
        }
        else
        {
            UIUtils.showAlert("sc6_msg_enter_three_friends", GlobalConstants.Lbl_Alert);
        }
    }

    @FXML
    private void addFriendsToList(ActionEvent event) 
    {
        if(validateFriendsForm())
        {
        
            Friends bean = new Friends();
            bean.setFriendName(txtFrnd1.getText());
            bean.setHighestQualification(cmbQualFrnd1.getValue().toString());
        //    bean.setOccupation(cmbOccupationFrnd1.getValue().toString());
            bean.setProfession(cmbProfessionFrnd1.getValue().toString());
            bean.setIncome(cmbIncomeFrnd1.getValue().toString());        
            addToFriendsListForAddition(bean);
            
            bean = new Friends();
            bean.setFriendName(txtFrnd2.getText());
            bean.setHighestQualification(cmbQualFrnd2.getValue().toString());
          //  bean.setOccupation(cmbOccupationFrnd2.getValue().toString());
            bean.setProfession(cmbProfessionFrnd2.getValue().toString());
            bean.setIncome(cmbIncomeFrnd2.getValue().toString());
            
            addToFriendsListForAddition(bean);
            
            bean = new Friends();
            bean.setFriendName(txtFrnd3.getText());
            bean.setHighestQualification(cmbQualFrnd3.getValue().toString());
            //bean.setOccupation(cmbOccupationFrnd3.getValue().toString());
            bean.setProfession(cmbProfessionFrnd3.getValue().toString());
            bean.setIncome(cmbIncomeFrnd3.getValue().toString());        
            
            addToFriendsListForAddition(bean);
            
            clearFriendsForm();
            showPreviousLink();
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private TextField txtFrnd1;
    @FXML
    private TextField txtFrnd2;
    @FXML
    private TextField txtFrnd3;
    
    

    
    private void clearFriendsForm()
    {
        txtFrnd1.clear();
        cmbQualFrnd1.getSelectionModel().clearSelection();
        //cmbOccupationFrnd1.getSelectionModel().clearSelection();
        cmbProfessionFrnd1.getSelectionModel().clearSelection();
        cmbIncomeFrnd1.getSelectionModel().clearSelection();
        
        txtFrnd2.clear();
        cmbQualFrnd2.getSelectionModel().clearSelection();
        //cmbOccupationFrnd2.getSelectionModel().clearSelection();
        cmbProfessionFrnd2.getSelectionModel().clearSelection();
        cmbIncomeFrnd2.getSelectionModel().clearSelection();
        
        txtFrnd3.clear();
        cmbQualFrnd3.getSelectionModel().clearSelection();
        //cmbOccupationFrnd3.getSelectionModel().clearSelection();
        cmbProfessionFrnd3.getSelectionModel().clearSelection();
        cmbIncomeFrnd3.getSelectionModel().clearSelection();
        
    }
    
    private boolean validateFriendsForm() {
        boolean isValid=true;
        if(txtFrnd1.getText()==null || txtFrnd1.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend1", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd1.getValue()==null || cmbQualFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend1", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd1.getValue()==null || cmbOccupationFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend1", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd1.getValue()==null || cmbProfessionFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend1", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd1.getValue()==null || cmbIncomeFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend1", GlobalConstants.Lbl_Alert);
        }
        else if(txtFrnd2.getText()==null || txtFrnd2.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend2", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd2.getValue()==null || cmbQualFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend2", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd2.getValue()==null || cmbOccupationFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend2", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd2.getValue()==null || cmbProfessionFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend2", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd2.getValue()==null || cmbIncomeFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend2", GlobalConstants.Lbl_Alert);
        }
        else if(txtFrnd3.getText()==null || txtFrnd3.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend3", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd3.getValue()==null || cmbQualFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend3", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd3.getValue()==null || cmbOccupationFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend3", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd3.getValue()==null || cmbProfessionFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend3", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd3.getValue()==null || cmbIncomeFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend3", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }
    
    @FXML
    private ComboBox cmbQualFrnd1;
    
    @FXML
    private ComboBox cmbQualFrnd2;
    
    @FXML
    private ComboBox cmbQualFrnd3;
    
    private void populateHighestQualification() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Highest_Education_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbQualFrnd1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbQualFrnd1.getItems().addAll(gen);                    
            }
        }
        
        if(cmbQualFrnd2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbQualFrnd2.getItems().addAll(gen);                    
            }
        }
        
        if(cmbQualFrnd3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbQualFrnd3.getItems().addAll(gen);                    
            }
        }
        
    }
    
    
//    @FXML
//    private ComboBox cmbOccupationFrnd1;
//    
//    @FXML
//    private ComboBox cmbOccupationFrnd2;
//    
//    @FXML
//    private ComboBox cmbOccupationFrnd3;
//
//    private void populateOccupation() 
//    {
//        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
//        String[] list =  genderList.split(GlobalConstants.COMMA);
//        
//        if(cmbOccupationFrnd1.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                    cmbOccupationFrnd1.getItems().addAll(gen);                    
//            }
//        }
//        
//        if(cmbOccupationFrnd2.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                    cmbOccupationFrnd2.getItems().addAll(gen);                    
//            }
//        }
//        
//        if(cmbOccupationFrnd3.getItems().size()==0)
//        {
//            for(String gen : list)
//            {
//                    cmbOccupationFrnd3.getItems().addAll(gen);                    
//            }
//        }
//        
//        
//    }

    
    @FXML
    private ComboBox cmbProfessionFrnd1;
    
    @FXML
    private ComboBox cmbProfessionFrnd2;
    
    @FXML
    private ComboBox cmbProfessionFrnd3;
    
    
    private void populateProfession() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Profession_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbProfessionFrnd1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbProfessionFrnd1.getItems().addAll(gen);                    
            }
        }
        
        if(cmbProfessionFrnd2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbProfessionFrnd2.getItems().addAll(gen);                    
            }
        }
        
        if(cmbProfessionFrnd3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbProfessionFrnd3.getItems().addAll(gen);                    
            }
        }
        
    }

    
    @FXML
    private ComboBox cmbIncomeFrnd1;
    
    @FXML
    private ComboBox cmbIncomeFrnd2;
    
    @FXML
    private ComboBox cmbIncomeFrnd3;
    
    
    private void populateIncome() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Income_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbIncomeFrnd1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbIncomeFrnd1.getItems().addAll(gen);                    
            }
        }
        
        if(cmbIncomeFrnd2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbIncomeFrnd2.getItems().addAll(gen);                    
            }
        }
        
        if(cmbIncomeFrnd3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbIncomeFrnd3.getItems().addAll(gen);                    
            }
        }
        
    }

    private boolean validateFriend1() {
        boolean isValid=true;
        if(txtFrnd1.getText()==null || txtFrnd1.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend1", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd1.getValue()==null || cmbQualFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend1", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd1.getValue()==null || cmbOccupationFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend1", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd1.getValue()==null || cmbProfessionFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend1", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd1.getValue()==null || cmbIncomeFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend1", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }

    private void addFriend1ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd1.getText());
            bean.setHighestQualification(cmbQualFrnd1.getValue().toString());
          //  bean.setOccupation(cmbOccupationFrnd1.getValue().toString());
            bean.setProfession(cmbProfessionFrnd1.getValue().toString());
            bean.setIncome(cmbIncomeFrnd1.getValue().toString());        
            addToFriendsList(bean);
    }

    private boolean validateFriend2() 
    {
        boolean isValid=true;
        if(txtFrnd2.getText()==null || txtFrnd2.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend2", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd2.getValue()==null || cmbQualFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend2", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd2.getValue()==null || cmbOccupationFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend2", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd2.getValue()==null || cmbProfessionFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend2", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd2.getValue()==null || cmbIncomeFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend2", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }
    private void addFriend2ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd2.getText());
            bean.setHighestQualification(cmbQualFrnd2.getValue().toString());
            //bean.setOccupation(cmbOccupationFrnd2.getValue().toString());
            bean.setProfession(cmbProfessionFrnd2.getValue().toString());
            bean.setIncome(cmbIncomeFrnd2.getValue().toString());        
            addToFriendsList(bean);
    }

    private boolean validateFriend3() {
        boolean isValid=true;
        if(txtFrnd3.getText()==null || txtFrnd3.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_name_friend3", GlobalConstants.Lbl_Alert);
        }
        else if(cmbQualFrnd3.getValue()==null || cmbQualFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_qual_friend3", GlobalConstants.Lbl_Alert);
        }
//        else if(cmbOccupationFrnd3.getValue()==null || cmbOccupationFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
//        {
//            isValid=false;
//            UIUtils.showAlert("sc6_msg_enter_occu_friend3", GlobalConstants.Lbl_Alert);
//        }
        else if(cmbProfessionFrnd3.getValue()==null || cmbProfessionFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_prof_friend3", GlobalConstants.Lbl_Alert);
        }
        else if(cmbIncomeFrnd3.getValue()==null || cmbIncomeFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc6_msg_enter_income_friend3", GlobalConstants.Lbl_Alert);
        }
        return isValid;
    }    
    private void addFriend3ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd3.getText());
            bean.setHighestQualification(cmbQualFrnd3.getValue().toString());
          //  bean.setOccupation(cmbOccupationFrnd3.getValue().toString());
            bean.setProfession(cmbProfessionFrnd3.getValue().toString());
            bean.setIncome(cmbIncomeFrnd3.getValue().toString());        
            addToFriendsList(bean);
    }

    private void setFriendsData() 
    {
        System.out.println("friendsListForAddition="+friendsListForAddition.size());
        System.out.println("****previous friendsList="+friendsList.size());
        for(Friends f : friendsListForAddition)
        {
            addToFriendsList(f);
        }
        System.out.println("***** after friendsList="+friendsList.size());
//        if(navigator.getUserInfo().getFriendsList()==null)
//        {
            navigator.getUserInfo().setFriendsList(friendsList);
        //}
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
            previousCounter=friendsListForAddition.size();
        }
        
        previousCounter--;        
            
        Friends frnd = friendsListForAddition.get(previousCounter);
        
        String fName = frnd.getFriendName();
        String fQual = frnd.getHighestQualification();
        String fOccu = frnd.getOccupation();
        String fProfession = frnd.getProfession();
        String fIncome = frnd.getIncome();            
        
        txtFrnd3.setText(fName);
        cmbQualFrnd3.getSelectionModel().select(fQual);
        //cmbOccupationFrnd3.getSelectionModel().select(fOccu);
        cmbProfessionFrnd3.getSelectionModel().select(fProfession);
        cmbIncomeFrnd3.getSelectionModel().select(fIncome);
        
        ///////////////////////////////////////////////// frnd 2 begins///////////////////////////////////////////////
        
        previousCounter--;        
            
        frnd = friendsListForAddition.get(previousCounter);
        
        fName = frnd.getFriendName();
        fQual = frnd.getHighestQualification();
        fOccu = frnd.getOccupation();
        fProfession = frnd.getProfession();
        fIncome = frnd.getIncome();            
        
        txtFrnd2.setText(fName);
        cmbQualFrnd2.getSelectionModel().select(fQual);
        //cmbOccupationFrnd2.getSelectionModel().select(fOccu);
        cmbProfessionFrnd2.getSelectionModel().select(fProfession);
        cmbIncomeFrnd2.getSelectionModel().select(fIncome);
        
        ///////////////////////////////////////////////// frnd 2 begins///////////////////////////////////////////////
        
        previousCounter--;        
            
        frnd = friendsListForAddition.get(previousCounter);
        
        fName = frnd.getFriendName();
        fQual = frnd.getHighestQualification();
        fOccu = frnd.getOccupation();
        fProfession = frnd.getProfession();
        fIncome = frnd.getIncome();            
        
        txtFrnd1.setText(fName);
        cmbQualFrnd1.getSelectionModel().select(fQual);
        //cmbOccupationFrnd1.getSelectionModel().select(fOccu);
        cmbProfessionFrnd1.getSelectionModel().select(fProfession);
        cmbIncomeFrnd1.getSelectionModel().select(fIncome);        
    }

    private void addToFriendsListForAddition(Friends bean) {
        
        if(friendsListForAddition.contains(bean))
            {
                friendsListForAddition.remove(bean);
                friendsListForAddition.add(bean);
            }
            else
            {
                friendsListForAddition.add(bean);
            }
    }
    
    private void addToFriendsList(Friends bean) {
        
        if(friendsList.contains(bean))
            {
                friendsList.remove(bean);
                friendsList.add(bean);
            }
            else
            {
                friendsList.add(bean);
            }
    }
}
