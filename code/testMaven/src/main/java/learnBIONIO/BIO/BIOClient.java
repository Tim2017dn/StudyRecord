package learnBIONIO.BIO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",4444);

        OutputStream out = socket.getOutputStream();

        out.write("hello dn".getBytes());

        out.close();

        Socket socket2 = new Socket("127.0.0.1",4444);
        OutputStream out2 = socket2.getOutputStream();

        out2.write("bye dn".getBytes());

        out2.close();



        socket.close();
    }

}
