package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseChat;
import utility.DataReader;

public class RequestChat extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseChat responseChat;

    public RequestChat() {
        responses.add(responseChat = new ResponseChat());
    }

    @Override
    public void parse() throws IOException {
        message = DataReader.readString(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseChat.setMessage(message);
        
    }
}
