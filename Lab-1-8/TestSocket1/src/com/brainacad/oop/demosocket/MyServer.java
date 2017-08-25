package com.brainacad.oop.demosocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {


        try(ServerSocket ss = new ServerSocket(8888)) {
                while (true) {
                    Socket socket = ss.accept();
                    ServerThread serverThread = new ServerThread(socket);
                    serverThread.start();
                }

            } catch(IOException e){
                e.printStackTrace();
            }


    }

}
