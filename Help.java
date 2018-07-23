import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.geometry.*;

public class Help {
	
	public static void help() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Help");
		window.setHeight(500);
		window.setWidth(460);
		window.setMinWidth(250);
		
		DropShadow shadowDrop = new DropShadow();
		
		Label lblHelpDef = new Label("Scroll Over Word For Its Definition");
		lblHelpDef.setTextFill(Color.BLACK);
		lblHelpDef.setFont(new Font("KufiStandardGK", 24));
		lblHelpDef.setStyle("-fx-font-weight: bold;");
		lblHelpDef.setStyle("-fx-underline: true;");
		lblHelpDef.setAlignment(Pos.CENTER);
		
		Label lblRevisionDef = new Label("Revision number of test.");
		lblRevisionDef.setVisible(false);
		lblRevisionDef.setMinHeight(25);
		
		Label lblRevision = new Label();
		lblRevision.setText("Revision");
		lblRevision.setMinWidth(110);
		lblRevision.setMinHeight(25);
		lblRevision.setAlignment(Pos.CENTER);
		lblRevision.setStyle(" -fx-background-color: \r\n" +  
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblRevision.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblRevisionDef.setVisible(true);
			lblRevision.setEffect(shadowDrop);
		});
		lblRevision.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblRevisionDef.setVisible(false);
			lblRevision.setEffect(null);
		});
		
		Label lblDateDef = new Label("The date the test took place.");
		lblDateDef.setVisible(false);
		lblDateDef.setMinHeight(25);
		
		Label lblDate = new Label();
		lblDate.setText("Date");
		lblDate.setMinWidth(110);
		lblDate.setMinHeight(25);
		lblDate.setAlignment(Pos.CENTER);
		lblDate.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblDate.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblDateDef.setVisible(true);
			lblDate.setEffect(shadowDrop);
		});
		lblDate.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblDateDef.setVisible(false);
			lblDate.setEffect(null);
		});
		
		Label lblInitialDef = new Label("What does this do????");
		lblInitialDef.setVisible(false);
		lblInitialDef.setMinHeight(25);
		
		Label lblInitial = new Label();
		lblInitial.setText("Initial");
		lblInitial.setMinWidth(110);
		lblInitial.setMinHeight(25);
		lblInitial.setAlignment(Pos.CENTER);
		lblInitial.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblInitial.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblInitialDef.setVisible(true);
			lblInitial.setEffect(shadowDrop);
		});
		lblInitial.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblInitialDef.setVisible(false);
			lblInitial.setEffect(null);
		});
		
		Label lblDescriptionDef = new Label("A brief description of the associated revision.");
		lblDescriptionDef.setVisible(false);
		lblDescriptionDef.setMinHeight(25);
			
		Label lblDescription = new Label();
		lblDescription.setText("Description");
		lblDescription.setMinWidth(110);
		lblDescription.setMinHeight(25);
		lblDescription.setAlignment(Pos.CENTER);
		lblDescription.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblDescription.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblDescriptionDef.setVisible(true);
			lblDescription.setEffect(shadowDrop);
		});
		lblDescription.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblDescriptionDef.setVisible(false);
			lblDescription.setEffect(null);
		});
		
		Label lblCodeDef = new Label("The code for the revision.");
		lblCodeDef.setVisible(false);
		lblCodeDef.setMinHeight(25);
		
		Label lblCode = new Label();
		lblCode.setText("Code");
		lblCode.setMinWidth(110);
		lblCode.setMinHeight(25);
		lblCode.setAlignment(Pos.CENTER);
		lblCode.setStyle(" -fx-background-color: \r\n" + 
				"        linear-gradient(#f49541, #f49541),\r\n" + 
				"        linear-gradient(#f49541 0%, #f49541 49%, #f49541 50%, #f49541 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 3 10 3 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblCode.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblCodeDef.setVisible(true);
			lblCode.setEffect(shadowDrop);
		});
		lblCode.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblCodeDef.setVisible(false);
			lblCode.setEffect(null);
		});
		
		Label lblAddAFieldDef = new Label("Adds a new revision line.");
		lblAddAFieldDef.setVisible(false);
		lblAddAFieldDef.setMinHeight(25);
		
		Label lblAddAField = new Label();
		lblAddAField.setText("Add a Field");
		lblAddAField.setMinWidth(110);
		lblAddAField.setMinHeight(25);
		lblAddAField.setAlignment(Pos.CENTER);
		lblAddAField.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold; \r\n");
		lblAddAField.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblAddAFieldDef.setVisible(true);
			lblAddAField.setEffect(shadowDrop);
		});
		lblAddAField.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblAddAFieldDef.setVisible(false);
			lblAddAField.setEffect(null);
		});
		
		Label lblSaveDraftDef = new Label("Save as Draft.");
		lblSaveDraftDef.setVisible(false);
		lblSaveDraftDef.setMinHeight(25);
		
		Label lblSaveDraft = new Label();
		lblSaveDraft.setText("Save as Draft");
		lblSaveDraft.setMinWidth(110);
		lblSaveDraft.setMinHeight(25);
		lblSaveDraft.setAlignment(Pos.CENTER);
		lblSaveDraft.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblSaveDraft.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblSaveDraftDef.setVisible(true);
			lblSaveDraft.setEffect(shadowDrop);
		});
		lblSaveDraft.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblSaveDraftDef.setVisible(false);
			lblSaveDraft.setEffect(null);
		});
		
		Label lblSaveReleaseDef = new Label("Save & Release.");
		lblSaveReleaseDef.setVisible(false);
		lblSaveReleaseDef.setMinHeight(25);
		
		Label lblSaveRelease = new Label();
		lblSaveRelease.setText("Save & Release");
		lblSaveRelease.setMinWidth(110);
		lblSaveRelease.setMinHeight(25);
		lblSaveRelease.setAlignment(Pos.CENTER);
		lblSaveRelease.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblSaveRelease.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblSaveReleaseDef.setVisible(true);
			lblSaveRelease.setEffect(shadowDrop);
		});
		lblSaveRelease.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblSaveReleaseDef.setVisible(false);
			lblSaveRelease.setEffect(null);
		});
		
		Label lblConfirmDef = new Label("Confirm Save & Release.");
		lblConfirmDef.setVisible(false);
		lblConfirmDef.setMinHeight(25);
		
		Label lblConfirm = new Label();
		lblConfirm.setText("Confirm");
		lblConfirm.setMinWidth(110);
		lblConfirm.setMinHeight(25);
		lblConfirm.setAlignment(Pos.CENTER);
		lblConfirm.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblConfirm.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblConfirmDef.setVisible(true);
			lblConfirm.setEffect(shadowDrop);
		});
		lblConfirm.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblConfirmDef.setVisible(false);
			lblConfirm.setEffect(null);
		});
	
		
		/**
		 * Print directs to separate print class
		 */
		
		Label lblPrintDef = new Label("Print");
		lblPrintDef.setVisible(false);
		lblPrintDef.setMinHeight(25);
		
		Label lblPrint = new Label();
		lblPrint.setText("Print");
		lblPrint.setMinWidth(110);
		lblPrint.setMinHeight(25);
		lblPrint.setAlignment(Pos.CENTER);
		lblPrint.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblPrint.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblPrintDef.setVisible(true);
			lblPrint.setEffect(shadowDrop);
		});
		lblPrint.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblPrintDef.setVisible(false);
			lblPrint.setEffect(null);
		});
		
		/**
		 * Directs to DNA Plot page
		 */
		
		Label lblDNAPlotDef = new Label("DNA Plot");
		lblDNAPlotDef.setVisible(false);
		lblDNAPlotDef.setMinHeight(25);
		
		Label lblDNAPlot = new Label();
		lblDNAPlot.setText("DNA Plot");
		lblDNAPlot.setMinWidth(110);
		lblDNAPlot.setMinHeight(25);
		lblDNAPlot.setAlignment(Pos.CENTER);
		lblDNAPlot.setStyle(" -fx-background-color: \r\n" + 
				"        #000000,\r\n" + 
				"        linear-gradient(#FFDAB9, #FFDAB9),\r\n" + 
				"        linear-gradient(#FFDAB9 0%, #FFDAB9 49%, #FFDAB9 50%, #FFDAB9 100%);\r\n" + 
				"    -fx-background-insets: 0,1,2;\r\n" + 
				"    -fx-background-radius: 3,2,1;\r\n" + 
				"    -fx-padding: 5 10 5 10;\r\n" + 
				"    -fx-text-fill: black;\r\n" + 
				"    -fx-font-size: 12px; \r\n" + 
				"    -fx-font-weight: bold;");
		lblDNAPlot.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> { // Displaying a shadow effect and the definition when the mouse cursor is on
			lblDNAPlotDef.setVisible(true);
			lblDNAPlot.setEffect(shadowDrop);
		});
		lblDNAPlot.addEventHandler(MouseEvent.MOUSE_EXITED, e -> { // Removing the shadow effect and hiding the definition when the mouse cursor is off
			lblDNAPlotDef.setVisible(false);
			lblDNAPlot.setEffect(null);
		});
		
		
		BorderPane layout = new BorderPane();
		
		HBox title = new HBox();
		title.setPadding(new Insets(15, 12, 15, 12));
		title.getChildren().add(lblHelpDef);
		title.setStyle("-fx-background-color: #DEFFB9");
		layout.setTop(title);
		
		VBox words = new VBox();
		words.setPadding(new Insets(10));
		words.setSpacing(10);
		words.getChildren().addAll(lblRevision, lblDate, lblInitial, lblDescription, lblCode, lblAddAField, lblSaveDraft, lblSaveRelease, lblConfirm, lblPrint, lblDNAPlot);
		words.setStyle("-fx-background-color: #DEFFB9");
		layout.setLeft(words);
		
		VBox definitions = new VBox();
		definitions.setPadding(new Insets(10.5));
		definitions.setSpacing(10);
		definitions.getChildren().addAll(lblRevisionDef, lblDateDef, lblInitialDef, lblDescriptionDef, lblCodeDef, lblAddAFieldDef, lblSaveDraftDef, lblSaveReleaseDef, lblConfirmDef, lblPrintDef, lblDNAPlotDef);
		definitions.setStyle("-fx-background-color: #DEFFB9");
		layout.setCenter(definitions);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.setResizable(false);
		window.showAndWait();
		
	} //end help
	
}
