/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srti.gbb.controller;

import com.srti.gbb.main.ScreensFramework;
import com.srti.gbb.navigator.ScreensNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author sonderaj
 */
public class ScreenIllnessGraphController implements  Initializable, ControlledScreen {
    private ScreensNavigator navigator;
    
    @FXML
    private LineChart demoLineGraph;
    
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
        buildLineGraph();
    }    

    @FXML
    private void goToPreviousScreen(ActionEvent event) {
        if(!navigator.getUserInfo().getSelfIllnessList().isEmpty())
            {
                navigator.navigateTo(ScreensFramework.Screen_Illness_Quantification);
            }
            else
            {
               navigator.navigateTo(ScreensFramework.Screen_Illness);
            }
    }
    
    @FXML
    private void goToNextScreen(ActionEvent event) {
        navigator.navigateTo(ScreensFramework.Screen_Welcome_Prakruti_Nidaan);
    }

//    @FXML
//    private void goToNextScreen(ActionEvent event) {
//    }

    private void buildLineGraph() {
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Month");
        demoLineGraph.setTitle("Demo Illness comparison graph");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Your");
        
        series1.getData().add(new XYChart.Data("Diseases", 23));
        series1.getData().add(new XYChart.Data("Discomforts", 20));
        series1.getData().add(new XYChart.Data("Intensity", 20));
        series1.getData().add(new XYChart.Data("Frequency", 24));
        series1.getData().add(new XYChart.Data("Duration", 34));
        series1.getData().add(new XYChart.Data("StopAct", 20));
        series1.getData().add(new XYChart.Data("TakeLeave", 22));
        series1.getData().add(new XYChart.Data("Hospitalize", 20));
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Average");
        series2.getData().add(new XYChart.Data("Diseases", 25));
        series2.getData().add(new XYChart.Data("Discomforts", 25));
        series2.getData().add(new XYChart.Data("Intensity", 25));
        series2.getData().add(new XYChart.Data("Frequency", 25));
        series2.getData().add(new XYChart.Data("Duration", 25));
        series2.getData().add(new XYChart.Data("StopAct", 25));
        series2.getData().add(new XYChart.Data("TakeLeave", 25));
        series2.getData().add(new XYChart.Data("Hospitalize", 25));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Best");
        series3.getData().add(new XYChart.Data("Diseases", 23));
        series3.getData().add(new XYChart.Data("Discomforts", 33));
        series3.getData().add(new XYChart.Data("Intensity", 31));
        series3.getData().add(new XYChart.Data("Frequency", 36));
        series3.getData().add(new XYChart.Data("Duration", 31));
        series3.getData().add(new XYChart.Data("StopAct", 36));
        series3.getData().add(new XYChart.Data("TakeLeave", 31));
        series3.getData().add(new XYChart.Data("Hospitalize", 33));
                
        Scene scene  = new Scene(demoLineGraph,800,600);       
        demoLineGraph.getData().addAll(series1, series2, series3);       
        
    }
}
