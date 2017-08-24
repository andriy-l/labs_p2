package com.brainacad.oop.demosocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyServer extends Thread {

    private static List<Student> students;

    public static void createdListStudents() {

        Student[] sts = {new Student("Mykola", "HTML", 2),
                        new Student("Orest", "UI", 3),
                        new Student("Pavlo", "Java", 1),
                        new Student("Sasha", "JavaScript", 4),
                        new Student("Misha", "CSS", 5)};

        students = Arrays.asList(sts);
    }

    public void run() {

        //Student student = null;
        createdListStudents();

        try(ServerSocket ss = new ServerSocket(8888)){

            while (true) {
                ThreadClient threadClient = new ThreadClient(students, ss.accept());
                threadClient.start();
            }


//            Socket socket = ss.accept();
//            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//            PrintWriter pw = new PrintWriter(socket.getOutputStream());
//
//            System.out.println(ois.readObject());
//            pw.write("Об'єкт отримано!!!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
