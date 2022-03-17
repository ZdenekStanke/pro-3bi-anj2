package cz.spsmb.b3i.w24.piskorky;


import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.time.LocalDateTime;
//add --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
public class PiskorkyServer {
    public static PiskorkyStatus ps;

    public static void main(String[] args) throws IOException {
        PiskorkyServer.ps = new PiskorkyStatus(25);
        int port = 8081;
        int request = 0;
        while (true) {
            try (var listener = new ServerSocket(port)) {
                System.out.printf("The started on port %d, address: %s%n", port, listener.getLocalSocketAddress());

                while (true) {
                    try (var socket = listener.accept()) {
                        switch (request) {
                            case 0:
                                try (var is = socket.getInputStream()) {
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
                                System.out.println(PiskorkyServer.ps.getHraci());
                                break;
                            // set status
                            case 30:
                                try (var pi = new ObjectInputStream(socket.getInputStream())) {
                                    PiskorkyServer.ps = (PiskorkyStatus) pi.readObject();
                                    request = 0;
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                break;
                        }
                    }
                }
            }
            catch (SocketException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
//            catch (ConnectException e) {
//                System.out.println("connection reset ");
//            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
