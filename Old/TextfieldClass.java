package ctos;


import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

public class TextfieldClass {
    
    public static ArrayList<TextField> revisionLogTextFields(){

        int screenWidth = ScreenResolutionClass.resolutionWidth();
        int screenHeight = ScreenResolutionClass.resolutionHeight();
        int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
        int proportionalHeight = ScreenResolutionClass.propotionalHeight(screenHeight);
        double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
        double numberOfFields = 2.1;
        
        ArrayList<TextField> textfields = new ArrayList<>();
        
        TextField txtCode = textfield("Code", fieldWidthAlignment*6, proportionalHeight*1.5, "textField");
        textfields.add(txtCode);        

        return textfields;
    }
    public static TextField textfield(String text, int positionX, double positionY, String style) {
	TextField textfield1 = new TextField();
        textfield1.setPromptText(text);
        textfield1.setAlignment(Pos.CENTER);
        textfield1.setPrefWidth(100);
        // eventually might need to add prefHeight
        textfield1.setLayoutX(positionX);
        textfield1.setLayoutY(positionY);
        textfield1.setId(style);
	    
        return textfield1;
	}
}
