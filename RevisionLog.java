package DSP;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.print.PrintException;

import com.itextpdf.text.BadElementException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;

public class RevisionLog{
    	
    Stage window;
    static Scene scene;
    static ScrollPane pane;
    public static double numberOfFields = 2.5;
    public static int StartAtOne = 1;
    
    static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    static int screenWidth = (int) primaryScreenBounds.getWidth();
    static int screenHeight = (int) primaryScreenBounds.getHeight();
    static int fieldWidthAlignment = screenWidth/45;
    static int proportionalHeight = screenHeight/10;
    static double proportionalWidth = screenWidth/16;
    static double numberOfFields1 = 2.5;
    static double halfPlusNumberOfFields = 2.875;
    static double scale = DSP.scale;        
    static Group group;
    
    
    public static void revisionLogScene(Stage stage) throws ClassNotFoundException{
        ScrollPane pane = new ScrollPane();

        Group root = new Group();
        group = root;
        /**
         * 
         * ALL LINES FOR REVISION LOG PAGE
         * 
         */

        int screenProportionHeightby25 = screenHeight/25;   

        Line line11 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenProportionHeightby25,screenHeight-80);

        System.out.println("SCREEN BY 25:" + screenProportionHeightby25 );

        Line line2 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenProportionHeightby25+40);
            

        Line line3 = LineBlackNoFill(screenWidth-screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenHeight-80);
       
        Line line = LineBlackNoFill(screenWidth-screenProportionHeightby25, screenHeight-80, screenProportionHeightby25, screenHeight-80);

        root.getChildren().addAll(line11,line2,line3,line);


        /**
         * ALL BUTTONS FOR REVISION LOG PAGE
         */
        Button btnAddAField = button("Add A New Revision and Unlock the Dashboard", fieldWidthAlignment *4, (proportionalHeight * 1.75), "functionalButtonBiggerText", true, "Adds a New Revision Line");
        btnAddAField.setOnAction(e -> {
        	ArrayList<TextField> newField = revisionLogAddAField(0);
        	for(int i = 0; i < newField.size(); i++)
        		RevisionLog.group.getChildren().add(newField.get(i));
        });

        Button btnPrint = button("Print", 120, (screenHeight-75), "functionalButtonBiggerText" ,true, "Print the Current Page");
        btnPrint.setOnAction((ActionEvent e) -> {
        	try {
        		PrintTest.printPDF();
        	} catch (IOException ex) {
        		Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
        	} catch (BadElementException ex) {
        		Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
        	} catch (PrintException ex) {
        		Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
        	}
        });

        Button btnDashboard = button("Dashboard", 220, (screenHeight-75), "functionalButtonBiggerText", true, "Redirects to the Dashboard Page");

        Button btnProjectRegistration = button("New Project Registration", 350, (screenHeight-75), "functionalButtonBiggerText" ,true, "Register a Project");

        Button btnSaveDraft = button("Save as PDF", proportionalWidth*7.5, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Save as PDF");
        btnSaveDraft.setOnAction(e -> {
        	try {
        		PDFClass.generatePDF2();
        	} catch (IOException ex) {
        		Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
        	} catch (BadElementException ex) {
        		Logger.getLogger(ButtonClass.class.getName()).log(Level.SEVERE, null, ex);
        	}
        });

        Button btnRelease = button("Release", proportionalWidth*9.25, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Releases the Revision");

        Button btnRequestToLead = button("Request Lead To Open New Revision", proportionalWidth*11.0, proportionalHeight*1.75, "functionalButtonBiggerText", true, "Request a Lead");
        btnRequestToLead.setOnAction(e -> {
        	try {

        		EmailClass.email();
        	} catch (ClassNotFoundException | SQLException e1) {
        		// TODO Auto-generated catch block
        		e1.printStackTrace();
        	}
        });


        Button btnScope =button("Scope", fieldWidthAlignment*6, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Scope Page");

        Button btnTermsNorms = button("Terms/Norms", fieldWidthAlignment*8, proportionalHeight*(numberOfFields)-15, "functionalButton", true, 55*scale, "Redirects to Terms/Norms Page");

        System.out.println("THE SCALE IS" + scale);
        Button btnControlVolume = button("Control Volume", fieldWidthAlignment*10, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to Control Volume Page");

        Button btnSystemModels = button("System Models", fieldWidthAlignment*12, proportionalHeight*numberOfFields-15, "functionalButton", true, 60*scale, "Redirects to System Models Page");

        Button btnInterface = button("Interface", fieldWidthAlignment*14, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to Interface Page");

        Button btnDIP = button("DIP", fieldWidthAlignment*16, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIP Page");

        Button btnDIF = button("DIF", fieldWidthAlignment*17, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIF Page");

        Button btnDIL = button("DIL", fieldWidthAlignment*18, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to DIL Page");

        Button btnKPFs = button("KPFs", fieldWidthAlignment*19, proportionalHeight*numberOfFields, "functionalButton", true, "Redirects to KPFs Page");

        Button btnDIPVerification = button("DIP Verification", fieldWidthAlignment*21, proportionalHeight*numberOfFields-15, "functionalButton", true, 80*scale, "Redirects to DIP Verification Page");

        Button btnDNAGenerator = button("DNA Generator", fieldWidthAlignment*24, proportionalHeight*numberOfFields-15, "functionalButton", true, 75*scale, "Redirects to DNA Generator Page");

        Button btnDNALibrary = button("DNA Library", fieldWidthAlignment*27, proportionalHeight*numberOfFields, "functionalButton", true, 90*scale, "Redirects to DNA Library Page");
        root.getChildren().addAll(btnAddAField,btnPrint,btnDashboard,btnProjectRegistration,btnSaveDraft,btnRelease,btnRequestToLead,btnScope,btnTermsNorms,btnControlVolume,btnSystemModels,btnInterface,btnDIP,btnDIF,btnDIL,btnKPFs,btnDIPVerification,btnDNAGenerator);

        
        /**
         * Labels used in the border
         * 
         */
        Label lblRevisionControl = label("REVISION CONTROL", 175, 15, 60, 30, "revisionControl", "The Current Menu");

        Label lblProjectID = label("123456789012345678901234567890", 250, 15, proportionalWidth*6, 30, "otherBorder", "Project ID");

        Label lblRevisionNum = label("R1", 75, 15, proportionalWidth*10, 30, "otherBorder", "Revision Number");

        Label lblDateBorder = label("YY-MM-DD", 75, 15, proportionalWidth*12, 30, "otherBorder", "Current Date");

        Label lblPageNum = label("Page 1 of 1", 75, 15, proportionalWidth*14, 30, "otherBorder", "Page Number");
        root.getChildren().addAll(lblRevisionControl,lblProjectID,lblRevisionNum,lblDateBorder,lblPageNum);
            
        /**
         * 
         * ALL TEXTFIELDS FOR REVISIONLOG CLASS
         */ 
        TextField txtCode = textfield("Code",120, true, proportionalWidth*7.25, proportionalHeight*1.25, "textFieldBiggerText");
        root.getChildren().add(txtCode);
 
        /**
         * ALL LABELS FOR  REVISION LOG
         */
        Label lblRevision = label("Revision", 55, 15, fieldWidthAlignment*2, proportionalHeight *numberOfFields, "label", "Revision Number of Test");

        Label lblDate = label("Date", 40, 15, fieldWidthAlignment *4, proportionalHeight *numberOfFields, "label", "The Date the Test Took Place");

        Label lblDescription = label("Description", 75, 15, fieldWidthAlignment*45, proportionalHeight *numberOfFields, "label", "A Brief Description of the Associated Revision");
        //labels.add(lblDescription);
        Label lblCode = label("Release Code", 100, 15, proportionalWidth*5, proportionalHeight *1.25, "labelBiggerText", "The Code to Release the Revision");
        root.getChildren().addAll(lblRevision, lblDate, lblCode);

        pane.setContent(group);
        pane.setPannable(true);
        /**
         * ScrollBar only used when screen is not full screen
         */
        pane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        pane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        pane.setPadding(new Insets(20, 0, 0, 25));
        scene = new Scene(root, Color.WHITE);

    	stage.setScene(scene);
    	stage.setTitle("Revision Log");
        
        /**
         * Sets to size of screen
         */
    	stage.setX(primaryScreenBounds.getMinX());
    	stage.setY(primaryScreenBounds.getMinY());
    	stage.setWidth(primaryScreenBounds.getWidth());
    	stage.setHeight(primaryScreenBounds.getHeight());

        stage.show();
        
    }
    private class ZoomingPane extends Pane {
        Node content;
        private DoubleProperty zoomFactor = new SimpleDoubleProperty(1);

        private ZoomingPane(Node content) {
            this.content = content;
            getChildren().add(content);
            Scale scale = new Scale(1, 1);
            content.getTransforms().add(scale);

            zoomFactor.addListener(new ChangeListener<Number>() {
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    scale.setX(newValue.doubleValue());
                    scale.setY(newValue.doubleValue());
                    requestLayout();
                }
            });
        }

        protected void layoutChildren() {
            Pos pos = Pos.TOP_LEFT;
            double width = getWidth();
            double height = getHeight();
            double top = getInsets().getTop();
            double right = getInsets().getRight();
            double left = getInsets().getLeft();
            double bottom = getInsets().getBottom();
            double contentWidth = (width - left - right)/zoomFactor.get();
            double contentHeight = (height - top - bottom)/zoomFactor.get();
            layoutInArea(content, left, top,
                    contentWidth, contentHeight,
                    0, null,
                    pos.getHpos(),
                    pos.getVpos());
        }

        public final Double getZoomFactor() {
            return zoomFactor.get();
        }
        public final void setZoomFactor(Double zoomFactor) {
            this.zoomFactor.set(zoomFactor);
        }
        public final DoubleProperty zoomFactorProperty() {
            return zoomFactor;
        }
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
    
        public static Line LineBlackNoFill(double x1, int y1, double x2, int y2) {

            Line line = new Line(x1, y1, x2, y2); 
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(1.0); 
            line.getStrokeDashArray().addAll(10.0,0.0,10.0,0.0);

            return line;
        }  

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

        public static ArrayList<TextField> revisionLogAddAField(int countPDF){
            ArrayList<TextField> AddAFieldTextFields = new ArrayList<>();
            
            if(numberOfFields1 <= 7.0) {
                numberOfFields1 += 0.75;
                halfPlusNumberOfFields += 0.75;
                
                if (countPDF == 1){
                    TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "disabledTextField");
                    AddAFieldTextFields.add(txtDescription);
                    TextField txtRevision = textfield("R1234", 55, false, fieldWidthAlignment * 2, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtRevision);
                    TextField txtDate = textfield("YY-MM-DD",70,false, fieldWidthAlignment * 4, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDate);
                    TextField txtScope = textfield("123", 50,false,fieldWidthAlignment * 6, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtScope);
                    TextField txtTermsNorms = textfield("123", 50,false,fieldWidthAlignment * 8, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtTermsNorms);
                    TextField txtControlVolume = textfield("123", 50,false,fieldWidthAlignment * 10, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtControlVolume);
                    TextField txtSystemModels = textfield("123", 50,false,fieldWidthAlignment * 12, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtSystemModels);
                    TextField txtInterface = textfield("123",50, false,fieldWidthAlignment * 14, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtInterface);
                    TextField txtDIP = textfield("123",30, false,fieldWidthAlignment * 16, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDIP);
                    TextField txtDIF = textfield("123", 30,false,fieldWidthAlignment * 17, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDIF);
                    TextField txtDIL = textfield("123",30, false,fieldWidthAlignment * 18, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDIL);
                    TextField txtKPFs = textfield("123",30, false,fieldWidthAlignment * 19, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtKPFs);
                    TextField txtDIPVerification = textfield("123", 50,false,fieldWidthAlignment * 21, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDIPVerification);
                    TextField txtDNAGenerator = textfield("123",50, false,fieldWidthAlignment * 24, proportionalHeight*numberOfFields1, "disabledTextField");
                    AddAFieldTextFields.add(txtDNAGenerator);
                    TextField txtDNALibrary = textfield("123", 50,false,fieldWidthAlignment * 27, proportionalHeight*numberOfFields1, "disabledTextField");

                    AddAFieldTextFields.add(txtDNALibrary); 
                }
                else{
                    TextField txtDescription = textfield("Please Enter The Description Here", fieldWidthAlignment * 38, false, fieldWidthAlignment * 2, (proportionalHeight*halfPlusNumberOfFields), "textField");
                    AddAFieldTextFields.add(txtDescription);                
                    TextField txtRevision = textfield("R1234", 55, true, fieldWidthAlignment * 2, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtRevision);
                    TextField txtDate = textfield("YY-MM-DD",70,true, fieldWidthAlignment * 4, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDate);
                    TextField txtScope = textfield("123", 50,true,fieldWidthAlignment * 6, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtScope);
                    TextField txtTermsNorms = textfield("123", 50,true,fieldWidthAlignment * 8, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtTermsNorms);
                    TextField txtControlVolume = textfield("123", 50,true,fieldWidthAlignment * 10, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtControlVolume);
                    TextField txtSystemModels = textfield("123", 50,true,fieldWidthAlignment * 12, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtSystemModels);
                    TextField txtInterface = textfield("123",50, true,fieldWidthAlignment * 14, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtInterface);
                    TextField txtDIP = textfield("123",30, true,fieldWidthAlignment * 16, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDIP);
                    TextField txtDIF = textfield("123", 30,true,fieldWidthAlignment * 17, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDIF);
                    TextField txtDIL = textfield("123",30, true,fieldWidthAlignment * 18, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDIL);
                    TextField txtKPFs = textfield("123",30, true,fieldWidthAlignment * 19, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtKPFs);
                    TextField txtDIPVerification = textfield("123", 50,true,fieldWidthAlignment * 21, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDIPVerification);
                    TextField txtDNAGenerator = textfield("123",50,true, fieldWidthAlignment * 24, proportionalHeight*numberOfFields1, "textField");
                    AddAFieldTextFields.add(txtDNAGenerator);
                    TextField txtDNALibrary = textfield("123", 50,true,fieldWidthAlignment * 27, proportionalHeight*numberOfFields1, "textField");

                    AddAFieldTextFields.add(txtDNALibrary);                 
                }
            }
        
            return AddAFieldTextFields;
        }
        
        public static TextField textfield(String text, int textWidth, Boolean booll, double positionX, double positionY, String style) {
        	TextField textfield1 = new TextField();
            textfield1.setPromptText(text);
            textfield1.setAlignment(Pos.CENTER);
            textfield1.setPrefWidth(textWidth);
            textfield1.setEditable(booll);
           // eventually might need to add prefHeight
            textfield1.setLayoutX(positionX);
            textfield1.setLayoutY(positionY);
            textfield1.setId(style);
    	    
            return textfield1;
        }
        
        public static TextArea textarea(String text, int textWidth, int positionX, double positionY, String style){
            
            TextArea textarea1 = new TextArea();
            textarea1.setPromptText(text);
            textarea1.setPrefWidth(textWidth);
            textarea1.setLayoutX(positionX);
            textarea1.setLayoutY(positionY);
            textarea1.setId(style);
            
            
            return textarea1;
        }         
}
