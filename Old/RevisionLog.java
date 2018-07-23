
package ctos;

import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class RevisionLog{
    	
    Stage window;
    static Scene scene;
    static Group group;
    public static double numberOfFields = 2.1;
    public static int StartAtOne = 1;
    
    static Rectangle2D primaryScreenBounds = ScreenResolutionClass.screenBounds();
	
	
    public static void revisionLogScene(Stage stage){
        
        Group root = new Group();
	group = root;
		
	ArrayList<Line> DrawingBorderLines = BorderClass.border1();
		
	for(int i=0; i < DrawingBorderLines.size(); i = i+1) {
            root.getChildren().add(DrawingBorderLines.get(i));	
	}
	ArrayList<Button> buttons = ButtonClass.revisionLogButtons();
	
        for(int i = 0; i <buttons.size(); i++) {
            root.getChildren().add(buttons.get(i));
	}
        
        ArrayList<Label> labels = LabelClass.revisionLogLabels();
        for(int i = 0; i < labels.size(); i++){
            root.getChildren().add(labels.get(i));
        }
        
        ArrayList<Label> borderLabels = LabelClass.borderLabels();
        for(int i = 0; i < borderLabels.size(); i++){
            root.getChildren().add(borderLabels.get(i));
        }
	
        ArrayList<TextField> textfields = TextfieldClass.revisionLogTextFields();
        for(int i = 0; i < textfields.size(); i++){
            root.getChildren().add(textfields.get(i));
        }

	scene = new Scene(root, Color.WHITE);

	stage.setScene(scene);
	stage.setTitle("Revision Log");
		
	stage.setScene(scene);
	stage.show();

	stage.setX(primaryScreenBounds.getMinX());
	stage.setY(primaryScreenBounds.getMinY());
	stage.setWidth(primaryScreenBounds.getWidth());
	stage.setHeight(primaryScreenBounds.getHeight());	
        
    }
}
