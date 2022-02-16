package cz.spsmb.b3i.w24.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;

//Vytvoření serveru, který vrací údaj o datumu a čase. Ověřit možné pomocí klienta ASocketTimeClient
public class EDateServer {
    public static void main(String[] args) throws IOException {
        int port = 8081;
        try (var listener = new ServerSocket(port)) {
            System.out.printf("The started on port %d%n", port);
            while (true) {
                try (var socket = listener.accept()) {
                    try (var pw = new PrintWriter(socket.getOutputStream(), true)) {
                        pw.println(LocalDateTime.now());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
