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
  	
}
