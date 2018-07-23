package javafxapplication9;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
/**
 * 
 * Holds the variables to do with the screen resolution
 * 
 * @author Aaron/Nic
 */
public class ScreenResolutionClass {
    
    /**
     * Gets the visual bounds of the users primary screen
     */
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    
    public static Rectangle2D screenBounds() {
        return primaryScreenBounds;
    }
    /**
     * Uses the screen Bounds to get the width of the screen
     * @return The width of the screen.
     */        
    public static int resolutionWidth() {	
	int screenWidth = (int) primaryScreenBounds.getWidth();
        System.out.println(screenWidth);
        return screenWidth;
    }
    /**
     * Uses the screen Bounds to get the height of the screen.
     * @return The height of the screen.
     */
    public static int resolutionHeight() {
	int screenHeight = (int) primaryScreenBounds.getHeight();
        return screenHeight;
    }
    /**
     * A variable made to place objects on the screen using an equal division of 16.
     * @param screenWidth The width of the screen
     * @return The proportional Width
     */		
    public static int proportionalWidth(int screenWidth){
        int proportionalWidth = screenWidth/16;
        return proportionalWidth;
    }
    /**
     * A variable made to place objects vertically on the screen using an equal division of 10.
     * @param screenHeight The height of the screen.
     * @return The proportionalHeight
     */
    public static int proportionalHeight(int screenHeight){
        int proportionalHeight = screenHeight/10;
        return proportionalHeight;
    }
    /**
     * A variable used when there are many objects on the screen
     * @param screenWidth The width of the screen
     * @return FieldWidthAlignment.
     */
    public static double fieldWidthAlignment(int screenWidth){
        double fieldWidthAlignment = screenWidth/45;
        return fieldWidthAlignment;
    }

                
}
