package learnBIONIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(4444);
        while(true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String message;

            while(null!=(message=br.readLine())){
                System.out.println(message);
            }

            inputStream.close();
            socket.close();

        }

    }


}
