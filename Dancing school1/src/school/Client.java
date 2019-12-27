package school;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class Client implements Runnable {

    static Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 3345);
            System.out.println("Client connected to socket");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(".");
        }
    }

    @Override
    public void run() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("Client oos & ois initialized");

            int i = 0;
            while (i < 5) {
                School school = new School("Client " + (i+1));
                oos.writeUTF("clientCommand " + i);
                oos.flush();

                Thread.sleep(10);
                System.out.println("Client wrote & start waiting for data from server...");

                System.out.println("reading...");
                String in = ois.readUTF();
                System.out.println(in);
                i++;
                Thread.sleep(5000);

            }
        } catch (IOException e) {
            System.out.println(".");
        } catch (InterruptedException e) {
            System.out.println(".");
        } catch (NullPointerException | SQLException e){
            System.out.println(".");
        }
    }
}