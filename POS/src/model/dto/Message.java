package model.dto;

public class Message {
    public String message;
    public MessageType type;

    public Message(String message, MessageType type) {
        this.message = message;
        this.type = type;
    }
}
