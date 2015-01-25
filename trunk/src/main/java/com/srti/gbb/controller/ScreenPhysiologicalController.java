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
public class ScreenPhysiologicalController implements  Initializable, ControlledScreen {
    
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
        navigator.navigateTo(ScreensFramework.Screen_Physiological);
    }
    
    @FXML
    private void goToNextScreen(ActionEvent event) {
        //navigator.navigateTo(ScreensFramework.screen11ID);
        navigator.navigateTo(ScreensFramework.screen2ID);
    }

//    @FXML
//    private void goToNextScreen(ActionEvent event) {
//    }

    private void buildLineGraph() {
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Month");
        demoLineGraph.setTitle("Demo physical and physiological graph");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Your");
        
        series1.getData().add(new XYChart.Data("BMI", 23));
        series1.getData().add(new XYChart.Data("Waist-to-Hip Ratio ", 20));
        series1.getData().add(new XYChart.Data("Resting Pulse Rate ", 20));
        series1.getData().add(new XYChart.Data("Blood Pressure SYS", 24));
        series1.getData().add(new XYChart.Data("Blood Pressure DIA", 34));
        series1.getData().add(new XYChart.Data("Breath Holding", 20));
        series1.getData().add(new XYChart.Data("Touching toes", 22));
        series1.getData().add(new XYChart.Data("Bowel Movement (Regularity)", 20));
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Average");
        series2.getData().add(new XYChart.Data("BMI", 25));
        series2.getData().add(new XYChart.Data("Waist-to-Hip Ratio ", 25));
        series2.getData().add(new XYChart.Data("Resting Pulse Rate ", 25));
        series2.getData().add(new XYChart.Data("Blood Pressure SYS", 25));
        series2.getData().add(new XYChart.Data("Blood Pressure DIA", 25));
        series2.getData().add(new XYChart.Data("Breath Holding Capacity", 25));
        series2.getData().add(new XYChart.Data("Flexibiltiy in touching toes", 25));
        series2.getData().add(new XYChart.Data("Bowel Movement (Regularity)", 25));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Best");
        series3.getData().add(new XYChart.Data("BMI", 33));
        series3.getData().add(new XYChart.Data("Waist-to-Hip Ratio ", 24));
        series3.getData().add(new XYChart.Data("Resting Pulse Rate ", 25));
        series3.getData().add(new XYChart.Data("Blood Pressure SYS", 34));
        series3.getData().add(new XYChart.Data("Blood Pressure DIA", 35));
        series3.getData().add(new XYChart.Data("Breath Holding Capacity", 35));
        series3.getData().add(new XYChart.Data("Flexibiltiy in touching toes", 32));
        series3.getData().add(new XYChart.Data("Bowel Movement (Regularity)", 35));
                
        Scene scene  = new Scene(demoLineGraph,800,600);       
        demoLineGraph.getData().addAll(series1, series2, series3);       
        
    }
    
}
