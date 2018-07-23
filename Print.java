package DSP;

import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;

public class Print {
	
	public static void pageSetup(Node node) { //Brings up the printing settings
		
		//Create a printer job for the default printer
		PrinterJob job = PrinterJob.createPrinterJob();
		
		if (job == null)
			return;
		
		boolean proceed = job.showPrintDialog(null);
		
		if (proceed)
			print(job, node);
		
	} // end pageSetup
	
	private static void print(PrinterJob job, Node node) { //Prints the page

		boolean printed = job.printPage(node);

		if (printed)
			job.endJob(); //End the printer job
		else { //Printing Error
			Alert printerError = new Alert(AlertType.ERROR);
			printerError.setTitle("Error");
			printerError.setHeaderText("Printing Error");
			printerError.setContentText("Uh oh! That's not supposed to happen!");
			printerError.initModality(Modality.APPLICATION_MODAL);
			printerError.showAndWait();
		}
	}// end print
}