/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school;


import java.io.IOException;
import java.net.*;
import java.util.logging.*;

public class Server {
    public static void main(String[] args) {
    
    try {
 
    ServerSocket ss = new ServerSocket(7777);
    System.out.println("Waiting client...");
    while(true){
        Socket socket = ss.accept();
        System.out.println("Client connected...");
      //  ClientHandler ch = new ClientHandler(socket, book);
      //  ch.start();
        }
} catch (IOException e) {
            e.printStackTrace();
        }


    }

}