/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen13Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @FXML
    private ListView listSelfHostpitalization;
    
    @FXML
    private ListView listParentsHostpitalization;
    
    @FXML
    private ListView listGrandParentsHostpitalization;
    
    @FXML
    private ListView listSiblingsHostpitalization;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateSelfDiseaseList();
    }
    
    private void populateSelfDiseaseList() {
        
        String diseaseList = GlobalConstants.getProperty(GlobalConstants.Lbl_Disease_Options);
        String[] list =  diseaseList.split(GlobalConstants.COMMA);
        
        if(listSelfHostpitalization.getItems().size()==0)
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

                listSelfHostpitalization.getItems().addAll(d);                    
            }
        }
        listSelfHostpitalization.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listParentsHostpitalization.getItems().size()==0)
        {
            for(String d : list)
            {
                listParentsHostpitalization.getItems().addAll(d);                    
            }
        }
        listParentsHostpitalization.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listGrandParentsHostpitalization.getItems().size()==0)
        {
            for(String d : list)
            {
                listGrandParentsHostpitalization.getItems().addAll(d);                    
            }
        }
        listGrandParentsHostpitalization.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        if(listSiblingsHostpitalization.getItems().size()==0)
        {
            for(String d : list)
            {
                listSiblingsHostpitalization.getItems().addAll(d);                    
            }
        }
        listSiblingsHostpitalization.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    
    

    @FXML
    private void listSelfDiseases(ContextMenuEvent event) {
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen10ID);
    }

    @FXML
    private void closeApplication(MouseEvent event) {
    }
}
