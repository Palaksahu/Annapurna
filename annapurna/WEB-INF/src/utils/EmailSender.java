package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;

import javax.mail.Message;

public class EmailSender {

	public static void sendEmail(String toEmail, String subject,String message) {
		Properties properties = new Properties();
		properties.setProperty("mail.transport.protocol","smtp" );
		properties.setProperty("mail.smtp.auth","true");
		properties.setProperty("mail.smtp.host","smtp.gmail.com");
		properties.setProperty("mail.smtp.port","587");
		properties.setProperty("mail.smtp.starttls.enable","true");
		
		Session session = Session.getInstance(properties,new passwordAuth());
		
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			
		mimeMessage.setFrom("annapurna7828@gmail.com");
		mimeMessage.setSubject(subject);
		mimeMessage.setContent(message,"text/html");
		mimeMessage.setRecipients(Message.RecipientType.TO,toEmail);
		Transport.send(mimeMessage);
		
		}catch(MessagingException  e){
			  e.printStackTrace();
		}
	}
}
class passwordAuth extends Authenticator{
	public PasswordAuthentication  getPasswordAuthentication(){
		            return new PasswordAuthentication("annapurna7828@gmail.com","AnnapurnaA$2");
	}
}
