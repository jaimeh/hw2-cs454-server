package networking.request;

// Java Imports
import java.io.IOException;

// Custom Imports
//import core.GameServer;
import networking.response.ResponseLogin;
import utility.DataReader;

public class RequestLogin extends GameRequest {

    // Data
    private String message;
    // Responses
    private ResponseLogin responseLogin;

    public RequestLogin() {
        responses.add(responseLogin = new ResponseLogin());
    }

    @Override
    public void parse() throws IOException {
        message = DataReader.readString(dataInput);
    }

    @Override
    public void doBusiness() throws Exception {
        responseLogin.setMessage(message);
        
    }
}
