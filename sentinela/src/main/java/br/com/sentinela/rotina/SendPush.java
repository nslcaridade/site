package br.com.sentinela.rotina;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sentinela.defines.Constantes;
import br.com.sentinela.mensagem.PushMessage;
import br.com.sentinela.model.DadosUsuario;

public class SendPush {
	private URL url;
	private HttpURLConnection conn;
	private OutputStream outputStream;
	
	public SendPush(){
		
		
	}
	
	
	public void sendPush(DadosUsuario dadosUsuario, String texto) throws Exception  {
		System.out.println("DEBUG - dadosUsuario:"+dadosUsuario);
		// Create connection to send FCM Message request.
				try {
					this.url = new URL("https://fcm.googleapis.com/fcm/send");
					this.conn = (HttpURLConnection) url.openConnection();
					conn.setRequestProperty("Authorization", "key=" + Constantes.SERVER_KEY);
					conn.setRequestProperty("Content-Type", "application/json");
					conn.setRequestMethod("POST");
					conn.setDoOutput(true);
					System.out.println("DEBUG - conn:"+conn);
					this.outputStream = conn.getOutputStream();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        // Send FCM message content.
		
		PushMessage pushMessage = new PushMessage();
		pushMessage.setTo(dadosUsuario.getPushReceiverId());
		pushMessage.setPlatform(dadosUsuario.getPlataforma());
		pushMessage.getNotification().setTitle(Constantes.TITULOPUSH);
		pushMessage.getNotification().setBody(texto);
		pushMessage.getData().setTitle(Constantes.TITULOPUSH);
		pushMessage.getData().setBody(texto);
		
		String sPushMessage;
    	ObjectMapper objectMapper = new ObjectMapper();
    	sPushMessage = objectMapper.writeValueAsString(pushMessage);
    	
    	System.out.println("DEBUG - sPushMessage:"+sPushMessage);
        this.outputStream.write(sPushMessage.getBytes());
        
        System.out.println("DEBUG - getResponseCode:"+conn.getResponseCode());
        System.out.println("DEBUG - getResponseMessage:"+conn.getResponseMessage());

	}

}
