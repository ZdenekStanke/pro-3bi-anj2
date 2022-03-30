package cz.spsmb.b3i.w24.piskorky;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;

public class ServerThread extends Thread {
    protected Socket socket;
    int request = 0;

    public ServerThread(Socket clientSocket) {
        this.socket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Running,request:"+this.request);
        switch (request) {
            case 0:
                try (var is = socket.getInputStream()) {
                    request = is.read();
                    System.out.println(request);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            // get local date
            case 10:
                try (var pw = new PrintWriter(socket.getOutputStream(), true)) {
                    pw.println(LocalDateTime.now());
                    request = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            // get status
            case 20:
                try (var pw = new ObjectOutputStream(socket.getOutputStream())) {
                    pw.writeObject(PiskorkyServer.ps);
                    request = 0;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(PiskorkyServer.ps.getHraci());
                break;
            // set status
            case 30:
                try (var pi = new ObjectInputStream(socket.getInputStream())) {
                    PiskorkyServer.ps = (PiskorkyStatus) pi.readObject();
                    request = 0;
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
