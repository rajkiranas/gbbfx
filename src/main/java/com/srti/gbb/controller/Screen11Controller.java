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
    private CheckBox q1o1a;
    @FXML
    private CheckBox q1o1b;
    @FXML
    private CheckBox q1o1c;
    @FXML
    private CheckBox q1o2a;
    @FXML
    private CheckBox q1o2b;
    @FXML
    private CheckBox q1o2c;
    @FXML
    private CheckBox q1o3a;
    @FXML
    private CheckBox q1o3b;
    @FXML
    private CheckBox q1o3c;
    @FXML
    private Label q2;
    @FXML
    private CheckBox q2o1a;
    @FXML
    private CheckBox q2o1b;
    @FXML
    private CheckBox q2o1c;
    @FXML
    private CheckBox q2o2a;
    @FXML
    private CheckBox q2o2b;
    @FXML
    private CheckBox q2o2c;
    @FXML
    private CheckBox q2o3a;
    @FXML
    private CheckBox q2o3b;
    @FXML
    private CheckBox q2o3c;
    @FXML
    private Label q3;
    @FXML
    private CheckBox q3o1a;
    @FXML
    private CheckBox q3o1b;
    @FXML
    private CheckBox q3o1c;
    @FXML
    private CheckBox q3o2a;
    @FXML
    private CheckBox q3o2b;
    @FXML
    private CheckBox q3o2c;
    @FXML
    private CheckBox q3o3a;
    @FXML
    private CheckBox q3o3b;
    @FXML
    private CheckBox q3o3c;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        hideExtraOptionsQ1();
        hideExtraOptionsQ2();
        hideExtraOptionsQ3();
        setNextQuestionsAndAnswersToLabels();        
    }
    
        @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
//        PersonalInformationBean pi= new PersonalInformationBean();
//        pi.setGender(male);
//        navigator.getUserInfo().setPi(pi);
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
    private static String female="female";
    private static String male="male";

    private void setNextQuestionsAndAnswersToLabels() 
    {
//        if(GlobalConstants.getProperty(Q+qC).contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
//        {
//            while(GlobalConstants.getProperty(Q+qC).contains(female))
//            {
//                qC++;
//                
//            }
//            
//        }
        
            qC++;
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ1();
            
                    if(q1.getText()!=null && q1.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                    {
                        q1.setDisable(true);
                        q1o1a.setDisable(true);
                        q1o2a.setDisable(true);
                        q1o3a.setDisable(true);
                    }
                    else
                    {
                        q1.setDisable(false);
                        q1o1a.setDisable(false);
                        q1o2a.setDisable(false);
                        q1o3a.setDisable(false);

                    }
            
            
            qC++;
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ2();
            
                    if(q2.getText()!=null && q2.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                    {
                        q2.setDisable(true);
                        q2o1a.setDisable(true);
                        q2o2a.setDisable(true);
                        q2o3a.setDisable(true);
                    }
                    else
                    {
                        q2.setDisable(false);
                        q2o1a.setDisable(false);
                        q2o2a.setDisable(false);
                        q2o3a.setDisable(false);

                    }
            
            
            qC++;
            q3.setText(GlobalConstants.getProperty(Q+qC));            
         
            q3o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ3();
            
                    if(q3.getText()!=null && q3.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                    {
                        q3.setDisable(true);
                        q3o1a.setDisable(true);
                        q3o2a.setDisable(true);
                        q3o3a.setDisable(true);
                    }
                    else
                    {
                        q3.setDisable(false);
                        q3o1a.setDisable(false);
                        q3o2a.setDisable(false);
                        q3o3a.setDisable(false);
                    }
            
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
            
            q3o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            setAdditionalOptionsValuesQ3();
            
             if(q3.getText()!=null && q3.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                   {
                       q3.setDisable(true);
                       q3o1a.setDisable(true);
                       q3o2a.setDisable(true);
                       q3o3a.setDisable(true);
                   }
                   else
                   {
                       q3.setDisable(false);
                       q3o1a.setDisable(false);
                       q3o2a.setDisable(false);
                       q3o3a.setDisable(false);
                   }
            
                    
            
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            setAdditionalOptionsValuesQ2();
            
                    if(q2.getText()!=null && q2.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                    {
                        q2.setDisable(true);
                        q2o1a.setDisable(true);
                        q2o2a.setDisable(true);
                        q2o3a.setDisable(true);
                    }
                    else
                    {
                        q2.setDisable(false);
                        q2o1a.setDisable(false);
                        q2o2a.setDisable(false);
                        q2o3a.setDisable(false);

                    }
            
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            qC--;
            
            setAdditionalOptionsValuesQ1();
            
                   if(q1.getText()!=null && q1.getText().contains(female) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male))
                    {
                        q1.setDisable(true);
                        q1o1a.setDisable(true);
                        q1o2a.setDisable(true);
                        q1o3a.setDisable(true);
                    }
                    else
                    {
                        q1.setDisable(false);
                        q1o1a.setDisable(false);
                        q1o2a.setDisable(false);
                        q1o3a.setDisable(false);

                    }
            
            setLastQuestionOptionsVisibility();
            removeUserQueAnsResponse();
            clearUserSelection();
            
    }

    private void setLastQuestionOptionsVisibility() 
    {
        if (qC == Integer.parseInt(GlobalConstants.getProperty(GlobalConstants.Total_Prakruti_Questions))) 
           {
               q3.setVisible(false);
               
               q3o1a.setVisible(false);
               q3o2a.setVisible(false);
               q3o3a.setVisible(false);               
           }
           else
           {
               q3.setVisible(true);
               
               q3o1a.setVisible(true);
               q3o2a.setVisible(true);
               q3o3a.setVisible(true);               
               
           }
    }

    private void recordUserQueAnsResponse() 
    {
        PrakrutiQuestionAnsBean res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q1.getText());
        
        if(q1o1a.isSelected())
        {
            res.setAns1(q1o1a.getText());
        }
        
        if(q1o2a.isSelected())
        {
            res.setAns2(q1o2a.getText());            
        }
        
        if(q1o3a.isSelected())
        {
            res.setAns3(q1o3a.getText());            
        }
        
        recordAdditionalOptionsQ1(res);
        prakrutiQuestionAnsList.add(res);
        
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q2.getText());
        
        if(q2o1a.isSelected())
        {
            res.setAns1(q2o1a.getText());            
        }
        
        if(q2o2a.isSelected())
        {
            res.setAns2(q2o2a.getText());            
        }
        
        if(q2o3a.isSelected())
        {
            res.setAns3(q2o3a.getText());            
        }
        
        
        recordAdditionalOptionsQ2(res);
        prakrutiQuestionAnsList.add(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q3.getText());
        
        if(q3o1a.isSelected())
        {
            res.setAns1(q3o1a.getText());            
        }
        
        if(q3o2a.isSelected())
        {
            res.setAns2(q3o2a.getText());            
        }
        
        if(q3o3a.isSelected())
        {
            res.setAns3(q3o3a.getText());            
        }
                
        recordAdditionalOptionsQ3(res);
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
         
         if (q1.getText() == null || q1.isDisabled()) 
         {
            isQ1Answered = true;

        }
         else if ((q1.getText().contains(GlobalConstants.hash)) && (q1o1a.isSelected() || q1o1b.isSelected() || q1o1c.isSelected() 
                 || q1o2a.isSelected() ||  q1o2b.isSelected() || q1o2c.isSelected() 
                 || q1o3a.isSelected() || q1o3b.isSelected() || q1o3c.isSelected())) 
        {
            isQ1Answered = true;
        }
         else if ((q1.getText().contains(GlobalConstants.dollar)) && (q1o1a.isSelected() || q1o1b.isSelected()
                 || q1o2a.isSelected() ||  q1o2b.isSelected()
                 || q1o3a.isSelected() || q1o3b.isSelected())) 
        {
            isQ1Answered = true;
        }
         else if (q1o1a.isSelected() || q1o2a.isSelected() || q1o3a.isSelected()) 
        {
            isQ1Answered = true;
        }


        if (q2.getText() == null || q2.isDisabled()) 
        {
            isQ2Answered = true;

        }
        else if ((q2.getText().contains(GlobalConstants.hash)) && (q2o1a.isSelected() || q2o1b.isSelected() || q2o1c.isSelected() 
                 || q2o2a.isSelected() ||  q2o2b.isSelected() || q2o2c.isSelected() 
                 || q2o3a.isSelected() || q2o3b.isSelected() || q2o3c.isSelected())) 
        {
            isQ2Answered = true;
        }
        else if ((q2.getText().contains(GlobalConstants.dollar)) && (q2o1a.isSelected() || q2o1b.isSelected() 
                 || q2o2a.isSelected() ||  q2o2b.isSelected() 
                 || q2o3a.isSelected() || q2o3b.isSelected() )) 
        {
            isQ2Answered = true;
        }
        else if (q2o1a.isSelected() || q2o2a.isSelected() || q2o3a.isSelected()) 
        {
            isQ2Answered = true;
        }


        if (q3.getText() == null || q3.isDisabled()) {
            isQ3Answered = true;

        } 
        else if ((q3.getText().contains(GlobalConstants.hash)) && (q3o1a.isSelected() || q3o1b.isSelected() || q3o1c.isSelected() 
                 || q3o2a.isSelected() ||  q3o2b.isSelected() || q3o2c.isSelected() 
                 || q3o3a.isSelected() || q3o3b.isSelected() || q3o3c.isSelected())) 
        {
            isQ3Answered = true;
        }
        else if ((q3.getText().contains(GlobalConstants.dollar)) && (q3o1a.isSelected() || q3o1b.isSelected() 
                 || q3o2a.isSelected() ||  q3o2b.isSelected() 
                 || q3o3a.isSelected() || q3o3b.isSelected() )) 
        {
            isQ3Answered = true;
        }
        else if (q3o1a.isSelected() || q3o2a.isSelected() || q3o3a.isSelected()) 
        {
            isQ3Answered = true;
        }
         
         if(isQ1Answered && isQ2Answered && isQ3Answered)
         {             
            isValid = true;
         }
         else
         {
             isValid = false;
             UIUtils.showAlert("sc11_msg_ans_all_questions", GlobalConstants.Lbl_Alert);
         }
         
         return isValid;         
    }

    private void clearUserSelection() {
        q1o1a.setSelected(false);
        q1o1b.setSelected(false);
        q1o1c.setSelected(false);
        
        q1o2a.setSelected(false);
        q1o2b.setSelected(false);
        q1o2c.setSelected(false);
        
        q1o3a.setSelected(false);
        q1o3b.setSelected(false);
        q1o3c.setSelected(false);
        
        q2o1a.setSelected(false);
        q2o1b.setSelected(false);
        q2o1c.setSelected(false);
        
        q2o2a.setSelected(false);
        q2o2b.setSelected(false);
        q2o2c.setSelected(false);
        
        q2o3a.setSelected(false);
        q2o3b.setSelected(false);
        q2o3c.setSelected(false);
        
        q3o1a.setSelected(false);
        q3o1b.setSelected(false);
        q3o1c.setSelected(false);
        
        
        q3o2a.setSelected(false);
        q3o2b.setSelected(false);
        q3o2c.setSelected(false);
        
        q3o3a.setSelected(false);
        q3o3b.setSelected(false);
        q3o3c.setSelected(false);
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

    private void hideExtraOptionsQ1() {
        q1o1b.setVisible(false);
        q1o1c.setVisible(false);
        q1o2b.setVisible(false);
        q1o2c.setVisible(false);
        q1o3b.setVisible(false);
        q1o3c.setVisible(false);
    }
    
    private void hideThirdOptionQ1() {
        q1o1c.setVisible(false);
        q1o2c.setVisible(false);
        q1o3c.setVisible(false);
    }
    
    private void showExtraOptionsQ1() {
        q1o1b.setVisible(true);
        q1o1c.setVisible(true);
        q1o2b.setVisible(true);
        q1o2c.setVisible(true);
        q1o3b.setVisible(true);
        q1o3c.setVisible(true);
    }
    
    private void hideExtraOptionsQ2() {
        q2o1b.setVisible(false);
        q2o1c.setVisible(false);
        q2o2b.setVisible(false);
        q2o2c.setVisible(false);
        q2o3b.setVisible(false);
        q2o3c.setVisible(false);
    }

    private void hideThirdOptionQ2() {
        q2o1c.setVisible(false);
        q2o2c.setVisible(false);
        q2o3c.setVisible(false);
    }
    
    private void showExtraOptionsQ2() {
        q2o1b.setVisible(true);
        q2o1c.setVisible(true);
        q2o2b.setVisible(true);
        q2o2c.setVisible(true);
        q2o3b.setVisible(true);
        q2o3c.setVisible(true);
    }
    
    private void hideExtraOptionsQ3() {
        q3o1b.setVisible(false);
        q3o1c.setVisible(false);
        q3o2b.setVisible(false);
        q3o2c.setVisible(false);
        q3o3b.setVisible(false);
        q3o3c.setVisible(false);
    }
    
    private void hideThirdOptionQ3() {
        q3o1c.setVisible(false);
        q3o2c.setVisible(false);
        q3o3c.setVisible(false);
    }
    
    private void showExtraOptionsQ3() {
        q3o1b.setVisible(true);
        q3o1c.setVisible(true);
        q3o2b.setVisible(true);
        q3o2c.setVisible(true);
        q3o3b.setVisible(true);
        q3o3c.setVisible(true);
    }

    private static final String a="a";
    private static final String b="b";
    private static final String c="c";

    private void setAdditionalOptionsValuesQ1() {
        if(q1.getText()!=null && q1.getText().contains(GlobalConstants.hash))
            {
                showExtraOptionsQ1();
                q1o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q1o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q1o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q1o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q1o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q1o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
            else if(q1.getText()!=null && q1.getText().contains(GlobalConstants.dollar))
            {
                showExtraOptionsQ1();
                q1o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                //q1o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q1o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                //q1o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q1o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                //q1o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
                hideThirdOptionQ1();
            }
            else
            {
                hideExtraOptionsQ1();
            }
    }
    
    private void setAdditionalOptionsValuesQ2() {
        if(q2.getText()!=null && q2.getText().contains(GlobalConstants.hash))
            {
                showExtraOptionsQ2();
                q2o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q2o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q2o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q2o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q2o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q2o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
        else if(q2.getText()!=null && q2.getText().contains(GlobalConstants.dollar))
            {
                showExtraOptionsQ2();
                q2o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                //q2o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q2o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                //q2o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q2o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                //q2o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
                hideThirdOptionQ2();
            }
            else
            {
                hideExtraOptionsQ2();
            }
    }
    
    private void setAdditionalOptionsValuesQ3() {
        if(q3.getText()!=null && q3.getText().contains(GlobalConstants.hash))
            {
                showExtraOptionsQ3();
                q3o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q3o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q3o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q3o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q3o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q3o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
        else if(q3.getText()!=null && q3.getText().contains(GlobalConstants.dollar))
            {
                showExtraOptionsQ3();
                q3o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                //q3o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q3o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                //q3o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q3o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                //q3o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
                hideThirdOptionQ3();
            }
            else
            {
                hideExtraOptionsQ3();
            }
    }

    private void recordAdditionalOptionsQ1(PrakrutiQuestionAnsBean res) 
    {
        if(q1.getText()!=null)
        {
            //additional options recording
            if(q1.getText().contains(GlobalConstants.hash))
            {
                if(q1o1b.isSelected())
                    res.setAns1b(q1o1b.getText());

                if(q1o1c.isSelected())
                    res.setAns1c(q1o1c.getText());

                if(q1o2b.isSelected())
                    res.setAns2b(q1o2b.getText());

                if(q1o2c.isSelected())
                    res.setAns2c(q1o2c.getText());

                if(q1o3b.isSelected())
                    res.setAns3b(q1o3b.getText());

                if(q1o3c.isSelected())
                    res.setAns3c(q1o3c.getText());
            }
            else if(q1.getText().contains(GlobalConstants.dollar))
            {
                if(q1o1b.isSelected())
                    res.setAns1b(q1o1b.getText());

                if(q1o2b.isSelected())
                    res.setAns2b(q1o2b.getText());

                if(q1o3b.isSelected())
                    res.setAns3b(q1o3b.getText());            
            }
        }
    }

    private void recordAdditionalOptionsQ2(PrakrutiQuestionAnsBean res) {
        if(q2.getText()!=null)
        {
            //additional options recording
            if(q2.getText().contains(GlobalConstants.hash))
            {
                if(q2o1b.isSelected())
                    res.setAns1b(q2o1b.getText());

                if(q2o1c.isSelected())
                    res.setAns1c(q2o1c.getText());

                if(q2o2b.isSelected())
                    res.setAns2b(q2o2b.getText());

                if(q2o2c.isSelected())
                    res.setAns2c(q2o2c.getText());

                if(q2o3b.isSelected())
                    res.setAns3b(q2o3b.getText());

                if(q2o3c.isSelected())
                    res.setAns3c(q2o3c.getText());
            }
            else if(q2.getText().contains(GlobalConstants.dollar))
            {
                if(q2o1b.isSelected())
                    res.setAns1b(q2o1b.getText());            

                if(q2o2b.isSelected())
                    res.setAns2b(q2o2b.getText());            

                if(q2o3b.isSelected())
                    res.setAns3b(q2o3b.getText());
            }
        }
    }

    private void recordAdditionalOptionsQ3(PrakrutiQuestionAnsBean res) {
        if(q3.getText()!=null)
        {
            //additional options recording
            if(q3.getText().contains(GlobalConstants.hash))
            {
                if(q3o1b.isSelected())
                    res.setAns1b(q3o1b.getText());

                if(q3o1c.isSelected())
                    res.setAns1c(q3o1c.getText());

                if(q3o2b.isSelected())
                    res.setAns2b(q3o2b.getText());

                if(q3o2c.isSelected())
                    res.setAns2c(q3o2c.getText());

                if(q3o3b.isSelected())
                    res.setAns3b(q3o3b.getText());

                if(q3o3c.isSelected())
                    res.setAns3c(q3o3c.getText());
            }
            else if(q3.getText().contains(GlobalConstants.dollar))
            {
                if(q3o1b.isSelected())
                    res.setAns1b(q3o1b.getText());            

                if(q3o2b.isSelected())
                    res.setAns2b(q3o2b.getText());            

                if(q3o3b.isSelected())
                    res.setAns3b(q3o3b.getText());
            }
        }
    }
}

