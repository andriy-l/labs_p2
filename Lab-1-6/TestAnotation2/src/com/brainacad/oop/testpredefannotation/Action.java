package com.brainacad.oop.testpredefannotation;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public class Action {

    @MyPermition(PermissionAction.USER_READ)
    public void readToFile(User user, File file) {
        try(FileReader fileInputStream = new FileReader(file)) {

            Class thisClass = this.getClass();

            Method method = null;

            try {
               method = thisClass.getDeclaredMethod("readToFile", User.class, File.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


            if(user.getPermissions().contains(method.getDeclaredAnnotation(MyPermition.class).value())) {
                System.out.print(user + "прочитав файл: ");
                int b  = 0;
                while ((b = fileInputStream.read()) != -1) {
                    System.out.print((char)b);
                }
                System.out.println();
            } else {
                System.out.println(user + ": немає прав для читання файлу!!!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @MyPermition(PermissionAction.USER_CHANGE)
    public void writeToFile(User user, File file) {
        try(FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            Class thisClass = this.getClass();

            Method method = null;

            try {
                method = thisClass.getDeclaredMethod("writeToFile", User.class, File.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }


            if(user.getPermissions().contains(method.getDeclaredAnnotation(MyPermition.class).value())) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введіть стрічку для запису у файл:");
                fileWriter.write(scanner.nextLine());
                System.out.println(user +  " файл успішно записав!!!");
            } else {
                System.out.println(user + ": немає прав для запису у файл!!!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
