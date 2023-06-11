package lesson23;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson21.HeroFactory;
import lesson21.HeroService;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.ServerSocket;


public class HeroServer {
    private static final int PORT = 8080;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static DataSource dataSource() {

        var dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("test");
        return dataSource;
    }

    public static void main(String[] args) throws IOException {
        HeroService heroService = HeroFactory.createService(dataSource());

        try (var serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for connection...");
                var clientSocket = serverSocket.accept();
                System.out.println("Connection established, starting handler");
                var handler = new HeroClientHandler(clientSocket, heroService, objectMapper);
                new Thread(handler).start();
            }
        }
    }
}