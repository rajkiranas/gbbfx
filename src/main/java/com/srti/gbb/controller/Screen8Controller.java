/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.EntertainmentBean;
import com.srti.gbb.bean.HobbyBean;
import com.srti.gbb.bean.TravelingBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen8Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    private List<HobbyBean> listForHobbyAddition=new ArrayList<HobbyBean>();
    private Map<String,String> entertainmentMap=new HashMap<String,String>();
    
    @FXML
    private Color x1;

    @FXML
    private ListView entertainmentList;
    @FXML
    private TextField txtHobby;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideShowPreviousLink();
        populateLocalTravels();
        populateNationalTravels();
        populateInternationalTravels();
        populateHobbyAndParams();
        populateEntertainmentList();
    }    

    @FXML
    private void goToScreen7(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen7ID);
    }
    
    @FXML
    private void manageMultipleSelections(Event event) {
        //System.out.println("****="+entertainmentList.getSelectionModel().getSelectedItem().toString());
        String e = entertainmentList.getSelectionModel().getSelectedItem().toString();
        if(e.equals(MU.getMsg(GlobalConstants.None)))
        {
            entertainmentMap.clear();
            entertainmentMap.put(e, e);
        }
        else
        {
            if (entertainmentMap.containsKey(e)) 
            {
                entertainmentMap.remove(e);
            }
            else
            {
                entertainmentMap.put(e, e);
            }

            if(entertainmentMap.containsKey(MU.getMsg(GlobalConstants.None)))
            {
                entertainmentMap.remove(MU.getMsg(GlobalConstants.None));
            }
        }
        
        entertainmentList.getSelectionModel().clearSelection();
            Set <String> ks = entertainmentMap.keySet();
            Iterator<String> itr = ks.iterator();
            String key = GlobalConstants.emptyString;
            while(itr.hasNext())
            {
                key = itr.next();
                entertainmentList.getSelectionModel().select(key);
            }
    }

    @FXML
    private void goToScreen9(ActionEvent event) 
    {
        if(cmbHobby.getValue()!=null || cmbHobbyHoursPerWeek.getValue()!=null)
        {
            if(validateTravelsForm() && validateHobby() && !isEntertainmentListEmpty())
            {
                addHobbyToList();
                setTravelingData();
                setHobyData();
                setEntertainmentData();
                navigateToNextScreen();
            }
        }
        else if(validateTravelsForm() && !isEntertainmentListEmpty())
        {
            if(!listForHobbyAddition.isEmpty())
            {
                setTravelingData();
                setHobyData();
                setEntertainmentData();
                navigateToNextScreen();
            }
            else
            {
                UIUtils.showAlert("sc8_msg_enter_atleast_one_hobby", GlobalConstants.Lbl_Alert);
            }
        }
    }
    private boolean isEntertainmentListEmpty()
    {
        boolean isEmpty=entertainmentList.getSelectionModel().isEmpty();
        if(isEmpty)
            UIUtils.showAlert("sc8_msg_enter_ent", GlobalConstants.Lbl_Alert);
        return isEmpty;
    }
    
    private boolean validateTravelsForm() 
    {
        boolean isValid = true;
         if(cmbLocalInd.getValue()==null || cmbLocalInd.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_indv_local", GlobalConstants.Lbl_Alert);
        }
         else if(cmbNationalInd.getValue()==null || cmbNationalInd.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_indv_national", GlobalConstants.Lbl_Alert);
        }
         else if(cmbInternationalInd.getValue()==null || cmbInternationalInd.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_indv_international", GlobalConstants.Lbl_Alert);
        }
         else if(cmbLocalFamily.getValue()==null || cmbLocalFamily.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_family_local", GlobalConstants.Lbl_Alert);
        }
         else if(cmbNationalFamily.getValue()==null || cmbNationalFamily.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_family_national", GlobalConstants.Lbl_Alert);
        }
         else if(cmbInternationalFamily.getValue()==null || cmbInternationalFamily.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_family_international", GlobalConstants.Lbl_Alert);
        }
         else if(cmbLocalFriends.getValue()==null || cmbLocalFriends.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_friends_local", GlobalConstants.Lbl_Alert);
        }
         else if(cmbNationalFriends.getValue()==null || cmbNationalFriends.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_friends_national", GlobalConstants.Lbl_Alert);
        }
         else if(cmbInternationalFriends.getValue()==null || cmbInternationalFriends.getValue().toString().equals(GlobalConstants.emptyString))
        {
            isValid=false;
            UIUtils.showAlert("sc8_msg_sel_friends_international", GlobalConstants.Lbl_Alert);
        }
         return isValid;
    }
    
     private boolean validateHobby() 
    {
        boolean isValid = true;
        
        if(cmbHobby.getValue()!=null && cmbHobby.getValue().toString().equals(MU.getMsg(GlobalConstants.None)))
        {
            isValid=true;
        }
        else if((cmbHobby.getValue()==null || cmbHobby.getValue().toString().equals(GlobalConstants.emptyString))  && (txtHobby.getText() ==null || txtHobby.getText().trim().equals(GlobalConstants.emptyString)) )
           {
               isValid=false;
               UIUtils.showAlert("sc8_msg_sel_or_enter_hobby", GlobalConstants.Lbl_Alert);
           }
            else if ((cmbHobby.getValue() != null) && (!txtHobby.getText().trim().equals(GlobalConstants.emptyString))) 
            {
               UIUtils.showAlert("sc8_msg_either_sel_or_enter_hobby", GlobalConstants.Lbl_Alert);
               isValid = false;
           }
            else if(cmbHobbyHoursPerWeek.getValue()==null || cmbHobbyHoursPerWeek.getValue().toString().equals(GlobalConstants.emptyString))
           {
               isValid=false;
               UIUtils.showAlert("sc8_msg_sel_time_for_hobby", GlobalConstants.Lbl_Alert);
           }
        
         return isValid;
    }
     
     @FXML
     private void addHobbyToList()
     {
         //!txtHobby.isDisabled() && !cmbHobbyHoursPerWeek.isDisabled() is for None hobby
         if(validateHobby() && !txtHobby.isDisabled() && !cmbHobbyHoursPerWeek.isDisabled())
         {
             HobbyBean h = new HobbyBean();
             if(cmbHobby.getValue()!=null)
            {
                h.setHobby(cmbHobby.getValue().toString());
            }
             else
             {
                 h.setHobby(txtHobby.getText().trim());
             }
             //h.setHobby(cmbHobby.getValue().toString());
             h.setHobbyHoursPerWeek(Float.parseFloat(cmbHobbyHoursPerWeek.getValue().toString()));
             
             if(listForHobbyAddition.contains(h))
             {
                 listForHobbyAddition.remove(h);
                listForHobbyAddition.add(h);
             }
             else
             {
                 listForHobbyAddition.add(h);
             }
             clearHobbySelection();
             showPreviousLink();
             removeNoneOptionFromList();
         }
     }
     private void clearHobbySelection()
     {
         cmbHobby.getSelectionModel().clearSelection();
         txtHobby.setText(GlobalConstants.emptyString);
         cmbHobbyHoursPerWeek.getSelectionModel().clearSelection();
     }
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    private void populateEntertainmentList() {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Entertainment_List);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(entertainmentList.getItems().size()==0)
        {
            for(String gen : list)
            {
                
                    entertainmentList.getItems().addAll(gen);                    
            }
        }
        
        
//        ObservableList<String> names = FXCollections.observableArrayList(
//          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
//        
//        names.add(null);
//                
//        entertainmentList.setItems(names);
        entertainmentList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        //entertainmentList.getSelectionModel().getSelectedItems();
    }

    @FXML
    private ComboBox cmbLocalInd;
    
    @FXML
    private ComboBox cmbLocalFamily;
    
    @FXML
    private ComboBox cmbLocalFriends;
    
    
    private void populateLocalTravels() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Traveling_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbLocalInd.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbLocalInd.getItems().addAll(gen);                    
            }
        }
        
        if(cmbLocalFamily.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbLocalFamily.getItems().addAll(gen);                    
            }
        }
        
        if(cmbLocalFriends.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbLocalFriends.getItems().addAll(gen);                    
            }
        }
        
    }
    
    @FXML
    private ComboBox cmbNationalInd;
    
    @FXML
    private ComboBox cmbNationalFamily;
    
    @FXML
    private ComboBox cmbNationalFriends;
    
    
    private void populateNationalTravels() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Traveling_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbNationalInd.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbNationalInd.getItems().addAll(gen);                    
            }
        }
        
        if(cmbNationalFamily.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbNationalFamily.getItems().addAll(gen);                    
            }
        }
        
        if(cmbNationalFriends.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbNationalFriends.getItems().addAll(gen);                    
            }
        }
        
    }
    
        @FXML
    private ComboBox cmbInternationalInd;
    
    @FXML
    private ComboBox cmbInternationalFamily;
    
    @FXML
    private ComboBox cmbInternationalFriends;
    
    
    private void populateInternationalTravels() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Traveling_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbInternationalInd.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbInternationalInd.getItems().addAll(gen);                    
            }
        }
        
        if(cmbInternationalFamily.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbInternationalFamily.getItems().addAll(gen);                    
            }
        }
        
        if(cmbInternationalFriends.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbInternationalFriends.getItems().addAll(gen);                    
            }
        }
        
    }
    
    @FXML
    private ComboBox cmbHobby;
    
    @FXML
    private ComboBox cmbHobbyHoursPerWeek;
    
   
    private List<String> listOfHobbiesForShowPrevious=new ArrayList<String>();
    
    
    private void populateHobbyAndParams() 
    {
        
        String strHobbyList = GlobalConstants.getProperty(GlobalConstants.Hobby_Options);
        String[] list =  strHobbyList.split(GlobalConstants.COMMA);
        
        if(cmbHobby.getItems().size()==0)
        {
            for(String hobby : list)
            {
                    cmbHobby.getItems().addAll(hobby); 
                    
                   
            }
        }
        
        if(listOfHobbiesForShowPrevious.isEmpty())
        {
            listOfHobbiesForShowPrevious.addAll(Arrays.asList(list));
        }
        
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        String[] list1 =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbHobbyHoursPerWeek.getItems().size()==0)
        {
            for(String gen : list1)
            {
                    cmbHobbyHoursPerWeek.getItems().addAll(gen); 
                    cmbHobbyHoursPerWeek.getItems().addAll(gen+".30"); 
            }
        }
    }

    private void setTravelingData() {
        TravelingBean tra = new TravelingBean();
        tra.setLocalIndividual(Integer.parseInt(cmbLocalInd.getValue().toString()));
        tra.setLocalFamily(Integer.parseInt(cmbLocalFamily.getValue().toString()));
        tra.setLocalFriends(Integer.parseInt(cmbLocalFriends.getValue().toString()));
        
        tra.setNationalIndividual(Integer.parseInt(cmbNationalInd.getValue().toString()));
        tra.setNationalFamily(Integer.parseInt(cmbNationalFamily.getValue().toString()));
        tra.setNationalFriends(Integer.parseInt(cmbNationalFriends.getValue().toString()));
        
        tra.setInternationalIndividual(Integer.parseInt(cmbInternationalInd.getValue().toString()));
        tra.setInternationalFamily(Integer.parseInt(cmbInternationalFamily.getValue().toString()));
        tra.setInternationalFriends(Integer.parseInt(cmbInternationalFriends.getValue().toString()));
        
//        if(navigator.getUserInfo().getTraveling()==null)
//        {
        System.out.println("****tra="+tra);
            navigator.getUserInfo().setTraveling(tra);
//        }
        
    }

    private void setHobyData() {
//        if(navigator.getUserInfo().getHobbyList()==null)
//        {
            System.out.println("****listForHobbyAddition="+listForHobbyAddition);
            navigator.getUserInfo().setHobbyList(listForHobbyAddition);            
        //}
    }

    private void setEntertainmentData() {
        ObservableList<String> l = entertainmentList.getSelectionModel().getSelectedItems();
        List<EntertainmentBean> eList = new ArrayList<EntertainmentBean>();
        for(String s : l)
        {
            if(!s.equals(MU.getMsg(GlobalConstants.None)))
            {
                EntertainmentBean e = new EntertainmentBean();
                e.setEntertainement(s);
                if(!eList.contains(e))
                {
                    eList.add(e);
                }
            }
        }
//        if(navigator.getUserInfo().getEducationList()==null)
//        {
        if(!eList.isEmpty())
        {
            System.out.println("entmt List="+eList.size());
            navigator.getUserInfo().setEntertainmentList(eList);
        }
        //}
    }
  

    
    private int previousCounter=0;
    
    @FXML
    private void showPrevious()
    {
        
        if(previousCounter==0)
        {
            previousCounter=listForHobbyAddition.size()-1;
        }
        else
        {
            previousCounter--;
        }
            HobbyBean v = listForHobbyAddition.get(previousCounter);
            String hobby = v.getHobby();
            float hoursPerWeek = v.getHobbyHoursPerWeek();
            if(listOfHobbiesForShowPrevious.contains(hobby))
            {
                cmbHobby.getSelectionModel().select(hobby);
                txtHobby.setText(GlobalConstants.emptyString);
            }
            else
            {
                txtHobby.setText(hobby);
                cmbHobby.getSelectionModel().clearSelection();
            }
            cmbHobbyHoursPerWeek.getSelectionModel().select(String.valueOf(hoursPerWeek));
    }
    
    
    @FXML
    Hyperlink linkShowPrevious;
    
    private void hideShowPreviousLink() {
        linkShowPrevious.setVisible(false);
    }
    
    private void showPreviousLink() {
        linkShowPrevious.setVisible(true);
    }
    
    @FXML
    private void chkForNoneHobby()
    {
        //below null check is necessary to block when selection is cleared
        if(cmbHobby.getValue()!=null)
        {
            String hobbySelection = cmbHobby.getValue().toString();
            if(hobbySelection.equalsIgnoreCase(MU.getMsg(GlobalConstants.None)))
            {
                lockHobbyInputs();
            }
            else
            {
                enableHobbyInputs();
            }
        }
    }

    @FXML
    private Button btnAddHobby;
    
    private void lockHobbyInputs() {
        txtHobby.setDisable(true);
        cmbHobbyHoursPerWeek.setDisable(true);
        btnAddHobby.setDisable(true);
    }

    private void enableHobbyInputs() {
        txtHobby.setDisable(false);
        cmbHobbyHoursPerWeek.setDisable(false);
        btnAddHobby.setDisable(false);
    }

    private void removeNoneOptionFromList() {
        cmbHobby.getItems().remove(MU.getMsg(GlobalConstants.None));
    }

    private void navigateToNextScreen() {
        navigator.navigateTo(ScreensFramework.screen15ID);
    }
}
