package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseHeartbeat;
import utility.DataReader;

public class RequestHeartbeat extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseHeartbeat responseHeartbeat;

    public RequestHeartbeat() {
        responses.add(responseHeartbeat = new ResponseHeartbeat());
    }

    @Override
    public void parse() throws IOException {
        message = DataReader.readString(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
    	responseHeartbeat.setMessage(message);
        
    }
}
