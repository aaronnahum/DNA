/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctos;

import java.util.ArrayList;
import javafx.scene.control.Label;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *  
 * A border class that has different border objects
 * 
 */
public class BorderClass{
	
    public static Line LineBlackNoFill(double x1, int y1, double x2, int y2) {

        Line line = new Line(x1, y1, x2, y2); 
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1.0); 
        line.getStrokeDashArray().addAll(10.0,0.0,10.0,0.0);

        return line;
    }
  
    public static ArrayList<Line> border1() {

        ArrayList<Line> borderLines = new ArrayList<>();

        int screenWidth = ScreenResolutionClass.resolutionWidth();
        int screenHeight = ScreenResolutionClass.resolutionHeight();
        int proportionalHeight = ScreenResolutionClass.propotionalHeight(screenHeight);
        double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
      
        Line line1 = LineBlackNoFill(60,60,60,screenHeight-80);
        borderLines.add(line1);

        Line line2 = LineBlackNoFill(60,60,screenWidth-60,60);
        borderLines.add(line2);              

        Line line3 = LineBlackNoFill(screenWidth-60,60,screenWidth-60,screenHeight-80);
        borderLines.add(line3);

        Line line4 = LineBlackNoFill(60, proportionalHeight, (screenWidth-60), proportionalHeight);
        borderLines.add(line4);

//        Line line5 = LineBlackNoFill((proportionalWidth*2.5), proportionalHeight, (proportionalWidth*2.5), 60);
//        borderLines.add(line5);

//        Line line6 = LineBlackNoFill ((screenWidth-(proportionalWidth*2.5)), proportionalHeight, (screenWidth-(proportionalWidth*2.5)), 60);
//        borderLines.add(line6);
//
        Line line = LineBlackNoFill(screenWidth-60, screenHeight-80, 60, screenHeight-80);
        borderLines.add(line);

        return borderLines;
    }
    
    
    public static void borderLabels() {
        Label lblRevisionControl = LabelClass.label("Revision Control", 100, 25, 60, 60, "label");
    }
	
}
