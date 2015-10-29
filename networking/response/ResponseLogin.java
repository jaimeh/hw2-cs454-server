package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;
import core.GameDB;
public class ResponseLogin extends GameResponse {

    private String message;
    private String[] login;
    private String username;
    private String password;

    public ResponseLogin() {
        responseCode = Constants.SMSG_AUTH;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        String result = "";
        setUP();
        if(checkDB(username,password)== true)
        	result = "Successful login";
        else
        	result ="Unsuccessful login";
        
        packet.addString(result);
        //packet.addString(message+"\nUsername: " + login[0] + " Password: " + login[1]);
        
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
		password = login[1];
	}
	
	public boolean checkDB(String user, String password){
		boolean valid = false;
		GameDB check = new GameDB();
		if(check.checkLogin(user, password) == true)
			valid = true;
		
		return valid;
	}
}
