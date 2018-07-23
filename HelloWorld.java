

import javafx.application.Application;
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
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

/** 
 * 
 * extends application which is an import
 *
 */
public class revisionLog extends Application implements  EventHandler<ActionEvent>{
	/**  fix buttons tomorrow using hover and CSS import*/

	Button btnAddaField;
	Button btnRevision;
	Button btnDate;
	Button btnInitial;
	Button btnDescription;
	Button btnCode;
	Button btnDraft;
	Button btnFinal;
	Button btnRelease;
	Button btnPrint;
	Button btnDNAPlot;
	Button btnHelp;
	Button btnAdd1;
	Button btnAdd2;
	Button btnSaveDraft;
	Button btnSaveRelease;
	Button btnConfirm;
	
	TextField txtRevision;
	TextField txtDate;
	TextField txtInitial;
	TextField txtDescription;
	TextField txtCode;
	
	public double numberOfFields = 2.5;
	
	
	public static void main(String[] args) {
		/** launches are javaFx */
		launch(args);
		
	}

	/**
	 *  To create Javafx app -> stage inside screen inside layout where we find widget
	 */
	@Override
	public void start(Stage stage) throws Exception {

		Group root = new Group();
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		int screenWidth=(int) primaryScreenBounds.getWidth();
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
		
		int fieldWidthAlignment = screenWidth/10;
		
		btnAddaField = new Button();
		btnAddaField.setText("Add a Field");
		btnAddaField.setOnAction(this);
		btnAddaField.setLayoutX(fieldWidthAlignment);
		btnAddaField.setLayoutY(proportionalHeight *1.5);
		btnAddaField.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold; \r\n");

		btnAddaField.setOnAction(e -> {
			if (numberOfFields < 8.5) {
				numberOfFields += 0.4;
				
				btnSaveDraft = new Button();
				btnSaveDraft.setText("Save as Draft");
				btnSaveDraft.setLayoutX(fieldWidthAlignment*7);
				btnSaveDraft.setLayoutY(proportionalHeight*numberOfFields);
				btnSaveDraft.setStyle(" -fx-background-color: \r\n" + 
						"        #000000,\r\n" + 
						"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
						"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
						"    -fx-background-insets: 0,1,2;\r\n" + 
						"    -fx-background-radius: 3,2,1;\r\n" + 
						"    -fx-padding: 3 10 3 10;\r\n" + 
						"    -fx-text-fill: black;\r\n" + 
						"    -fx-font-size: 12px; \r\n" + 
						"    -fx-font-weight: bold;");
				root.getChildren().add(btnSaveDraft);
				
				btnSaveRelease = new Button();
				btnSaveRelease.setText("Save & Release");
				btnSaveRelease.setLayoutX(fieldWidthAlignment*8);
				btnSaveRelease.setLayoutY(proportionalHeight*numberOfFields);
				btnSaveRelease.setStyle(" -fx-background-color: \r\n" + 
						"        #000000,\r\n" + 
						"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
						"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
						"    -fx-background-insets: 0,1,2;\r\n" + 
						"    -fx-background-radius: 3,2,1;\r\n" + 
						"    -fx-padding: 3 10 3 10;\r\n" + 
						"    -fx-text-fill: black;\r\n" + 
						"    -fx-font-size: 12px; \r\n" + 
						"    -fx-font-weight: bold;");
				root.getChildren().add(btnSaveRelease);
				
				btnConfirm = new Button();
				btnConfirm.setText("Confirm");
				btnConfirm.setLayoutX(fieldWidthAlignment*9);
				btnConfirm.setLayoutY(proportionalHeight*numberOfFields);
				btnConfirm.setStyle(" -fx-background-color: \r\n" + 
						"        #000000,\r\n" + 
						"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
						"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
						"    -fx-background-insets: 0,1,2;\r\n" + 
						"    -fx-background-radius: 3,2,1;\r\n" + 
						"    -fx-padding: 3 10 3 10;\r\n" + 
						"    -fx-text-fill: black;\r\n" + 
						"    -fx-font-size: 12px; \r\n" + 
						"    -fx-font-weight: bold;");
				root.getChildren().add(btnConfirm);
				
				txtRevision = new TextField();
				txtRevision.setPrefWidth(100);
				txtRevision.setText("1234567890");
				txtRevision.setAlignment(Pos.CENTER);
				txtRevision.setLayoutX(fieldWidthAlignment);
				txtRevision.setLayoutY(proportionalHeight*numberOfFields);
				txtRevision.setStyle("-fx-background-color: #d4ffd4;");
				root.getChildren().add(txtRevision);
				
				txtDate = new TextField();
				txtDate.setPrefWidth(90);
				txtDate.setText("yy/mm/dd");
				txtDate.setAlignment(Pos.CENTER);
				txtDate.setLayoutX(fieldWidthAlignment*2);
				txtDate.setLayoutY(proportionalHeight*numberOfFields);
				txtDate.setStyle("-fx-background-color: #d4ffd4;");
				root.getChildren().add(txtDate);
				
				txtInitial = new TextField();
				txtInitial.setPrefWidth(100);
				txtInitial.setText("1234567890");
				txtInitial.setAlignment(Pos.CENTER);
				txtInitial.setLayoutX(fieldWidthAlignment*3);
				txtInitial.setLayoutY(proportionalHeight*numberOfFields);
				txtInitial.setStyle("-fx-background-color: #d4ffd4;");
				root.getChildren().add(txtInitial);
				
				txtDescription = new TextField();
				txtDescription.setPrefWidth(260);
				txtDescription.setText("1234567890");
				txtDescription.setAlignment(Pos.BASELINE_LEFT);
				txtDescription.setLayoutX(fieldWidthAlignment*4);
				txtDescription.setLayoutY(proportionalHeight*numberOfFields);
				txtDescription.setStyle("-fx-background-color: #d4ffd4;");
				root.getChildren().add(txtDescription);
				
				txtCode = new TextField();
				txtCode.setPrefWidth(100);
				txtCode.setText("1234567890");
				txtCode.setAlignment(Pos.CENTER);
				txtCode.setLayoutX(fieldWidthAlignment*6);
				txtCode.setLayoutY(proportionalHeight*numberOfFields);
				txtCode.setStyle("-fx-background-color: #d4ffd4;");
				root.getChildren().add(txtCode);
			}
			
		});
		btnRevision = new Button();
		btnRevision.setText("Revision");
		btnRevision.setLayoutX(fieldWidthAlignment);
		btnRevision.setLayoutY(proportionalHeight *2);
		btnRevision.setStyle(" -fx-background-color: \r\n" +  
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		txtRevision = new TextField();
		txtRevision.setPrefWidth(100);
		txtRevision.setText("1234567890");
		txtRevision.setAlignment(Pos.CENTER);
		txtRevision.setLayoutX(fieldWidthAlignment);
		txtRevision.setLayoutY(proportionalHeight*2.5);
		txtRevision.setStyle("-fx-background-color: #d4ffd4;");
		
		btnDate = new Button();
		btnDate.setText("Date");
		btnDate.setLayoutX(fieldWidthAlignment*2);
		btnDate.setLayoutY(proportionalHeight *2);
		btnDate.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		txtDate = new TextField();
		txtDate.setPrefWidth(90);
		txtDate.setText("yy/mm/dd");
		txtDate.setAlignment(Pos.CENTER);
		txtDate.setLayoutX(fieldWidthAlignment*2);
		txtDate.setLayoutY(proportionalHeight*2.5);
		txtDate.setStyle("-fx-background-color: #d4ffd4;");
		
		btnInitial = new Button();
		btnInitial.setText("Initial");
		btnInitial.setLayoutX(fieldWidthAlignment*3);
		btnInitial.setLayoutY(proportionalHeight *2);
		btnInitial.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		txtInitial = new TextField();
		txtInitial.setPrefWidth(100);
		txtInitial.setText("1234567890");
		txtInitial.setAlignment(Pos.CENTER);
		txtInitial.setLayoutX(fieldWidthAlignment*3);
		txtInitial.setLayoutY(proportionalHeight*2.5);
		txtInitial.setStyle("-fx-background-color: #d4ffd4;");
		
		btnDescription = new Button();
		btnDescription.setText("Description");
		btnDescription.setLayoutX(fieldWidthAlignment*4);
		btnDescription.setLayoutY(proportionalHeight *2);
		btnDescription.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		txtDescription = new TextField();
		txtDescription.setPrefWidth(260);
		txtDescription.setText("1234567890");
		txtDescription.setAlignment(Pos.BASELINE_LEFT);
		txtDescription.setLayoutX(fieldWidthAlignment*4);
		txtDescription.setLayoutY(proportionalHeight*2.5);
		txtDescription.setStyle("-fx-background-color: #d4ffd4;");
		
		btnCode = new Button();
		btnCode.setText("Code");
		btnCode.setLayoutX(fieldWidthAlignment*6);
		btnCode.setLayoutY(proportionalHeight *2);
		btnCode.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		txtCode = new TextField();
		txtCode.setPrefWidth(100);
		txtCode.setText("1234567890");
		txtCode.setAlignment(Pos.CENTER);
		txtCode.setLayoutX(fieldWidthAlignment*6);
		txtCode.setLayoutY(proportionalHeight*2.5);
		txtCode.setStyle("-fx-background-color: #d4ffd4;");
		
		btnDraft = new Button();
		btnDraft.setText("Draft");
		btnDraft.setLayoutX(fieldWidthAlignment*7);
		btnDraft.setLayoutY(proportionalHeight *2);
		btnDraft.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		btnFinal = new Button();
		btnFinal.setText("Final");
		btnFinal.setLayoutX(fieldWidthAlignment*8);
		btnFinal.setLayoutY(proportionalHeight *2);
		btnFinal.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		btnRelease = new Button();
		btnRelease.setText("Release");
		btnRelease.setLayoutX(fieldWidthAlignment*9);
		btnRelease.setLayoutY(proportionalHeight *2);
		btnRelease.setStyle(" -fx-background-color: \r\n" +  
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" +
				"    -fx-font-weight: bold;");
		
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
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
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
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
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
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		btnSaveDraft = new Button();
		btnSaveDraft.setText("Save as Draft");
		btnSaveDraft.setLayoutX(fieldWidthAlignment*7);
		btnSaveDraft.setLayoutY(proportionalHeight*numberOfFields);
		btnSaveDraft.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		btnSaveRelease = new Button();
		btnSaveRelease.setText("Save & Release");
		btnSaveRelease.setLayoutX(fieldWidthAlignment*8);
		btnSaveRelease.setLayoutY(proportionalHeight*numberOfFields);
		btnSaveRelease.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		
		btnConfirm = new Button();
		btnConfirm.setText("Confirm");
		btnConfirm.setLayoutX(fieldWidthAlignment*9);
		btnConfirm.setLayoutY(proportionalHeight*numberOfFields);
		btnConfirm.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");	
		
		root.getChildren().addAll(btnAddaField,btnRevision,btnDate, btnInitial,btnDescription, btnCode, 
				btnDraft,btnFinal, btnRelease, btnPrint, btnDNAPlot,btnHelp,btnSaveDraft,
				btnSaveRelease,btnConfirm,txtRevision,txtDate,txtInitial,txtDescription, txtCode);
		
		Scene scene = new Scene(root, screenWidth, screenHeight, Color.WHITE);
		stage.setScene(scene);
		stage.setTitle("Revision Log");
		
		scene.getStylesheets().add("myStyle.css");
		stage.setScene(scene);
		stage.show();

		stage.setX(primaryScreenBounds.getMinX());
		stage.setY(primaryScreenBounds.getMinY());
		stage.setWidth(primaryScreenBounds.getWidth());
		stage.setHeight(primaryScreenBounds.getHeight());
		
	}
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btnAddaField) {
			System.out.println("Add a field button was clicked :)");
		}
		if(event.getSource() == btnHelp) {
			System.out.println("Display new help menu with exit button");
		}
	}


}
