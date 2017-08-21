package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6666);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream()) {


        }
       catch (IOException e){
                e.printStackTrace();
       }
    }

}
