package teamWork.brainacad.oop.Collections;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class TextFileHandler {

    public String readTextFile(Path path){
        String string = null;
        try {
            string = new String ( Files.readAllBytes (path ));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        return string;
    }
    public void writeTextFile(String string, Path path){
        try {
            FileWriter fileWriter = new FileWriter (path.toFile (), true);
            fileWriter.write (string);
            fileWriter.flush ();
        } catch (IOException e) {
            System.out.println ("IOException");
        }
    }
    public static void main(String[] args) {

    }
}
