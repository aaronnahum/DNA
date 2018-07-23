package DSP;

import DSP.RevisionLog;
import com.itextpdf.text.BadElementException;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.Paper;
import java.awt.Image;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;
import javax.print.*;
  
public class PrintTest{
   
    private static BufferedImage image;
    static Image scaled = null;
    
    public static void printPDF() throws IOException, BadElementException, PrintException {

        WritableImage snapshot = RevisionLog.group.snapshot(new SnapshotParameters(), null);
        File file = new File("log.png");
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
        } catch (IOException e) {
            System.err.println(e);
        }

        image = ImageIO.read(new File("log.png"));
        
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (pj.printDialog()) {
            PageFormat pf = pj.defaultPage();
            Paper paper = pf.getPaper();

//                        609.6 x 457.2 = 24x18 in
            double width = fromCMToPPI(60.96);
            double height = fromCMToPPI(45.72);
              
            //2100.0,1500.0);
            paper.setSize(2100.0,1500.0);         
            
            paper.setImageableArea(
                            fromCMToPPI(20.0),
                            fromCMToPPI(10.0),
                            2100.0 - fromCMToPPI(20.0),
                            1500.0 - fromCMToPPI(10.0));
            pf.setOrientation(PageFormat.LANDSCAPE);
            pf.setPaper(paper);           
            
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