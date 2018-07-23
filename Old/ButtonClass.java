package ctos;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class ButtonClass {
	 
    public static ArrayList<Button> revisionLogButtons(){       

        int screenWidth = ScreenResolutionClass.resolutionWidth();
        int screenHeight = ScreenResolutionClass.resolutionHeight();
        int fieldWidthAlignment = (int) ScreenResolutionClass.fieldWidthAlignment(screenWidth);
        int proportionalHeight = ScreenResolutionClass.propotionalHeight(screenHeight);
        double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
        double numberOfFields = 2.1;

        ArrayList<Button> buttons = new ArrayList<>();

        Button btnAddAField = button("Add A New Revision and Unlock the Dashboard", fieldWidthAlignment, (proportionalHeight * 1.5), "functionalButton" ,true);
        buttons.add(btnAddAField);

        Button btnSaveDraft = button("Save as PDF", fieldWidthAlignment*7, proportionalHeight*1.5, "functionalButton", true);
        buttons.add(btnSaveDraft);
        Button btnRelease = button("Revision", fieldWidthAlignment*8, proportionalHeight*1.5, "functionalButton", true);
        buttons.add(btnRelease);
        
        Button btnScope = button("Scope", fieldWidthAlignment*4, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnScope);
        Button btnTermsNorms = button("Terms/Norms", fieldWidthAlignment*5, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnTermsNorms);
        Button btnControlVolume = button("Control Volume", fieldWidthAlignment*6, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnControlVolume);
        Button btnSystemModels = button("System Models", fieldWidthAlignment*7, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnSystemModels);
        Button btnInterface = button("Interface", fieldWidthAlignment*8, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnInterface);
        Button btnDIP = button("DIP", fieldWidthAlignment*9, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnDIP);
        Button btnDIF = button("DIF", fieldWidthAlignment*10, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnDIF);
        Button btnDIL = button("DIL", fieldWidthAlignment*11, proportionalHeight*numberOfFields, "functionalButton", true);
        buttons.add(btnDIL);

        return buttons;
    }

    public static Button button(String text, double positionX, double positionY, String style, Boolean shadow) {

        Button button1 = new Button();
        button1.setText(text);
        button1.setLayoutX(positionX);
        button1.setLayoutY(positionY);
        button1.setId(style);

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