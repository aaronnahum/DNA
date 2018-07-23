
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


/** 
 * extends application which is an import
 */
public class revisionLog extends Application{
	/**  fix buttons tomorrow using hover and CSS import*/
	
	Stage window;
	
	Button btnAddaField;
	Button btnRevision;
	Button btnDate;
	Button btnDescription;
	Button btnCode;
	Button btnPrint;
	Button btnDNAPlot;
	Button btnHelp;
	Button btnSaveDraft;
	Button btnSaveRelease;

	
	Label lblRevision;
	
	TextField txtDate;
	TextField txtDescription;
	TextField txtCode;
	
	ChoiceBox<Integer> pageNum;
	
	static ObservableList<Button> buttons = FXCollections.observableArrayList();
	static ObservableList<Label> labels = FXCollections.observableArrayList();
	static ObservableList<TextField> textFields = FXCollections.observableArrayList();
	
	static ObservableList<Label> labelsTemp = FXCollections.observableArrayList();
	static ObservableList<TextField> textFieldsTemp = FXCollections.observableArrayList();
	
	ArrayList<Button> lst = new ArrayList<>();
	
	//ObservableList<Button> buttons = FXCollections.observableList(lst);
	
	
	
	public static double numberOfFields = 2.1;
	public static int StartAtOne = 1;
	static Group group;
	
	public static void main(String[] args) {
		/** launches are javaFx */
		
		launch(args);

	}
	
	@Override
	public void start(Stage stage) throws Exception {
		
		window = stage;

		Group root = new Group();
		group = root;
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		int screenWidth = (int) primaryScreenBounds.getWidth();
		int screenHeight = (int) primaryScreenBounds.getHeight();
		
		
		
		Line line = new Line(60,60,60,screenHeight-80);
		line.setStroke(Color.BLACK);
		root.getChildren().add(line);
		Line line1 = new Line(60,60,screenWidth-60,60);
		line1.setStroke(Color.BLACK);
		root.getChildren().add(line1);
		Line line2 = new Line(screenWidth-60,60,screenWidth-60,screenHeight-80);
		line2.setStroke(Color.BLACK);
		root.getChildren().add(line2);
		Line line3 = new Line(screenWidth-60, screenHeight-80, 60, screenHeight-80);
		line3.setStroke(Color.BLACK);
		root.getChildren().add(line3);
		
		int proportionalWidth = screenWidth/16;
		int proportionalHeight = screenHeight/10;
		
		Line line4 = new Line(60, proportionalHeight, (screenWidth-60), proportionalHeight);
		line4.setStroke(Color.BLACK);
		root.getChildren().add(line4);
		
		Line line5 = new Line((proportionalWidth*2.5), proportionalHeight, (proportionalWidth*2.5), 60);
		line5.setStroke(Color.BLACK);
		root.getChildren().add(line5);
		Line line6 = new Line ((screenWidth-(proportionalWidth*2.5)), proportionalHeight, (screenWidth-(proportionalWidth*2.5)), 60);
		line6.setStroke(Color.BLACK);
		root.getChildren().add(line6);
		
		double fieldWidthAlignment = screenWidth/10.5;
		
		pageNum = new ChoiceBox<>();
		pageNum.getItems().add(1);
		pageNum.setValue(1);
		pageNum.setTooltip(new Tooltip("Select a page"));
		pageNum.setLayoutX(fieldWidthAlignment * 0.5);
		pageNum.setLayoutY(proportionalHeight * 1.5);
		
		/** Add a field button
		 * Positioned proportionally
		 * CSS setStyle of button with on Button shadow
		 * Functionality iteratively prints out TextFields: Revision, Date, Initial, Description, code 
		 * and Buttons Save as Draft, Save & Release, confirm
		 */
		btnAddaField = new Button();
		btnAddaField.setText("Add A New Revision and unlock the Spec");
		btnAddaField.setLayoutX(fieldWidthAlignment);
		btnAddaField.setLayoutY(proportionalHeight *1.5);
		btnAddaField.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold; \r\n");
		
		DropShadow shadowDrop = new DropShadow();
		// Adding the shadow when the mouse cursor is on
		btnAddaField.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnAddaField.setEffect(shadowDrop);
			}
		});
		//Removing the shadow when the mouse cursor is off
		btnAddaField.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnAddaField.setEffect(null);
			}
		});
		
		/**
		 * Set's functionality to Add a field button
		 */
		btnAddaField.setOnAction(e -> addAField(root, window));
		//btnAddaField.setOnAction(e -> updateFields(root));
		/**
		 * Revision disabled button label
		 */
		btnRevision = new Button();
		btnRevision.setText("Revision");
		btnRevision.setLayoutX(fieldWidthAlignment);
		btnRevision.setLayoutY(proportionalHeight *numberOfFields);
		btnRevision.setStyle(" -fx-background-color: \r\n" +  
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * Date disabled button
		 */
		btnDate = new Button();
		btnDate.setText("Date");
		btnDate.setLayoutX(fieldWidthAlignment*2);
		btnDate.setLayoutY(proportionalHeight *numberOfFields);
		btnDate.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * Description disabled button label
		 */
		btnDescription = new Button();
		btnDescription.setText("Description");
		btnDescription.setLayoutX(fieldWidthAlignment*3);
		btnDescription.setLayoutY(proportionalHeight *numberOfFields);
		btnDescription.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * Code disabled Button
		 */
		btnCode = new Button();
		btnCode.setText("Code");
		btnCode.setLayoutX(fieldWidthAlignment*5);
		btnCode.setLayoutY(proportionalHeight *numberOfFields);
		btnCode.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * Print directs to separate print class
		 */
		btnPrint = new Button();
		btnPrint.setText("Print");
		btnPrint.setLayoutX(120);
		btnPrint.setLayoutY(screenHeight-75);
		btnPrint.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		DropShadow shadowPrint = new DropShadow();
		// Adding the shadow when the mouse cursor is on
		btnPrint.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnPrint.setEffect(shadowPrint);
			}
		});
		//Removing the shadow when the mouse cursor is off
		btnPrint.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnPrint.setEffect(null);
			}
		});
		btnPrint.setOnAction(e -> Print.pageSetup(root));
		
		/**
		 * Directs to DNA Plot page
		 */
		btnDNAPlot = new Button();
		btnDNAPlot.setText("DNA Plot");
		btnDNAPlot.setLayoutX(220);
		btnDNAPlot.setLayoutY(screenHeight-75);
		btnDNAPlot.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * For DNAPlot Button
		 * When mouse goes over active buttons, display a shadow
		 */
		DropShadow shadowDNAPlot = new DropShadow();
		// Adding the shadow when the mouse cursor is on
		btnDNAPlot.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnDNAPlot.setEffect(shadowDNAPlot);
			}
		});
		/**
		 * For DNAPlot Button
		 * When mouse goes away from active button, remove shadow
		 */
		//Removing the shadow when the mouse cursor is off
		btnDNAPlot.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnDNAPlot.setEffect(null);
			}
		});
		/**
		 * Help button redirects to help class which 
		 * describes every button/field on page
		 */
		btnHelp = new Button();
		btnHelp.setText("Help");
		btnHelp.setLayoutX(screenWidth-180);
		btnHelp.setLayoutY(screenHeight-75);
		btnHelp.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		/**
		 * For Help Button
		 * Display a shadow when mouse goes over button
		 */
		DropShadow shadowHelp = new DropShadow();
		// Adding the shadow when the mouse cursor is on
		btnHelp.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnHelp.setEffect(shadowHelp);
			}
		});
		/**
		 * For Help Button
		 * Remove a shadow when mouse leaves button
		 * 
		 */
		//Removing the shadow when the mouse cursor is off
		btnHelp.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				btnHelp.setEffect(null);
			}
		});
		btnHelp.setOnAction(e -> Help.help());
		
		/**
		 * Save as draft functional button
		 */
		btnSaveDraft = new Button();
		btnSaveDraft.setText("Save as PDF");
		btnSaveDraft.setLayoutX(fieldWidthAlignment*6);
		btnSaveDraft.setLayoutY(proportionalHeight*numberOfFields);
		btnSaveDraft.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		btnSaveDraft.setOnAction(e -> {
			generatePDFFromSQL();
//			try {
//				//btnSavePDF(lblRevision.getText(),txtDate.getText(),txtDescription.getText(), txtCode.getText());
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			}
		});
				
		/**
		 * Save & Release functional Button
		 */
		btnSaveRelease = new Button();
		btnSaveRelease.setText("Release");
		btnSaveRelease.setLayoutX(fieldWidthAlignment*7);
		btnSaveRelease.setLayoutY(proportionalHeight*1.5);
		btnSaveRelease.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		btnSaveRelease.setOnAction(e -> release());
		/**
		 * Add everything to scene
		 */
		
		// Adds existing revisions from database on application startup
		updateFields(root);
		
		buttons.addAll(btnAddaField, btnRevision, btnDate, btnDescription, btnCode, btnPrint, btnDNAPlot, btnHelp, btnSaveDraft, btnSaveRelease);
		
		for (int i = 0; i < buttons.size(); i++)
			root.getChildren().add(buttons.get(i));
		
		root.getChildren().add(pageNum);
		
		/**
		 * Setting up the scene
		 */
		Scene scene = new Scene(root, screenWidth, screenHeight, Color.WHITE);
		scene.getStylesheets().add("C:\\Users\\Minghua\\eclipse-workspace\\CTOS\\src\\fancytext.css");
		window.setScene(scene);
		window.setTitle("Revision Log");
		
		window.setScene(scene);
		window.show();

		window.setX(primaryScreenBounds.getMinX());
		window.setY(primaryScreenBounds.getMinY());
		window.setWidth(primaryScreenBounds.getWidth());
		window.setHeight(primaryScreenBounds.getHeight());	
	}
	
	
	
	
	
	
	
	
	
	public void addAField(Group root, Stage stage) {
		
		//root = group;
		
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		int screenWidth=(int) primaryScreenBounds.getWidth();
		int screenHeight = (int) primaryScreenBounds.getHeight();
		double fieldWidthAlignment = screenWidth/10.5;
		int proportionalHeight = screenHeight/10;
		
		if (numberOfFields < 8.5) {
			numberOfFields += 0.4;
			
			btnSaveDraft = new Button();
			btnSaveDraft.setText("Save as PDF");
			btnSaveDraft.setLayoutX(fieldWidthAlignment*6);
			btnSaveDraft.setLayoutY(proportionalHeight*numberOfFields);
			btnSaveDraft.setStyle(" -fx-background-color: \r\n" + 
					"        #000000,\r\n" + 
					"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
					"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
					"    -fx-background-insets: 0,1,2;\r\n" + 
					"    -fx-background-radius: 3,2,1;\r\n" + 
					"    -fx-padding: 5 10 5 10;\r\n" + 
					"    -fx-text-fill: black;\r\n" + 
					"    -fx-font-size: 12px; \r\n" + 
					"    -fx-font-weight: bold;");
			root.getChildren().add(btnSaveDraft);
			
		    lblRevision = new Label();
		    lblRevision.setText(String.valueOf(("R" + StartAtOne)));
		    lblRevision.setPrefWidth(100);
		    lblRevision.setAlignment(Pos.CENTER);
		    lblRevision.setLayoutX(fieldWidthAlignment);
		    lblRevision.setLayoutY(proportionalHeight*numberOfFields);
		    lblRevision.setStyle("-fx-background-color: #d4ffd4;-fx-padding: 5 10 5 10;");
		    root.getChildren().add(lblRevision);
		    
			txtDate = new TextField();
			txtDate.setPrefWidth(90);
			txtDate.setPromptText("yy/mm/dd");
			txtDate.setAlignment(Pos.CENTER);
			txtDate.setLayoutX(fieldWidthAlignment*2);
			txtDate.setLayoutY(proportionalHeight*numberOfFields);
			txtDate.setStyle("-fx-background-color: #d4ffd4;");
			root.getChildren().add(txtDate);
					
			txtDescription = new TextField();
			txtDescription.setPrefWidth(260);
			txtDescription.setPromptText("1234567890123456789012345678901234567890");
			txtDescription.setAlignment(Pos.BASELINE_LEFT);
			txtDescription.setLayoutX(fieldWidthAlignment*3);
			txtDescription.setLayoutY(proportionalHeight*numberOfFields);
			txtDescription.setStyle("-fx-background-color: #d4ffd4;");
			root.getChildren().add(txtDescription);
			
			txtCode = new TextField();
			txtCode.setPrefWidth(100);
			txtCode.setPromptText("1234567890");
			txtCode.setAlignment(Pos.CENTER);
			txtCode.setLayoutX(fieldWidthAlignment*5);
			txtCode.setLayoutY(proportionalHeight*numberOfFields);
			txtCode.setStyle("-fx-background-color: #d4ffd4;");
			root.getChildren().add(txtCode);
			
			labels.add(lblRevision);
			textFields.addAll(txtDate, txtDescription, txtCode);
			
			StartAtOne +=1;
		}
		/**
		 * Determines how many fields per page
		 */
		
		else if(numberOfFields > 8.5) {
			Group root2 = new Group();
			root2.getChildren().addAll(btnRevision, pageNum);
			Scene page2 = new Scene(root2, screenWidth, screenHeight, Color.WHITE);
			pageNum.getItems().add(2);
			pageNum.setValue(2);
			stage.setScene(page2);
		}
	}
	

	public static void btnSavePDF(String revision, String date, String description, String code) throws ClassNotFoundException{
		try {
			Connection connection = connectToDatabase();
			String query = "INSERT INTO mydb.revision_log(`REVISION_ID`, `DATE`,`DESCRIPTION`,`CODE`) VALUES (?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1,revision);
			ps.setString(2, date);
			ps.setString(3, description);
			ps.setString(4, code);
			System.out.print(ps.toString());
			
			ps.executeUpdate();
		}
		catch (SQLException error) {
			error.printStackTrace();
		
		}
	}
	
	// makes the connection to the database, 
	// I believe you need to call this function before any SQL commands
	public static Connection connectToDatabase() throws ClassNotFoundException{
		
		java.sql.Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connectionURL = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
			connection = DriverManager.getConnection(connectionURL, "root", "root1");
			System.out.println("Here");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void generatePDF(){
		
		try{	
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("revisionLog.pdf"));
			
			document.open();
			Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
			Chunk chunk = new Chunk("Hello world", font);
			
			document.add(chunk);
			document.close();
			
			System.out.println("Finished");
		} catch (Exception e){
			System.err.println(e);
		}
	}
	
	public static void generatePDFFromSQL(){
		try{
			Connection connection = connectToDatabase();
			Document document = new Document();
			
			PdfWriter.getInstance(document, new FileOutputStream("revisionLog.pdf"));
			document.open();
			
			PreparedStatement ps=null;
			ResultSet rs=null;

			String query = "SELECT * FROM mydb.revisionlog";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();

			while (rs.next()){
				Paragraph para=new Paragraph(rs.getInt("REVISION_ID")+"  "+rs.getString("DESCRIPTION"));
				document.add(para);
				document.add(new Paragraph(" "));

			} 
			document.close();
			System.out.println("Finished");

		} catch (Exception e){
		System.err.println(e);
		}
	}

	
	public static void refreshTable() {
		removeFields();
		updateFields(group);
	}
	
	public static void release() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Release");
		alert.setHeaderText("Are you sure you'd like to Release?");

		Optional<ButtonType> result = alert.showAndWait();
		
		
		if (result.get() == ButtonType.OK) {
			//revNum = revNum.substring(9);
			try {
				Connection connection = connectToDatabase();
				String query = "UPDATE mydb.revisionlog SET RELEASED=? WHERE SAVEPDF=?";
				
				PreparedStatement ps = connection.prepareStatement(query);
				ps.setInt(1, 1);
				ps.setInt(2, 1);
				ps.executeUpdate();
				connection.close();
				StartAtOne = 1;
				refreshTable();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			// actions if ok
			// ex. add to DB
		} else {
			// user chose CANCEL or closed the dialog
		}
	}
	
	public static void removeFields() {
		buttons.clear();
		for (int i = 0; i < labels.size(); i++)
			group.getChildren().remove(labels.get(i));
		for (int i = 0; i < textFields.size(); i++)
			group.getChildren().remove(textFields.get(i));
	}
	
	public static void updateFields(Group root) {
		numberOfFields = 2.1;
		try {
			Connection connection = connectToDatabase();
			String query1 = "SELECT * FROM mydb.revisionlog";
			Statement stst = connection.createStatement();
			ResultSet fullRevisionLog = stst.executeQuery(query1);
			
	
			while(fullRevisionLog.next()) {
				
				numberOfFields += 0.4;
				
				int revisionNum = fullRevisionLog.getInt("REVISION_ID");
				Date dateCreated = fullRevisionLog.getDate("DATE");
				String description = fullRevisionLog.getString("DESCRIPTION");
				int code = fullRevisionLog.getInt("CODE");
				int release =fullRevisionLog.getInt("RELEASED");
				System.out.format("%s, %s, %s, %s\n", revisionNum, dateCreated, description, code);
				
				
				Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			    int screenWidth=(int) primaryScreenBounds.getWidth();
			    int screenHeight = (int) primaryScreenBounds.getHeight();
			    double fieldWidthAlignment = screenWidth/10.5;
			    int proportionalHeight = screenHeight/10;
			    
			    if (release == 0) {
			    					    
				    Label lblRevision = new Label();
				    lblRevision.setText(String.valueOf(("R" + StartAtOne)));
				    lblRevision.setPrefWidth(100);
				    lblRevision.setAlignment(Pos.CENTER);
				    lblRevision.setLayoutX(fieldWidthAlignment);
				    lblRevision.setLayoutY(proportionalHeight*numberOfFields);
				    lblRevision.setStyle("-fx-background-color: #d4ffd4;-fx-padding: 5 10 5 10;");
					
				    
				    /**
				     * Date Text field 1
				     */
				    TextField txtDate = new TextField();
				    txtDate.setText(String.valueOf(dateCreated));

				    txtDate.setPrefWidth(90);
				    txtDate.setPromptText("yy/mm/dd");
				    txtDate.setAlignment(Pos.CENTER);
				    txtDate.setLayoutX(fieldWidthAlignment*2);
				    txtDate.setLayoutY(proportionalHeight*numberOfFields);
			        txtDate.setStyle("-fx-background-color: #d4ffd4;");
			        /**
			         * Description Textfield 1
			         * 			         */
				       
			        TextField txtDescription = new TextField();
			        txtDescription.setText(description);
				    txtDescription.setPrefWidth(260);
			        txtDescription.setPromptText("1234567890123456789012345678901234567890");
			        txtDescription.setAlignment(Pos.BASELINE_LEFT);
			        txtDescription.setLayoutX(fieldWidthAlignment*3);
			        txtDescription.setLayoutY(proportionalHeight*numberOfFields);
				    txtDescription.setStyle("-fx-background-color: #d4ffd4;");
				    /**
			         * 
			         * Code TextField 1
			         * 		         */
				    TextField txtCode = new TextField();
				    txtCode.setText(String.valueOf((code)));
				    txtCode.setPrefWidth(100);
				    txtCode.setPromptText("1234567890");
				    txtCode.setAlignment(Pos.CENTER);
				    txtCode.setLayoutX(fieldWidthAlignment*5);
				    txtCode.setLayoutY(proportionalHeight*numberOfFields);
				    txtCode.setStyle("-fx-background-color: #d4ffd4;");

				    StartAtOne +=1;
				    
				    labels.add(lblRevision);
				    labelsTemp.add(lblRevision);
				    textFields.addAll(txtDate, txtDescription, txtCode);
				    textFieldsTemp.addAll(txtDate, txtDescription, txtCode);
				    
				    for (int i = 0; i < textFieldsTemp.size(); i++)
				    	root.getChildren().addAll(textFieldsTemp.get(i));
				    for (int i = 0; i < labelsTemp.size(); i++)
				    	root.getChildren().add(labelsTemp.get(i));
				    
				    textFieldsTemp.clear();
				    labelsTemp.clear();
			    }
			    else {
			    	
				    Label lblRevision = new Label();
				    lblRevision.setText(String.valueOf(("R" + StartAtOne)));
				    lblRevision.setPrefWidth(100);
				    lblRevision.setAlignment(Pos.CENTER);
				    lblRevision.setLayoutX(fieldWidthAlignment);
				    lblRevision.setLayoutY(proportionalHeight*numberOfFields);
				    lblRevision.setStyle("-fx-background-color: #DCDCDC;-fx-padding: 5 10 5 10;");
					
				    
				    /**
				     * Date Text field 1
				     */
			        Label lblDate = new Label();
			        lblDate.setText(String.valueOf(dateCreated));
			        lblDate.setAlignment(Pos.CENTER);
			        lblDate.setLayoutX(fieldWidthAlignment*2);
			        lblDate.setLayoutY(proportionalHeight*numberOfFields);
			        lblDate.setStyle("-fx-background-color: #DCDCDC; -fx-padding: 5 10 5 10;");
			        
			        /**
			         * Description Textfield 1
			         * 			         */
				    Label lblDescription = new Label();
				    lblDescription.setText(description);
				    lblDescription.setPrefWidth(260);
				    lblDescription.setAlignment(Pos.BASELINE_LEFT);
				    lblDescription.setLayoutX(fieldWidthAlignment*3);
				    lblDescription.setLayoutY(proportionalHeight*numberOfFields);
				    lblDescription.setStyle("-fx-background-color: #DCDCDC; -fx-padding: 5 10 5 10;");
				    /**
			         * 
			         * Code TextField 1
			         * 		         	
			         * 
			         */
				    Label lblCode = new Label();
				    lblCode.setText(String.valueOf((code)));
				    lblCode.setPrefWidth(100);

				    lblCode.setAlignment(Pos.CENTER);
				    lblCode.setLayoutX(fieldWidthAlignment*5);
				    lblCode.setLayoutY(proportionalHeight*numberOfFields);
				    lblCode.setStyle("-fx-background-color: #DCDCDC; -fx-padding: 5 10 5 10;");

				    StartAtOne +=1;
				    
				    labels.addAll(lblRevision, lblDate, lblDescription, lblCode);
				    labelsTemp.addAll(lblRevision, lblDate, lblDescription, lblCode);
				    for (int i = 0; i < labelsTemp.size(); i++)
				    	root.getChildren().addAll(labelsTemp.get(i));
				    labelsTemp.clear();
			    				    	
			    	
			    }
			    /**
			    * Revision textField 1
			    */
			}
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

