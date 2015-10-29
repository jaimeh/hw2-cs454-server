package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;
import core.GameDB;
public class ResponseRegister extends GameResponse {

    private String message;
    private String[] login;
    private String username;
    private String password;

    public ResponseRegister() {
        responseCode = Constants.SMSG_REGISTER;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        String result = "";
        setUP();
        if(checkusername(username) == true)
        	result = "User name taken please pick another username";
        else{
	        insertDB(username,password);
	        result = "Registration successful";
        }
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
	
	//Insert the user info into the db
	public void insertDB(String user, String password){
		GameDB check = new GameDB();
		check.register(user, password); 		
	}
	
	//Check to see if the user name is in the data base. If its true the username
	//is taken, false the name is available
	public boolean checkusername(String user){
		GameDB check = new GameDB();
		return check.checkAvailability(user);
	}
}
