package cz.spsmb.b3i.w24.piskorky;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.time.LocalDateTime;

public class PiskorkyServer {
    public static PiskorkyStatus ps;

    public static void main(String[] args) throws IOException {
        PiskorkyServer.ps = new PiskorkyStatus(10);
        int port = 8081;
        int request = 0;
        try (var listener = new ServerSocket(port)) {
            System.out.printf("The started on port %d%n", port);
            while (true) {
                try (var socket = listener.accept()) {
                    switch(request){
                        case 0:
                            try( var is = socket.getInputStream()) {
                                request = is.read();
                                System.out.println(request);
                            }
                            break;
                            // get local date
                        case 10:
                            try (var pw = new PrintWriter(socket.getOutputStream(), true)) {
                                pw.println(LocalDateTime.now());
                                request = 0;
                            }
                            break;
                            // get status
                        case 20:
                            try (var pw = new ObjectOutputStream(socket.getOutputStream())) {
                                pw.writeObject(PiskorkyServer.ps);
                                request = 0;
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
