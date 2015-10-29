package networking.response;

// Custom Imports
import metadata.Constants;
import utility.GamePacket;

public class ResponseHeartbeat extends GameResponse {

    private String message;

    public ResponseHeartbeat() {
        responseCode = Constants.SMSG_HEARTBEAT;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addString(message+"--CS454");
        
        return packet.getBytes();
    }
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
