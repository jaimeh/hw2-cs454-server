package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseCheckMessage;
import utility.DataReader;

public class RequestCheckMessage extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseCheckMessage responseChat;

    public RequestCheckMessage() {
        responses.add(responseChat = new ResponseCheckMessage());
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
