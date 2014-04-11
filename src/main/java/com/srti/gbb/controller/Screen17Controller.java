/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.PrakrutiQuestionAnsBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen17Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
     @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen11ID);
    }

    @FXML
    private void submitDataAndShowReport(ActionEvent event) 
    {
        //if net // if data submitted // then go to next screen and show prakruti report
        showPrakrutiConstitution();
    }

    
    private static final String V="V";
    private static final String P="P";
    private static final String K="K";
    private void showPrakrutiConstitution() {
        //vpk denotes vata, pitta and kafa
        int vCount=0;
        int pCount=0;
        int kCount=0;
        List<PrakrutiQuestionAnsBean> prakrutiQuestionAnsList=navigator.getUserInfo().getPrakrutiQuestionAnsList();
        
        if(prakrutiQuestionAnsList!=null)
        {
            for (PrakrutiQuestionAnsBean bean : prakrutiQuestionAnsList) 
            {
                if(bean.isOpt1Checked())
                {
                    vCount++;
                }

                if(bean.isOpt2Checked())
                {
                    pCount++;
                }

                if(bean.isOpt3Checked())
                {
                    kCount++;
                }            
            }
        }
        int key=0;
        int count=0;
        String firstLetter=GlobalConstants.emptyString;
        String secondLetter=GlobalConstants.emptyString;
        
        //for sorting vpk
        TreeMap<Integer,String> ts = new TreeMap<Integer,String>();
        
        ts.put(vCount,V);
        ts.put(pCount,P);
        ts.put(kCount,K);
        
        System.out.println("***ts="+ts);
        
        Set<Integer> decendingKeySet = ts.descendingKeySet();
        System.out.println("***decendingKeySet="+decendingKeySet);
        Iterator<Integer> itr = decendingKeySet.iterator();
        
        if(itr.hasNext())
        {
            key = itr.next();
            firstLetter=ts.get(key);
        }

        if(itr.hasNext())
        {
            key = itr.next();
            secondLetter=ts.get(key);
        }
        
        
        File f = new File(GlobalConstants.emptyString);
        String projectFolder=GlobalConstants.emptyString;
        try {
            projectFolder = f.getCanonicalPath();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        File pdfFile = new File(projectFolder+File.separatorChar+"Prakruti"+File.separatorChar+firstLetter+secondLetter+File.separatorChar+"Prakruti.pdf");
		
        if (pdfFile.exists()) 
        {
 
			if (Desktop.isDesktopSupported()) {
                            try 
                            {
                                Desktop.getDesktop().open(pdfFile);
                            } catch (IOException ex) 
                            {
                                ex.printStackTrace();
                            }
			} else {
				System.out.println("Awt Desktop is not supported!");
			}
 
		}
    }
}
