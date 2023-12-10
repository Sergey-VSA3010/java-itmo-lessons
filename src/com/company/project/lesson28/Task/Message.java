package com.company.project.lesson28.Task;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Message implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime() {
        dateTime = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "{" +
                "Отправитель='" + sender + '\'' +
                ", текст='" + text + '\'' +
                ", дата=" + dateTime +
                '}';
    }

    public static Message getMessage(String sender, String text) {
        return new Message(sender, text);
    }
}
