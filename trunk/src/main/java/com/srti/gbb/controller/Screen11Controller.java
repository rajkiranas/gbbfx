/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.bean.PrakrutiQuestionAnsBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen11Controller implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    private List<PrakrutiQuestionAnsBean> prakrutiQuestionAnsList = new ArrayList<PrakrutiQuestionAnsBean>();
    
    @FXML
    private Color x1;
    @FXML
    private Label q1;
    @FXML
    private CheckBox q1o1;
    @FXML
    private CheckBox q1o2;
    @FXML
    private CheckBox q1o3;
    @FXML
    private Label q2;
    @FXML
    private CheckBox q2o1;
    @FXML
    private CheckBox q2o2;
    @FXML
    private CheckBox q2o3;
    @FXML
    private Label q3;
    @FXML
    private CheckBox q3o1;
    @FXML
    private CheckBox q3o2;
    @FXML
    private CheckBox q3o3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setNextQuestionsAndAnswersToLabels();
    }
    
        @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }
    

    @FXML
    private void goToScreen10(ActionEvent event) 
    {
        if(qC==0)
        {
            navigator.navigateTo(ScreensFramework.screen13ID);
        }
        else
        {
            setPreviousQuestionsAndAnswersToLabels();
        }
    }

    @FXML
    private void goToScreen12(ActionEvent event) 
    {
        if(validateUserQueAnsResponse())
        {
            recordUserQueAnsResponse();

            if(qC==Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.Total_Prakruti_Questions)))
            {
                setPrakrutiQuestionAnsData();
                navigator.navigateTo(ScreensFramework.ThankyouSceneId);
            }
            else
            {
                setNextQuestionsAndAnswersToLabels();
            }
        }
    }

    private int qC=0;
    
    private String Q="Q";   

    private void setNextQuestionsAndAnswersToLabels() 
    {
        
            qC++;
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            qC++;
                    
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            qC++;
                    
            q3.setText(GlobalConstants.getProperty(Q+qC));            
         
            q3o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
           setLastQuestionOptionsVisibility();
           clearUserSelection();
    }
    
    private void setPreviousQuestionsAndAnswersToLabels() 
    {
//        if(qC>3)
//        {
//            qC=qC-3;
//        }
            
            q3.setText(GlobalConstants.getProperty(Q+qC));
            
            q3o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            setLastQuestionOptionsVisibility();
            removeUserQueAnsResponse();
            clearUserSelection();
            
    }

    private void setLastQuestionOptionsVisibility() {
        if (qC == Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.Total_Prakruti_Questions))) 
           {
               q3.setVisible(false);
               
               q3o1.setVisible(false);
               q3o2.setVisible(false);
               q3o3.setVisible(false);               
           }
           else
           {
               q3.setVisible(true);
               
               q3o1.setVisible(true);
               q3o2.setVisible(true);
               q3o3.setVisible(true);               
               
           }
    }

    private void recordUserQueAnsResponse() 
    {
        PrakrutiQuestionAnsBean res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q1.getText());
        
        if(q1o1.isSelected())
        {
            res.setAns1(q1o1.getText());            
        }
        
        if(q1o2.isSelected())
        {
            res.setAns1(q1o2.getText());            
        }
        
        if(q1o3.isSelected())
        {
            res.setAns1(q1o3.getText());            
        }        
        prakrutiQuestionAnsList.add(res);
        
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q2.getText());
        
        if(q2o1.isSelected())
        {
            res.setAns1(q2o1.getText());            
        }
        
        if(q2o2.isSelected())
        {
            res.setAns1(q2o2.getText());            
        }
        
        if(q2o3.isSelected())
        {
            res.setAns1(q2o3.getText());            
        }        
        prakrutiQuestionAnsList.add(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q3.getText());
        
        if(q3o1.isSelected())
        {
            res.setAns1(q3o1.getText());            
        }
        
        if(q3o2.isSelected())
        {
            res.setAns1(q3o2.getText());            
        }
        
        if(q3o3.isSelected())
        {
            res.setAns1(q3o3.getText());            
        }        
        prakrutiQuestionAnsList.add(res);
    }

    private void setPrakrutiQuestionAnsData() 
    {
        if(navigator.getUserInfo().getPrakrutiQuestionAnsList()==null)
        {
            navigator.getUserInfo().setPrakrutiQuestionAnsList(prakrutiQuestionAnsList);
        }
        
    }

    private boolean validateUserQueAnsResponse() {
        
         boolean isQ1Answered = false;
         boolean isQ2Answered = false;
         boolean isQ3Answered = false;
         boolean isValid;
         
         if(q1o1.isSelected() || q1o2.isSelected() || q1o3.isSelected())
        {
            isQ1Answered=true;
        }
         
         if(q2o1.isSelected() || q2o2.isSelected() || q2o3.isSelected())
        {
            isQ2Answered=true;
        }
         
         if(q3o1.isSelected() || q3o2.isSelected() || q3o3.isSelected())
        {
            isQ3Answered=true;            
        }
         
         if(isQ1Answered && isQ2Answered && isQ3Answered)
         {             
            isValid = true;
         }
         else
         {
             isValid = false;
             UIUtils.showAlert("Please answer all questions on the screen", "Alert");
         }
         
         return isValid;         
    }

    private void clearUserSelection() {
        q1o1.setSelected(false);
        q1o2.setSelected(false);
        q1o3.setSelected(false);
        
        q2o1.setSelected(false);
        q2o2.setSelected(false);
        q2o3.setSelected(false);
        
        q3o1.setSelected(false);
        q3o2.setSelected(false);
        q3o3.setSelected(false);
    }

    private void removeUserQueAnsResponse() 
    {
        PrakrutiQuestionAnsBean res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q1.getText());
        prakrutiQuestionAnsList.remove(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q2.getText());
        prakrutiQuestionAnsList.remove(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q3.getText());
        prakrutiQuestionAnsList.remove(res);
        
        System.out.println("prakrutiQuestionAnsList="+prakrutiQuestionAnsList.size());
    }
}
