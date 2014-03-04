/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.utils;

import com.srti.gbb.global.GlobalConstants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author rajkiran
 */
public class UIUtils 
{
    public static void showAlert(String msg,String title)
    {
        final Stage secondaryStage = new Stage(StageStyle.UTILITY);
        VBox secondaryLayout = new VBox();
//        secondaryLayout.setPrefWidth(300);
//        secondaryLayout.setPrefHeight(10);
        
//        HBox header= new HBox();
//        header.setPrefWidth(300);
//        header.setPrefHeight(10);
//        header.getChildren().add(new Label(GlobalConstants.getProperty(GlobalConstants.Lbl_Alert)));
//        header.setStyle("-fx-background-color: #BF232B; -fx-padding: 10; -fx-font-size: 12px; -fx-text-fill: white;");
        //secondaryLayout.getChildren().add(header);
        Label l = new Label(msg);
        l.setWrapText(true);
        secondaryLayout.getChildren().add(l);
        Button ok = new Button();
        ok.setText("OK");
        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                secondaryStage.close();
            }
        });
        secondaryLayout.getChildren().add(ok);
        secondaryLayout.setAlignment(Pos.CENTER);
        secondaryLayout.setSpacing(5);
        secondaryLayout.setStyle("-fx-background-color: white; -fx-padding: 10; -fx-border-color: #105675; -fx-font-size: 12px; -fx-text-fill: #BF232B;");
        secondaryStage.setScene(new Scene(secondaryLayout, 300, 90));
        //scene.getStylesheets().add("/styles/Styles.css");
        secondaryStage.setTitle(title);
        //secondaryStage.initStyle(StageStyle.TRANSPARENT);
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }
    
}
