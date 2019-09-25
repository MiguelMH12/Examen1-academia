package com.everis.examenuno.ejerciciotres;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServicioEmail implements IServicioEmail{
	Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private String remitente = "academiaeveris";
		
	public void enviarCorreo(String email, String asunto, String texto) {
		// TODO Auto-generated method stub
		Matcher mather = patron.matcher(email);
		if(mather.find() == true) {
			System.out.println("Direccion de correo valida");
			

		    Properties props = System.getProperties();
		    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
		    props.put("mail.smtp.user", remitente);
		    props.put("mail.smtp.clave", "tecguru$");    //La clave de la cuenta
		    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
		    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
		    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);
		    
		    try {
		    message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, email);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(texto);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "tecguru$");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        
		    } catch(MessagingException e){
		    	e.fillInStackTrace();
		    }
			
		}else {
			System.out.println("Email valido");
		}
	}

	public void enviarcorreoHTML(String email, String asunto, String html) {
		// TODO Auto-generated method stub
		Matcher mather = patron.matcher(email);
		if(mather.find() == true) {
			System.out.println("Direccion de correo valida");
		}else {
			System.out.println("Direccion de correo invalida");
		}
	}
	
}
