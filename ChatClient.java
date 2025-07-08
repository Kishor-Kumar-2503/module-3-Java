import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = userInput.readLine()).equalsIgnoreCase("exit")) {
            out.write(line + "\n");
            out.flush();
            System.out.println("Server: " + in.readLine());
        }
        socket.close();
    }
}