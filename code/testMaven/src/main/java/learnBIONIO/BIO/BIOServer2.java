package learnBIONIO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);

        while(true){
            Socket socket = serverSocket.accept();
            new Thread(new BIOServerHandler(socket));

        }

    }

}
