package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public final static short CMSG_AUTH = 101;
    public final static short CMSG_REGISTER = 103;
    public final static short SMSG_REGISTER = 203;
    public final static short CMSG_CREATE_CHARACTER = 104;
    public final static short SMSG_AUTH = 201;
    public final static short CMSG_CHAT = 112;
    public final static short SMSG_CHAT = 212;
    public final static short CMSG_MESSAGE = 115;
    public final static short SMSG_MESSAGE = 215;
    public final static short CMSG_CHECK_MESSAGE = 116;
    public final static short SMSG_CHECK_MESSAGE = 216;
    public final static short CMSG_HEARTBEAT = 113;
    public final static short SMSG_HEARTBEAT = 213;
    public final static short CMSG_SAVE_EXIT_GAME = 119;
    public final static short SMSG_SAVE_EXIT_GAME = 219;

    //Test Request + Response
    public final static short RAND_INT = 1;
    public final static short RAND_STRING = 2;
    public final static short RAND_SHORT = 3;
    public final static short RAND_FLOAT = 4;
    // Other
    public static final int SAVE_INTERVAL = 60000;
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 90;
}
