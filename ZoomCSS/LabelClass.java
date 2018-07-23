/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;

import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

/**
 * Creates labels used on pages
 * @author Aaron and Nic
 */
public class LabelClass {
    /**
     * Creates static variables need to create specific labels
     * Another and easier way to do this is do initalize and declare in
     * revision log and send through as a parameter
     */
    static int screenWidth = ScreenResolutionClass.resolutionWidth();
    static int screenHeight = ScreenResolutionClass.resolutionHeight();
    static int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
    static int proportionalHeight = ScreenResolutionClass.proportionalHeight(screenHeight);
    static int proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
    static double numberOfFields = 2.5;
    
    /**
     * Labels used in revision Log
     * @return an ArrayList of labels
     */
    public static ArrayList<Label> revisionLogLabels(){
        
        ArrayList<Label> labels = new ArrayList<>();
		
        Label lblRevision = label("Revision", 55, 15, fieldWidthAlignment*2, proportionalHeight *numberOfFields, "label", "Revision Number of Test");
        labels.add(lblRevision);
        Label lblDate = label("Date", 40, 15, fieldWidthAlignment *4, proportionalHeight *numberOfFields, "label", "The Date the Test Took Place");
        labels.add(lblDate);
        Label lblDescription = label("Description", 75, 15, fieldWidthAlignment*45, proportionalHeight *numberOfFields, "label", "A Brief Description of the Associated Revision");
        //labels.add(lblDescription);
        Label lblCode = label("Release Code", 100, 15, proportionalWidth*5, proportionalHeight *1.25, "labelBiggerText", "The Code to Release the Revision");
        labels.add(lblCode);
        
        return labels;
    }
    
    /**
     * Labels used in the border
     * @return An arrayList of labels
     */
    public static ArrayList<Label> borderLabels() {
        ArrayList<Label> labels = new ArrayList<>();
        
        Label lblRevisionControl = label("REVISION CONTROL", 175, 15, 60, 30, "revisionControl", "The Current Menu");
        labels.add(lblRevisionControl);
        Label lblProjectID = label("123456789012345678901234567890", 250, 15, proportionalWidth*6, 30, "otherBorder", "Project ID");
        labels.add(lblProjectID);
        Label lblRevisionNum = label("R1", 75, 15, proportionalWidth*10, 30, "otherBorder", "Revision Number");
        labels.add(lblRevisionNum);
        Label lblDateBorder = label("YY-MM-DD", 75, 15, proportionalWidth*12, 30, "otherBorder", "Current Date");
        labels.add(lblDateBorder);
        Label lblPageNum = label("Page 1 of 1", 75, 15, proportionalWidth*14, 30, "otherBorder", "Page Number");
        labels.add(lblPageNum);
        
        return labels;
    }
    
    /**
     * 
     * @param text The text on the label.
     * @param boxWidth The width of the label
     * @param boxHeight The height of the label
     * @param x The x position of the label
     * @param y The y position of the label
     * @param style The style used for this certain label
     * @return Returns a label
     */
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
    
    public static Label label(String text, int boxWidth, int boxHeight, int x, double y, String style, String tip) {
       
        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(boxWidth);
        label1.setMinHeight(boxHeight);
        label1.setLayoutX(x);
        label1.setLayoutY(y);
        label1.setId(style);
        label1.setTooltip(new Tooltip(tip));
                
        return label1;
    }
    
        /**
         * 
         * @param text The text on the label.
         * @param boxWidth The width of the label
         * @param boxHeight The height of the label
         * @param style The style used for this certain label
         * @param def The definition of the label
         * @return Returns a label
     */
    public static Label label(String text, int boxWidth, int boxHeight, String style, Label def) {
        DropShadow shadowDrop = new DropShadow();
        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(boxWidth);
        label1.setMinHeight(boxHeight);
        label1.setId(style);
        /**
         * On and off mouse definition functionality
         */
        label1.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
            def.setVisible(true);
            label1.setEffect(shadowDrop);
        });
        label1.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
            def.setVisible(false);
            label1.setEffect(null);
        });        
        return label1;
    }
    /**
     * 
     * @param text The text on the label.
     * @param boxWidth The width of the label
     * @param boxHeight The height of the label
     * @param style The style used for this certain label
     * @return Returns a label
     */
    public static Label label(String text, int boxWidth, int boxHeight, String style) {

        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setMinWidth(boxWidth);
        label1.setMinHeight(boxHeight);
        label1.setId(style);
       
        return label1;
    }
        /**
     * 
     * @param text The text on the label.
     * @param style The style used for this certain label
     * @return Returns a label
     */
    public static Label label(String text, String style) {
       
        Label label1 = new Label();
        label1.setText(text);
        label1.setAlignment(Pos.CENTER);
        label1.setId(style);
                
        return label1;
    }
}
