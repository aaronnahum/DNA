/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctos;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class ScreenResolutionClass {
    
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    public static Rectangle2D screenBounds() {
        return primaryScreenBounds;
    }
            
    public static int resolutionWidth() {	
	int screenWidth = (int) primaryScreenBounds.getWidth();
        return screenWidth;
    }
    
    public static int resolutionHeight() {
	int screenHeight = (int) primaryScreenBounds.getHeight();
        return screenHeight;
    }
    				
    public static int proportionalWidth(int screenWidth){
        int proportionalWidth = screenWidth/16;
        return proportionalWidth;
    }
    public static int propotionalHeight(int screenHeight){
        int proportionalHeight = screenHeight/10;
        return proportionalHeight;
    }
    public static double fieldWidthAlignment(int screenWidth){
        //double fieldWidthAlignment = screenWidth/10.5;
        double fieldWidthAlignment = screenWidth/16.5;
        return fieldWidthAlignment;
    }
}
