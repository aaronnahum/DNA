package DSP;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.geometry.*;
//import DSP.LabelClass.*;

public class Help {
    
    static Scene scene;
	
    /**
     * Creates the help window
     */
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
