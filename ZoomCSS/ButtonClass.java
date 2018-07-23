/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication9;



import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.print.PrintException;

public class ButtonClass {
    
    /**
     * 
     * @return This returns an array list which contains all of the buttons that are a part of the revision log screen
     */
    public static ArrayList<Button> revisionLogButtons(){       

        int screenWidth = ScreenResolutionClass.resolutionWidth();
        int screenHeight = ScreenResolutionClass.resolutionHeight();
        int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
        int proportionalHeight = ScreenResolutionClass.proportionalHeight(screenHeight);
        double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
        double numberOfFields = 2.5;
        
        double scale = 1.3;  
        
        ArrayList<Button> buttons = new ArrayList<>();

        Button btnAddAField = button("Add A New Revision and Unlock the Dashboard", fieldWidthAlignment *4, (proportionalHeight * 1.75), "functionalButtonBiggerText", true, "Adds a New Revision Line");
        btnAddAField.setOnAction(e -> {
            ArrayList<TextField> newField = TextfieldClass.revisionLogAddAField(0);
            for(int i = 0; i < newField.size(); i++)
                ZoomRevisionLog.group.getChildren().add(newField.get(i));
        });
        buttons.add(btnAddAField);
        
        Button btnPrint = button("Print", 120, (screenHeight-75), "functionalButtonBiggerText" ,true, "Print the Current Page");

        buttons.add(btnPrint);
        Button btnDashboard = button("Dashboard", 220, (screenHeight-75), "functionalButtonBiggerText", true, "Redirects to the Dashboard Page");
        buttons.add(btnDashboard);
        Button btnProjectRegistration = button("New Project Registration", 350, (screenHeight-75), "functionalButtonBiggerText" ,true);
        buttons.add(btnProjectRegistration);        
//        Button btnHelp = button("Help", screenWidth-180, (screenHeight -75), "functionalButtonBiggerText" ,true);
//        btnHelp.setOnAction(e -> Help.help());
//        buttons.add(btnHelp);
        
        
        
        
        Button btnSaveDraft = button("Save as PDF", proportionalWidth*7.5, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Save as PDF");

        buttons.add(btnSaveDraft);
        Button btnRelease = button("Release", proportionalWidth*9.25, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Releases the Revision");

        buttons.add(btnRelease);
        Button btnRequestToLead = button("Request Lead To Open New Revision", proportionalWidth*11.0, proportionalHeight*1.75, "functionalButtonBiggerText", true);
        //btnRequestToLead.setOnAction(e -> EmailClass.Email("dsppracticeemail@gmail.com", "Kepstrum2005", "Testing Subject", "Dear Lead, \n\nAssociate #1 would like you to open up a new revision\n\nAssociate #1.", "15nw2@queensu.ca"));
        buttons.add(btnRequestToLead);
        
        Button btnScope = button("Scope", fieldWidthAlignment*6, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Scope Page");
        buttons.add(btnScope);
        Button btnTermsNorms = button("Terms/Norms", fieldWidthAlignment*8, proportionalHeight*(numberOfFields)-15, "functionalButton", true, 55*scale, "Redirects to Terms/Norms Page");
        buttons.add(btnTermsNorms);
        System.out.println("THE SCALE IS" + scale);
        Button btnControlVolume = button("Control Volume", fieldWidthAlignment*10, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to Control Volume Page");
        buttons.add(btnControlVolume);
        Button btnSystemModels = button("System Models", fieldWidthAlignment*12, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to System Models Page");
        buttons.add(btnSystemModels);
        Button btnInterface = button("Interface", fieldWidthAlignment*14, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Interface Page");
        buttons.add(btnInterface);
        Button btnDIP = button("DIP", fieldWidthAlignment*16, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIP Page");
        buttons.add(btnDIP);
        Button btnDIF = button("DIF", fieldWidthAlignment*17, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIF Page");
        buttons.add(btnDIF);
        Button btnDIL = button("DIL", fieldWidthAlignment*18, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIL Page");
        buttons.add(btnDIL);
        Button btnKPFs = button("KPFs", fieldWidthAlignment*19, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to KPFs Page");
        buttons.add(btnKPFs);
        Button btnDIPVerification = button("DIP Verification", fieldWidthAlignment*21, proportionalHeight*numberOfFields-15, "functionalButton", true, 80*scale, "Redirects to DIP Verification Page");
        buttons.add(btnDIPVerification);
        Button btnDNAGenerator = button("DNA Generator", fieldWidthAlignment*24, proportionalHeight*numberOfFields-15, "functionalButton", true, 75*scale, "Redirects to DNA Generator Page");
        buttons.add(btnDNAGenerator);
        Button btnDNALibrary = button("DNA Library", fieldWidthAlignment*27, proportionalHeight*numberOfFields, "functionalButton", true, 90*scale, "Redirects to DNA Library Page");
        buttons.add(btnDNALibrary);
        
//        Button btnImportImage = button("Import Image", fieldWidthAlignment*31, proportionalHeight*numberOfFields, "functionalButton", true, "Import an Image to the Program");
//        btnImportImage.setOnAction(e -> {
//            final FileChooser fileChooser = new FileChooser();
//            fileChooser.setTitle("Import Image");
//            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//            fileChooser.getExtensionFilters().addAll(
//                new FileChooser.ExtensionFilter("All Image Files (*.jpg; *.png)", "*.jpg", "*.png"),
//                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//                new FileChooser.ExtensionFilter("PNG", "*.png"));
//            File file = fileChooser.showOpenDialog(DSP.window);
//            if (file != null) {
//                Image image = new Image(file.toURI().toString(), 100, 150, true, true);
//                ImageView imageView = new ImageView(image);
//                imageView.setFitWidth(100);
//                imageView.setFitHeight(150);
//                imageView.setPreserveRatio(true);
//                
//                RevisionLog.group.getChildren().add(imageView);
//            }
//        });
//        buttons.add(btnImportImage);
        
        return buttons;
    }
    
    /**
     * 
     * @param text The text on the button
     * @param positionX The position of the button on the x-axis
     * @param positionY The position of the button on the y-axis
     * @param style The CSS style for the button
     * @param shadow Determines if there is a shadow when the mouse is over the button
     * @param wrap The max width of the button (used for wrapping the text)
     * @return This returns a button
     */
    public static Button button(String text, double positionX, double positionY, String style, Boolean shadow, double wrap) {

        Button button1 = new Button();
        button1.setText(text);
        button1.setLayoutX(positionX);
        button1.setLayoutY(positionY);
        button1.setId(style);
        button1.setAlignment(Pos.BOTTOM_CENTER);

        if(shadow == true) {
            DropShadow shadowDrop = new DropShadow();
            // Adding the shadow when the mouse cursor is on
            button1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                button1.setEffect(shadowDrop);
            });
            //Removing the shadow when the mouse cursor is off
            button1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                button1.setEffect(null);
            });
        }
        button1.setMaxWidth(wrap);
        button1.setWrapText(true);
        
     
        return button1;
    }
    
    public static Button button(String text, double positionX, double positionY, String style, Boolean shadow, double wrap, String tip) {

        Button button1 = new Button();
        button1.setText(text);
        button1.setLayoutX(positionX);
        button1.setLayoutY(positionY);
        button1.setId(style);
        button1.setAlignment(Pos.BOTTOM_CENTER);

        if(shadow == true) {
            DropShadow shadowDrop = new DropShadow();
            // Adding the shadow when the mouse cursor is on
            button1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                button1.setEffect(shadowDrop);
            });
            //Removing the shadow when the mouse cursor is off
            button1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                button1.setEffect(null);
            });
        }
        button1.setMaxWidth(wrap);
        button1.setWrapText(true);
        button1.setTooltip(new Tooltip(tip));
        
     
        return button1;
    }
        
        /**
         * 
         * @param text The text on the button
         * @param positionX The position of the button on the x-axis
         * @param positionY The position of the button on the y-axis
         * @param style The CSS style for the button
         * @param shadow Determines if there is a shadow when the mouse is over the button
         * @return This returns a button
         */
        public static Button button(String text, double positionX, double positionY, String style, Boolean shadow) {

        Button button1 = new Button();
        button1.setText(text);
        button1.setLayoutX(positionX);
        button1.setLayoutY(positionY);
        button1.setId(style);
        button1.setAlignment(Pos.CENTER);

        if(shadow == true) {
            DropShadow shadowDrop = new DropShadow();
            // Adding the shadow when the mouse cursor is on
            button1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                button1.setEffect(shadowDrop);
            });
            //Removing the shadow when the mouse cursor is off
            button1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                button1.setEffect(null);
            });
        }
        return button1;
        }
        
        public static Button button(String text, double positionX, double positionY, String style, Boolean shadow, String tipText ){

        Button button1 = new Button();
        button1.setText(text);
        button1.setLayoutX(positionX);
        button1.setLayoutY(positionY);
        button1.setId(style);
        button1.setAlignment(Pos.CENTER);
        Tooltip tip = new Tooltip();
        tip.setText(tipText);
        tip.setId("tooltip");
        button1.setTooltip(tip);

        if(shadow == true) {
            DropShadow shadowDrop = new DropShadow();
            // Adding the shadow when the mouse cursor is on
            button1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                button1.setEffect(shadowDrop);
            });
            //Removing the shadow when the mouse cursor is off
            button1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                button1.setEffect(null);
            });
        }
        return button1;
        }
        
}