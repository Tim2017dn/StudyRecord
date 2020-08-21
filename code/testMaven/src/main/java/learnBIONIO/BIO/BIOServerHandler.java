package learnBIONIO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class BIOServerHandler implements Runnable{

    private Socket socket;

    public BIOServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // 获取输入流
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while (null != (message = br.readLine())) {
                System.out.println(message);
            }
            // 关闭流
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
