package networking.response;

// Custom Imports
import java.util.ArrayList;

import core.GameDB;
import metadata.Constants;
import utility.GamePacket;

public class ResponseChat extends GameResponse {

    private String message;
    private String[] login;
    private String username;
    private String chat_message = "";
    private GameDB chatObj = new GameDB();
    private ArrayList<String> result;
    private String text;

    public ResponseChat() {
        responseCode = Constants.SMSG_CHAT;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        setUP();
        chatObj.chat(username, chat_message);
        
        result = chatObj.retrieveChat();
        
        setDisplay();
        
        packet.addString(text);
        
        return packet.getBytes();
    }
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setUP(){
		login = message.split(" ");
		username = login[0];
		for(int i=1;i<login.length;i++ ){
			chat_message = chat_message + login[i]+ " ";
		}
	}
	
	public void setDisplay(){
		text = "";
		for(int i = 0; i<result.size(); i++){
			text = text + result.get(i) + "\n";
		}
		
	}
	
}
