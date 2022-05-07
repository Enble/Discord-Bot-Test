package springbot;

public class Message {

    private String msg;

    public void help() {
        msg = "!help, !h : see commands\n";
    }

    public String getMsg() {
        return msg;
    }

}
