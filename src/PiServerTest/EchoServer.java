package PiServerTest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws IOException{

        ServerSocket server = new ServerSocket(12345);
        System.out.println("waiting for client to connect...");
        Socket client = server.accept();
        System.out.println("client connected!");
        PrintStream out = new PrintStream(client.getOutputStream());
        Scanner in = new Scanner(client.getInputStream());

        String msg = "";
        while(!msg.equals("quit")){
            msg = in.nextLine();
            System.out.println("received: " + msg);
            out.println(msg);
            out.flush();
        }
    }

}
