package networking.response;

// Custom Imports
import java.util.ArrayList;

import core.GameDB;
import metadata.Constants;
import utility.GamePacket;

public class ResponseCheckMessage extends GameResponse {

    private String message;
    private String[] login;
    private String username;
    private String toUsername;
    private String chat_message = "";
    private GameDB chatObj = new GameDB();
    private ArrayList<String> result;
    private String text;

    public ResponseCheckMessage() {
        responseCode = Constants.SMSG_CHECK_MESSAGE;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        
        result = chatObj.retrieveMessages(message);
        
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
	
	
	public void setDisplay(){
		text = "";
		for(int i = 0; i<result.size(); i++){
			text = text + result.get(i) + "\n";
		}
		
	}
	
}
