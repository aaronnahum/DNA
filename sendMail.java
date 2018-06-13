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
public class sendMail {
	
    public static void main(String[] args) {

    	/**
    	 * Has to send from a gmail account.
    	 * This is a gmail account made for our testing purposes.
    	 */
        final String username = "dsppracticeemail@gmail.com";
        final String password = "Kepstrum2005";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dsppracticeemail@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("15nw2@queensu.ca"));
            
            message.setSubject("Testing Subject");
            
            String somethingHasBeenReleased = ("Dear Lead,"
            		+ "\n\n Revision #3 has been Released from Revision Control");
            
            String toOpenNewRevision = ("Dear Lead,"
            		+ "\n\n Associate #1 would like you to open up a new Revision"
            		+ "\n\n\n Associate");
            message.setText(toOpenNewRevision);
            
            //message.setText("Dear Mail Crawler,"
            //    + "\n\n No spam to my email, please!");

            Transport.send(message);

            System.out.println("Email Sent :)");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
