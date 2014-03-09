/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.PropertyBean;
import com.srti.gbb.bean.VehicleBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen9Controller implements Initializable, ControlledScreen  {
    
    private ScreensNavigator navigator;
    private List<VehicleBean> vehicleList=new ArrayList<VehicleBean>();
    private List<PropertyBean> propertyList=new ArrayList<PropertyBean>();;
    
    @FXML
    private Color x1;
    @FXML
    private CheckBox chkHouseOwned;
    @FXML
    private CheckBox chkHouseRented;
    @FXML
    private CheckBox chkLandOwned;
    @FXML
    private CheckBox chkLandRented;
    @FXML
    private TextField txtLandApproxArea;
    @FXML
    private TextField txtLandMembers;
    @FXML
    private TextField txtLandLoan;
    @FXML
    private TextField txtHouseLoan;
    @FXML
    private TextField txtHouseApproxArea;
    @FXML
    private TextField txtHouseMembers;
    @FXML
    private ComboBox cmbVehicleType;
    @FXML
    private TextField txtVehicleNumbers;
    @FXML
    private Button btnAddVehicle;
    
    @FXML
    private Label lblHouse;
    
    @FXML
    private Label lblLand;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hidePreviousButton();
        populateVehicleTypes();
    }
    
    @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    private void populateVehicleTypes() 
    {
        
        String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Vehicle_Type_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        
        if(cmbVehicleType.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbVehicleType.getItems().addAll(gen);                    
            }
        }        
    }
    
    @FXML
    private void goToScreen8(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen8ID);
    }

    @FXML
    private void goToScreen10(ActionEvent event) 
    {
        if(cmbVehicleType.getValue()!=null || !txtVehicleNumbers.getText().trim().equals(GlobalConstants.emptyString))
        {
            if(validateVehicleForm())
            {
                if(validateHouseForm())
                {
                    if(!chkLandOwned.isSelected() && !chkLandRented.isSelected())
                    {
                        addVehicleToList();
                        addHouseToList();

                        setPropertyData();
                        setVehicleData();
                        navigateToNextScreen();
                        
                    }
                    else
                    {
                        if(validateLandForm())
                        {
                            addVehicleToList();
                            addHouseToList();
                            addLandToList();

                            setPropertyData();
                            setVehicleData();
                            navigateToNextScreen();
                        }
                        
                    }
                    
                }
            }            
        }
        else if(!vehicleList.isEmpty())
        {
            if(validateHouseForm())
            {
                if(!chkLandOwned.isSelected() && !chkLandRented.isSelected())
                {
                    addHouseToList();

                    setPropertyData();
                    setVehicleData();
                    navigateToNextScreen();
                }
                else
                {
                    if (validateLandForm()) 
                    {
                        //addVehicleToList();
                        addHouseToList();
                        addLandToList();

                        setPropertyData();
                        setVehicleData();
                        navigateToNextScreen();
                    }
                    
                }
            }
            
        }        
        else
        {
            UIUtils.showAlert("Please enter atleast one vehicle information", "Alert"); 
        }
   }

    @FXML
    private void addVehiclesToList(ActionEvent event) 
    {
        if(validateVehicleForm())
        {
            addVehicleToList();
        }
    }

    private void clearVehicleForm() {
        cmbVehicleType.getSelectionModel().clearSelection();
        txtVehicleNumbers.setText(GlobalConstants.emptyString);
    }

    private boolean validateVehicleForm() {
        boolean isValid=true;
         if(cmbVehicleType.getValue()==null || cmbVehicleType.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select vehicle type", "Alert"); 
             isValid=false;
         }
         
         else if(txtVehicleNumbers.getText() ==null || txtVehicleNumbers.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter number of vehicles", "Alert"); 
             isValid=false;
         }
         else if(txtVehicleNumbers.getText() ==null || txtVehicleNumbers.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter number of vehicles", "Alert"); 
             isValid=false;
         }         
         
         else if(!GbbValidator.isValidNumber(txtVehicleNumbers.getText()))
         {
              UIUtils.showAlert("Please enter valid number of vehicles", "Alert");  
    
             isValid=false;
         }
         
         return isValid;
    }

    private boolean validateHouseForm() {
        boolean isValid=true;
         if(!chkHouseOwned.isSelected() && !chkHouseRented.isSelected() )
         {
             UIUtils.showAlert("Please select atlease one house type", "Alert"); 
             isValid=false;
         }         
         else if(txtHouseApproxArea.getText() ==null || txtHouseApproxArea.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter approximate house area", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtHouseApproxArea.getText()))
         {
              UIUtils.showAlert("Please enter valid house area", "Alert");  
             isValid=false;
         }
         else if(txtHouseMembers.getText() ==null || txtHouseMembers.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter members in house", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtHouseApproxArea.getText()))
         {
              UIUtils.showAlert("Please enter valid members in house", "Alert");  
             isValid=false;
         }
         else if(txtHouseLoan.getText() ==null || txtHouseLoan.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter house loan", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtHouseLoan.getText()))
         {
             UIUtils.showAlert("Please enter valid house loan", "Alert");  
             isValid=false;
         }
         
         return isValid;
    }

    private boolean validateLandForm() {
        boolean isValid=true;
         if(txtLandApproxArea.getText() ==null || txtLandApproxArea.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter approximate land area", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtLandApproxArea.getText()))
         {
              UIUtils.showAlert("Please enter valid land area", "Alert");  
             isValid=false;
         }
         else if(txtLandMembers.getText() ==null || txtLandMembers.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter members in land", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtLandApproxArea.getText()))
         {
              UIUtils.showAlert("Please enter valid members in land", "Alert");  
             isValid=false;
         }
         else if(txtLandLoan.getText() ==null || txtLandLoan.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please enter land loan", "Alert"); 
             isValid=false;
         }         
         else if(!GbbValidator.isValidNumber(txtLandLoan.getText()))
         {
             UIUtils.showAlert("Please enter valid land loan", "Alert");  
             isValid=false;
         }
         
         return isValid;
    }

    private void addVehicleToList() {
        VehicleBean v = new VehicleBean();
        v.setVehicleType(cmbVehicleType.getValue().toString());
        v.setNumberOfVehicles(Integer.parseInt(txtVehicleNumbers.getText()));
        if(vehicleList.contains(v))
        {
            vehicleList.remove(v);
            vehicleList.add(v);
        }
        else
        {
            vehicleList.add(v);
        }
        clearVehicleForm();
        showPreviousButton();
    }

    private void addHouseToList() {
        PropertyBean house = new PropertyBean();
                house.setPropertyType(lblHouse.getText());
                house.setIsOwned(chkHouseOwned.isSelected());
                house.setIsRented(chkHouseRented.isSelected());
                house.setApproxArea(Integer.parseInt(txtHouseApproxArea.getText()));
                house.setMembersInHouse(Integer.parseInt(txtHouseMembers.getText()));
                house.setOutstandingLoan(Integer.parseInt(txtHouseLoan.getText()));
                propertyList.add(house);
    }

    private void addLandToList() {
        PropertyBean land = new PropertyBean();
                        land.setPropertyType(lblLand.getText());
                        land.setIsOwned(chkLandOwned.isSelected());
                        land.setIsRented(chkLandRented.isSelected());
                        land.setApproxArea(Integer.parseInt(txtLandApproxArea.getText()));
                        land.setMembersInHouse(Integer.parseInt(txtLandMembers.getText()));
                        land.setOutstandingLoan(Integer.parseInt(txtLandLoan.getText()));
                        propertyList.add(land);
    }

    private void setVehicleData() 
    {
//        if(navigator.getUserInfo().getVehicleList()==null)
//        {
            System.out.println("***vehicleList="+vehicleList);
            navigator.getUserInfo().setVehicleList(vehicleList);
        //}
    }

    private void setPropertyData() {
//        if(navigator.getUserInfo().getPropertyList()==null)
//        {
            System.out.println("***propertyList="+propertyList);
            navigator.getUserInfo().setPropertyList(propertyList);
        //}
    }

    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.screen10ID);
    }
    
//    @FXML
//    private void showVehicleInfoInPopup()
//    {
//        TableView table = new TableView();
//        //table.setEditable(true);
// 
//        TableColumn firstNameCol = new TableColumn("First Name");
//        TableColumn lastNameCol = new TableColumn("Last Name");
//        
//        firstNameCol.setCellValueFactory(
//                new PropertyValueFactory<VehicleBean, String>("vehicleType")
//        );
//        lastNameCol.setCellValueFactory(
//                new PropertyValueFactory<VehicleBean, String>("numberOfVehicles")
//        );
//        
//       
//        table.getColumns().addAll(firstNameCol, lastNameCol);
//        
//        ObservableList oblist =FXCollections.observableList(vehicleList);
//        
//        table.setItems(oblist);
//        
//        
//                
//        final Label label = new Label("Address Book");
//        label.setFont(new Font("Arial", 20));
//        
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        //vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//        
//        final Stage secondaryStage = new Stage(StageStyle.UTILITY);
//        secondaryStage.setScene(new Scene(vbox, 300, 200));
//        //scene.getStylesheets().add("/styles/Styles.css");
//        secondaryStage.setTitle("edit/delete table");
//        //secondaryStage.initStyle(StageStyle.TRANSPARENT);
//        secondaryStage.setResizable(false);
//        secondaryStage.show();
//        
//    }
    
    private int previousCounter=0;
    private int nextCounter=0;
    
    @FXML
    private void showPrevious()
    {
        
        if(previousCounter==0)
        {
            previousCounter=vehicleList.size()-1;
        }
        else
        {
            previousCounter--;
        }
            VehicleBean v = vehicleList.get(previousCounter);
            String type = v.getVehicleType();
            int no = v.getNumberOfVehicles();
            cmbVehicleType.getSelectionModel().select(type);
            txtVehicleNumbers.setText(String.valueOf(no));
        
        
    }
    
//    @FXML
//    private void showNext()
//    {
//        if(nextCounter==vehicleList.size()-1)
//        {
//            nextCounter=0;
//        }
//        else
//        {
//            nextCounter++;
//        }
//            VehicleBean v = vehicleList.get(nextCounter);
//            String type = v.getVehicleType();
//            int no = v.getNumberOfVehicles();
//            cmbVehicleType.getSelectionModel().select(type);
//            txtVehicleNumbers.setText(String.valueOf(no));
//    }

    @FXML
    Hyperlink linkShowPrevious;
    
    private void hidePreviousButton() {
        linkShowPrevious.setVisible(false);
    }
    
    private void showPreviousButton() {
        linkShowPrevious.setVisible(true);
    }
    
}
