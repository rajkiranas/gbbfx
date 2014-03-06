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
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen10ID);
    }

    @FXML
    private void closeApplication(MouseEvent event) {
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        
        if(!txtHospAddSelf.getText().trim().equals(GlobalConstants.emptyString)
                || !txtHospAddParents.getText().trim().equals(GlobalConstants.emptyString)
                || !txtHospAddGrandParents.getText().trim().equals(GlobalConstants.emptyString)
                || !txtHospAddSiblings.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("Please click on add button to add the disease","Info");
            
        }
        else
        {
        
            recordUserResponseForIllnessAndSetData();

            //System.out.println("***"+navigator.getUserInfo().getSelfIllnessList().get(0).isIsHospitalized());
            System.out.println("***"+navigator.getUserInfo().getSelfIllnessList().size());
            navigator.navigateTo(ScreensFramework.screen11ID);
        }
        
        
    }
    
    private List<String> arrayListSelfHosp = new ArrayList<String>();
    private List<String> arrayListParentsHosp = new ArrayList<String>();
    private List<String> arrayListGrandParentsHosp = new ArrayList<String>();
    private List<String> arrayListSiblingsHosp = new ArrayList<String>();
        
    @FXML
    private TextField txtHospAddSelf;
    @FXML
    private TextField txtHospAddParents;
    @FXML
    private TextField txtHospAddGrandParents;
    @FXML
    private TextField txtHospAddSiblings;
    
    private void recordUserResponseForIllnessAndSetData() 
    {
        ObservableList<String> list = listSelfHostpitalization.getSelectionModel().getSelectedItems();
        List<IllnessBean> selfHospList = new ArrayList<IllnessBean>();
        for(String d : list)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            selfHospList.add(e);
        }
        
        for(String d : arrayListSelfHosp)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            selfHospList.add(e);
        }
        
        mergeSelfDiseaseAndHospInfo(selfHospList);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> plist = listParentsHostpitalization.getSelectionModel().getSelectedItems();
        List<IllnessBean> parentsHospList = new ArrayList<IllnessBean>();
        for(String d : plist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            parentsHospList.add(e);
        }
        for(String d : arrayListParentsHosp)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            parentsHospList.add(e);
        }
        
        mergeParentsDiseaseAndHospInfo(parentsHospList);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> gplist = listGrandParentsHostpitalization.getSelectionModel().getSelectedItems();
        List<IllnessBean> grandParentsHospList = new ArrayList<IllnessBean>();
        for(String d : gplist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            grandParentsHospList.add(e);
        }
        for(String d : arrayListGrandParentsHosp)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            grandParentsHospList.add(e);
        }
        mergeGrandParentsDiseaseAndHospInfo(grandParentsHospList);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        ObservableList<String> siblist = listSiblingsHostpitalization.getSelectionModel().getSelectedItems();
        List<IllnessBean> sibHospList = new ArrayList<IllnessBean>();
        for(String d : siblist)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            sibHospList.add(e);
        }
        
        for(String d : arrayListSiblingsHosp)
        {
            IllnessBean e = new IllnessBean();
            e.setIllness(d);
            sibHospList.add(e);
        }
        
        mergeSiblingsDiseaseAndHospInfo(sibHospList);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        if(navigator.getUserInfo().getSelfIllnessList()==null)
//        {
//            System.out.println("selfIllnessList="+selfHospList.size());
//            navigator.getUserInfo().setSelfIllnessList(selfHospList);
//        }
//        
//        if(navigator.getUserInfo().getParentsIllnessList()==null)
//        {
//            System.out.println("parentsIllnessList="+parentsHospList.size());
//            navigator.getUserInfo().setParentsIllnessList(parentsHospList);
//        }
//        
//        if(navigator.getUserInfo().getGrandParentsIllnessList()==null)
//        {
//            navigator.getUserInfo().setGrandParentsIllnessList(grandParentsHospList);
//        }
//        
//        if(navigator.getUserInfo().getSiblingsIllnessList()==null)
//        {
//            navigator.getUserInfo().setSiblingsIllnessList(sibHospList);
//        }
    }
    
    @FXML
    private void addSelfDiseaseToList()
    {
        if(txtHospAddSelf.getText()==null || txtHospAddSelf.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("Please write something in self disease textbox","Alert");
        }
        else
        {
            arrayListSelfHosp.add(txtHospAddSelf.getText().trim());
            txtHospAddSelf.setText(GlobalConstants.emptyString);
        }
    }
    
    @FXML
    private void addParentsDiseaseToList()
    {
        if(txtHospAddParents.getText()==null || txtHospAddParents.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("Please write something in parents disease textbox","Alert");
        }
        else
        {
            arrayListParentsHosp.add(txtHospAddParents.getText().trim());
            txtHospAddParents.setText(GlobalConstants.emptyString);
        }
        
    }
    
    @FXML
    private void addGrandParentsDiseaseToList()
    {
        if(txtHospAddGrandParents.getText()==null || txtHospAddGrandParents.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("Please write something in grand parents disease textbox","Alert");
        }
        else
        {
            arrayListGrandParentsHosp.add(txtHospAddGrandParents.getText().trim());
            txtHospAddGrandParents.setText(GlobalConstants.emptyString);
        }
        
    }
    
    @FXML
    private void addSiblingsDiseaseToList()
    {
        if(txtHospAddSiblings.getText()==null || txtHospAddSiblings.getText().trim().equals(GlobalConstants.emptyString))
        {
            UIUtils.showAlert("Please write something in siblings disease textbox","Alert");
        }
        else
        {
            arrayListSiblingsHosp.add(txtHospAddSiblings.getText().trim());
            txtHospAddSiblings.setText(GlobalConstants.emptyString);
        }
        
    }

    private void mergeSelfDiseaseAndHospInfo(List<IllnessBean> selfHospList) 
    {
        List<IllnessBean> selfIllList = navigator.getUserInfo().getSelfIllnessList();
        for(IllnessBean b :selfHospList)
        {
            if(selfIllList.contains(b))
            {
                System.out.println("contains****="+b.getIllness());
                b.setIsHospitalized(true);
                selfIllList.remove(b);
                selfIllList.add(b);
            }
            else
            {
                IllnessBean illness = new IllnessBean();
                illness.setIllness(b.getIllness());
                illness.setIsHospitalized(true);
                selfIllList.add(illness);                
            }
        }        
    }
    
    private void mergeParentsDiseaseAndHospInfo(List<IllnessBean> parentsHospList) 
    {
        List<IllnessBean> parentsIllList = navigator.getUserInfo().getParentsIllnessList();
        for(IllnessBean b :parentsHospList)
        {
            if(parentsIllList.contains(b))
            {
                System.out.println("contains****="+b.getIllness());
                b.setIsHospitalized(true);
                
                 parentsIllList.remove(b);
                parentsIllList.add(b);
            }
            else
            {
                IllnessBean illness = new IllnessBean();
                illness.setIllness(b.getIllness());
                illness.setIsHospitalized(true);
                parentsIllList.add(illness);
            }
        }
        
    }
    
    private void mergeGrandParentsDiseaseAndHospInfo(List<IllnessBean> selfHospList) 
    {
        List<IllnessBean> grandParentsIllList = navigator.getUserInfo().getGrandParentsIllnessList();
        for(IllnessBean b :selfHospList)
        {
            if(grandParentsIllList.contains(b))
            {
                System.out.println("contains****="+b.getIllness());
                b.setIsHospitalized(true);
                
                grandParentsIllList.remove(b);
                grandParentsIllList.add(b);
                
            }
            else
            {
                IllnessBean illness = new IllnessBean();
                illness.setIllness(b.getIllness());
                illness.setIsHospitalized(true);
                grandParentsIllList.add(illness);
            }
        }
        
    }
    
    private void mergeSiblingsDiseaseAndHospInfo(List<IllnessBean> selfHospList) 
    {
        List<IllnessBean> siblingsIllList = navigator.getUserInfo().getSiblingsIllnessList();
        for(IllnessBean b :selfHospList)
        {
            if(siblingsIllList.contains(b))
            {
                System.out.println("contains****="+b.getIllness());
                b.setIsHospitalized(true);
                
                siblingsIllList.remove(b);
                siblingsIllList.add(b);
            }
            else
            {
                IllnessBean illness = new IllnessBean();
                illness.setIllness(b.getIllness());
                illness.setIsHospitalized(true);
                siblingsIllList.add(illness);
            }
        }
        
    }
    
    
    
    private Map<String,String> entertainmentMapSelf=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsSelf(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listSelfHostpitalization.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapSelf.containsKey(e)) 
        {
            entertainmentMapSelf.remove(e);
        }
        else
        {
            entertainmentMapSelf.put(e, e);
        }
        
        listSelfHostpitalization.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapSelf.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listSelfHostpitalization.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapParents=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsParents(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listParentsHostpitalization.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapParents.containsKey(e)) 
        {
            entertainmentMapParents.remove(e);
        }
        else
        {
            entertainmentMapParents.put(e, e);
        }
        
        listParentsHostpitalization.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapParents.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listParentsHostpitalization.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapGrandParents=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsGrandParents(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listGrandParentsHostpitalization.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapGrandParents.containsKey(e)) 
        {
            entertainmentMapGrandParents.remove(e);
        }
        else
        {
            entertainmentMapGrandParents.put(e, e);
        }
        
        listGrandParentsHostpitalization.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapGrandParents.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listGrandParentsHostpitalization.getSelectionModel().select(key);
        }
    }
    
    private Map<String,String> entertainmentMapSiblings=new HashMap<String,String>();
    @FXML
    private void manageMultipleSelectionsSiblings(Event event) {
        //System.out.println("****="+listSelfDiseases.getSelectionModel().getSelectedItem().toString());
        String e = listSiblingsHostpitalization.getSelectionModel().getSelectedItem().toString();
        if (entertainmentMapSiblings.containsKey(e)) 
        {
            entertainmentMapSiblings.remove(e);
        }
        else
        {
            entertainmentMapSiblings.put(e, e);
        }
        
        listSiblingsHostpitalization.getSelectionModel().clearSelection();
        Set <String> ks = entertainmentMapSiblings.keySet();
        Iterator<String> itr = ks.iterator();
        String key = GlobalConstants.emptyString;
        while(itr.hasNext())
        {
            key = itr.next();
            listSiblingsHostpitalization.getSelectionModel().select(key);
        }
    }
}
