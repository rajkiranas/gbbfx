package com.srti.gbb.main;

import com.srti.gbb.navigator.ScreensNavigator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Rajkiran
 */
public class ScreensFramework extends Application {
    
    public static String screen0ID = "screen0";
    public static String screen0File = "/screensframework/Screen0.fxml";
    public static String screen1ID = "screen1";
    public static String screen1File = "/screensframework/Screen1.fxml";
    
    //address
    public static String screen12ID = "screen12";
    public static String screen12File = "/screensframework/Screen12.fxml";
    
    public static String screen2ID = "screen2";
    public static String screen2File = "/screensframework/Screen2.fxml";
    public static String screen3ID = "screen3";
    public static String screen3File = "/screensframework/Screen3.fxml";
    public static String screen4ID = "screen4";
    public static String screen4File = "/screensframework/Screen4.fxml";
    
    public static String screen5ID = "screen5";
    public static String screen5File = "/screensframework/Screen5.fxml";
    
    public static String screen6ID = "screen6";
    public static String screen6File = "/screensframework/Screen6.fxml";
    
    public static String screen7ID = "screen7";
    public static String screen7File = "/screensframework/Screen7.fxml";
    
    public static String screen8ID = "screen8";
    public static String screen8File = "/screensframework/Screen8.fxml";
    
    public static String screen9ID = "screen9";
    public static String screen9File = "/screensframework/Screen9.fxml";
    
    public static String screen11ID = "screen11";
    public static String screen11File = "/screensframework/Screen11.fxml";
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensNavigator nav = new ScreensNavigator();
        nav.loadScreen(ScreensFramework.screen0ID, ScreensFramework.screen0File);
        nav.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        nav.loadScreen(ScreensFramework.screen12ID, ScreensFramework.screen12File);
        nav.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        nav.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        nav.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        nav.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        nav.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
        nav.loadScreen(ScreensFramework.screen7ID, ScreensFramework.screen7File);
        nav.loadScreen(ScreensFramework.screen8ID, ScreensFramework.screen8File);
        nav.loadScreen(ScreensFramework.screen9ID, ScreensFramework.screen9File);
        
        nav.loadScreen(ScreensFramework.screen11ID, ScreensFramework.screen11File);
        
        
        nav.navigateTo(ScreensFramework.screen12ID);
        
        Group root = new Group();
        root.getChildren().addAll(nav);
        Scene scene = new Scene(root,800,400);
        //root.setLayoutX(800);
        scene.getStylesheets().add("/styles/Styles.css");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
