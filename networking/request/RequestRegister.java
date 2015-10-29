package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseRegister;
import utility.DataReader;

public class RequestRegister extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseRegister responseRegister;

    public RequestRegister() {
        responses.add(responseRegister = new ResponseRegister());
    }

    @Override
    public void parse() throws IOException {
        message = DataReader.readString(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseRegister.setMessage(message);
        
    }
}
