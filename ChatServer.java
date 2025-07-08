import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started...");
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Client: " + message);
            out.write("Echo: " + message + "\n");
            out.flush();
        }
        socket.close();
        serverSocket.close();
    }
}