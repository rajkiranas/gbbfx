package com.srti.gbb.controller;

import com.srti.gbb.bean.ExerciseBean;
import com.srti.gbb.bean.MealTypeBean;
import com.srti.gbb.bean.PhysicalParameters;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private void goToScreen1(ActionEvent event){
       navigator.navigateTo(ScreensFramework.screen12ID);
    }
    
    @FXML
    private void goToScreen3(ActionEvent event){
        if(validateForm())
         {
             setMealType();
            navigator.navigateTo(ScreensFramework.screen3ID);
         }
       
    }
    
    private boolean validateForm()
     {
         
         boolean isValid=true;
          if(cmbDiet.getValue()==null || cmbDiet.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select diet", "Alert"); 
             isValid=false;
         }
         else if(cmbNonVeg.getValue()==null || cmbNonVeg.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select non veg value", "Alert"); 
             isValid=false;
         }
         else if(cmbFoodType.getValue() ==null || cmbFoodType.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select food type", "Alert"); 
             isValid=false;
         }
          else if(cmbFruits.getValue()==null || cmbFruits.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select fruits value", "Alert"); 
             isValid=false;
         }
          else if(cmbEatingOut.getValue()==null || cmbEatingOut.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select eating out value", "Alert"); 
             isValid=false;
         }
          else if(cmbExerciseSchedule.getValue()==null || cmbExerciseSchedule.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select exercise schedule value", "Alert"); 
             isValid=false;
         }
          else if(cmbExerciseType.getValue()==null || cmbExerciseType.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select exercise type value", "Alert"); 
             isValid=false;
         }
          else if(cmbDuration.getValue()==null || cmbDuration.getValue().toString().trim().equals(GlobalConstants.emptyString))
         {
             UIUtils.showAlert("Please select hours value", "Alert"); 
             isValid=false;
         }
         
         return isValid;
     }
    private void setMealType() {
        
        MealTypeBean meal = new MealTypeBean();
        meal.setDiet(cmbDiet.getValue().toString());
        meal.setNonVegPerWeek(Integer.valueOf(cmbNonVeg.getValue().toString()));
        meal.setFoodType(cmbFoodType.getValue().toString());
        meal.setFruitsPerWeek(Integer.valueOf(cmbFruits.getValue().toString()));
        meal.setEatingOutPerWeek(Integer.valueOf(cmbEatingOut.getValue().toString()));
        
        navigator.getUserInfo().setMeal(meal);
        
        ExerciseBean exercise = new ExerciseBean();
        exercise.setExercisePerWeek(Integer.valueOf(cmbExerciseSchedule.getValue().toString()));
        exercise.setExerciseType(cmbExerciseType.getValue().toString());
        exercise.setDurationPerDay(Integer.valueOf(cmbDuration.getValue().toString()));
        
        navigator.getUserInfo().setExercise(exercise);
    }
    
     @FXML
    private void populateDietTypes(Event event) {
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
    
    @FXML
    private void populateNonVegPerWeek(Event event) {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
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
    
    @FXML
    private void populateFoodTypes(Event event) {
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
   
    @FXML
    private void populateFruitsPerWeek(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
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
    
    @FXML
    private void populateEatingOutPerWeek(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
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
    
    @FXML
    private void populateExerciseSchedule(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbExerciseSchedule.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbExerciseSchedule.getItems().addAll(gen);
            }
        }
    }
    
     @FXML
    private void populateExerciseTypes(Event event) 
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
    
     @FXML
    private void populateExerciseDuration(Event event) 
    {
        String genderList = GlobalConstants.getProperty(GlobalConstants.Loose_Motions_Constipations_Values);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  genderList.split(GlobalConstants.COMMA);
        if(cmbDuration.getItems().size()==0)
        {
            for(String gen : list)
            {
                 cmbDuration.getItems().addAll(gen);
            }
        }
    }


    
    
}
