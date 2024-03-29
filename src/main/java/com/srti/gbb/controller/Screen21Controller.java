/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.global.GlobalConstants;
import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class Screen21Controller implements Initializable, ControlledScreen {

    private ScreensNavigator navigator;
    
    
     @Override
    public void setScreenParent(ScreensNavigator screenParent){
        navigator = screenParent;
    }
     
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToPreviousScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen0ID);
    }

    @FXML
    private void goToNextScreen(ActionEvent event) 
    {
        navigator.navigateTo(ScreensFramework.screen1ID);
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
//            if (!true) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else 
            {
                System.out.println("Awt Desktop is not supported!");
                pushDisclaimerForSaving(pdfFile);
            }
        }
    }
    
    private void pushDisclaimerForSaving(File pdfFile) 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Disclaimer in PDF format");

        Stage stage = new Stage(StageStyle.UTILITY);
        File file = fileChooser.showSaveDialog(stage);
        //fileChooser.setInitialFileName("Gbb-Disclaimer.pdf");
        
        String path = file.getAbsolutePath();
        
        if(path.indexOf(".pdf")>0)
        {
            
        }
        else
        {
            path = path+".pdf";
        }
        
        System.out.println("pat*******h="+path);
        
        InputStream inStream = null;
	OutputStream outStream = null;
        
        try 
        {
            inStream = new FileInputStream(pdfFile);
            outStream = new FileOutputStream(new File(path));
            
            byte[] buffer = new byte[1024];
            
            int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
    	    inStream.close();
    	    outStream.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
