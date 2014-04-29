/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

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
import com.srti.gbb.global.GlobalConstants;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author rajkirans
 */
public class ThankyouSceneController implements Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    
     @Override
    public void setScreenParent(ScreensNavigator screenPage) {
        this.navigator=screenPage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void showHealthReport(ActionEvent event) 
    {
        //File pdfFile = new File("/home/rajkirans/NetBeansProjects/fx/fx-aft-mahur-shegaon-trip/fx-aft-mahur-shegaon-trip/fx/GBBfxSvn/trunk/Prakruti/KP/Prakruti.pdf");
        File pdfFile = new File(navigator.getUserInfo().getHealthReportPath());
		
        if (pdfFile.exists()) 
        {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else 
            {
                pushReportForSaving(pdfFile);
                System.out.println("Awt Desktop is not supported!");
            }
        }
        else
        {
             UIUtils.showAlert("sc17_msg_report_does_not_exists", GlobalConstants.Lbl_Alert);
        }
    }

    private void pushReportForSaving(File pdfFile) 
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save prakruti report in PDF format");

        Stage stage = new Stage(StageStyle.UTILITY);
        File file = fileChooser.showSaveDialog(stage);
        
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
