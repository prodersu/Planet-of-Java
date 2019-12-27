package school;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static ServerSocket server;

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        ExecutorService exec = Executors.newFixedThreadPool(10);
        int j = 0;

        while (j < 2) {
            School school = new School("Client " + (j+1));
            j++;
            exec.execute(new Client());
            Thread.sleep(1000);
        }

        exec.shutdown();
    }
}
