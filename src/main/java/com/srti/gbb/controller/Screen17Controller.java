/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.bean.PrakrutiQuestionAnsBean;
import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen17Controller implements  Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    @FXML
    private Button submitDataBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //setVisibilityOfSubmitButton();
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
        if(isInternetAvailable())
        {
            //submit data
            submitDataToService();
            
            //show constitution
            showPrakrutiConstitution();
            navigateToNextScreen();
        }
        else
        {
            UIUtils.showAlert("sc17_msg_no_inet_available", GlobalConstants.Lbl_Alert);
        }
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
        
        


//        int key=0;
//        int count=0;
        String firstLetter=GlobalConstants.emptyString;
        String secondLetter=GlobalConstants.emptyString;
//        
//        //for sorting vpk
//        TreeMap<Integer,String> ts = new TreeMap<Integer,String>();
//        
//        ts.put(vCount,V);
//        ts.put(pCount,P);
//        ts.put(kCount,K);
//        
//        System.out.println("***ts="+ts);
//        
//        Set<Integer> decendingKeySet = ts.descendingKeySet();
//        System.out.println("***decendingKeySet="+decendingKeySet);
//        Iterator<Integer> itr = decendingKeySet.iterator();
//        
//        if(itr.hasNext())
//        {
//            key = itr.next();
//            firstLetter=ts.get(key);
//        }
//
//        if(itr.hasNext())
//        {
//            key = itr.next();
//            secondLetter=ts.get(key);
//        }
        
        
        if (vCount > pCount && vCount > kCount) {
            firstLetter=V;
            
            if(pCount>kCount)
            {
                secondLetter=P;
            }
            else
            {
                secondLetter=K;
            }
        }

        else if (pCount > vCount && pCount > kCount) {
            firstLetter=P;
            
            if(vCount > kCount)
            {
                secondLetter=V;
            }
            else
            {
                secondLetter=K;
            }
        }

        else if (kCount > vCount && kCount > pCount) {
            firstLetter=K;
            
            if(vCount > pCount)
            {
                secondLetter=V;
            }
            else
            {
                secondLetter=P;
            }
            
        }
        else
        {
            firstLetter=V;
            secondLetter=P;
        }
        
        
        System.out.println("******firstLettersecondLetter="+firstLetter+secondLetter);
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

            navigator.getUserInfo().setHealthReportPath(pdfFile.getAbsolutePath());
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Awt Desktop is not supported!");
            }

        }
        else
        {
             UIUtils.showAlert("sc17_msg_report_does_not_exists", GlobalConstants.Lbl_Alert);
        }
    }
    
    private boolean isInternetAvailable()
    {
        boolean isAvailable=false;
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();
            isAvailable= true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("***isAvailable="+isAvailable);
        return isAvailable;
    }

    private void submitDataToService() {
        navigator.getUserInfo().setDataSubmittedSuccessfully(true);
    }

    private void navigateToNextScreen() {
         navigator.navigateTo(ScreensFramework.ThankyouSceneId);
    }

    
    private void setVisibilityOfSubmitButton() {
        if(!navigator.getUserInfo().isDataSubmittedSuccessfully())
        {
            submitDataBtn.setDisable(false);
        }
        else
        {
            submitDataBtn.setDisable(true);
        }
    }
}
