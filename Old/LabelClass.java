
package ctos;

import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.geometry.Pos;

public class LabelClass {
    
    static int screenWidth = ScreenResolutionClass.resolutionWidth();
    static int screenHeight = ScreenResolutionClass.resolutionHeight();
    static int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
    static int proportionalHeight = ScreenResolutionClass.propotionalHeight(screenHeight);
    double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
    static double numberOfFields = 2.1;
    
    public static ArrayList<Label> revisionLogLabels(){
        
        ArrayList<Label> labels = new ArrayList<>();
		
        Label lblRevision = label("Revision", 100, 25, fieldWidthAlignment, (proportionalHeight*numberOfFields), "label");
        labels.add(lblRevision);
        Label lblDate = label("Date", 100, 25, fieldWidthAlignment*2, proportionalHeight*numberOfFields, "label");
        labels.add(lblDate);
        Label lblDescription = label("Description", 100, 25, fieldWidthAlignment*3, proportionalHeight*numberOfFields, "label");
        labels.add(lblDescription);  
        Label lblCode = label("Code", 100, 25, fieldWidthAlignment*5, proportionalHeight*1.5, "label");
        labels.add(lblCode);
        
        return labels;
    }
    
    public static ArrayList<Label> borderLabels() {
        
        ArrayList<Label> labels = new ArrayList<>();
        
        Label lblRevisionControl = label("REVISION CONTROL", 175, 30, 100, proportionalHeight*0.625, "revisionControl");
        labels.add(lblRevisionControl);
        Label lblProjectID = label("123456789012345678901234567890", 250, 30, fieldWidthAlignment*6, proportionalHeight*0.625, "otherBorder");
        labels.add(lblProjectID);
        Label lblRevisionNum = label("R1", 75, 30, fieldWidthAlignment*7+90, proportionalHeight*0.625, "otherBorder");
        labels.add(lblRevisionNum);
        Label lblDateBorder = label("YY-MM-DD", 75, 30, fieldWidthAlignment*8, proportionalHeight*0.625, "otherBorder");
        labels.add(lblDateBorder);
        Label lblPageNum = label("Page 1 of 1", 75, 30, fieldWidthAlignment*9+50, proportionalHeight*0.625, "otherBorder");
        labels.add(lblPageNum);
        
        return labels;
    }
    
    public static Label label(String text, int boxWidth, int boxHeight, int x, double y, String style) {
       
        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(boxWidth);
        label1.setMinHeight(boxHeight);
        label1.setLayoutX(x);
        label1.setLayoutY(y);
        label1.setId(style);
                
        return label1;
    } 	
}
