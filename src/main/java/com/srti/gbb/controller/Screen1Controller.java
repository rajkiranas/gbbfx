/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.PersonalInformationBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.GbbValidator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen1Controller implements Initializable, ControlledScreen  {

        private ScreensNavigator navigator;
        
        @FXML
        private TextField txtName;
        
        @FXML
        private TextField txtAge;
        
        @FXML
        private ComboBox cmbGenderList;
        
        @FXML
        private ComboBox cmbReligionList;

        @FXML
        private TextField txtReligion;
        
        @FXML
        private ComboBox cmbMaritalStatus;
        
        @FXML
        private ComboBox cmbChildren;
        
        
        
        
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getGendersFromProperty();
        getReligionsFromProperty();
        populateMaritalStatus();
        //dob
        populateDays();
        populateMonth();
        populateYear();
        
        populateHours();
        populateMinutes();
    }    
    
   

    /**
     * Initializes the controller class.
     * @param screenParent
     */
        @Override
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }
    
    @FXML
    private void setAgeLimit(KeyEvent e)
    {
        txtAge.setPrefColumnCount(3);
    }
    
    @FXML
        private void goToScreen0(ActionEvent event){
       navigator.navigateTo(ScreensFramework.screen21ID);
    }

     @FXML
     private void goToScreen2(ActionEvent event)
     {
         if(validatePersonalInformationForm())
         {
             setPersonalInformation();
            navigator.navigateTo(ScreensFramework.screen12ID);
         }
         
         //ValidationUtils.forceValidate(txtName, ValidationMode.ON_FOCUS_LOST);
            
                /* ImageView asteriskImage = new ImageView("/img/red_asterisk.gif");
                Label label = new Label ( "Required",asteriskImage);
                System.out.println("bingo!!!!!");
                Decorator d = new Decorator(label,Pos.TOP_RIGHT);
                
                DecorationUtils.install(txtName, d); */
            
     }
     
     
     private boolean validatePersonalInformationForm()
     {
         
         boolean isValid=true;
         if(txtName.getText() ==null || txtName.getText().trim().equals(GlobalConstants.emptyString))
         {
             
              UIUtils.showAlert("sc1_msg_enter_name", GlobalConstants.Lbl_Alert);
    
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtName.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_name", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         
         else if(cmbGenderList.getValue()==null || cmbGenderList.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_gender", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbReligionList.getValue()==null || cmbReligionList.getValue().toString().trim().equals(GlobalConstants.emptyString))&& (txtReligion.getText() ==null || txtReligion.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_sel_or_enter_religion", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbReligionList.getValue()!=null) && (!txtReligion.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_either_sel_or_enter_religion", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbMaritalStatus.getValue()==null || cmbMaritalStatus.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_marital_status", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((!cmbChildren.isDisabled()) && (cmbChildren.getValue()==null || cmbChildren.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc1_msg_sel_children", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbDobDay.getValue()==null || cmbDobDay.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_dob_day", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbDobMonth.getValue()==null || cmbDobMonth.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_dob_month", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbDobYear.getValue()==null || cmbDobYear.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_dob_year", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbHours.getValue()==null || cmbHours.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_dob_hours", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbMinutes.getValue()==null || cmbMinutes.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_sel_dob_minutes", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(txtBirthPlace.getText() ==null || txtBirthPlace.getText().trim().equals(GlobalConstants.emptyString))
         {
             
              UIUtils.showAlert("sc1_msg_enter_birth_place", GlobalConstants.Lbl_Alert);
    
             isValid=false;
         }
         else if(!GbbValidator.isValidName(txtBirthPlace.getText()))
         {
              UIUtils.showAlert("sc1_msg_enter_valid_birth_place", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(txtAge.getText() ==null || txtAge.getText().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc1_msg_enter_age", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(!GbbValidator.isValidNumber(txtAge.getText()))
         {
              UIUtils.showAlert("sc1_msg_valid_age", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         else if(Integer.parseInt(txtAge.getText())>Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.MaxAge)))
         {
              UIUtils.showAlert("sc1_msg_greater_age", GlobalConstants.Lbl_Alert);  
    
             isValid=false;
         }
         
//         else if(txtMobile.getText() ==null || txtMobile.getText().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_enter_mobile", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(!GbbValidator.isValidPhoneNumber(txtMobile.getText()))
//         {
//              UIUtils.showAlert("sc1_msg_valid_mobile", GlobalConstants.Lbl_Alert);  
//    
//             isValid=false;
//         }
//         else if(txtEmail.getText() ==null || txtEmail.getText().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_enter_email", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(!GbbValidator.isValidEmail(txtEmail.getText()))
//         {
//              UIUtils.showAlert("sc1_msg_valid_email", GlobalConstants.Lbl_Alert);  
//    
//             isValid=false;
//         }
//         else if(cmbOccupation.getValue()==null || cmbOccupation.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_occu", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
//         else if(cmbIncome.getValue()==null || cmbIncome.getValue().toString().trim().equals(GlobalConstants.emptyString))
//         {
//             UIUtils.showAlert("sc1_msg_sel_income", GlobalConstants.Lbl_Alert); 
//             isValid=false;
//         }
         
         return isValid;
     }

    
    private void getReligionsFromProperty() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.ReligionList);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbReligionList.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbReligionList.getItems().addAll(gen);
            }
        }
       
    }

    
    private void getGendersFromProperty() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.GenderList);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbGenderList.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbGenderList.getItems().addAll(gen);
            }
        }
    }
    
    
    

    private void setPersonalInformation() {
        PersonalInformationBean pi = new PersonalInformationBean();
        pi.setName(txtName.getText());
        pi.setAge(Integer.parseInt(txtAge.getText()));
        pi.setGender(cmbGenderList.getValue().toString());
        if(cmbReligionList.getValue()!=null)
        {
            pi.setReligion(cmbReligionList.getValue().toString());
        }
        else
        {
            pi.setReligion(txtReligion.getText().trim());
        }
        pi.setMaritalStatus(cmbMaritalStatus.getValue().toString());
        
        if(!cmbChildren.isDisabled())
            pi.setNoOfChildren(Integer.parseInt(cmbChildren.getValue().toString()));
        
        
        setBirthInformation(pi);
//        pi.setMobile(Long.parseLong(txtMobile.getText()));
//        pi.setEmail(txtEmail.getText());
//        pi.setOrganization(txtOrganization.getText());
//        pi.setOccupation(cmbOccupation.getValue().toString());
//        pi.setIncome(cmbIncome.getValue().toString());
        System.out.println("1****pi="+pi);
        navigator.getUserInfo().setPi(pi);
    }
    
    
    
    
        


    
    private void populateMaritalStatus() {
         String genderList = GlobalConstants.getProperty(GlobalConstants.Lbl_Marital_Status_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbMaritalStatus.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbMaritalStatus.getItems().addAll(gen);
            }
        }
    }
    
    
    @FXML
    private void populateChildren() 
    {
//        if (cmbMaritalStatus.getValue() != null
//                && !cmbMaritalStatus.getValue().toString().trim().equals(GlobalConstants.emptyString)
//                && !cmbMaritalStatus.getValue().toString().equals(GlobalConstants.getProperty(GlobalConstants.Lbl_Single_Status)))
//        {
            cmbChildren.setDisable(false);
            String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
            String[] list = genderList.split(GlobalConstants.COMMA);
            if (cmbChildren.getItems().size() == 0) {
                for (String gen : list) {
                    //if(!gen.equals(GlobalConstants.Zero))
                    cmbChildren.getItems().addAll(gen);
                }
            }
        //}
//        else
//        {
//            cmbChildren.setDisable(true);
//        }
    }

    @FXML
    private TextField txtBirthPlace;
    
    @FXML
    private ComboBox cmbDobDay;
    private void populateDays() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Day_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbDobDay.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbDobDay.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbDobMonth;
    private void populateMonth() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Month_Options);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbDobMonth.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbDobMonth.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbDobYear;
    private void populateYear() 
    {
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        int currentYear = c.get(Calendar.YEAR);
        
        int startYear = Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.Year_Start_Option));
        
        if(cmbDobYear.getItems().size()==0)
        {
            while(startYear<=currentYear)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                     cmbDobYear.getItems().addAll(GlobalConstants.emptyString+startYear);
                     startYear++;
            }
        }
    }
    
    @FXML
    private ComboBox cmbHours;
    private void populateHours() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Time_Params);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbHours.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbHours.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbMinutes;
    private void populateMinutes() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Minute_Params);
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbMinutes.getItems().size()==0)
        {
            for(String gen : list)
            {
                //if(!gen.equals(GlobalConstants.Zero))
                 cmbMinutes.getItems().addAll(gen);
            }
        }
    }

    private void setBirthInformation(PersonalInformationBean pi) {
        
        pi.setBirthDate(getDateForCurrentForm().getTime());
        pi.setBirthPlace(txtBirthPlace.getText().trim());
    }
    
    @FXML
    private void calculateAndDisplayAge(Event e)
    {
        //int age = getAge(getDateForCurrentForm());
        
        
        int from = Integer.parseInt(cmbDobYear.getValue().toString());
        int to = 2014;
        int age = to - from;
        
        txtAge.setText(GlobalConstants.emptyString+age);
    }
    
    public int getAge(Date birthDate) 
    {
	long ageInMillis = new Date().getTime() - birthDate.getTime();

	Date age = new Date(ageInMillis);

	return age.getYear();
}
    
    private Date getDateForCurrentForm()
    {
        Calendar c = Calendar.getInstance();
        
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(cmbDobDay.getValue().toString()));
        c.set(Calendar.MONTH, (Integer.parseInt(cmbDobMonth.getValue().toString()) - 1));
        c.set(Calendar.YEAR, Integer.parseInt(cmbDobYear.getValue().toString()));
        
        c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(cmbHours.getValue().toString()));
        c.set(Calendar.MINUTE, Integer.parseInt(cmbMinutes.getValue().toString()));
        c.set(Calendar.SECOND, 0);
        
        System.out.println("*****"+c.getTime());
        return c.getTime();
    }
}
