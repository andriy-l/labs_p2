package com.brainacad.oop.demosocket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient extends Thread {

    private Student student;

    public MyClient(Student student) {
        this.student = student;
    }

    public void run() {
        try(Socket socket = new Socket("localhost", 8888);
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new  ObjectOutputStream(os);
            Scanner scanner = new Scanner(socket.getInputStream())) {

            oos.writeObject(student);

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
