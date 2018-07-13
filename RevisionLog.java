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

        //      Line line1 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25,screenProportionHeightby25,screenHeight-80);
        //            borderLines.add(line1);
        Line line11 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenProportionHeightby25,screenHeight-80);

        System.out.println("SCREEN BY 25:" + screenProportionHeightby25 );

        Line line2 = LineBlackNoFill(screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenProportionHeightby25+40);
            

        Line line3 = LineBlackNoFill(screenWidth-screenProportionHeightby25,screenProportionHeightby25+40,screenWidth-screenProportionHeightby25,screenHeight-80);
       
        //Line line4 = LineBlackNoFill(screenProportionHeightby25, proportionalHeight, (screenWidth-screenProportionHeightby25), proportionalHeight);
        //borderLines.add(line4);

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

// Button to import an image from comp        
//        Button btnImportImage = ButtonClass.button("Import Image", fieldWidthAlignment*31, proportionalHeight*numberOfFields, "functionalButton", true, "Import an Image to the Program");
//        btnImportImage.setOnAction(e -> {
//        	final FileChooser fileChooser = new FileChooser();
//        	fileChooser.setTitle("Import Image");
//        	fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//        	fileChooser.getExtensionFilters().addAll(
//        			new FileChooser.ExtensionFilter("All Image Files (*.jpg; *.png)", "*.jpg", "*.png"),
//        			new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//        			new FileChooser.ExtensionFilter("PNG", "*.png"));
//        	File file = fileChooser.showOpenDialog(DSP.window);
//        	if (file != null) {
//        		Image image = new Image(file.toURI().toString(), 100, 150, true, true);
//        		ImageView imageView = new ImageView(image);
//        		imageView.setFitWidth(100);
//        		imageView.setFitHeight(150);
//        		imageView.setX(600);
//        		imageView.setY(600);
//        		imageView.setPreserveRatio(true);
//
//        		RevisionLog.group.getChildren().add(imageView);
//        	}
//        });

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

        /**
         * Creates the connection to the database.
         * Called everytime you need to insert,delete, or update
         * the database
         */
       // ConnectionToDatabase.connectToDatabase();
        
        //EmailClass1.emailPerson("dsppracticeemail@gmail.com", "Kepstrum2005", "Testing Subject", "Dear Lead, ", "15nw2@queensu.ca");
        //EmailClass.Email();
        //revisionLogUpdateFields();
        //PDFClass.generatePDFFromSQL();

//        ArrayList<TextArea> textarea = TextfieldClass.textArea();
//        for(int i = 0; i < textarea.size(); i++){
//            root.getChildren().add(textarea.get(i));
//        }
        
        Line line1 = LineBlackNoFill(60, proportionalHeight, screenWidth-77, proportionalHeight);
        //root.getChildren().add(line1);

        
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
//    /**
//    * Fetches the user's information from the database
//    */
//    public static void revisionLogUpdateFields(){
//        ArrayList<TextField> x = new ArrayList<>();
//        numberOfFields = 2.1;
//        try{
//            Connection connection = ConnectionToDatabase.connectToDatabase();
//            String query1 = "SELECT * FROM mydb.revisionlog";
//            Statement stst = connection.createStatement();
//            ResultSet fullRevisionLog = stst.executeQuery(query1); 
//            int countPDF = 0;
//            while(fullRevisionLog.next()){
//                numberOfFields += 0.4;
//                int revisionNum = fullRevisionLog.getInt("REVISION_ID");
//                Date dateCreated = fullRevisionLog.getDate("DATE");
//                String description = fullRevisionLog.getString("DESCRIPTION");
//                int code = fullRevisionLog.getInt("CODE");
//                int saveAsPDF = fullRevisionLog.getInt("SAVEPDF");
//                
//                countPDF += saveAsPDF;
//                
//                String scope = fullRevisionLog.getString("SCOPE");
//                String termsNorms = fullRevisionLog.getString("TERMSNORMS");
//                String controlVolume = fullRevisionLog.getString("CONTROLVOLUME");
//                String systemModels = fullRevisionLog.getString("SYSTEMMODELS");
//                String dip = fullRevisionLog.getString("DIP");
//                String dif = fullRevisionLog.getString("DIF");
//                String dil = fullRevisionLog.getString("DIL");
//                String kpfs = fullRevisionLog.getString("KPFS");
//                String dipVerification = fullRevisionLog.getString("DIPVERIFICATION");
//                String dnaGenerator = fullRevisionLog.getString("DNAGENERATOR");
//                String dnaLibrary = fullRevisionLog.getString("DNALIBRARY");
//                
//                System.out.format("%s, %s, %s, %s\n", revisionNum, dateCreated, description, saveAsPDF);
//
//                x = revisionLogAddAField(countPDF);
//                for(int i = 0; i < x.size(); i++)
//                    group.getChildren().add(x.get(i));
//                x.clear();
//                
//            }
//            
//        } catch(Exception e) {
//            System.out.println("HERE");
//            System.err.println(e.getMessage());
//        }   
//    }

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
        /**
         * 
         * @param countPDF Taken from the database for each revision. It's used to check if that revision has been saved as a PDF yet
         * @return This returns an array list containing all the fields for a revision. These fields will be immutable if the revision has been saved as a PDF
         */
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
        
        /**
         * 
         * @param text The prompt text set in the text field
         * @param textWidth The width of the text field
         * @param booll Determines if the text field is editable
         * @param positionX The position of the text field on the x-axis
         * @param positionY The position of the text field on the y-axis
         * @param style The CSS style associated with the text field
         * @return This returns a text field
         */
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
        
        /**
         * 
         * @param text The prompt text set in the text area
         * @param textWidth The width of the text area
         * @param positionX The position of the text area on the x-axis
         * @param positionY The position of the text area on the y-axis
         * @param style The CSS style associated with the text area
         * @return This returns a text area
         */
        public static TextArea textarea(String text, int textWidth, int positionX, double positionY, String style){
            
            TextArea textarea1 = new TextArea();
            
            textarea1.setPromptText(text);
            textarea1.setPrefWidth(textWidth);
            textarea1.setLayoutX(positionX);
            textarea1.setLayoutY(positionY);
            textarea1.setId(style);
            
            
            return textarea1;
        }  
        public static void help() {
    		Stage window = new Stage();
                   
            ScrollPane pane = new ScrollPane();
    		
            window.initModality(Modality.APPLICATION_MODAL);
    		window.setTitle("Help");
    		window.setHeight(500);
    		window.setWidth(550);
    		window.setMinWidth(250);
    		
    		DropShadow shadowDrop = new DropShadow();
    		
            Label lblHelpDef = LabelClass.label("Scroll Over Word For Its Definition", "helpTitle");
    		
                    
                    
            // Uses the label method from LabelClass to create a label which starts out invisible
    		Label lblRevisionDef = LabelClass.label("Revision number of test.", 40, 25, "");
    		lblRevisionDef.setVisible(false);
            // Uses the label method from LabelClass to create a label. Has an action where you mouse over the label, it'll set the definition label visible
    		Label lblRevision = LabelClass.label("Revision", 110, 25, "label", lblRevisionDef);

    		Label lblDateDef = LabelClass.label("The date the test took place.", 40, 25, "");
    		lblDateDef.setVisible(false);
    		Label lblDate = LabelClass.label("Date", 110, 25, "label",lblDateDef);

    		Label lblDescriptionDef = LabelClass.label("A brief description of the associated revision.", 40, 25, "");
    		lblDescriptionDef.setVisible(false);
    		Label lblDescription = LabelClass.label("Description", 110, 25, "label",lblDescriptionDef);
                    
                    
                    
    		Label lblScopeDef = LabelClass.label("Redirects to scope page.", 40, 25, "");
    		lblScopeDef.setVisible(false);
    		Label lblScope = LabelClass.label("Scope", 110, 25, "label",lblScopeDef);

    		Label lblTermsNormsDef = LabelClass.label("Redirects to Terms/Norms page.", 40, 25, "");
    		lblTermsNormsDef.setVisible(false);
    		Label lblTermsNorms = LabelClass.label("Terms/Norms", 110, 25, "label",lblTermsNormsDef);

    		Label lblControlVolumeDef = LabelClass.label("Redirects to Control Volume page.", 40, 25, "");
    		lblControlVolumeDef.setVisible(false);
    		Label lblControlVolume = LabelClass.label("Control Volume", 110, 25, "label",lblControlVolumeDef);
    		Label lblSystemModelsDef = LabelClass.label("Redirects to System Models page.", 40, 25, "");
    		lblSystemModelsDef.setVisible(false);
    		Label lblSystemModels = LabelClass.label("System Models", 110, 25, "label",lblSystemModelsDef);

    		Label lblInterfaceDef = LabelClass.label("Redirects to Interface page.", 40, 25, "");
    		lblInterfaceDef.setVisible(false);
    		Label lblInterface = LabelClass.label("Interface", 110, 25, "label",lblInterfaceDef);                

    		Label lblDIPDef = LabelClass.label("Redirects to DIP page.", 40, 25, "");
    		lblDIPDef.setVisible(false);
    		Label lblDIP = LabelClass.label("DIP", 110, 25, "label",lblDIPDef);  
    		Label lblDIFDef = LabelClass.label("Redirects to DIF page.", 40, 25, "");
    		lblDIFDef.setVisible(false);
    		Label lblDIF = LabelClass.label("DIF", 110, 25, "label",lblDIFDef);   

    		Label lblDILDef = LabelClass.label("Redirects to DIL page.", 40, 25, "");
    		lblDILDef.setVisible(false);
    		Label lblDIL = LabelClass.label("DIL", 110, 25, "label",lblDILDef);                
    		Label lblKPFsDef = LabelClass.label("Redirects to KPFs page.", 40, 25, "");
    		lblKPFsDef.setVisible(false);
    		Label lblKPFs = LabelClass.label("KPFs", 110, 25, "label",lblKPFsDef);                

    		Label lblDIPVerificationDef = LabelClass.label("Redirects to DIP Verification page.", 40, 25, "");
    		lblDIPVerificationDef.setVisible(false);
    		Label lblDIPVerification = LabelClass.label("DIP Verification", 110, 25, "label",lblDIPVerificationDef);                

    		Label lblDNAGeneratorDef = LabelClass.label("Redirects to DNA Generator page.", 40, 25, "");
    		lblDNAGeneratorDef.setVisible(false);
    		Label lblDNAGenerator = LabelClass.label("DNA Generator", 110, 25, "label",lblDNAGeneratorDef);                

    		Label lblDNALibraryDef = LabelClass.label("Redirects to DNA Library page.", 40, 25, "");
    		lblDNALibraryDef.setVisible(false);
    		Label lblDNALibrary = LabelClass.label("DNA Library", 110, 25, "label",lblDNALibraryDef);                

    		Label lblAddAFieldDef = LabelClass.label("Adds a new revision line.", 40, 25, "");
    		lblAddAFieldDef.setVisible(false);
    		Label lblAddAField = LabelClass.label("Add A New Revision and Unlock the Dashboard", 110, 25, "functionalButton",lblAddAFieldDef);                  
                                     
                    
    		Label lblCodeDef = LabelClass.label("The code to release the revision.", 40, 25, "");
    		lblCodeDef.setVisible(false);
    		Label lblCode = LabelClass.label("Code", 110, 25, "label",lblCodeDef);

    		


    		
    		Label lblSavePDFDef = LabelClass.label("Save as PDF.", 40, 25, "");
    		lblSavePDFDef.setVisible(false);
    		Label lblSavePDF = LabelClass.label("Save as PDF", 110, 25, "functionalButton",lblSavePDFDef);

    		
    		Label lblReleaseDef = LabelClass.label("Releases the revision.", 40, 25, "");
    		lblReleaseDef.setVisible(false);
    		
    		Label lblRelease = LabelClass.label("Release", 110, 25, "functionalButton",lblReleaseDef);

                    
    		/**
    		 * Print directs to separate print class
    		 */
    		
    		Label lblPrintDef = LabelClass.label("Print the current page", 40, 25, "");
    		lblPrintDef.setVisible(false);
    		
    		Label lblPrint = LabelClass.label("Print", 110, 25, "functionalButton",lblPrintDef);
    		
    		/**
    		 * Directs to DNA Plot page
    		 */
    		
    		Label lblDashboardDef = LabelClass.label("Redirects to the dashboard page.", 40, 25, "");
    		lblDashboardDef.setVisible(false);
    		Label lblDashboard = LabelClass.label("Dashboard", 110, 25, "functionalButton",lblDashboardDef);

    		
    		BorderPane layout = new BorderPane();
    		
    		HBox title = new HBox();
    		title.setPadding(new Insets(15, 12, 15, 12));
    		title.getChildren().add(lblHelpDef);
    		//title.setStyle("-fx-background-color: #DEFFB9");
    		layout.setTop(title);
    		
    		VBox words = new VBox();
    		words.setPadding(new Insets(10));
    		words.setSpacing(10);
    		words.getChildren().addAll(lblRevision, lblDate, lblScope, lblTermsNorms, lblControlVolume, lblSystemModels,lblInterface, lblDIP, lblDIF, lblDIL, lblKPFs, lblDIPVerification, lblDNAGenerator, lblDNALibrary,lblDescription, lblCode, lblAddAField, lblSavePDF, lblRelease, lblPrint, lblDashboard);
    		//words.setStyle("-fx-background-color: #DEFFB9");
    		layout.setLeft(words);
    		
    		VBox definitions = new VBox();
    		definitions.setPadding(new Insets(10.5));
    		definitions.setSpacing(10);
    		definitions.getChildren().addAll(lblRevisionDef, lblDateDef, lblScopeDef,lblTermsNormsDef, lblControlVolumeDef, lblSystemModelsDef, lblInterfaceDef, lblDIPDef, lblDIFDef, lblDILDef, lblKPFsDef, lblDIPVerificationDef, lblDNAGeneratorDef, lblDNALibraryDef,lblDescriptionDef, lblCodeDef, lblAddAFieldDef, lblSavePDFDef, lblReleaseDef, lblPrintDef, lblDashboardDef);
    		//definitions.setStyle("-fx-background-color: #DEFFB9");
    		layout.setCenter(definitions);


    		pane.setContent(layout);
    		// scene = new Scene(pane, Color.WHITE);
    		// stage.setScene(scene);


    		Scene scene = new Scene(pane);
    		//scene.getStylesheets().add(DSP.css);
    		window.setScene(scene);
    		window.setResizable(false);
    		window.showAndWait();

    	} //end help        
}
