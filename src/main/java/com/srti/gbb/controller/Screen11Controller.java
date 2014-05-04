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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
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
    private Map<String,PrakrutiQuestionAnsBean> prakrutiQuestionAnsMap = new HashMap<String,PrakrutiQuestionAnsBean>();
    
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
    
    private List<String> twoOptionQuestionList = new ArrayList<String>();
    private List<String> threeOptionQuestionList = new ArrayList<String>();
    private List<String> femaleOnlyQuestionList = new ArrayList<String>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getTwoOptionQuestions();
        getThreeOptionQuestions();
        getFemaleOnlyQuestions();
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
            navigator.navigateTo(ScreensFramework.screen23ID);
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
                navigator.navigateTo(ScreensFramework.screen17ID);
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
            setRecordedUserOptionsToFormQ1();
            determineFemaleQuestionQ1();
            
            
            qC++;
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ2();
            setRecordedUserOptionsToFormQ2();
            determineFemaleQuestionQ2();
            
            qC++;
            q3.setText(GlobalConstants.getProperty(Q+qC));            
         
            q3o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q3o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q3o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ3();
            setRecordedUserOptionsToFormQ3();
            determineFemaleQuestionQ3();
            
           setLastQuestionOptionsVisibility();
           //clearUserSelection();
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
            
            setAdditionalOptionsValuesQ3();
            setRecordedUserOptionsToFormQ3();
            
            determineFemaleQuestionQ3();
            
            qC--;
            q2.setText(GlobalConstants.getProperty(Q+qC));
            
            q2o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q2o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q2o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            
            setAdditionalOptionsValuesQ2();
            setRecordedUserOptionsToFormQ2();
            
            determineFemaleQuestionQ2();
            
            
            qC--;
            q1.setText(GlobalConstants.getProperty(Q+qC));
            
            q1o1a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE));
            q1o2a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO));
            q1o3a.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE));
            setAdditionalOptionsValuesQ1();
            setRecordedUserOptionsToFormQ1();
            
            determineFemaleQuestionQ1();
            
            
            qC--;
            setLastQuestionOptionsVisibility();
//            removeUserQueAnsResponse();
            //clearUserSelection();
            
            
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
        PrakrutiQuestionAnsBean res;
        
        if(q1.getText()!=null)
        {
            res = new PrakrutiQuestionAnsBean();
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
            determineCheckedOptionsForQuestion(res);
            addToPrakrutiQuestionsAnsList(res);
        }
        
        
        if(q2.getText()!=null)
        {
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
            determineCheckedOptionsForQuestion(res);
            addToPrakrutiQuestionsAnsList(res);
        
        }
        
        if(q3.getText()!=null)
        {
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
            determineCheckedOptionsForQuestion(res);
            addToPrakrutiQuestionsAnsList(res);
        }
    }

    private void setPrakrutiQuestionAnsData() 
    {
//        if(navigator.getUserInfo().getPrakrutiQuestionAnsList()==null)
//        {
        
        List<PrakrutiQuestionAnsBean> prakrutiQuestionAnsList = Collections.list(Collections.enumeration(prakrutiQuestionAnsMap.values()));
        
        System.out.println("****prakrutiQuestionAnsList="+prakrutiQuestionAnsList);
        navigator.getUserInfo().setPrakrutiQuestionAnsList(prakrutiQuestionAnsList);
        
        
        //}
        
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
         //(q1.getText().contains(GlobalConstants.hash)) &&
         else if ( (q1o1a.isSelected() || q1o1b.isSelected() || q1o1c.isSelected() 
                 || q1o2a.isSelected() ||  q1o2b.isSelected() || q1o2c.isSelected() 
                 || q1o3a.isSelected() || q1o3b.isSelected() || q1o3c.isSelected())) 
        {
            isQ1Answered = true;
        }
         //(q1.getText().contains(GlobalConstants.dollar)) && 
         else if ((q1o1a.isSelected() || q1o1b.isSelected()
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
        //(q2.getText().contains(GlobalConstants.hash)) && 
        else if ((q2o1a.isSelected() || q2o1b.isSelected() || q2o1c.isSelected() 
                 || q2o2a.isSelected() ||  q2o2b.isSelected() || q2o2c.isSelected() 
                 || q2o3a.isSelected() || q2o3b.isSelected() || q2o3c.isSelected())) 
        {
            isQ2Answered = true;
        }
        //(q2.getText().contains(GlobalConstants.dollar)) &&
        else if ( (q2o1a.isSelected() || q2o1b.isSelected() 
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
        //(q3.getText().contains(GlobalConstants.hash)) &&
        else if ( (q3o1a.isSelected() || q3o1b.isSelected() || q3o1c.isSelected() 
                 || q3o2a.isSelected() ||  q3o2b.isSelected() || q3o2c.isSelected() 
                 || q3o3a.isSelected() || q3o3b.isSelected() || q3o3c.isSelected())) 
        {
            isQ3Answered = true;
        }
        //(q3.getText().contains(GlobalConstants.dollar)) &&
        else if ( (q3o1a.isSelected() || q3o1b.isSelected() 
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
        prakrutiQuestionAnsMap.remove(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q2.getText());
        prakrutiQuestionAnsMap.remove(res);
        
        res = new PrakrutiQuestionAnsBean();
        res.setQuestion(q3.getText());
        prakrutiQuestionAnsMap.remove(res);
        
        System.out.println("prakrutiQuestionAnsList="+prakrutiQuestionAnsMap.size());
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
        //if(q1.getText()!=null && q1.getText().contains(GlobalConstants.hash))
        if(q1.getText()!=null && threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
            {
                showExtraOptionsQ1();
                q1o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q1o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q1o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q1o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q1o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q1o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
            else if(q1.getText()!=null && twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
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
        if(q2.getText()!=null && threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
            {
                showExtraOptionsQ2();
                q2o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q2o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q2o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q2o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q2o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q2o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
        else if(q2.getText()!=null && twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
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
        if(q3.getText()!=null && threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
            {
                showExtraOptionsQ3();
                q3o1b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+b));
                q3o1c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.ONE+c));
                
                q3o2b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+b));
                q3o2c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.TWO+c));
                
                q3o3b.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+b));
                q3o3c.setText(GlobalConstants.getProperty(Q+qC+GlobalConstants.underscore+GlobalConstants.THREE+c));
            }
        else if(q3.getText()!=null && twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
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
//        if(q1.getText()!=null)
//        {
            //additional options recording
//            if(threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
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
//            }
//            else if(twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
//                if(q1o1b.isSelected())
//                    res.setAns1b(q1o1b.getText());
//
//                if(q1o2b.isSelected())
//                    res.setAns2b(q1o2b.getText());
//
//                if(q1o3b.isSelected())
//                    res.setAns3b(q1o3b.getText());            
            //}
        //}
    }

    private void recordAdditionalOptionsQ2(PrakrutiQuestionAnsBean res) {
//        if(q2.getText()!=null)
//        {
            //additional options recording
//            if(threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
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
//            }
//            else if(twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
                if(q2o1b.isSelected())
                    res.setAns1b(q2o1b.getText());            

                if(q2o2b.isSelected())
                    res.setAns2b(q2o2b.getText());            

                if(q2o3b.isSelected())
                    res.setAns3b(q2o3b.getText());
            //}
        //}
    }

    private void recordAdditionalOptionsQ3(PrakrutiQuestionAnsBean res) {
//        if(q3.getText()!=null)
//        {
            //additional options recording
//            if(threeOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
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
//            }
//            else if(twoOptionQuestionList.contains(GlobalConstants.emptyString+qC))
//            {
                if(q3o1b.isSelected())
                    res.setAns1b(q3o1b.getText());            

                if(q3o2b.isSelected())
                    res.setAns2b(q3o2b.getText());            

                if(q3o3b.isSelected())
                    res.setAns3b(q3o3b.getText());
            //}
        //}
    }
    
    private void getFemaleOnlyQuestions() {
        String toq = GlobalConstants.getProperty(GlobalConstants.femaleOnlyQuestions);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  toq.split(GlobalConstants.COMMA);
        if(femaleOnlyQuestionList.isEmpty())
        {
            for(String gen : list)
            {
                 femaleOnlyQuestionList.add(gen);
            }
        }
    }
    
    private void getTwoOptionQuestions() 
    {
        String toq = GlobalConstants.getProperty(GlobalConstants.twoOptionQuestions);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  toq.split(GlobalConstants.COMMA);
        if(twoOptionQuestionList.isEmpty())
        {
            for(String gen : list)
            {
                 twoOptionQuestionList.add(gen);
            }
        }
    }

    private void getThreeOptionQuestions() {

        String toq = GlobalConstants.getProperty(GlobalConstants.threeOptionQuestions);
        //ObservableList genderOptions = new ObservableList();
        String[] list =  toq.split(GlobalConstants.COMMA);
        if(threeOptionQuestionList.isEmpty())
        {
            for(String gen : list)
            {
                 threeOptionQuestionList.add(gen);
            }
        }
    }


    private void addToPrakrutiQuestionsAnsList(PrakrutiQuestionAnsBean res) 
    {
        System.out.println("****res="+res);
        //if(res.getQuestion()!=null)
            prakrutiQuestionAnsMap.put(res.getQuestion(), res);
        
//        if (prakrutiQuestionAnsList.contains(res)) 
//        {
//            prakrutiQuestionAnsList.remove(res);
//            prakrutiQuestionAnsList.add(res);
//        } 
//        else 
//        {
//            prakrutiQuestionAnsList.add(res);
//        }
    }

    private void setRecordedUserOptionsToFormQ3() {
        if(q3.getText()!=null)
        {
            PrakrutiQuestionAnsBean userResponse=prakrutiQuestionAnsMap.get(q3.getText());
            //System.out.println("***userResponse="+userResponse);
            if(userResponse!=null)
            {
                
                if(userResponse.getAns1()!=null)
                {
                    q3o1a.setSelected(true);
                }
                else
                {
                    q3o1a.setSelected(false);
                }
                
                if(userResponse.getAns1b()!=null)
                {
                    q3o1b.setSelected(true);
                }
                else
                {
                    q3o1b.setSelected(false);
                }
                
                
                if(userResponse.getAns1c()!=null)
                {
                    q3o1c.setSelected(true);
                }
                else
                {
                    q3o1c.setSelected(false);
                }
                

                if(userResponse.getAns2()!=null)
                {
                    q3o2a.setSelected(true);
                }
                else
                {
                    q3o2a.setSelected(false);
                }
                
                if(userResponse.getAns2b()!=null)
                {
                    q3o2b.setSelected(true);
                }
                else
                {
                    q3o2b.setSelected(false);
                }
                
                if(userResponse.getAns2c()!=null)
                {
                    q3o2c.setSelected(true);
                }
                else
                {
                    q3o2c.setSelected(false);
                }

                if(userResponse.getAns3()!=null)
                {
                    q3o3a.setSelected(true);
                }
                else
                {
                    q3o3a.setSelected(false);
                }
                
                if(userResponse.getAns3b()!=null)
                {
                    q3o3b.setSelected(true);
                }
                else
                {
                    q3o3b.setSelected(false);
                }
                
                if(userResponse.getAns3c()!=null)
                {
                    q3o3c.setSelected(true);
                }
                else
                {
                    q3o3c.setSelected(false);
                }
            
            }
            else
            {
                clearUserSelection();
            }
        }
    }

    private void setRecordedUserOptionsToFormQ2() {
        if(q2.getText()!=null)
        {
            PrakrutiQuestionAnsBean userResponse=prakrutiQuestionAnsMap.get(q2.getText());
//            System.out.println("***userResponse="+userResponse);
            if(userResponse!=null)
            {
                
                if(userResponse.getAns1()!=null)
                {
                    q2o1a.setSelected(true);
                }
                else
                {
                    q2o1a.setSelected(false);
                }
                
                if(userResponse.getAns1b()!=null)
                {
                    q2o1b.setSelected(true);
                }
                else
                {
                    q2o1b.setSelected(false);
                }
                
                if(userResponse.getAns1c()!=null)
                {
                    q2o1c.setSelected(true);
                }
                else
                {
                    q2o1c.setSelected(false);
                }

                if(userResponse.getAns2()!=null)
                {
                    q2o2a.setSelected(true);
                }
                else
                {
                    q2o2a.setSelected(false);
                }
                
                if(userResponse.getAns2b()!=null)
                {
                    q2o2b.setSelected(true);
                }
                else
                {
                    q2o2b.setSelected(false);
                }
                
                if(userResponse.getAns2c()!=null)
                {
                    q2o2c.setSelected(true);
                }
                else
                {
                    q2o2c.setSelected(false);
                }
                

                if(userResponse.getAns3()!=null)
                {
                    q2o3a.setSelected(true);
                }
                else
                {
                    q2o3a.setSelected(false);
                }
                
                if(userResponse.getAns3b()!=null)
                {
                    q2o3b.setSelected(true);
                }
                else
                {
                    q2o3b.setSelected(false);
                }
                
                if(userResponse.getAns3c()!=null)
                {
                    q2o3c.setSelected(true);
                }
                else
                {
                    q2o3c.setSelected(false);
                }
            
            }
            else
            {
                clearUserSelection();
            }
        }
    }
    
    private void setRecordedUserOptionsToFormQ1() {
        if(q1.getText()!=null)
        {
            PrakrutiQuestionAnsBean userResponse=prakrutiQuestionAnsMap.get(q1.getText());
//            System.out.println("***userResponse="+userResponse);
            if(userResponse!=null)
            {
                
                if(userResponse.getAns1()!=null)
                {
                    q1o1a.setSelected(true);
                }
                else
                {
                    q1o1a.setSelected(false);
                }
                
                if(userResponse.getAns1b()!=null)
                {
                    q1o1b.setSelected(true);
                }
                else
                {
                    q1o1b.setSelected(false);
                }
                
                if(userResponse.getAns1c()!=null)
                {
                    q1o1c.setSelected(true);
                }
                else
                {
                    q1o1c.setSelected(false);
                }
                

                if(userResponse.getAns2()!=null)
                {
                    q1o2a.setSelected(true);
                }
                else
                {
                    q1o2a.setSelected(false);
                }
                
                
                if(userResponse.getAns2b()!=null)
                {
                    q1o2b.setSelected(true);
                }
                else
                {
                    q1o2b.setSelected(false);
                }
                
                if(userResponse.getAns2c()!=null)
                {
                    q1o2c.setSelected(true);
                }
                else
                {
                    q1o2c.setSelected(false);
                }
                
                

                if(userResponse.getAns3()!=null)
                {
                    q1o3a.setSelected(true);
                }
                else
                {
                    q1o3a.setSelected(false);
                }
                
                if(userResponse.getAns3b()!=null)
                {
                    q1o3b.setSelected(true);
                }
                else
                {
                    q1o3b.setSelected(false);
                }
                
                if(userResponse.getAns3c()!=null)
                {
                    q1o3c.setSelected(true);
                }
                else
                {
                    q1o3c.setSelected(false);
                }
            
            }
            else
            {
                clearUserSelection();
            }
        }
    }    

    private void determineFemaleQuestionQ1() {
        if (q1.getText() != null && femaleOnlyQuestionList.contains(GlobalConstants.emptyString + qC) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male)) {
            q1.setDisable(true);
            q1o1a.setDisable(true);
            q1o1b.setDisable(true);
            q1o1c.setDisable(true);

            q1o2a.setDisable(true);
            q1o2b.setDisable(true);
            q1o2c.setDisable(true);

            q1o3a.setDisable(true);
            q1o3b.setDisable(true);
            q1o3c.setDisable(true);

        } else {
            q1.setDisable(false);
            q1o1a.setDisable(false);
            q1o1b.setDisable(false);
            q1o1c.setDisable(false);


            q1o2a.setDisable(false);
            q1o2b.setDisable(false);
            q1o2c.setDisable(false);


            q1o3a.setDisable(false);
            q1o3b.setDisable(false);
            q1o3c.setDisable(false);

        }
    }

    private void determineFemaleQuestionQ2() {
        if (q2.getText() != null && femaleOnlyQuestionList.contains(GlobalConstants.emptyString + qC) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male)) {
            q2.setDisable(true);
            q2o1a.setDisable(true);
            q2o1b.setDisable(true);
            q2o1c.setDisable(true);


            q2o2a.setDisable(true);
            q2o2b.setDisable(true);
            q2o2c.setDisable(true);


            q2o3a.setDisable(true);
            q2o3b.setDisable(true);
            q2o3c.setDisable(true);
        } else {
            q2.setDisable(false);
            q2o1a.setDisable(false);
            q2o1b.setDisable(false);
            q2o1c.setDisable(false);

            q2o2a.setDisable(false);
            q2o2b.setDisable(false);
            q2o2c.setDisable(false);

            q2o3a.setDisable(false);
            q2o3b.setDisable(false);
            q2o3c.setDisable(false);

        }
    }

    private void determineFemaleQuestionQ3() {
        if (q3.getText() != null && femaleOnlyQuestionList.contains(GlobalConstants.emptyString + qC) && navigator.getUserInfo().getPi().getGender().equalsIgnoreCase(male)) {
            q3.setDisable(true);
            q3o1a.setDisable(true);
            q3o1b.setDisable(true);
            q3o1c.setDisable(true);

            q3o2a.setDisable(true);
            q3o2b.setDisable(true);
            q3o2c.setDisable(true);

            q3o3a.setDisable(true);
            q3o3b.setDisable(true);
            q3o3c.setDisable(true);
        } else {
            q3.setDisable(false);
            q3o1a.setDisable(false);
            q3o1b.setDisable(false);
            q3o1c.setDisable(false);

            q3o2a.setDisable(false);
            q3o2b.setDisable(false);
            q3o2c.setDisable(false);

            q3o3a.setDisable(false);
            q3o3b.setDisable(false);
            q3o3c.setDisable(false);
        }
    }

    private void determineCheckedOptionsForQuestion(PrakrutiQuestionAnsBean res) 
    {
        if(res.getAns1()!=null || res.getAns1b()!=null || res.getAns1c()!=null)
        {
            res.setOpt1Checked(true);
        }
        
        if(res.getAns2()!=null || res.getAns2b()!=null || res.getAns2c()!=null)
        {
            res.setOpt2Checked(true);
        }
        
        if(res.getAns3()!=null || res.getAns3b()!=null || res.getAns3c()!=null)
        {
            res.setOpt3Checked(true);
        }
    }
}

