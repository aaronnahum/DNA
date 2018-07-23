/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;

import static DSP.ConnectionToDatabase.connectToDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Nic & Aaron
 */
public class ReleaseClass {
 

    public static void release() throws SQLException, ClassNotFoundException {
        Connection connection = connectToDatabase();
        Statement stm = connection.createStatement();
        String sql = "SELECT SAVEPDF FROM mydb.revisionlog";
        ResultSet rst;
        rst = stm.executeQuery(sql);
        int saveAsPDFTotal = 0;
        System.out.println("RIGHT HERE" + rst);
        while (rst.next()){
            if(rst.getInt("SAVEPDF")==1){
                saveAsPDFTotal += 1;
            }
        }        
        
        if (saveAsPDFTotal == 0){
            

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Release");
            alert.setHeaderText("Are you sure you'd like to Release?");

            Optional<ButtonType> result = alert.showAndWait();


            if (result.get() == ButtonType.OK) {
                //revNum = revNum.substring(9);
                try {
                    
                    //Send a PDF copy of current revisionLog To All Lead and Associates.


                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                // actions if ok
                // ex. add to DB
            } else {
                    // user chose CANCEL or closed the dialog
            }
        }else{
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Please make sure everything is Saved as a PDF.");
            
        }
    }
}
