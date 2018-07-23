package DSP;

import com.itextpdf.text.BadElementException;
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

/**
 * 
 * @author Aaron and Nic
 * Overloading Button Class that can be called to build all sorts of Buttons
 *
 */
public class ButtonClass {
    
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
    /**
     * 
     * @param text The text on the button
     * @param positionX The position of the button on the x-axis
     * @param positionY The position of the button on the y-axis
     * @param style The CSS style for the button
     * @param shadow Determines if there is a shadow when the mouse is over the button
     * @param wrap The max width of the button (used for wrapping the text)
     * @param a tool tip help option
     * @return This returns a button
     */
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