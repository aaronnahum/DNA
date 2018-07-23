package javafxapplication9;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * An application with a zoomable and pannable canvas.
 */
public class ZoomRevisionLog extends Application {
    
    Stage window;
    static Scene scene;
    static ScrollPane pane;
    public static double numberOfFields = 2.1;
    public static int StartAtOne = 1;
    
    static Group group;
    
    static Rectangle2D primaryScreenBounds = ScreenResolutionClass.screenBounds();
    
    
    public static void main(String[] args) {
        launch(args);
    }
    public static void trying(Stage stage){
        Group root = new Group();
        group = root;
        // create canvas
        PannableCanvas canvas = new PannableCanvas();

        // we don't want the canvas on the top/left in this example => just
        // translate it a bit
        canvas.setTranslateX(100);
        canvas.setTranslateY(100);

        // create sample nodes which can be dragged
        NodeGestures nodeGestures = new NodeGestures( canvas);

        
        ArrayList<Line> DrawingBorderLines = BorderClass.border1(); 
        for(int i=0; i < DrawingBorderLines.size(); i = i+1) {
            canvas.getChildren().add(DrawingBorderLines.get(i));  
        }        
        ArrayList<Button> buttons = ButtonClass.revisionLogButtons();
        for(int i = 0; i <buttons.size(); i++) {
            canvas.getChildren().add(buttons.get(i));
        }
        
 /**
        * Iterates through the arrayList of Labels
        * and adds them to the scene
        */
        ArrayList<Label> labels = LabelClass.revisionLogLabels();
        for(int i = 0; i < labels.size(); i++){
            canvas.getChildren().add(labels.get(i));
        }
        /**
        * Iterates through the arrayList of Border labels
        * and adds them to the scene
        */
        ArrayList<Label> borderLabels = LabelClass.borderLabels();
        for(int i = 0; i < borderLabels.size(); i++){
            canvas.getChildren().add(borderLabels.get(i));
        }
        /**
        * Iterates through the arrayList of textfields
        * and adds them to the scene
        */
        ArrayList<TextField> textfields = TextfieldClass.revisionLogTextFields();
        for(int i = 0; i < textfields.size(); i++){
            canvas.getChildren().add(textfields.get(i));
        }        
        
        Button txtOne = new Button();
        txtOne.setText("New Button 1");
        txtOne.setAlignment(Pos.CENTER);
        txtOne.setLayoutX(400);
        txtOne.setLayoutY(300);
        txtOne.setStyle("    -fx-background-color: \n" +
            "        linear-gradient(#fcc9ab 0%, #fcc9ab 25%, #fcc9ab 75%, #fcc9ab 100%);\n" +
            "\n" +
            "    -fx-text-fill: white;\n" +
            "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
            "    -fx-font-family: \"Arial\";\n" +
            "    -fx-text-fill: black;\n" +
            "    -fx-font-size: 12px;");
        txtOne.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtOne.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());
        
        Button txtTwo = new Button();
        txtTwo.setText("New Button 2");
        txtTwo.setAlignment(Pos.CENTER);
        txtTwo.setLayoutX(400);
        txtTwo.setLayoutY(350);
        txtTwo.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-size: 1.2em; \r\n" + 
				"    -fx-font-weight: bold;");
        txtTwo.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtTwo.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());
        

        
        Button txtThree = new Button();
        txtThree.setAlignment(Pos.CENTER);
        txtThree.setText("New Button 3");
        txtThree.setLayoutX(400);
        txtThree.setLayoutY(400);
        txtThree.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
        txtThree.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtThree.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());
        
        TextField txtThree1 = new TextField();
        txtThree1.setAlignment(Pos.CENTER);
        txtThree1.setText("Old textfield");
        txtThree1.setLayoutX(200);
        txtThree1.setLayoutY(300);
        txtThree1.setStyle("	-fx-background-color: #d4ffd4;\n" +
                "	-fx-padding: 5 10 5 10;");
        txtThree1.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtThree1.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());        
        
        Label txtThree12 = new Label();
        txtThree12.setAlignment(Pos.CENTER);
        txtThree12.setText("Old Label");
        txtThree12.setLayoutX(200);
        txtThree12.setLayoutY(350);
        txtThree12.setStyle("        -fx-background-color: #000000,\n" +
                "            linear-gradient(#f49541, #f49541),\n" +
                "            linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\n" +
                "        -fx-background-insets: 0,1,2;\n" +
                "        -fx-background-radius: 3,2,1;\n" +
                "        -fx-padding: 5 10 5 10;\n" +
                "        -fx-text-fill: black;\n" +
                "        -fx-font-size: 12px;\n" +
                "        -fx-font-weight: bold;");
        txtThree12.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtThree12.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());        
        
        Button txtThree123 = new Button();
        txtThree123.setAlignment(Pos.CENTER);
        txtThree123.setText("Old Button");
        txtThree123.setLayoutX(200);
        txtThree123.setLayoutY(400);
        txtThree123.setStyle("    -fx-background-color:#000000,\n" +
                "        linear-gradient(#FFDAB9, #FFDAB9), \n" +
                "        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%); \n" +
                "        -fx-background-insets: 0,1,2;\n" +
                "        -fx-background-radius: 3,2,1;\n" +
                "        -fx-padding: 5 10 5 10;\n" +
                "        -fx-text-fill: black;\n" +
                "        -fx-font-size: 12px;\n" +
                "        -fx-font-weight: bold;");
        txtThree123.addEventFilter( MouseEvent.MOUSE_PRESSED, nodeGestures.getOnMousePressedEventHandler());
        txtThree123.addEventFilter( MouseEvent.MOUSE_DRAGGED, nodeGestures.getOnMouseDraggedEventHandler());            
        
        
        canvas.getChildren().addAll(txtOne,txtTwo,txtThree,txtThree1,txtThree12,txtThree123);
        System.out.println(canvas);
        group.getChildren().add(canvas);

        // create scene which can be dragged and zoomed
        Scene scene = new Scene(group, ScreenResolutionClass.resolutionWidth(),ScreenResolutionClass.resolutionHeight());

        SceneGestures sceneGestures = new SceneGestures(canvas);
        scene.addEventFilter( MouseEvent.MOUSE_PRESSED, sceneGestures.getOnMousePressedEventHandler());
        scene.addEventFilter( MouseEvent.MOUSE_DRAGGED, sceneGestures.getOnMouseDraggedEventHandler());
        scene.addEventFilter( ScrollEvent.ANY, sceneGestures.getOnScrollEventHandler());

        stage.setScene(scene);
        stage.show();        
    }
    @Override
    public void start(Stage stage) {
        trying(stage);


        //canvas.addGrid();

    }
}
class PannableCanvas extends Pane {

    DoubleProperty myScale = new SimpleDoubleProperty(1.0);

    public PannableCanvas() {
        //setPrefSize(600, 600);
        //setStyle("-fx-background-color: yellow; -fx-border-color: blue;");

        // add scale transform
        scaleXProperty().bind(myScale);
        scaleYProperty().bind(myScale);
    }

    /**
     * Add a grid to the canvas, send it to back
     */
    public void addGrid() {

        double w = getBoundsInLocal().getWidth();
        double h = getBoundsInLocal().getHeight();

        // add grid
        Canvas grid = new Canvas(w, h);

        // don't catch mouse events
        grid.setMouseTransparent(true);

        GraphicsContext gc = grid.getGraphicsContext2D();

        gc.setStroke(Color.GRAY);
        gc.setLineWidth(1);

        // draw grid lines
        double offset = 50;
        for( double i=offset; i < w; i+=offset) {
            gc.strokeLine( i, 0, i, h);
            gc.strokeLine( 0, i, w, i);
        }

        getChildren().add( grid);

        grid.toBack();
    }

    public double getScale() {
        return myScale.get();
    }

    public void setScale( double scale) {
        myScale.set(scale);
    }

    public void setPivot( double x, double y) {
        setTranslateX(getTranslateX()-x);
        setTranslateY(getTranslateY()-y);
    }
}


/**
 * Mouse drag context used for scene and nodes.
 */
class DragContext {

    double mouseAnchorX;
    double mouseAnchorY;

    double translateAnchorX;
    double translateAnchorY;

}

/**
 * Listeners for making the nodes draggable via left mouse button. Considers if parent is zoomed.
 */
class NodeGestures {

    private DragContext nodeDragContext = new DragContext();

    PannableCanvas canvas;

    public NodeGestures( PannableCanvas canvas) {
        this.canvas = canvas;

    }

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return onMousePressedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseDraggedEventHandler() {
        return onMouseDraggedEventHandler;
    }

    private EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            // left mouse button => dragging
            if( !event.isPrimaryButtonDown())
                return;

            nodeDragContext.mouseAnchorX = event.getSceneX();
            nodeDragContext.mouseAnchorY = event.getSceneY();

            Node node = (Node) event.getSource();

            nodeDragContext.translateAnchorX = node.getTranslateX();
            nodeDragContext.translateAnchorY = node.getTranslateY();

        }

    };

    private EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {

            // left mouse button => dragging
            if( !event.isPrimaryButtonDown())
                return;

            double scale = canvas.getScale();

            Node node = (Node) event.getSource();

            node.setTranslateX(nodeDragContext.translateAnchorX + (( event.getSceneX() - nodeDragContext.mouseAnchorX) / scale));
            node.setTranslateY(nodeDragContext.translateAnchorY + (( event.getSceneY() - nodeDragContext.mouseAnchorY) / scale));

            event.consume();

        }
    };
}

/**
 * Listeners for making the scene's canvas draggable and zoomable
 */
class SceneGestures {

    private static final double MAX_SCALE = 5.0d;
    private static final double MIN_SCALE = 0.66d;

    private DragContext sceneDragContext = new DragContext();

    PannableCanvas canvas;

    public SceneGestures( PannableCanvas canvas) {
        this.canvas = canvas;
    }

    public EventHandler<MouseEvent> getOnMousePressedEventHandler() {
        return onMousePressedEventHandler;
    }

    public EventHandler<MouseEvent> getOnMouseDraggedEventHandler() {
        return onMouseDraggedEventHandler;
    }

    public EventHandler<ScrollEvent> getOnScrollEventHandler() {
        return onScrollEventHandler;
    }

    private EventHandler<MouseEvent> onMousePressedEventHandler = new EventHandler<MouseEvent>() {

        public void handle(MouseEvent event) {

            // right mouse button => panning
            if( !event.isSecondaryButtonDown())
                return;

            sceneDragContext.mouseAnchorX = event.getSceneX();
            sceneDragContext.mouseAnchorY = event.getSceneY();

            sceneDragContext.translateAnchorX = canvas.getTranslateX();
            sceneDragContext.translateAnchorY = canvas.getTranslateY();

        }

    };

    private EventHandler<MouseEvent> onMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {

            // right mouse button => panning
            if( !event.isSecondaryButtonDown())
                return;

            canvas.setTranslateX(sceneDragContext.translateAnchorX + event.getSceneX() - sceneDragContext.mouseAnchorX);
            canvas.setTranslateY(sceneDragContext.translateAnchorY + event.getSceneY() - sceneDragContext.mouseAnchorY);

            event.consume();
        }
    };

    /**
     * Mouse wheel handler: zoom to pivot point
     */
    private EventHandler<ScrollEvent> onScrollEventHandler = new EventHandler<ScrollEvent>() {

        @Override
        public void handle(ScrollEvent event) {

            double delta = 1.2;

            double scale = canvas.getScale(); // currently we only use Y, same value is used for X
            double oldScale = scale;

            if (event.getDeltaY() < 0)
                scale /= delta;
            else
                scale *= delta;

            scale = clamp( scale, MIN_SCALE, MAX_SCALE);

            double f = (scale / oldScale)-1;

            double dx = (event.getSceneX() - (canvas.getBoundsInParent().getWidth()/2 + canvas.getBoundsInParent().getMinX()));
            double dy = (event.getSceneY() - (canvas.getBoundsInParent().getHeight()/2 + canvas.getBoundsInParent().getMinY()));

            canvas.setScale( scale);

            // note: pivot value must be untransformed, i. e. without scaling
            canvas.setPivot(f*dx, f*dy);

            event.consume();

        }

    };


    public static double clamp( double value, double min, double max) {

        if( Double.compare(value, min) < 0)
            return min;

        if( Double.compare(value, max) > 0)
            return max;

        return value;
    }
}


