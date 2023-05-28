package lesson23;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson21.HeroDto;
import lesson21.HeroService;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@RequiredArgsConstructor
public class HeroClientHandler implements Runnable {
    private final Socket clientSocket;
    private final HeroService heroService;
    private final ObjectMapper objectMapper;

    @Override
    public void run() {
        System.out.println("Connection successful");
        System.out.println("Waiting for input...");

        try {
            var writer = new PrintWriter(clientSocket.getOutputStream(), true);
            var reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = reader.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                String[] value = inputLine.split(" ", 2);
                if (value[0].equals("name")) {
                    HeroDto heroDto = heroService.findByName(value[1]).stream().findFirst().orElse(null);
                    if (heroDto != null) {
                        String heroJson = objectMapper.writeValueAsString(heroDto);
                        writer.println(heroJson);
                    } else {
                        writer.println("Hero is not found");
                    }
                } else if (value[0].equals("exit")) {
                    System.out.println("Client disconnected");
                    break;
                } else {
                    writer.println("Unknown command " + value[0] + ". Try again");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
