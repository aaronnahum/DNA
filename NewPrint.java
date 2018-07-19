package DSP;

import java.lang.reflect.InvocationTargetException;

import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;

import javafx.geometry.Insets;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.transform.Scale;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author mzhao
 */
public class NewPrint {
	

	
	public static void printNode(final Node node) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Printer printer = Printer.getDefaultPrinter();
		
		Paper photo = PrintHelper.createPaper("24x18", 24, 18, Units.INCH);
		
		PageLayout pageLayout= printer.createPageLayout(photo, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
		PrinterAttributes attr = printer.getPrinterAttributes();
		PrinterJob job = PrinterJob.createPrinterJob();
		double scaleX
		= pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
		double scaleY
		= pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
		Scale scale = new Scale(scaleX, scaleY);
		node.getTransforms().add(scale);

		if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
			boolean success = job.printPage(pageLayout, node);
			if (success) {
				job.endJob();

			}
		}
		node.getTransforms().remove(scale);
	}

}
