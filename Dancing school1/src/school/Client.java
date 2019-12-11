
package school;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        School s = new School();
        try{
            Socket socket = new Socket("127.0.0.1",7777);
            Scanner in = new Scanner(System.in);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new  ObjectInputStream(socket.getInputStream());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
