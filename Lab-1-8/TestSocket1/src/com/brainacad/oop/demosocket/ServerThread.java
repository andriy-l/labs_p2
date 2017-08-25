package com.brainacad.oop.demosocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Socket socket = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        String str = "PONG";

        try(Scanner scanner = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
            int k = 0;
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine() + "-" + str + " " + this.getName() + " Number iteration: " + k++);
                printWriter.write(str + "\n");
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
