package com.brainacad.oop.demosocket;

public class MainClient {
    public static void main(String[] args) {

        Student student1 = new Student("Pavlo", "Java", 1);
        Student student2 = new Student("Anton", "Java", 2);
        Student student3 = new Student("Orest", "CSS", 3);
        Student student4 =  new Student("Orest", "UI", 3);
        Student student5 = new Student("Sasha", "JavaScript", 4);
//        student.setCourse("Java");
//        student.setName("Pavlo");
//        student.setId(1);

        MyClient myClient = new MyClient(student1);
        MyClient myClient1 = new MyClient(student2);
        MyClient myClient2 = new MyClient(student3);
        MyClient myClient3 = new MyClient(student4);
        MyClient myClient4 = new MyClient(student5);
        myClient.start();
        myClient1.start();
        myClient2.start();
        myClient3.start();
        myClient4.start();

    }
}
