package br.com.sentinela.rotina;

import javax.mail.MessagingException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.sentinela.defines.Constantes;
import br.com.sentinela.model.Mensagem;
import br.com.sentinela.model.PastoralCaridade;

public class SendEmail {
	
	public SendEmail() {
		
	}
	
	@SuppressWarnings("deprecation")
	public void sendEmail(PastoralCaridade pastoralCaridade, Mensagem mensagem) throws EmailException {
		String html;
		
		html = mensagem.getTexto();
	    html = html.replace("$1?", pastoralCaridade.getNome());
	    		  
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setDebug(true);
		htmlEmail.setHtmlMsg(html);
		htmlEmail.addTo(pastoralCaridade.getEmail());
		htmlEmail.setSubject("Feliz aniversário");
		htmlEmail.setFrom(Constantes.MAYEMAIL);
		htmlEmail.setHostName("smtp.googlemail.com");
		htmlEmail.setSSLOnConnect(true);
		htmlEmail.setSmtpPort(587);
		htmlEmail.setStartTLSRequired(true);
		//htmlEmail.setTLS(true);
		//htmlEmail.setSSL(true);                
		htmlEmail.setAuthenticator(new DefaultAuthenticator(Constantes.MAYEMAIL,Constantes.MAYKEY));            
		htmlEmail.send();
		
		/*Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "625");
	    email.setSmtpPort(587);
	    email.setStartTLSRequired(true);
	    props.put("mail.smtp.starttls.enable", "true");
	 
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() 
	           {
	                 return new PasswordAuthentication(Constantes.MAYEMAIL,Constantes.MAYKEY);
	           }
	      });
	 
	    session.setDebug(true);
	    if ( pastoralCaridade == null || pastoralCaridade.getEmail() == null || pastoralCaridade.getEmail().isEmpty())
	    	return;
	 
	    try {
	 
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(Constantes.MAYEMAIL)); 
	      //Remetente
	 
	      Address[] toUser = InternetAddress.parse(pastoralCaridade.getEmail());  
	 
	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Feliz aniversário");//Assunto
	      html = mensagem.getTexto();
	      html = html.replace("$1?", pastoralCaridade.getNome());
		  message.setContent(html, "text/html; charset=UTF-8");
		  Transport.send(message);
	 
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }*/
	}

}
