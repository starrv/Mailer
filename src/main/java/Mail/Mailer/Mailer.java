package Mail.Mailer;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailer
{
      // Recipient's email ID needs to be mentioned.
	public static void sendMail(String username, String password, String host, String from, String to, String subject, String body)
	{

		final String user=username;
		final String pass=password;
		
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "2525");

      // Get the Session object.
      System.out.println("Creating session....");
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() 
      {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
               return new PasswordAuthentication(user, pass);
            }
       });

      try 
      {
	   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		   message.setFrom(new InternetAddress(from));
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject(subject);
		
		   // Now set the actual message
		   message.setText(body);
	
		   // Send message
		   Transport.send(message);
		   System.out.println("Sending message....");
		   System.out.println("Sent message successfully....");

      } 
      catch (MessagingException e)
      {
         System.out.println("Message Failed to be sent");
         e.printStackTrace();
      }
	}
	
	public static void sendMail(String username, String password, String host, String to, String subject, String body)
	{

		final String user=username;
		final String pass=password;
		
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "2525");

      // Get the Session object.
      System.out.println("Creating session....");
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() 
      {
            protected PasswordAuthentication getPasswordAuthentication() 
            {
               return new PasswordAuthentication(user, pass);
            }
       });

      try 
      {
	   // Create a default MimeMessage object.
		   Message message = new MimeMessage(session);
		
		   // Set From: header field of the header.
		
		   // Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse(to));
		
		   // Set Subject: header field
		   message.setSubject(subject);
		
		   // Now set the actual message
		   message.setText(body);
	
		   // Send message
		   Transport.send(message);
		   System.out.println("Sending message....");
		   System.out.println("Sent message successfully....");

      } 
      catch (MessagingException e)
      {
         System.out.println("Message Failed to be sent");
         e.printStackTrace();
      }
	}
}