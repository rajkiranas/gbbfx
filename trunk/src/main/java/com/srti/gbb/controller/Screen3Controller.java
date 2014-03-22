package com.srti.gbb.controller;

import com.srti.gbb.bean.AddictionBean;
import com.srti.gbb.bean.GynecBean;
import com.srti.gbb.bean.LifestyleBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.xml.bind.Marshaller.Listener;

/**
 * FXML Controller class
 *
 * @author Rajkiran
 */
public class Screen3Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @FXML
    private GridPane addictionGridPane;
    
//    @FXML
//    private Button btnAddAddiction;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
                }
    
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }

    @FXML
    private void goToScreen2(ActionEvent event){
       navigator.navigateTo(ScreensFramework.screen2ID);
    }
    
    @FXML
    private void goToScreen4(ActionEvent event){
        if(validateLifestyleForm() && validateAddictionsForm())
        {
            setLifestyleData();
            setGynecData();
            setAddictionData();
            navigator.navigateTo(ScreensFramework.screen4ID);
        }
       
    }
    private boolean validateLifestyleForm()
     {
         
         boolean isValid=true;
          if(cmbWakeupTime.getValue()==null || cmbWakeupTime.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc3_msg_sel_wakeup", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbSleepTime.getValue()==null || cmbSleepTime.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc3_msg_sel_sleep", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbAfternoonSleep.getValue() ==null || cmbAfternoonSleep.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc3_msg_sel_afternoon", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbLateNights.getValue()==null || cmbLateNights.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc3_msg_sel_late_nights", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(navigator.getUserInfo().getPi().getGender().equalsIgnoreCase("Female") && txtAge.getText()!=null && !txtAge.getText().equals(GlobalConstants.emptyString) && navigator.getUserInfo().getPi().getAge()<=Integer.parseInt(txtAge.getText()))
            {
                UIUtils.showAlert("sc3_msg_greater_hyst_age", GlobalConstants.Lbl_Alert);
                isValid=false;
            }
         
         return isValid;
     }
    
    private boolean validateAddictionsForm()
     {
         
         boolean isValid=true;
          if((cmbAddict1.getValue()!=null && !cmbAddict1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq1.getValue()==null || cmbFreq1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_freq1", GlobalConstants.Lbl_Alert); 
                isValid=false;

             }
             
         }
         else if((cmbFreq1.getValue()!=null && !cmbFreq1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbAddict1.getValue()==null || cmbAddict1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_addiction1", GlobalConstants.Lbl_Alert); 
                isValid=false;

             }
             
         }
         else if((cmbAddict2.getValue()!=null && !cmbAddict2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq2.getValue()==null || cmbFreq2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_freq2", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
         else if((cmbFreq2.getValue()!=null && !cmbFreq2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbAddict2.getValue()==null ||cmbAddict2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_addiction2", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
          else if((cmbAddict3.getValue()!=null && !cmbAddict3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq3.getValue()==null || cmbFreq3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_freq3", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
         else if((cmbFreq3.getValue()!=null && !cmbFreq3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbAddict3.getValue()==null || cmbAddict3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_addiction3", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
          else if((cmbAddict4.getValue()!=null && !cmbAddict4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq4.getValue()==null || cmbFreq4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_freq4", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
         else if((cmbFreq4.getValue()!=null && !cmbFreq4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbAddict4.getValue()==null || cmbAddict4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                UIUtils.showAlert("sc3_msg_sel_addiction4", GlobalConstants.Lbl_Alert); 
                isValid=false;
             }
         }
         
         return isValid;
     }
    
//    @FXML
//    private void addNewAddictionRow(ActionEvent event)
//    {
//        RowConstraints row = new RowConstraints();
//        System.out.println("asdf;lkajdsf;kljdsf");
//        addictionGridPane.getChildren().add(new Label("Addiction"));
//        
//        //addictionGridPane.getRowConstraints().addAll(row);
//    }
    
    @FXML
    private ComboBox cmbWakeupTime;
    @FXML
    private void populateWakeupTime(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Time_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbWakeupTime.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbWakeupTime.getItems().addAll(gen);
                    if(!gen.equals(GlobalConstants.TwentyFour))
                    {
                        cmbWakeupTime.getItems().addAll(gen+".15");
                        cmbWakeupTime.getItems().addAll(gen+".30");
                        cmbWakeupTime.getItems().addAll(gen+".45");
                    }
            }
        }
     setVisibilityOfGynecInputs();   
    }
    
    @FXML
    private ComboBox cmbSleepTime;
    
    @FXML
    private void populateSleepTime(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Time_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbSleepTime.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbSleepTime.getItems().addAll(gen);
                    if(!gen.equals(GlobalConstants.TwentyFour))
                    {
                        cmbSleepTime.getItems().addAll(gen+".15");
                        cmbSleepTime.getItems().addAll(gen+".30");
                        cmbSleepTime.getItems().addAll(gen+".45");
                    }
            }
        }
        
    }
    
    @FXML
    private ComboBox cmbAfternoonSleep;
    
    @FXML
    private void populateAfternoonSleep(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbAfternoonSleep.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbAfternoonSleep.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbLateNights;
    
    @FXML
    private void populateLateNights(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbLateNights.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbLateNights.getItems().addAll(gen);
            }
        }
        
    }
    
    @FXML
    private ComboBox cmbAddict1;
    @FXML
    private void populateAddiction1(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbAddict1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbAddict1.getItems().addAll(gen);
            }
        }
        
    }
    
    @FXML
    private ComboBox cmbAddict2;
    @FXML
    private void populateAddiction2(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbAddict2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbAddict2.getItems().addAll(gen);
            }
        }
        
    }
    
    
    @FXML
    private ComboBox cmbAddict3;
    @FXML
    private void populateAddiction3(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbAddict3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbAddict3.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbAddict4;
    @FXML
    private void populateAddiction4(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Params);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbAddict4.getItems().size()==0)
        {
            for(String gen : list)
            {
                cmbAddict4.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbFreq1;
    @FXML
    private void populateFrequency1(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFreq1.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFreq1.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbFreq2;
    
    @FXML
    private void populateFrequency2(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFreq2.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFreq2.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbFreq3;
    
    @FXML
    private void populateFrequency3(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFreq3.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFreq3.getItems().addAll(gen);
            }
        }
    }
    
    @FXML
    private ComboBox cmbFreq4;
    
    @FXML
    private void populateFrequency4(Event e)
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Addiction_Frequency_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFreq4.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbFreq4.getItems().addAll(gen);
            }
        }
    }

    private void setLifestyleData() {
        LifestyleBean life = new LifestyleBean();
        life.setWakeupTime(Float.valueOf(cmbWakeupTime.getValue().toString()));
        life.setSleepTime(Float.valueOf(cmbSleepTime.getValue().toString()));
        life.setAfternoonSleepPerWeek(Integer.parseInt(cmbAfternoonSleep.getValue().toString()));
        life.setLateNightsPerWeek(Integer.parseInt(cmbLateNights.getValue().toString()));
        navigator.getUserInfo().setLife(life);
    }
    
    @FXML
    private CheckBox chkIrregular;
    @FXML
    private CheckBox chkPainful;
    @FXML
    private CheckBox chkHeavy;
    
    private void setGynecData() 
    {
        if(navigator.getUserInfo().getPi().getGender().equalsIgnoreCase("Female"))
        {
            
            
                GynecBean g = new GynecBean();
                g.setIrregularMenses(chkIrregular.isSelected());
                g.setPainfulMenses(chkPainful.isSelected());
                g.setHeavyMenses(chkHeavy.isSelected());
                
                if(txtAge.getText()!=null && !txtAge.getText().equals(GlobalConstants.emptyString))
                {
                    g.setMenopauseHysterectomyAtAge(Integer.parseInt(txtAge.getText()));
                }

                navigator.getUserInfo().setGynecBean(g);
        }
    }

    private void setAddictionData() {
        List<AddictionBean> addictionList = new ArrayList<AddictionBean>();
        AddictionBean addict;
        
        if((cmbAddict1.getValue()!=null && !cmbAddict1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq1.getValue()!=null && !cmbFreq1.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                 
                addict=new AddictionBean();
                addict.setAddiction(cmbAddict1.getValue().toString());
                addict.setFrequencyPerWeek(Integer.parseInt(cmbFreq1.getValue().toString()));
                addictionList.add(addict);
             }
             
         }
        
        if((cmbAddict2.getValue()!=null && !cmbAddict2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq2.getValue()!=null && !cmbFreq2.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                 
                addict=new AddictionBean();
                addict.setAddiction(cmbAddict2.getValue().toString());
                addict.setFrequencyPerWeek(Integer.parseInt(cmbFreq2.getValue().toString()));
                addictionList.add(addict);
             }
             
         }
        
        if((cmbAddict3.getValue()!=null && !cmbAddict3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq3.getValue()!=null && !cmbFreq3.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                 
                addict=new AddictionBean();
                addict.setAddiction(cmbAddict3.getValue().toString());
                addict.setFrequencyPerWeek(Integer.parseInt(cmbFreq3.getValue().toString()));
                addictionList.add(addict);
             }
             
         }
        
        if((cmbAddict4.getValue()!=null && !cmbAddict4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
         {
             if((cmbFreq4.getValue()!=null && !cmbFreq4.getValue().toString().trim().equals(GlobalConstants.emptyString)))
             {
                 
                addict=new AddictionBean();
                addict.setAddiction(cmbAddict4.getValue().toString());
                addict.setFrequencyPerWeek(Integer.parseInt(cmbFreq4.getValue().toString()));
                addictionList.add(addict);
             }
             
         }
        
        navigator.getUserInfo().setAddictionsList(addictionList);
    }
    
    @FXML
    private Label lblMenses;
    @FXML
    private Label lblIrregular;
    @FXML
    private Label lblPainful;
    @FXML
    private Label lblHeavy;
    @FXML
    private Label lblAge;
    @FXML
    private TextField txtAge;
    
    private void setVisibilityOfGynecInputs() {
        
        if(navigator.getUserInfo().getPi().getGender().equalsIgnoreCase("Male"))
        {
            lblMenses.setVisible(false);
            lblIrregular.setVisible(false);
            lblPainful.setVisible(false);
            lblHeavy.setVisible(false);
            lblAge.setVisible(false);
            
            chkIrregular.setVisible(false);
            chkPainful.setVisible(false);
            chkHeavy.setVisible(false);
            txtAge.setVisible(false);
        }
        else
        {
            lblMenses.setVisible(true);
            lblIrregular.setVisible(true);
            lblPainful.setVisible(true);
            lblHeavy.setVisible(true);
            lblAge.setVisible(true);
            
            chkIrregular.setVisible(true);
            chkPainful.setVisible(true);
            chkHeavy.setVisible(true);
            txtAge.setVisible(true);
            
        }
    }    
}
