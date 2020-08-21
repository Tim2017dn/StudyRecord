package learnBIONIO.BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer3 {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        try{

            ServerSocket serverSocket = new ServerSocket(4444);
            while(true){
                Socket socket = serverSocket.accept();
                executorService.execute(new BIOServerHandler(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
