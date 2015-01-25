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
public class ScreenLifestyleController implements  Initializable, ControlledScreen {
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
        navigator.navigateTo(ScreensFramework.screen3ID);
    }
    
    @FXML
    private void goToNextScreen(ActionEvent event) {
        //navigator.navigateTo(ScreensFramework.screen11ID);
        //navigator.navigateTo(ScreensFramework.screen2ID);
        navigator.navigateTo(ScreensFramework.screen4ID);        
    }

//    @FXML
//    private void goToNextScreen(ActionEvent event) {
//    }

    private void buildLineGraph() {
        
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("Month");
        demoLineGraph.setTitle("Demo Lifestyle comparison graph");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Your");
        
        series1.getData().add(new XYChart.Data("Sleeping Time", 23));
        series1.getData().add(new XYChart.Data("Waking Up", 20));
        series1.getData().add(new XYChart.Data("Hours of Sleep", 20));
        series1.getData().add(new XYChart.Data("Afternoon Sleep", 24));
        series1.getData().add(new XYChart.Data("Meal Timings", 34));
        series1.getData().add(new XYChart.Data("Eating Outside", 20));
        series1.getData().add(new XYChart.Data("Late Nights", 22));
        series1.getData().add(new XYChart.Data("Quality of Sleep", 20));        
        series1.getData().add(new XYChart.Data("Appetite", 20));
        series1.getData().add(new XYChart.Data("Meditation", 24));
        series1.getData().add(new XYChart.Data("Enthusiastic & Excited", 34));
        series1.getData().add(new XYChart.Data("Feeling on Waking Up", 20));
        series1.getData().add(new XYChart.Data("Feeling in Control", 22));
        series1.getData().add(new XYChart.Data("Anxiety/Worry/Fear", 20));
        
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Average");
        series2.getData().add(new XYChart.Data("Sleeping Time", 25));
        series2.getData().add(new XYChart.Data("Waking Up", 25));
        series2.getData().add(new XYChart.Data("Hours of Sleep", 25));
        series2.getData().add(new XYChart.Data("Afternoon Sleep", 25));
        series2.getData().add(new XYChart.Data("Meal Timings", 25));
        series2.getData().add(new XYChart.Data("Eating Outside", 25));
        series2.getData().add(new XYChart.Data("Late Nights", 25));
        series2.getData().add(new XYChart.Data("Quality of Sleep", 25));        
        series2.getData().add(new XYChart.Data("Appetite", 25));
        series2.getData().add(new XYChart.Data("Meditation", 25));
        series2.getData().add(new XYChart.Data("Enthusiastic & Excited", 25));
        series2.getData().add(new XYChart.Data("Feeling on Waking Up", 25));
        series2.getData().add(new XYChart.Data("Feeling in Control", 25));
        series2.getData().add(new XYChart.Data("Anxiety/Worry/Fear", 25));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Best");
        series3.getData().add(new XYChart.Data("Sleeping Time", 35));
        series3.getData().add(new XYChart.Data("Waking Up", 33));
        series3.getData().add(new XYChart.Data("Hours of Sleep", 35));
        series3.getData().add(new XYChart.Data("Afternoon Sleep", 33));
        series3.getData().add(new XYChart.Data("Meal Timings", 35));
        series3.getData().add(new XYChart.Data("Eating Outside", 35));
        series3.getData().add(new XYChart.Data("Late Nights", 33));
        series3.getData().add(new XYChart.Data("Quality of Sleep", 35));        
        series3.getData().add(new XYChart.Data("Appetite", 31));
        series3.getData().add(new XYChart.Data("Meditation", 35));
        series3.getData().add(new XYChart.Data("Enthusiastic & Excited", 33));
        series3.getData().add(new XYChart.Data("Feeling on Waking Up", 30));
        series3.getData().add(new XYChart.Data("Feeling in Control", 33));
        series3.getData().add(new XYChart.Data("Anxiety/Worry/Fear", 30));
                
        Scene scene  = new Scene(demoLineGraph,800,600);       
        demoLineGraph.getData().addAll(series1, series2, series3);       
        
    }
}
