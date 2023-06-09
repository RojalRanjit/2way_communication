import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",12345);

            //asking user input with buffer
            BufferedReader userInputBuffer = new BufferedReader(new InputStreamReader(System.in));

            //taking data input with user
            BufferedReader socketInputBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message i need a pen
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);

            String sendingMessage, receivingMessage;
            while(true)
            {

                receivingMessage = socketInputBuffer.readLine();
                System.out.println("Server:" + receivingMessage);

                sendingMessage = userInputBuffer.readLine();
                printWriter.println(sendingMessage);
                printWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
