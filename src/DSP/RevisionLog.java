package DSP;

import static DSP.LabelClass.proportionalHeight;
import static DSP.LabelClass.screenWidth;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;

public class RevisionLog{
    	
    Stage window;
    static Scene scene;
    static ScrollPane pane;
    public static double numberOfFields = 2.1;
    public static int StartAtOne = 1;
    
    static Group group;
    
    static Rectangle2D primaryScreenBounds = ScreenResolutionClass.screenBounds();
    
    public static void revisionLogScene(Stage stage) throws ClassNotFoundException{
        

        ScrollPane pane = new ScrollPane();

        Group root = new Group();
        group = root;

  
        
        /**
        * Creates the connection to the database.
        * Called everytime you need to insert,delete, or update
        * the database
        */
        ConnectionToDatabase.connectToDatabase();

        //EmailClass1.emailPerson("dsppracticeemail@gmail.com", "Kepstrum2005", "Testing Subject", "Dear Lead, ", "15nw2@queensu.ca");
        //EmailClass.Email();
        revisionLogUpdateFields();
        //PDFClass.generatePDFFromSQL();

        /**
        * 
        * Iterates through the arrayList of borders
        * And adds them to the scene
        * 
        */
        ArrayList<Line> DrawingBorderLines = BorderClass.border1(); 
        for(int i=0; i < DrawingBorderLines.size(); i = i+1) {
            root.getChildren().add(DrawingBorderLines.get(i));  
        }
        /**
        * Iterates through the arrayList of buttons 
        * and adds them to the scene
        */
        ArrayList<Button> buttons = ButtonClass.revisionLogButtons();
        for(int i = 0; i <buttons.size(); i++) {
            root.getChildren().add(buttons.get(i));
        }
        /**
        * Iterates through the arrayList of Labels
        * and adds them to the scene
        */
        ArrayList<Label> labels = LabelClass.revisionLogLabels();
        for(int i = 0; i < labels.size(); i++){
        root.getChildren().add(labels.get(i));
        }
        /**
        * Iterates through the arrayList of Border labels
        * and adds them to the scene
        */
        ArrayList<Label> borderLabels = LabelClass.borderLabels();
        for(int i = 0; i < borderLabels.size(); i++){
        root.getChildren().add(borderLabels.get(i));
        }
        /**
        * Iterates through the arrayList of textfields
        * and adds them to the scene
        */
        ArrayList<TextField> textfields = TextfieldClass.revisionLogTextFields();
        for(int i = 0; i < textfields.size(); i++){
        root.getChildren().add(textfields.get(i));
        }
        ArrayList<TextArea> textarea = TextfieldClass.textArea();
        for(int i = 0; i < textarea.size(); i++){
        root.getChildren().add(textarea.get(i));
        }

        Line line1 = BorderClass.LineBlackNoFill(60, proportionalHeight, screenWidth-77, proportionalHeight);
        //root.getChildren().add(line1);
        pane.setContent(group);
        pane.setPannable(true);
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
    /**
    * Fetches the user's information from the database
    */
    public static void revisionLogUpdateFields(){
        ArrayList<TextField> x = new ArrayList<>();
        numberOfFields = 2.1;
        try{
            Connection connection = ConnectionToDatabase.connectToDatabase();
            String query1 = "SELECT * FROM mydb.revisionlog";
            Statement stst = connection.createStatement();
            ResultSet fullRevisionLog = stst.executeQuery(query1); 
            int countPDF = 0;
            while(fullRevisionLog.next()){
                numberOfFields += 0.4;
                int revisionNum = fullRevisionLog.getInt("REVISION_ID");
                Date dateCreated = fullRevisionLog.getDate("DATE");
                String description = fullRevisionLog.getString("DESCRIPTION");
                int code = fullRevisionLog.getInt("CODE");
                int saveAsPDF = fullRevisionLog.getInt("SAVEPDF");
                
                countPDF += saveAsPDF;
                
                String scope = fullRevisionLog.getString("SCOPE");
                String termsNorms = fullRevisionLog.getString("TERMSNORMS");
                String controlVolume = fullRevisionLog.getString("CONTROLVOLUME");
                String systemModels = fullRevisionLog.getString("SYSTEMMODELS");
                String dip = fullRevisionLog.getString("DIP");
                String dif = fullRevisionLog.getString("DIF");
                String dil = fullRevisionLog.getString("DIL");
                String kpfs = fullRevisionLog.getString("KPFS");
                String dipVerification = fullRevisionLog.getString("DIPVERIFICATION");
                String dnaGenerator = fullRevisionLog.getString("DNAGENERATOR");
                String dnaLibrary = fullRevisionLog.getString("DNALIBRARY");
                
                System.out.format("%s, %s, %s, %s\n", revisionNum, dateCreated, description, saveAsPDF);

                x = TextfieldClass.revisionLogAddAField(countPDF);
                for(int i = 0; i < x.size(); i++)
                    group.getChildren().add(x.get(i));
                x.clear();
                
            }
            
        } catch(Exception e) {
            System.out.println("HERE");
            System.err.println(e.getMessage());
	}
        
        
    }
}  

