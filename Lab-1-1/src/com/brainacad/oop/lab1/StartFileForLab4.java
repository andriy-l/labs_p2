package com.brainacad.oop.lab1;

import java.io.*;

/**
 * Created by Павло on 03.07.2017.
 */
public class StartFileForLab4 {
    private String a;
    private int b;
    private int[] c;
    private float v;
    private static void main(String[] args) {
        //String path = "E:\\Навчання\\Книги та матеріали\\Книги\\SQL\\postgresql.pdf";
        String path = "fileLab2.txt";
        File file = new File(path);
        //File file1 = new File(path2);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        divide("FileReader");
        //private
        //private
        //publc
        //ublic
        //private
        //publi
        long timeStart = System.nanoTime();
        try {
            fileReader = new FileReader(file);
            //FileOutputStream fileOutputStream = new FileOutputStream(file1);
            int b = 0;
            while ((b = fileReader.read()) != -1) {
                System.out.print((char) b);
                //fileOutputStream.write(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        long timeEnd = System.nanoTime();
        long result1 = timeEnd - timeStart;

        divide("BufferedReader");
        timeStart = System.nanoTime();
        try {
            FileReader fileReader1 = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader1);
            System.out.println();

            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        timeEnd = System.nanoTime();
        long result2 = timeEnd - timeStart;

        divide("Час виконня");
        System.out.printf("Чаc зчитування за допомогою FileReader:     %d\n", result1);
        System.out.printf("Чаc зчитування за допомогою BufferedReader: %d", result2);
    }

    static void divide(String name) {
        System.out.println("\n");
        for (int i = 0; i < 100; i++) {
            System.out.print("==");
            if (i == 50) {
                System.out.print("  " + name + "  ");
            }
        }
        System.out.println();
    }

}
