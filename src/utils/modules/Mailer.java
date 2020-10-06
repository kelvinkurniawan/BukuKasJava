/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import models.User;

/**
 *
 * @author kelvi
 */
public class Mailer {
    
    /**
     * fungsi send email
     * @param receiver
     * @param user 
     */
        public static void sendMail(String receiver, User user) {

        // Recipient's email ID needs to be mentioned.
        String to = receiver;

        // Sender's email ID needs to be mentioned
        String from = "tepinnko@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("tepinnko@gmail.com", "Kelvinko123");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("BukuKas Registration Succeessfully!");

            // Now set the actual message
            message.setText("Welcome to buku kas .. Thanks for your Registration \n \n Detail Akun : \n"
                    + "Name : " + user.getName() + "\n"
                    + "Email : " + user.getEmail() + "\n"
                    + "Username : " + user.getUsername()+ "\n"
                    + "Password : ***Secret***\n"
                    + "Phone : " + user.getPhone()+ "\n");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
