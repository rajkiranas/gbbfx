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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

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
        
        //File pdfFile = new File(navigator.getUserInfo().getHealthReportPath());
        File pdfFile = new File(navigator.getUserInfo().getHealthReportPath());
		
        if (pdfFile.exists()) 
        {

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
        
//        DirectoryChooser dc = new DirectoryChooser();
//        File file = dc.showDialog(null);
//        if (file != null) 
//        {
//            file = new File(file.getAbsolutePath() + "/dafaultFilename.extension");
//            
//            FileChooser myFile = new FileChooser();
//            myFile.setInitialFileName("Whatever_file_I_want.coolFile");
//        }
        
    }
}
