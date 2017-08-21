package ua.diamant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHeandler {
        Path path = Paths.get("C:/info.txt");

        public byte[] fileRead(Path path) throws IOException{
            byte[] fileReader = null;
            try {
                fileReader = Files.readAllBytes(path);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return fileReader;
        }

        public void fileWrite(Path path, byte[] bytes) throws IOException {
            Path fileWriter = Files.write(path, bytes);
        }
        public static void main(String[] args) {
//            Path path = Paths.get("C:/info.txt");
//            try {
//                byte[] fileReader = Files.readAllBytes(path);
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//            byte[] fileWriter = Files.write(path, fileReader);


        }
    }
