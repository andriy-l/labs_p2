package com.brainacad.oop.demosocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ThreadClient extends Thread {

    private List<Student> students;
    private Socket socket;

    public ThreadClient(List<Student> students, Socket socket) {
        this.students = students;
        this.socket = socket;
    }

    public void run() {

        try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream())) {

            Student s = (Student)ois.readObject();

            if (students.contains(s)) {
                pw.write("Student " +  s.getName() + " has access to the server service");
                System.out.println("Student " +  s.getName() + " has access to the server service");
            } else {
                pw.write("Student " +  s.getName() + " has NOT access to the server service");
                System.out.println("Student " +  s.getName() + " has NOT access to the server service");
            }
            pw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
