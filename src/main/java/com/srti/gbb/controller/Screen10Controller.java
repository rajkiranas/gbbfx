/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.IllnessBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen10Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @FXML
    private ListView listSelfDiseases;
    
    @FXML
    private ListView listParentsDiseases;
    
    @FXML
    private ListView listGrandParentsDiseases;
    
    @FXML
    private ListView listSiblingsDiseases;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateSelfDiseaseList();
    }    
    
    private void populateSelfDiseaseList() {
        
        String diseaseList = GlobalConstants.getProperty(GlobalConstants.Lbl_Disease_Options);
        String[] list =  diseaseList.split(GlobalConstants.COMMA);
        
        if(listSelfDiseases.getItems().size()==0)
        {
            for(String d : list)
            {
                
//                GridPane gridpane = new GridPane();
//                ColumnConstraints column1 = new ColumnConstraints();
//                column1.setPercentWidth(80);
//                column1.setHgrow(Priority.ALWAYS);
//                
//                
//                ColumnConstraints column2 = new ColumnConstraints();
//                column2.setPercentWidth(20);
//                gridpane.getColumnConstraints().addAll(column1,column2);
//     
//                gridpane.add(new Label(d),0,0);
//                gridpane.add(new CheckBox(),1,0);     

                listSelfDiseases.getItems().addAll(d);                    
            }
        }
        listSelfDiseases.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listParentsDiseases.getItems().size()==0)
        {
            for(String d : list)
            {
                listParentsDiseases.getItems().addAll(d);                    
            }
        }
        listParentsDiseases.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listGrandParentsDiseases.getItems().size()==0)
        {
            for(String d : list)
            {
                listGrandParentsDiseases.getItems().addAll(d);                    
            }
        }
        listGrandParentsDiseases.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listSiblingsDiseases.getItems().size()==0)
        {
            for(String d : list)
            {
                listSiblingsDiseases.getItems().addAll(d);                    
            }
        }
        listSiblingsDiseases.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void goToScreen10(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen9ID);
    }

    @FXML
    private void goToScreen12(ActionEvent event) 
    {
        recordUserResponseForIllnessAndSetData();
        
        navigator.navigateTo(ScreensFramework.screen13ID);
    }

    @FXML
    private void listSelfDiseases(ContextMenuEvent event) {
    }

    private void recordUserResponseForIllnessAndSetData() 
    {
        ObservableList<String> list = listSelfDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> selfIllnessList = new ArrayList<IllnessBean>();
        for(String d : list)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            selfIllnessList.add(e);
        }
        
        ObservableList<String> plist = listParentsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> parentsIllnessList = new ArrayList<IllnessBean>();
        for(String d : plist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            parentsIllnessList.add(e);
        }
        
        ObservableList<String> gplist = listGrandParentsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> grandParentsIllnessList = new ArrayList<IllnessBean>();
        for(String d : gplist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            grandParentsIllnessList.add(e);
        }
        
        ObservableList<String> siblist = listSiblingsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> sibIllnessList = new ArrayList<IllnessBean>();
        for(String d : siblist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            sibIllnessList.add(e);
        }
        
        if(navigator.getUserInfo().getSelfIllnessList()==null)
        {
            navigator.getUserInfo().setSelfIllnessList(selfIllnessList);
        }
        
        if(navigator.getUserInfo().getParentsIllnessList()==null)
        {
            navigator.getUserInfo().setParentsIllnessList(parentsIllnessList);
        }
        
        if(navigator.getUserInfo().getGrandParentsIllnessList()==null)
        {
            navigator.getUserInfo().setGrandParentsIllnessList(grandParentsIllnessList);
        }
        
        if(navigator.getUserInfo().getSiblingsIllnessList()==null)
        {
            navigator.getUserInfo().setSiblingsIllnessList(sibIllnessList);
        }        
    }
}
