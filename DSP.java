/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;


import DSP.RevisionLog;
import static DSP.ScreenResolutionClass.resolutionHeight;
import static DSP.ScreenResolutionClass.resolutionWidth;
import javafx.application.Application;
import static javafx.application.Application.launch;


import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * The first class of the appplication.
 * Will contain a menu with many options that will
 * redirect you to the right page
 * @author Aaron and Nic
 */
public class DSP extends Application {
    
    /**
     * Starts the application and launches "start"
     * @param args 
     */
     public static void main(String[] args) {
    /** launches our javaFx */
		
        launch(args);
    }
    static Stage window;
    static Group group;
    static double scale;
    
    @Override
    /**
     * Calls the first page.
     * 
     */
    public void start(Stage stage) throws ClassNotFoundException{
        window = stage;
        int screenWidth = resolutionWidth();
        int screenHeight = resolutionHeight();
        
        if (screenWidth >= 1920 && screenHeight >= 1050)
            scale = 1.35;
        else if (screenWidth >= 1366 && screenHeight >= 738)
            scale = 1.2;
        else if (screenWidth >= 1024 && screenHeight >= 690)
            scale = 1.0;
        
        RevisionLog.revisionLogScene(stage); 
        
        if (screenWidth >= 1920 && screenHeight >= 1050){
            RevisionLog.scene.getStylesheets().add(RevisionLog.class.getResource("DSP16.css").toExternalForm());
            System.out.println("SIZE 16 font");
        }
        else if (screenWidth >= 1366 && screenHeight >= 738){
            RevisionLog.scene.getStylesheets().add(RevisionLog.class.getResource("DSP14.css").toExternalForm());
            System.out.println("SIZE 14 font");
        }
        else if (screenWidth >= 1024 && screenHeight >= 690){
            RevisionLog.scene.getStylesheets().add(RevisionLog.class.getResource("DSP12.css").toExternalForm());
            System.out.println("SIZE 12 font");
        }
         

       // Help.scene.getStylesheets().add(Help.class.getResource("DSP.css").toExternalForm());
    }
}
