package javaCore.lesson_6.src.main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost", 1234);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Input a message for Server: ");
                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);

                if ("end".equals(request))
                    break;

                System.out.println("Response from Server: " + dataInputStream.readUTF());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

