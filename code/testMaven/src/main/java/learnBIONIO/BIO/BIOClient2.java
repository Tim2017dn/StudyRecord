package learnBIONIO.BIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",4444);

        OutputStream out = socket.getOutputStream();

        out.write("hello anthor".getBytes());

        out.close();

        socket.close();
    }
}
