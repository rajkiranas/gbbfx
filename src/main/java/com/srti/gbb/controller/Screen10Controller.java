/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.EntertainmentBean;
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
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

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
        ObservableList<String> list = listSelfDiseases.getSelectionModel().getSelectedItems();
        List<EntertainmentBean> eList = new ArrayList<EntertainmentBean>();
        for(String d : list)
        {
            EntertainmentBean e = new EntertainmentBean();
            e.setEntertainement(d);
            eList.add(e);
        }
        
        navigator.navigateTo(ScreensFramework.screen11ID);
    }

    @FXML
    private void listSelfDiseases(ContextMenuEvent event) {
    }
    
    
}
