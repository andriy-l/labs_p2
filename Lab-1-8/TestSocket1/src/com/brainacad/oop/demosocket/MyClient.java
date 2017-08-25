package com.brainacad.oop.demosocket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

    public static void main(String[] args) {

        InetAddress inetAddress = null;

        try {
            inetAddress = InetAddress.getByAddress(new byte[]{(byte) 127, (byte) 0, (byte) 0, (byte) 1});
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try(Socket socket = new Socket(inetAddress, 8888);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(socket.getInputStream())) {

            String str = "PING\n";

            for (int i = 0; i < 10; i++) {
                pw.write(str);
                pw.flush();
                System.out.println(scanner.nextLine());
                Thread.sleep(1_000);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
