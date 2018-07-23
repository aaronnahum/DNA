/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class TextfieldClass {
    static int screenWidth = ScreenResolutionClass.resolutionWidth();
    static int screenHeight = ScreenResolutionClass.resolutionHeight();
    static int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
    static int proportionalHeight = ScreenResolutionClass.proportionalHeight(screenHeight);
    static double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
    static double numberOfFields = 2.5;
    static double halfPlusNumberOfFields = 2.875;
    /**
     * 
     * @return This returns an array list with the text fields belonging to the revision log page
     */
    public static ArrayList<TextField> revisionLogTextFields(){
        
        ArrayList<TextField> textfields = new ArrayList<>();
        
        TextField txtCode = textfield("Code",120, true, proportionalWidth*7.25, proportionalHeight*1.25, "textFieldBiggerText");
        textfields.add(txtCode);    

        return textfields;
    }
    public static ArrayList<TextArea> textArea(){
        ArrayList<TextArea> textareas = new ArrayList<>();
        TextArea txtAREA= textarea("Text Area",300,500,500,"textField");
        //textareas.add(txtAREA);
        return textareas;
    }
    
    /**
     * 
     * @param countPDF Taken from the database for each revision. It's used to check if that revision has been saved as a PDF yet
     * @return This returns an array list containing all the fields for a revision. These fields will be immutable if the revision has been saved as a PDF
     */
    public static ArrayList<TextField> revisionLogAddAField(int countPDF){
        ArrayList<TextField> AddAFieldTextFields = new ArrayList<>();
        
        if(numberOfFields <= 7.0) {
            numberOfFields += 0.75;
            halfPlusNumberOfFields += 0.75;
            
            if (countPDF == 1){
                TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "disabledTextField");
                AddAFieldTextFields.add(txtDescription);
                TextField txtRevision = textfield("R1234", 55, false, fieldWidthAlignment * 2, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtRevision);
                TextField txtDate = textfield("YY-MM-DD",70,false, fieldWidthAlignment * 4, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDate);
                TextField txtScope = textfield("123", 50,false,fieldWidthAlignment * 6, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtScope);
                TextField txtTermsNorms = textfield("123", 50,false,fieldWidthAlignment * 8, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtTermsNorms);
                TextField txtControlVolume = textfield("123", 50,false,fieldWidthAlignment * 10, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtControlVolume);
                TextField txtSystemModels = textfield("123", 50,false,fieldWidthAlignment * 12, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtSystemModels);
                TextField txtInterface = textfield("123",50, false,fieldWidthAlignment * 14, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtInterface);
                TextField txtDIP = textfield("123",30, false,fieldWidthAlignment * 16, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIP);
                TextField txtDIF = textfield("123", 30,false,fieldWidthAlignment * 17, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIF);
                TextField txtDIL = textfield("123",30, false,fieldWidthAlignment * 18, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIL);
                TextField txtKPFs = textfield("123",30, false,fieldWidthAlignment * 19, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtKPFs);
                TextField txtDIPVerification = textfield("123", 50,false,fieldWidthAlignment * 21, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDIPVerification);
                TextField txtDNAGenerator = textfield("123",50, false,fieldWidthAlignment * 24, proportionalHeight*numberOfFields, "disabledTextField");
                AddAFieldTextFields.add(txtDNAGenerator);
                TextField txtDNALibrary = textfield("123", 50,false,fieldWidthAlignment * 27, proportionalHeight*numberOfFields, "disabledTextField");

                AddAFieldTextFields.add(txtDNALibrary); 
            }
            else{
                TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "textField");
                AddAFieldTextFields.add(txtDescription);                
                TextField txtRevision = textfield("R1234", 55, true, fieldWidthAlignment * 2, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtRevision);
                TextField txtDate = textfield("YY-MM-DD",70,true, fieldWidthAlignment * 4, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDate);
                TextField txtScope = textfield("123", 50,true,fieldWidthAlignment * 6, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtScope);
                TextField txtTermsNorms = textfield("123", 50,true,fieldWidthAlignment * 8, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtTermsNorms);
                TextField txtControlVolume = textfield("123", 50,true,fieldWidthAlignment * 10, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtControlVolume);
                TextField txtSystemModels = textfield("123", 50,true,fieldWidthAlignment * 12, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtSystemModels);
                TextField txtInterface = textfield("123",50, true,fieldWidthAlignment * 14, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtInterface);
                TextField txtDIP = textfield("123",30, true,fieldWidthAlignment * 16, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIP);
                TextField txtDIF = textfield("123", 30,true,fieldWidthAlignment * 17, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIF);
                TextField txtDIL = textfield("123",30, true,fieldWidthAlignment * 18, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIL);
                TextField txtKPFs = textfield("123",30, true,fieldWidthAlignment * 19, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtKPFs);
                TextField txtDIPVerification = textfield("123", 50,true,fieldWidthAlignment * 21, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDIPVerification);
                TextField txtDNAGenerator = textfield("123",50,true, fieldWidthAlignment * 24, proportionalHeight*numberOfFields, "textField");
                AddAFieldTextFields.add(txtDNAGenerator);
                TextField txtDNALibrary = textfield("123", 50,true,fieldWidthAlignment * 27, proportionalHeight*numberOfFields, "textField");

                AddAFieldTextFields.add(txtDNALibrary);                 
                

            }

        }
        
        return AddAFieldTextFields;
    }
    
    /**
     * 
     * @param text The prompt text set in the text field
     * @param textWidth The width of the text field
     * @param booll Determines if the text field is editable
     * @param positionX The position of the text field on the x-axis
     * @param positionY The position of the text field on the y-axis
     * @param style The CSS style associated with the text field
     * @return This returns a text field
     */
    public static TextField textfield(String text, int textWidth, Boolean booll, double positionX, double positionY, String style) {
	TextField textfield1 = new TextField();
        textfield1.setPromptText(text);
        textfield1.setAlignment(Pos.CENTER);
        textfield1.setPrefWidth(textWidth);
        textfield1.setEditable(booll);
       // eventually might need to add prefHeight
        textfield1.setLayoutX(positionX);
        textfield1.setLayoutY(positionY);
        textfield1.setId(style);
	    
        return textfield1;
    }
    
    /**
     * 
     * @param text The prompt text set in the text area
     * @param textWidth The width of the text area
     * @param positionX The position of the text area on the x-axis
     * @param positionY The position of the text area on the y-axis
     * @param style The CSS style associated with the text area
     * @return This returns a text area
     */
    public static TextArea textarea(String text, int textWidth, int positionX, double positionY, String style){
        
        TextArea textarea1 = new TextArea();
        
        textarea1.setPromptText(text);
        textarea1.setPrefWidth(textWidth);
        textarea1.setLayoutX(positionX);
        textarea1.setLayoutY(positionY);
        textarea1.setId(style);
        
        
        return textarea1;
    }
}
