package test;

import java.applet.Applet;
import java.awt.*;
//import java.awt.Graphics;
import javax.swing.*;

/***
 * this class is just to test how veiwing applets with firefox works.
 * First time actually using swing or Applet, so we'll see how it goes.
 *      - Aidan Lear
 * @author Aidan Lear
 */

public class AppletHelloWorld extends Applet{

    public JLabel text;


    /**
     * constructs the hello world using a given String.
     * It won't necisarily say "Hello World"
     * It will say whatever you give it as the string
     */
    public AppletHelloWorld(String text){
        this.text = new JLabel(text);
        JFrame frame = new JFrame();
        initialize(frame);
        frame.add(this.text);
        //frame.pack(); //should not be used concurrently with .setSize
        frame.setVisible(true);
    }


    /**
     * helper function that initializes the swing stuff
     * initializes:
     *  - Location
     *  - exit on close
     *  - size
     *  - (add more here)
     */
    private void initialize(JFrame frame){
        frame.setSize(250, 75);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width/2;
        int centerY = screenSize.height/2;
        frame.setLocation(centerX, centerY);
    }


    /**
     * I didnt realize how unecissary this was untill after autofill told me text has a setText...
     * Im just gonna leave this hear for whoever wants to see one of my blunders
     *      - Aidan Lear
     * @param text A string of what to change the text to.
     */
    public void setText(String text){
        this.text.setText(text);
    }


    /**
     * main method currently just contructs a hello world java Applet
     * @param args
     */
    public static void main(String[] args){
        //here we make a basic hello world swing applet
        AppletHelloWorld test = new AppletHelloWorld("Hello World");
    }
}
