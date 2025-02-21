package util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {
    
    // Mailtrap credentials - replace with your actual values
    private static final String HOST = "sandbox.smtp.mailtrap.io";
    private static final String PORT = "587";
    private static final String USERNAME = "3ba897d0b91369";
    private static final String PASSWORD = "34bc9da23a2f6a";
    
    public static boolean sendEmail(String to, String subject, String body) {
        // Configure SMTP server properties
    	Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS is enabled
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);
        
        // Create session with authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        
        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@yourapp.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            
            // Send message
            Transport.send(message);
            System.out.println("Email sent successfully to Mailtrap");
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
            return false;
        }
    }
}