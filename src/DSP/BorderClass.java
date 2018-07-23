package DSP;

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
    
    /**
     * takes in the x,y,x1,y1 coordinates in pixels of a specific line 
    * and returns the line
     * @param x1 The starting point on the x-axis
     * @param y1 The starting point on the y-axis
     * @param x2 The ending point on the x-axis
     * @param y2 The ending point on the y-axis
     * @return This returns a black line with the given coordinates from the parameters
     */
    public static Line LineBlackNoFill(double x1, int y1, double x2, int y2) {

        Line line = new Line(x1, y1, x2, y2); 
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1.0); 
        line.getStrokeDashArray().addAll(10.0,0.0,10.0,0.0);

        return line;
    }
    /**
     * 
     * @return This returns an array list containing the lines to create the boarder of the screen
     */
    public static ArrayList<Line> border1() {

        ArrayList<Line> borderLines = new ArrayList<>();

        int screenWidth = ScreenResolutionClass.resolutionWidth();
        int screenHeight = ScreenResolutionClass.resolutionHeight();
        int proportionalHeight = ScreenResolutionClass.proportionalHeight(screenHeight);
        double proportionalWidth = ScreenResolutionClass.proportionalWidth(screenWidth);
      
        int screenProportionHeightby25 = screenHeight/25;   
        
  //      Line line1 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25,screenProportionHeightby25,screenHeight-80);
//        borderLines.add(line1);
        Line line11 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenProportionHeightby25,screenHeight-80);
        borderLines.add(line11);
        System.out.println("SCREEN BY 25:" + screenProportionHeightby25 );

        Line line2 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenProportionHeightby25+40);
        borderLines.add(line2);              

        Line line3 = LineBlackNoFill(screenWidth-screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenHeight-80);
        borderLines.add(line3);

        //Line line4 = LineBlackNoFill(screenProportionHeightby25, proportionalHeight, (screenWidth-screenProportionHeightby25), proportionalHeight);
        //borderLines.add(line4);

        Line line = LineBlackNoFill(screenWidth-screenProportionHeightby25, screenHeight-80, screenProportionHeightby25, screenHeight-80);
        borderLines.add(line);



        return borderLines;
    }
    
    /**
     * 
     */
    public static void borderLabels() {
        Label lblRevisionControl = LabelClass.label("Revision Control", 100, 25, 60, 60, "label");
    }
	
}
