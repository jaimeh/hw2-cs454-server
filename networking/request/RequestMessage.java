package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseMessage;
import utility.DataReader;

public class RequestMessage extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseMessage responseChat;

    public RequestMessage() {
        responses.add(responseChat = new ResponseMessage());
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
