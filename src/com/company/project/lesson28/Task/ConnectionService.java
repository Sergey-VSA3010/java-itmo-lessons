package com.company.project.lesson28.Task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionService implements AutoCloseable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String sender;

    public ConnectionService(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void setSender(String senders) {
        this.sender = senders;
    }

    public String getSender() {
        return sender;
    }

    public void sendMessage(Message message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) input.readObject();

    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
