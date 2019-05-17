package PiServerTest;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DietClient {

    private Socket client;
    private Scanner in;
    private PrintStream out;
    private Scanner localIn;

    /**
     * sentinel boolean
     */
    private boolean sentinel;


    public DietClient(String host, int port){
        this.sentinel = true;
        try{
            localIn = new Scanner(System.in);
            this.client = new Socket(host, port);
            this.in = new Scanner(client.getInputStream());
            this.out = new PrintStream(client.getOutputStream());

        } catch(UnknownHostException uhe){
            System.out.println(uhe.getMessage());
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    /**
     * receive a message and send the same message back to the server
     */
    public void echo(){
        String request = nextLine();
        System.out.println("received :" + request);
        send(request);
        String[] tokens = request.split(" ");
    }

    public void send(String msg){
        out.println(msg);
        out.flush();
    }


    public String nextLine(){
        return in.nextLine();
    }


    /**
     * main loop
     */
    public void run(){
        int requests = 0;
        while(sentinel && requests++ < 5){
            Scanner scanner = new Scanner(System.in);
            String msg = localIn.nextLine();
            send(msg);

            //receive the message back from the server
            System.out.println(in.nextLine());
        }
        System.out.println("max echos reiched, quitting");
        try{
            client.close();
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }


    public static void main(String[] args){
        System.out.println("Starting client...");
        DietClient client = new DietClient("localhost", 12345);
        client.run();
    }
}
