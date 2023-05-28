package lesson23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HeroClient {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        var scanner = new Scanner(System.in);

        try (
                var heroSocket = new Socket(SERVER_HOST, SERVER_PORT);
                var writer = new PrintWriter(heroSocket.getOutputStream(), true);
                var reader = new BufferedReader(new InputStreamReader(heroSocket.getInputStream()))) {
            while (true) {
                String userInput = scanner.nextLine();
                writer.println(userInput);
                if (userInput.equals("exit")) {
                    System.out.println("Server disconnected");
                    break;
                }
                System.out.println("Server: " + reader.readLine());
            }
        }
    }
}

