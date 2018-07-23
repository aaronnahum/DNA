package DSP;

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
    /**
     * 
     * @param text The text on the label.
     * @param boxWidth The width of the label
     * @param boxHeight The height of the label
     * @param x The x position of the label
     * @param y The y position of the label
     * @param style The style used for this certain label
     * @param tip Tool tip used for Help
     * @return Returns a label
     */
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
     * @param x The x position of the label
     * @param y The y position of the label
     * @param style The style used for this certain label
     * @param tip Tool tip used for Help
     * @return Returns a label
     */
    public static Label label(String text, int boxWidth, int boxHeight, double x, double y, String style, String tip) {
        
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
