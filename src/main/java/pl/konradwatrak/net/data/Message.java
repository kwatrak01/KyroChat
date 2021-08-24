package pl.konradwatrak.net.data;

import java.time.LocalTime;

public class Message {

    private String absender = "", text = "";
    private LocalTime timeStamp;

    public Message(){};
    public Message(String absender, String text) {
        this.absender = absender;
        this.text = text;
    }

    public String getMessage() {
        return "[" + timeStamp.toString().substring(0, 5) + " " + absender + "] " + text + "\n";
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
