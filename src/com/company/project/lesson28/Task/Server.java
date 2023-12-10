package com.company.project.lesson28.Task;

import com.sun.jdi.ClassNotPreparedException;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {
    private static final int PORT = 8090;
    private CopyOnWriteArraySet<ConnectionService> senders = new CopyOnWriteArraySet<>();
    private LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<>();

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started");
        new Thread(new Writer()).start();

        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Reader(new ConnectionService(socket))).start();
        }
    }

    class Reader implements Runnable {
        ConnectionService connection;

        public Reader(ConnectionService connection) {
            this.connection = connection;
            senders.add(connection);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Message message = connection.readMessage();
                    if (message.getText().equals("exit")) {
                        senders.remove(connection);
                        break;
                    }
                    messages.put(message);
                    connection.setSender(message.getSender());
                } catch (InterruptedException | IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Writer implements Runnable {

        @Override
        public void run() {
            Message messageOut = null;
            while (true) {
                try {
                    messageOut = messages.take();
                    String sender = messageOut.getSender();
                    for (ConnectionService c : senders) {
                        //if (!Objects.requireNonNull(sender).equals(c.getSender()))
                            try {
                                c.sendMessage(messageOut);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        try {
            server.start();
        } catch (ClassNotPreparedException e) {
            e.printStackTrace();
        }
    }
}