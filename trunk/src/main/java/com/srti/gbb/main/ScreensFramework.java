package com.srti.gbb.main;

import com.srti.gbb.navigator.ScreensNavigator;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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
    
    public static String screen15ID = "screen15";
    public static String screen15File = "/screensframework/Screen15.fxml";
    
    public static String screen9ID = "screen9";
    public static String screen9File = "/screensframework/Screen9.fxml";
    
    public static String screen10ID = "screen10";
    public static String screen10File = "/screensframework/Screen10.fxml";
    
    public static String screen13ID = "screen13";
    public static String screen13File = "/screensframework/Screen13.fxml";
    
    public static String screen14ID = "screen14";
    public static String screen14File = "/screensframework/Screen14.fxml";
    
    public static String screen11ID = "screen11";
    public static String screen11File = "/screensframework/Screen11.fxml";
    
    public static String screen17ID = "screen17";
    public static String screen17File = "/screensframework/Screen17.fxml";
    
    public static String screen18ID = "screen18";
    public static String screen18File = "/screensframework/Screen18.fxml";
    
    public static String screen19ID = "screen19";
    public static String screen19File = "/screensframework/Screen19.fxml";
    
    public static String screen20ID = "screen20";
    public static String screen20File = "/screensframework/Screen20.fxml";
    
    public static String screen21ID = "screen21";
    public static String screen21File = "/screensframework/Screen21.fxml";
    
    public static String ThankyouSceneId = "ThankyouScene";
    public static String ThankyouSceneFile = "/screensframework/ThankyouScene.fxml";
    
    private double xOffset;
    private double yOffset;
    
    
    @Override
    public void start(final Stage primaryStage) {
        
        ScreensNavigator nav = new ScreensNavigator();
        nav.loadScreen(ScreensFramework.screen0ID, ScreensFramework.screen0File);
        nav.loadScreen(ScreensFramework.screen21ID, ScreensFramework.screen21File);
        nav.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        nav.loadScreen(ScreensFramework.screen12ID, ScreensFramework.screen12File);
        nav.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);
        nav.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        nav.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        nav.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        nav.loadScreen(ScreensFramework.screen18ID, ScreensFramework.screen18File);
        nav.loadScreen(ScreensFramework.screen6ID, ScreensFramework.screen6File);
        nav.loadScreen(ScreensFramework.screen7ID, ScreensFramework.screen7File);
        nav.loadScreen(ScreensFramework.screen8ID, ScreensFramework.screen8File);
        nav.loadScreen(ScreensFramework.screen15ID, ScreensFramework.screen15File);
        nav.loadScreen(ScreensFramework.screen9ID, ScreensFramework.screen9File);
        nav.loadScreen(ScreensFramework.screen10ID, ScreensFramework.screen10File);
        nav.loadScreen(ScreensFramework.screen13ID, ScreensFramework.screen13File);
        nav.loadScreen(ScreensFramework.screen14ID, ScreensFramework.screen14File);
        
        nav.loadScreen(ScreensFramework.screen11ID, ScreensFramework.screen11File);
        nav.loadScreen(ScreensFramework.screen17ID, ScreensFramework.screen17File);
        
        nav.loadScreen(ScreensFramework.screen19ID, ScreensFramework.screen19File);
        nav.loadScreen(ScreensFramework.screen20ID, ScreensFramework.screen20File);
        
        nav.loadScreen(ScreensFramework.ThankyouSceneId, ScreensFramework.ThankyouSceneFile);
        
        
        nav.navigateTo(ScreensFramework.screen0ID);
        
        Group root = new Group();
        root.getChildren().addAll(nav);
        
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
        
        
        Scene scene = new Scene(root,800,450);
        //root.setLayoutX(800);
        scene.getStylesheets().add("/styles/Styles.css");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GoBeyondBalance");
//        scene.setm(false);
//        scene.setResizable(true);
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
