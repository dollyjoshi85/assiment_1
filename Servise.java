package com.servise;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Servise {
	public static void sendMail(String emailid,int otp) {
		final String username="joshidolly36@gmail.com";//sender Email
		final String password="ywnw ljcy ugxc fqfy";
		
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.port","587");
		
	Session session = Session.getDefaultInstance(props,	new javax.mail.Authenticator() {
		        protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
		        	return new javax.mail.PasswordAuthentication(username, password);
		        }
	});
	System.out.println(session.getProperties());
	try {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(username));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailid));
		message.setSubject("OTP For Forgot Passsword");
		
		message.setText("DearUser,"+"\n\nYour OTP For Forgot Password is:"+otp);
		
		Transport.send(message);
		
		System.out.println("Done");
		
	} catch (MessagingException e )
	{
		System.out.println(e);
		throw new RuntimeException(e);
	
	}				
  }
}


