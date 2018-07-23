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
	
	public static void main(String args[]) {
		mailContent(1);
	}
	public static void mailContent(int mailContent) {
		if(mailContent == 1) {
			String content1 = "Dear Lead,"
            		+ "\n\n Associate #1 would like you to open up a new Revision"
            		+ "\n\n\n Associate";
			Mail("dsppracticeemail@gmail.com","Kepstrum2005","15nw2@queensu.ca","Testing Subject", content1);
		}else if (mailContent ==2) {
			String content2 = "Dear Lead,"
            		+ "\n\n Revision #3 has been Released from Revision Control";
			Mail("dsppracticeemail@gmail.com","Kepstrum2005","15nw2@queensu.ca","Testing Subject", content2);
		}
	}
    public static void Mail(String username, String password, String receiver, String subject, String content) {

    	/**
    	 * Has to send from a gmail account.
    	 * This is a gmail account made for our testing purposes.
    	 */
        //String username = "dsppracticeemail@gmail.com";
        //String password = "Kepstrum2005";

    	// Mailing properties
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // creates a mail session
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver));
            //sets the subject of the email
            message.setSubject(subject);
            // sets the text of the email
            // going to be like Associate would like to release etc
            message.setText(content);
            //this send the message
            Transport.send(message);

            System.out.println("Email WORKED :)");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
