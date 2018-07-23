package DSP;


import DSP.RevisionLog;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
//import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.print.PrintHelper;
import com.sun.javafx.print.Units;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.Paper;
import java.awt.Image;
import java.awt.Robot;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList; 
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
//import javafx.print.Paper;
import javafx.scene.SnapshotParameters;
//import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
//import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.print.*;
import javax.print.attribute.*; 
import javax.print.attribute.standard.*; 
  
public class PrintTest{
   
    private static BufferedImage image;
    static Image scaled = null;
    
//    public void print() throws AWTException {
//        Robot robot = new Robot();
//        BufferedImage bi = "Log.png";
//    }
    
    public static void printPDF() throws IOException, BadElementException, PrintException {

        WritableImage snapshot = RevisionLog.group.snapshot(new SnapshotParameters(), null);
        File file = new File("log.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
        } catch (IOException e) {
            System.err.println(e);
        }

        image = ImageIO.read(new File("log.png"));

        System.out.println(image.getWidth() + "x" + image.getHeight());
        
//        Constructor<Paper> c = Paper.class.getDeclaredConstructor(String.class, double.class, double.class, Units.class);
//        c.setAccessible(true);
//        Paper archC = c.newInstance("archc", 24, 18, Units.INCH);
//        javafx.print.Paper archC2 = PrintHelper.createPaper("24x18", 24, 18, Units.INCH);
        
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.printDialog()) {
            PageFormat pf = pj.defaultPage();
            System.out.println("PF HEIGHT" + pf.getHeight());
            System.out.println("PF IMAGEABLE HEIGHT"+pf.getImageableHeight());
            System.out.println("PF IMAGEABLEX"+pf.getImageableX());
            System.out.println("PF WIDTH"+pf.getWidth());
            System.out.println("PF IMAGEABLE WIDTH"+pf.getImageableWidth());
            System.out.println("PF IMAGEABLE Y"+pf.getImageableY());
            Paper paper = pf.getPaper();
//            Paper paper = pj.defaultPage().getPaper();

//                        609.6 x 457.2 = 24x18 in
            double width = fromCMToPPI(60.96);
            double height = fromCMToPPI(45.72);
            
            System.out.println("------------------------------------------------------");      
            System.out.println("paper HEIGHT" + paper.getHeight());
            System.out.println("paper IMAGEABLE HEIGHT"+paper.getImageableHeight());
            System.out.println("paper IMAGEABLEX"+paper.getImageableX());
            System.out.println("paper WIDTH"+paper.getWidth());
            System.out.println("paper IMAGEABLE WIDTH"+paper.getImageableWidth());
            System.out.println("paper IMAGEABLE Y"+paper.getImageableY());            
            //2100.0,1500.0);
            paper.setSize(2100.0,1500.0);
            System.out.println("------------------------------------------------------");
            System.out.println("paper HEIGHT" + paper.getHeight());
            System.out.println("paper IMAGEABLE HEIGHT"+paper.getImageableHeight());
            System.out.println("paper IMAGEABLEX"+paper.getImageableX());
            System.out.println("paper WIDTH"+paper.getWidth());
            System.out.println("paper IMAGEABLE WIDTH"+paper.getImageableWidth());
            System.out.println("paper IMAGEABLE Y"+paper.getImageableY());            
            
            paper.setImageableArea(
                            fromCMToPPI(20.0),
                            fromCMToPPI(10.0),
                            2300.0 - fromCMToPPI(20.0),
                            1500.0 - fromCMToPPI(10.0));
            pf.setOrientation(PageFormat.LANDSCAPE);
            pf.setPaper(paper);
            
            System.out.println("------------------------------------------------------");
            System.out.println("paper HEIGHT" + paper.getHeight());
            System.out.println("paper IMAGEABLE HEIGHT"+paper.getImageableHeight());
            System.out.println("paper IMAGEABLEX"+paper.getImageableX());
            System.out.println("paper WIDTH"+paper.getWidth());
            System.out.println("paper IMAGEABLE WIDTH"+paper.getImageableWidth());
            System.out.println("paper IMAGEABLE Y"+paper.getImageableY());                
            
            PageFormat validatePage = pj.validatePage(pf);
            System.out.println("Valid- " + dump(validatePage));
            pj.setPrintable(new MyPrintable(), validatePage);
            try {
                pj.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected static double fromPPItoCM(double dpi) {
        return dpi / 72 / 0.393700787;
    }

    protected static double fromCMToPPI(double cm) {
        return toPPI(cm * 0.393700787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }
 
    protected static String dump(Paper paper) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(paper.getWidth()).append("x").append(paper.getHeight())
                        .append("/").append(paper.getImageableX()).append("x").
                        append(paper.getImageableY()).append(" - ").append(paper
                        .getImageableWidth()).append("x").append(paper.getImageableHeight());
        return sb.toString();
    }

    protected static String dump(PageFormat pf) {
        Paper paper = pf.getPaper();
        return dump(paper);
    }

    public static class MyPrintable implements Printable {

        @Override
        public int print(Graphics graphics, PageFormat pageFormat,
                                         int pageIndex) throws PrinterException {
            System.out.println(pageIndex);
            int result = NO_SUCH_PAGE;
            if (pageIndex < 1) {
                Graphics2D g2d = (Graphics2D) graphics;
                System.out.println("[Print] " + dump(pageFormat));
                double width = pageFormat.getImageableWidth();
                double height = pageFormat.getImageableHeight();

                System.out.println("Print Size = " + fromPPItoCM(width) + "x" + fromPPItoCM(height));
                g2d.translate((int) pageFormat.getImageableX(),
                                (int) pageFormat.getImageableY());
                
                if (width > height) {
                    scaled = image.getScaledInstance((int)Math.round(width), -1, Image.SCALE_SMOOTH);
                } else {
                    scaled = image.getScaledInstance(-1, (int)Math.round(height), Image.SCALE_SMOOTH);
                }
                g2d.drawImage(scaled, 0, 0, null);
                result = PAGE_EXISTS;
            }
            return result;
        }

    }
   
   
}