/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.controller;

import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import com.srti.gbb.utils.UIUtils;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author rajkiran
 */
public class Screen0Controller implements Initializable, ControlledScreen {

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
        navigator = screenPage;
    }
    
    @FXML
    private void goToScreen1(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.screen21ID);
    }
    
    @FXML
    private void showDisclaimer(ActionEvent event) 
    {
        
        File f = new File(GlobalConstants.emptyString);
        String projectFolder=GlobalConstants.emptyString;
        try {
            projectFolder = f.getCanonicalPath();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        File pdfFile = new File(projectFolder+File.separatorChar+"Disclaimer"+File.separatorChar+"Gbb-Disclaimer.pdf");
		
        if (pdfFile.exists()) 
        {

            //navigator.getUserInfo().setHealthReportPath(pdfFile.getAbsolutePath());
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
    }
    
}
