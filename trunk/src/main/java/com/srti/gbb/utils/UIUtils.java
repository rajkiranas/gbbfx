/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.srti.gbb.utils;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
        Stage secondaryStage = new Stage(StageStyle.UTILITY);
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(new Label(msg));
        secondaryLayout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
        secondaryStage.setScene(new Scene(secondaryLayout, 300, 80));
        secondaryStage.setTitle(title);
        secondaryStage.setResizable(false);
        secondaryStage.show();
    }
    
}
