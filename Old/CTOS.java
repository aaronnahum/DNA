/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctos;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.stage.Stage;

/**
 *
 * @author mzhao
 */
public class CTOS extends Application {
     public static void main(String[] args) {
    /** launches our javaFx */
		
        launch(args);
    }
	
     
    Stage window;
    static Group group;
    @Override
    public void start(Stage stage) throws Exception {
		
	RevisionLog.revisionLogScene(stage);
        
        RevisionLog.scene.getStylesheets().add(getClass().getResource("ctos.css").toExternalForm());
		
    }
}
