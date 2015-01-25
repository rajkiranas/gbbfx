package com.srti.gbb.controller;

import com.srti.gbb.bean.ExerciseBean;
import com.srti.gbb.bean.MealTypeBean;
import com.srti.gbb.bean.PhysicalParameters;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.MU;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Rajkiran
 */
public class Screen2Controller implements Initializable , ControlledScreen {

    private ScreensNavigator navigator;
    
        @FXML
        private ComboBox cmbDiet;
        
        @FXML
        private ComboBox cmbNonVeg;
        
        @FXML
        private ComboBox cmbFoodType;
        
        @FXML
        private ComboBox cmbFruits;
        
        @FXML
        private ComboBox cmbEatingOut;
        
        @FXML
        private ComboBox cmbExerciseSchedule;
        
        @FXML
        private ComboBox cmbExerciseType;
        
        @FXML
        private ComboBox cmbDuration;
        
        @FXML
        private TextField txtFoodType;
        
        @FXML
        private CheckBox chkRegularExercise;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateDietTypes();
        populateNonVegPerWeek();
        populateFoodTypes();
        populateFruitsPerWeek();
        populateEatingOutPerWeek();
        populateExerciseSchedule();
        populateExerciseTypes();
        populateExerciseDuration();
        cmbExerciseSchedule.setDisable(true);
        cmbExerciseType.setDisable(true);
        cmbDuration.setDisable(true);
        
    }
    
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }

    @FXML
    private void goToScreen1(ActionEvent event){
       navigator.navigateTo(ScreensFramework.ScreenPhysiologicalGraph);
    }
    
    @FXML
    private void goToScreen3(ActionEvent event){
        if(validateMealForm() && validateExerciseForm())
         {
             setMealType();
            navigator.navigateTo(ScreensFramework.screen3ID);
         }
    }
    
    @FXML
    private void toggleExerciseCombos(ActionEvent event)
    {
        if(chkRegularExercise.isSelected())
         {
             cmbExerciseSchedule.setDisable(false);
             cmbExerciseType.setDisable(false);
             cmbDuration.setDisable(false);
         }
         else
         {
             cmbExerciseSchedule.setDisable(true);
             cmbExerciseType.setDisable(true);
             cmbDuration.setDisable(true);
         }
    }
    
    private boolean validateMealForm()
     {
         
         boolean isValid=true;
          if(cmbDiet.getValue()==null || cmbDiet.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc2_msg_sel_diet", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if(cmbNonVeg.getValue()==null || cmbNonVeg.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc2_msg_sel_nonveg", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbFoodType.getValue() ==null || cmbFoodType.getValue().toString().trim().equals(GlobalConstants.emptyString)) && (txtFoodType.getText() ==null || txtFoodType.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc2_msg_sel_or_enter_foodtype", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         else if((cmbFoodType.getValue()!=null) && (!txtFoodType.getText().trim().equals(GlobalConstants.emptyString)))
         {
             UIUtils.showAlert("sc2_msg_either_sel_or_enter_foodtype", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbFruits.getValue()==null || cmbFruits.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc2_msg_sel_fruits", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
          else if(cmbEatingOut.getValue()==null || cmbEatingOut.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("sc2_msg_sel_eating_out", GlobalConstants.Lbl_Alert); 
             isValid=false;
         }
         
         return isValid;
     }
    
    private boolean validateExerciseForm()
     {
         
         boolean isValid=true;
         if (chkRegularExercise.isSelected()) 
         {
             if (cmbExerciseSchedule.getValue() == null || cmbExerciseSchedule.getValue().toString().trim().equals(GlobalConstants.emptyString)) {
                 UIUtils.showAlert("sc2_msg_sel_exercise", GlobalConstants.Lbl_Alert);
                 isValid = false;
             } else if (cmbExerciseType.getValue() == null || cmbExerciseType.getValue().toString().trim().equals(GlobalConstants.emptyString)) {
                 UIUtils.showAlert("sc2_msg_sel_exercise_type", GlobalConstants.Lbl_Alert);
                 isValid = false;
             } else if (cmbDuration.getValue() == null || cmbDuration.getValue().toString().trim().equals(GlobalConstants.emptyString)) {
                 UIUtils.showAlert("sc2_msg_sel_exercise_hours", GlobalConstants.Lbl_Alert);
                 isValid = false;
             }
         }
         
         return isValid;
     }
    private void setMealType() {
        
        MealTypeBean meal = new MealTypeBean();
        meal.setDiet(cmbDiet.getValue().toString());
        meal.setNonVegPerWeek(Integer.valueOf(cmbNonVeg.getValue().toString()));
        if(cmbFoodType.getValue()!=null)
        {
            meal.setFoodType(cmbFoodType.getValue().toString());
        }
        else
        {
            meal.setFoodType(txtFoodType.getText().trim());
        }
        
        meal.setFruitsPerWeek(Integer.valueOf(cmbFruits.getValue().toString()));
        meal.setEatingOutPerWeek(Integer.valueOf(cmbEatingOut.getValue().toString()));
        
        System.out.println("3*****meal="+meal);
        navigator.getUserInfo().setMeal(meal);
        
        if (chkRegularExercise.isSelected()) 
        {
            ExerciseBean exercise = new ExerciseBean();
            exercise.setExercisePerWeek(Integer.valueOf(cmbExerciseSchedule.getValue().toString()));
            exercise.setExerciseType(cmbExerciseType.getValue().toString());
            exercise.setDurationPerDay(Integer.valueOf(cmbDuration.getValue().toString()));

            System.out.println("4****exercise="+exercise);
            navigator.getUserInfo().setExercise(exercise);
        }
    }
    
     
    private void populateDietTypes() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Diet_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbDiet.getItems().size()==0)
        {
            for(String gen : list)
            {
                    cmbDiet.getItems().addAll(gen);
            }
        }
        
    }
    
    
    private void populateNonVegPerWeek() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbNonVeg.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbNonVeg.getItems().addAll(gen);
            }
        }
    }
    
    
    private void populateFoodTypes() {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Food_Type_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFoodType.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbFoodType.getItems().addAll(gen);
            }
        }
    }
   
    
    private void populateFruitsPerWeek() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbFruits.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbFruits.getItems().addAll(gen);
            }
        }
    }
    
    
    private void populateEatingOutPerWeek() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbEatingOut.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbEatingOut.getItems().addAll(gen);
            }
        }
    }
    
    
    private void populateExerciseSchedule() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Zero_To_Seven_WeekDays);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbExerciseSchedule.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.Zero_Number))
                    cmbExerciseSchedule.getItems().addAll(gen);
            }
        }
    }
    
     
    private void populateExerciseTypes() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Exercise_Type_Options);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbExerciseType.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbExerciseType.getItems().addAll(gen);
            }
        }
    }
    
     
    private void populateExerciseDuration() 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbDuration.getItems().size()==0)
        {
            for(String gen : list)
            {
                if(!gen.equals(GlobalConstants.Zero_Number))
                 cmbDuration.getItems().addAll(gen);
            }
        }
    }
     
    @FXML
    private void manageNonVeg(ActionEvent event)
    {
        Object objDiet = cmbDiet.getValue();
        
        if(objDiet!=null)
        {
            String diet = objDiet.toString();
            if(!diet.equals(GlobalConstants.emptyString) && diet.equals(MU.getMsg("Lbl_Non_Veg")))
            {
                cmbNonVeg.getSelectionModel().clearSelection();
                cmbNonVeg.setDisable(false);
            }
            else
            {
                cmbNonVeg.getSelectionModel().selectFirst();
                cmbNonVeg.setDisable(true);
            }
        }
    }
}
