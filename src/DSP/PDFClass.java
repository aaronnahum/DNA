/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;
import static DSP.ConnectionToDatabase.connectToDatabase;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;


import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;


/**
 *
 * @author mzhao
 */
public class PDFClass {
    //PDFClass.generatePDFFromSQL();
    
    public static void generatePDF2() throws IOException, BadElementException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        List<Image> image = new ArrayList<>();
        try {
            SnapshotParameters parameters = new SnapshotParameters();
            WritableImage snapshot = RevisionLog.group.snapshot(parameters, null);
        
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", byteStream);
            image.add(Image.getInstance(byteStream.toByteArray()));
        } catch (IOException e) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            Document document = new Document(PageSize.LETTER_LANDSCAPE.rotate());
            PdfWriter.getInstance(document, new FileOutputStream("revisionLog " + new Date().getTime() + ".pdf"));
            document.open();
            System.out.println(document.getPageSize());
            //image.get(0).scaleToFit(1296.0f, 1728.0f);
            //image.get(0).scaleToFit(1728.0f, 1296.0f);
            image.get(0).scaleToFit(725.0f, 612.0f);
            document.add(image.get(0));
            document.close();
        } catch(Exception e) {
            System.err.println(e);
        }
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
    public static ArrayList<RevisionControl> getAllRevision() throws ClassNotFoundException, SQLException{
        Connection connection = connectToDatabase();
        Statement stm = connection.createStatement();
        String sql = "SELECT * FROM mydb.revisionlog";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        ArrayList<RevisionControl> revisionControlList = new ArrayList<>();
        
        while (rst.next()){
            RevisionControl revisionControl = new RevisionControl(rst.getInt("REVISION_ID"), rst.getString("DESCRIPTION"), rst.getString("SCOPE"), rst.getString("CONTROLVOLUME"), rst.getString("SYSTEMMODELS"));
            revisionControlList.add(revisionControl);
        }
        return revisionControlList;
    }
    public static void generatePDFFromSQL(){
            try{
                    Connection connection = connectToDatabase();

                    // A4 is 8.27 in x 11.7 in
                    Document document = new Document(PageSize.A4);

                    PdfWriter.getInstance(document, new FileOutputStream("revisionLog.pdf"));
                    document.open();
                    
                    Image kepstrumLogo = Image.getInstance("logo.png");
                    //document.add(new Paragraph ("kepstrumLogo"));
                    document.add(kepstrumLogo);
                    PreparedStatement ps=null;
                    ResultSet rs=null;

                    String query = "SELECT * FROM mydb.revisionlog";
                    ps=connection.prepareStatement(query);
                    rs=ps.executeQuery();
                    
                    //document.add(new Paragraph(RevisionLog.scene));
                    
         
                    document.add(new Paragraph("Revision Control",FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
                    document.add(new Paragraph("Date Saved:     " + new Date().toString()));
                    document.add(new Paragraph("_____________________________________________________________________\n\n"));

                    document.add(new Paragraph("\n"));
                    document.add(new Paragraph(""));
                    
                    
                    // 2 is the number of columns for the table
                            
                    PdfPTable table = new PdfPTable(4);
                    PdfPCell cell = new PdfPCell(new Paragraph("Revision Control"));
                    cell.setColspan(8);
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.ORANGE);
                    cell.setPadding(10.0f);
                    
                    table.addCell(cell);
                    
                    table.addCell("Revision ID");
                    table.addCell("");
                    table.addCell("");
                    table.addCell("Date");
                    table.addCell("");
                    table.addCell("");
                    table.addCell("Scope");
                    table.addCell("");
                    table.addCell("");                    
                    
                    document.add(table);
                   
                    while (rs.next()){
                            Paragraph para=new Paragraph(rs.getInt("REVISION_ID")+"  "+rs.getString("DESCRIPTION"));
                            document.add(para);
                            document.add(new Paragraph(" "));

                    } 
                    document.close();
                    System.out.println("Finished PDF!!!");

            } catch (Exception e){

            System.err.println(e);
            }
    }



    
}
