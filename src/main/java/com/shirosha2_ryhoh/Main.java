package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Standby.");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(54190);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }


        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("from " + socket.getInetAddress());
                socket.getOutputStream().write("Hello\n".getBytes());
                socket.getOutputStream().flush();
            } catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                        System.out.println("closed");
                    } catch (Exception e) {
                    }
                }
            }
        }

    }
}
