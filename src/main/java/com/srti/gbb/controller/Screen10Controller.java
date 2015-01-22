/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.IllnessBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
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
    
    private List<String> arrayListSelfDiseases = new ArrayList<String>();
    private List<String> arrayListParentsDiseases = new ArrayList<String>();
    private List<String> arrayListGrandParentsDiseases = new ArrayList<String>();
    private List<String> arrayListSiblingsDiseases = new ArrayList<String>();
    
    
    
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
        if(!txtDiseaseAddSelf.getText().trim().equals(GlobalConstants.emptyString)
                || !txtDiseaseAddParents.getText().trim().equals(GlobalConstants.emptyString)
                || !txtDiseaseAddGrandParents.getText().trim().equals(GlobalConstants.emptyString)
                || !txtDiseaseAddSiblings.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("sc10_msg_click_on_add_btn",GlobalConstants.Lbl_Alert);
            
        }
        else
        {
        
            recordUserResponseForIllnessAndSetData();

            if(!navigator.getUserInfo().getSelfIllnessList().isEmpty())
            {
                navigator.navigateTo(ScreensFramework.Screen_Illness_Quantification);
            }
            else
            {
                //navigator.navigateTo(ScreensFramework.Screen_Hospitalization);
                navigator.navigateTo(ScreensFramework.Screen_Welcome_Prakruti_Nidaan);
            }
        }
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
        
        for(String d : arrayListSelfDiseases)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            selfIllnessList.add(e);
        }
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> plist = listParentsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> parentsIllnessList = new ArrayList<IllnessBean>();
        for(String d : plist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            parentsIllnessList.add(e);
        }
        for(String d : arrayListParentsDiseases)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            parentsIllnessList.add(e);
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> gplist = listGrandParentsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> grandParentsIllnessList = new ArrayList<IllnessBean>();
        for(String d : gplist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            grandParentsIllnessList.add(e);
        }
        for(String d : arrayListGrandParentsDiseases)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            grandParentsIllnessList.add(e);
        }
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> siblist = listSiblingsDiseases.getSelectionModel().getSelectedItems();
        List<IllnessBean> sibIllnessList = new ArrayList<IllnessBean>();
        for(String d : siblist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            sibIllnessList.add(e);
        }
        
        for(String d : arrayListSiblingsDiseases)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            sibIllnessList.add(e);
        }
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if(navigator.getUserInfo().getSelfIllnessList()==null)
//        {
            System.out.println("******selfIllnessList="+selfIllnessList);
            navigator.getUserInfo().setSelfIllnessList(selfIllnessList);
        //}
        
//        if(navigator.getUserInfo().getParentsIllnessList()==null)
//        {
            System.out.println("******parentsIllnessList="+parentsIllnessList);
            navigator.getUserInfo().setParentsIllnessList(parentsIllnessList);
        //}
        
//        if(navigator.getUserInfo().getGrandParentsIllnessList()==null)
//        {
            System.out.println("******grandParentsIllnessList="+grandParentsIllnessList);
            navigator.getUserInfo().setGrandParentsIllnessList(grandParentsIllnessList);
        //}
        
//        if(navigator.getUserInfo().getSiblingsIllnessList()==null)
//        {
            System.out.println("******sibIllnessList="+sibIllnessList);
            navigator.getUserInfo().setSiblingsIllnessList(sibIllnessList);
        //}
    }
    
    @FXML
    private TextField txtDiseaseAddSelf;
    @FXML
    private TextField txtDiseaseAddParents;
    @FXML
    private TextField txtDiseaseAddGrandParents;
    @FXML
    private TextField txtDiseaseAddSiblings;
    
    @FXML
    private void addSelfDiseaseToList()
    {
        if(txtDiseaseAddSelf.getText()==null || txtDiseaseAddSelf.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("sc10_msg_enter_self_textbox",GlobalConstants.Lbl_Alert);
        }
        else
        {
            arrayListSelfDiseases.add(txtDiseaseAddSelf.getText().trim());
            txtDiseaseAddSelf.setText(GlobalConstants.emptyString);
        }
    }
    
    @FXML
    private void addParentsDiseaseToList()
    {
        if(txtDiseaseAddParents.getText()==null || txtDiseaseAddParents.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("sc10_msg_enter_self_textbox",GlobalConstants.Lbl_Alert);
        }
        else
        {
            arrayListParentsDiseases.add(txtDiseaseAddParents.getText().trim());
            txtDiseaseAddParents.setText(GlobalConstants.emptyString);
        }
        
    }
    
    @FXML
    private void addGrandParentsDiseaseToList()
    {
        if(txtDiseaseAddGrandParents.getText()==null || txtDiseaseAddGrandParents.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("sc10_msg_enter_grand_parents_textbox",GlobalConstants.Lbl_Alert);
        }
        else
        {
            arrayListGrandParentsDiseases.add(txtDiseaseAddGrandParents.getText().trim());
            txtDiseaseAddGrandParents.setText(GlobalConstants.emptyString);
        }
        
    }
    
    @FXML
    private void addSiblingsDiseaseToList()
    {
        if(txtDiseaseAddSiblings.getText()==null || txtDiseaseAddSiblings.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("sc10_msg_enter_siblings_textbox",GlobalConstants.Lbl_Alert);
        }
        else
        {
            arrayListSiblingsDiseases.add(txtDiseaseAddSiblings.getText().trim());
            txtDiseaseAddSiblings.setText(GlobalConstants.emptyString);
        }
        
    }
    
    private Map<String,String> entertainmentMapSelf=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsSelf(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listSelfDiseases.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapSelf.containsKey(e)) 
        {
            entertainmentMapSelf.remove(e);
        }
        else
        {
            entertainmentMapSelf.put(e, e);
        }
        
        listSelfDiseases.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapSelf.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listSelfDiseases.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapParents=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsParents(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listParentsDiseases.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapParents.containsKey(e)) 
        {
            entertainmentMapParents.remove(e);
        }
        else
        {
            entertainmentMapParents.put(e, e);
        }
        
        listParentsDiseases.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapParents.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listParentsDiseases.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapGrandParents=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsGrandParents(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listGrandParentsDiseases.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapGrandParents.containsKey(e)) 
        {
            entertainmentMapGrandParents.remove(e);
        }
        else
        {
            entertainmentMapGrandParents.put(e, e);
        }
        
        listGrandParentsDiseases.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapGrandParents.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listGrandParentsDiseases.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapSiblings=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsSiblings(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listSiblingsDiseases.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapSiblings.containsKey(e)) 
        {
            entertainmentMapSiblings.remove(e);
        }
        else
        {
            entertainmentMapSiblings.put(e, e);
        }
        
        listSiblingsDiseases.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapSiblings.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listSiblingsDiseases.getSelectionModel().select(key);
        }
    }
}
