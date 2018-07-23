/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 
 * Class made that takes in a receiver and sender email 
 * and sends the variable "message" to the receiver email.
 * @author nic & Aaron
 *
 */
public class EmailClass {
    
    
    //EmailClass.Email("dsppracticeemail@gmail.com", "Kepstrum2005", "Testing Subject", "Dear Lead, \n\nAssociate #1 would like you to open up a new revision\n\nAssociate #1.", "15nw2@queensu.ca");
    public static void Email(String username, String password, String subject, String messageText, String receiver) {
//        String username = "dsppracticeemail@gmail.com";
//        String password = "Kepstrum2005";
//        String subject = "Testing";
//        String messageText = "messageText";
//        String receiver = "15nw2@queensu.ca";
        
    	/**
    	 * Has to send from a gmail account.
    	 * This is a gmail account made for our testing purposes.
    	 */
        //final String username = "dsppracticeemail@gmail.com";
        //final String password = "Kepstrum2005";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "stmp.gmail.com");
        props.put("mail.smtp.starttls.enable","true");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        System.out.println("BEFORE TRY");
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dsppracticeemail@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
            
            message.setSubject(subject);
            
            String somethingHasBeenReleased = ("Dear Lead,"
            		+ "\n\n Revision #3 has been Released from Revision Control");
            
            String toOpenNewRevision = ("Dear Lead,"
            		+ "\n\n Associate #1 would like you to open up a new Revision"
            		+ "\n\n\n Associate");
            message.setText(messageText);
            
            //message.setText("Dear Mail Crawler,"
            //    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Email Sent :)");

        } catch (MessagingException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}

