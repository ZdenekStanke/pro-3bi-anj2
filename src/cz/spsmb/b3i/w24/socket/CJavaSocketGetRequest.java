package cz.spsmb.b3i.w24.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
// Vrátí web. stránku z http://www.webcode.me
public class CJavaSocketGetRequest {
    public static void main(String[] args) throws IOException {
        try (var socket = new Socket("spsmb.cz", 80)) {
            try (var wtr = new PrintWriter(socket.getOutputStream())) {
                // create GET request
                wtr.print("GET / HTTP/1.1\r\n");
                wtr.print("Host: www.webcode.me\r\n");
                wtr.print("\r\n");
                wtr.flush();
                socket.shutdownOutput();
                String outStr;
                try (var bufRead = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()))) {
                    while ((outStr = bufRead.readLine()) != null) {
                        System.out.println(outStr);
                    }
                    socket.shutdownInput();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
