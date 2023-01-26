package javaCore.lesson_6.src.main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server is started and waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if ("end".equals(clientRequest))
                    break;

                System.out.println("Server got string " + clientRequest);

                dataOutputStream.writeUTF("Server responds " + clientRequest);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
