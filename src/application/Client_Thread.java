package application;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Platform;

public class Client_Thread extends Thread{
	
	DataInputStream dis = null;
	ChatController client;
	public Client_Thread(DataInputStream dis,ChatController client) {
		this.dis = dis;
		this.client = client;
	}
	
	public void run() {
		while(true) {
			try {
				while(dis.available()==0) { 
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {e.printStackTrace();}
				}
				String Message = dis.readUTF();
				client.addMessageToScreen(Message);
								
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	};
}


















//if(Message.contains("SET USERS/")) {
//	
//	List<String> Users = new ArrayList<String>();
//	 Matcher m = Pattern.compile("(\\w+)")
//	     .matcher(Message.split("/")[1]);
//	 while (m.find()) {
//		 Users.add(m.group());
//	 }
////	String[] Users = Pattern.compile("(\\w+)")
////              .matcher(Message.split("-")[1])
////              .results()
////              .map(MatchResult::group)
////              .toArray(String[]::new);
//	client.addUsers(Users);
//	continue;
//}

