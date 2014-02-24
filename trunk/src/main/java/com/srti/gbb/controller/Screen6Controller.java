/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.Friends;
import com.srti.gbb.controller.ControlledScreen;
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
        populateHighestQualification();
        populateOccupation();
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
        
        if(!txtFrnd1.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd1.getValue()==null ||
                cmbOccupationFrnd1.getValue()==null ||
                cmbProfessionFrnd1.getValue()==null ||
                cmbIncomeFrnd1.getValue()==null)
        {
            if(validateFriend1())
            {
                addFriend1ToList();
                
            }
            
        }
        
        if(!txtFrnd2.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd2.getValue()==null ||
                cmbOccupationFrnd2.getValue()==null ||
                cmbProfessionFrnd2.getValue()==null ||
                cmbIncomeFrnd2.getValue()==null)
        {
            if(validateFriend2())
            {
                addFriend2ToList();
                
            }
            
        }
        
        if(!txtFrnd3.getText().equals(GlobalConstants.emptyString) ||
             cmbQualFrnd3.getValue()==null ||
                cmbOccupationFrnd3.getValue()==null ||
                cmbProfessionFrnd3.getValue()==null ||
                cmbIncomeFrnd3.getValue()==null)
        {
            if(validateFriend3())
            {
                addFriend3ToList();
                
            }
            
        }
        setFriendsData();
        //navigator.navigateTo(ScreensFramework.screen7ID);
    }

    @FXML
    private void addFriendsToList(ActionEvent event) 
    {
        if(validateFriendsForm())
        {
        
            Friends bean = new Friends();
            bean.setFriendName(txtFrnd1.getText());
            bean.setHighestQualification(cmbQualFrnd1.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd1.getValue().toString());
            bean.setProfession(cmbProfessionFrnd1.getValue().toString());
            bean.setIncome(cmbIncomeFrnd1.getValue().toString());        
            friendsListForAddition.add(bean);
            
            bean = new Friends();
            bean.setFriendName(txtFrnd2.getText());
            bean.setHighestQualification(cmbQualFrnd2.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd2.getValue().toString());
            bean.setProfession(cmbProfessionFrnd2.getValue().toString());
            bean.setIncome(cmbIncomeFrnd2.getValue().toString());        
            friendsListForAddition.add(bean);
            
            bean = new Friends();
            bean.setFriendName(txtFrnd3.getText());
            bean.setHighestQualification(cmbQualFrnd3.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd3.getValue().toString());
            bean.setProfession(cmbProfessionFrnd3.getValue().toString());
            bean.setIncome(cmbIncomeFrnd3.getValue().toString());        
            friendsListForAddition.add(bean);
            
            clearFriendsForm();
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
        cmbOccupationFrnd1.getSelectionModel().clearSelection();
        cmbProfessionFrnd1.getSelectionModel().clearSelection();
        cmbIncomeFrnd1.getSelectionModel().clearSelection();
        
        txtFrnd2.clear();
        cmbQualFrnd2.getSelectionModel().clearSelection();
        cmbOccupationFrnd2.getSelectionModel().clearSelection();
        cmbProfessionFrnd2.getSelectionModel().clearSelection();
        cmbIncomeFrnd2.getSelectionModel().clearSelection();
        
        txtFrnd3.clear();
        cmbQualFrnd3.getSelectionModel().clearSelection();
        cmbOccupationFrnd3.getSelectionModel().clearSelection();
        cmbProfessionFrnd3.getSelectionModel().clearSelection();
        cmbIncomeFrnd3.getSelectionModel().clearSelection();
        
    }
    
    private boolean validateFriendsForm() {
        boolean isValid=true;
        if(txtFrnd1.getText()==null || txtFrnd1.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please enter name of friend1", "Alert");
        }
        else if(cmbQualFrnd1.getValue()==null || cmbQualFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend1", "Alert");
        }
        else if(cmbOccupationFrnd1.getValue()==null || cmbOccupationFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend1", "Alert");
        }
        else if(cmbProfessionFrnd1.getValue()==null || cmbProfessionFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend1", "Alert");
        }
        else if(cmbIncomeFrnd1.getValue()==null || cmbIncomeFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend1", "Alert");
        }
        else if(txtFrnd2.getText()==null || txtFrnd2.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please enter name of friend2", "Alert");
        }
        else if(cmbQualFrnd2.getValue()==null || cmbQualFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend2", "Alert");
        }
        else if(cmbOccupationFrnd2.getValue()==null || cmbOccupationFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend2", "Alert");
        }
        else if(cmbProfessionFrnd2.getValue()==null || cmbProfessionFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend2", "Alert");
        }
        else if(cmbIncomeFrnd2.getValue()==null || cmbIncomeFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend2", "Alert");
        }
        else if(txtFrnd3.getText()==null || txtFrnd3.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please enter name of friend3", "Alert");
        }
        else if(cmbQualFrnd3.getValue()==null || cmbQualFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend3", "Alert");
        }
        else if(cmbOccupationFrnd3.getValue()==null || cmbOccupationFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend3", "Alert");
        }
        else if(cmbProfessionFrnd3.getValue()==null || cmbProfessionFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend3", "Alert");
        }
        else if(cmbIncomeFrnd3.getValue()==null || cmbIncomeFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend3", "Alert");
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
    
    
    @FXML
    private ComboBox cmbOccupationFrnd1;
    
    @FXML
    private ComboBox cmbOccupationFrnd2;
    
    @FXML
    private ComboBox cmbOccupationFrnd3;

    private void populateOccupation() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Occupation_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbOccupationFrnd1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbOccupationFrnd1.getItems().addAll(gen);                    
            }
        }
        
        if(cmbOccupationFrnd2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbOccupationFrnd2.getItems().addAll(gen);                    
            }
        }
        
        if(cmbOccupationFrnd3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbOccupationFrnd3.getItems().addAll(gen);                    
            }
        }
        
        
    }

    
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
            UIUtils.showAlert("Please enter name of friend1", "Alert");
        }
        else if(cmbQualFrnd1.getValue()==null || cmbQualFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend1", "Alert");
        }
        else if(cmbOccupationFrnd1.getValue()==null || cmbOccupationFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend1", "Alert");
        }
        else if(cmbProfessionFrnd1.getValue()==null || cmbProfessionFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend1", "Alert");
        }
        else if(cmbIncomeFrnd1.getValue()==null || cmbIncomeFrnd1.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend1", "Alert");
        }
        return isValid;
    }

    private void addFriend1ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd1.getText());
            bean.setHighestQualification(cmbQualFrnd1.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd1.getValue().toString());
            bean.setProfession(cmbProfessionFrnd1.getValue().toString());
            bean.setIncome(cmbIncomeFrnd1.getValue().toString());        
            friendsList.add(bean);
    }

    private boolean validateFriend2() 
    {
        boolean isValid=true;
        if(txtFrnd2.getText()==null || txtFrnd2.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please enter name of friend2", "Alert");
        }
        else if(cmbQualFrnd2.getValue()==null || cmbQualFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend2", "Alert");
        }
        else if(cmbOccupationFrnd2.getValue()==null || cmbOccupationFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend2", "Alert");
        }
        else if(cmbProfessionFrnd2.getValue()==null || cmbProfessionFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend2", "Alert");
        }
        else if(cmbIncomeFrnd2.getValue()==null || cmbIncomeFrnd2.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend2", "Alert");
        }
        return isValid;
    }
    private void addFriend2ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd2.getText());
            bean.setHighestQualification(cmbQualFrnd2.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd2.getValue().toString());
            bean.setProfession(cmbProfessionFrnd2.getValue().toString());
            bean.setIncome(cmbIncomeFrnd2.getValue().toString());        
            friendsList.add(bean);
    }

    private boolean validateFriend3() {
        boolean isValid=true;
        if(txtFrnd3.getText()==null || txtFrnd3.getText().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please enter name of friend3", "Alert");
        }
        else if(cmbQualFrnd3.getValue()==null || cmbQualFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select qualification of friend3", "Alert");
        }
        else if(cmbOccupationFrnd3.getValue()==null || cmbOccupationFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select occupation of friend3", "Alert");
        }
        else if(cmbProfessionFrnd3.getValue()==null || cmbProfessionFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select profession of friend3", "Alert");
        }
        else if(cmbIncomeFrnd3.getValue()==null || cmbIncomeFrnd3.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("Please select income of friend3", "Alert");
        }
        return isValid;
    }
    private void addFriend3ToList() {
        Friends bean = new Friends();
            bean.setFriendName(txtFrnd3.getText());
            bean.setHighestQualification(cmbQualFrnd3.getValue().toString());
            bean.setOccupation(cmbOccupationFrnd3.getValue().toString());
            bean.setProfession(cmbProfessionFrnd3.getValue().toString());
            bean.setIncome(cmbIncomeFrnd3.getValue().toString());        
            friendsList.add(bean);
    }

    private void setFriendsData() 
    {
        System.out.println("friendsListForAddition="+friendsListForAddition.size());
        System.out.println("friendsList="+friendsList.size());
        for(Friends f : friendsListForAddition)
        {
            friendsList.add(f);
        }
        System.out.println("friendsList="+friendsList.size());
        if(navigator.getUserInfo().getFriendsList()==null)
        {
            navigator.getUserInfo().setFriendsList(friendsList);
        }
        
    }
}
