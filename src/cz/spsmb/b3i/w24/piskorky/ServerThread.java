package cz.spsmb.b3i.w24.piskorky;

import java.io.*;
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
        InputStream inp = null;
        ObjectInputStream ois = null;
        try {
            inp = this.socket.getInputStream();
            request = inp.read();
            System.out.println(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Running,request:"+this.request);
        switch (request) {
            case 0:
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
                    System.out.println("messsage:" + e.getMessage());
                    e.printStackTrace();
                }
                System.out.println(PiskorkyServer.ps.getHraci());
                break;
            // set status
            case 30:
                try  {
                    inp = this.socket.getInputStream();
                    ois = new ObjectInputStream(inp);
                    PiskorkyStatus ps  = (PiskorkyStatus) ois.readObject();
                    if(!PiskorkyServer.ps.isEnded) {
                        PiskorkyServer.ps = ps;
                    }
                    System.out.println(PiskorkyServer.ps.getHraci());
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                    System.out.println("Tadik " + e.getMessage());
                }
                break;
        }
    }
}
