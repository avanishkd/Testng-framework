package com.mindtree.test;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.annotations.Test;

public class SendReport {
  @Test
  public void sendReport() {

      String to = "ajaybhadoriya1897@gmail.com";

      String from = "saikata95@gmail.com";
      
      String password = "Skt@1121";

      String host = "smtp.gmail.com";

      Properties properties = System.getProperties();

      properties.setProperty("mail.smtp.host", host);
      
      properties.put("mail.smtp.auth","true");
      
      properties.put("mail.smtp.starttls.enable","true");
      
      properties.put("mail.smtp.port","587");

      Session session = Session.getDefaultInstance(properties, new Authenticator() {
    	  protected PasswordAuthentication getPasswordAuthentication() {
    		  return new PasswordAuthentication(from, password);
    	  }
	});

      try {
   
         MimeMessage message = new MimeMessage(session);

         
         message.setFrom(new InternetAddress(from));

         
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
         
         message.setSubject("Test Report");
         
         message.setText("Extent Report: " +"http://orchardpertest3977.cloudapp.net/jenkins/job/BookMyFurniture/ws/logs/Extent.html" +  "\n\n"
         		+"Logs: " + "http://orchardpertest3977.cloudapp.net/jenkins/job/BookMyFurniture/ws/logs/application.log" );

         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }

  }

}
