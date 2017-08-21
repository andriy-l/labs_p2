package server;

import ua.diamant.FileHeandler;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServerDemo {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6666);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream()) {
            FileHeandler fileHeandler = new FileHeandler();
            Path path = Paths.get("file.bin");

            byte[] bytes = null;
            int count = 0;
            int b = 0;
            FileOutputStream fos = new FileOutputStream(path.toFile());
            while((b = inputStream.read()) != -1) {
                fos.write(b);
            }
            fos.flush();
            fos.close();

            //fileHeandler.fileWrite(path, bytes);

        }
       catch (IOException e){
                e.printStackTrace();
       }
    }

}
