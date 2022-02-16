package cz.spsmb.b3i.w24.socket;
//Socket - nějaký koncový bod, který umožňuje komunikaci počítačovou sítí
//         s okolím. Sockety se používají pro vytvoření komunikace mezi
//         klientským programem a serverem.
// Socket        - třída reprezentující klienta (TCP protokol)
// ServerSocket  - třída reprezentující server  (TCP protokol)
// Pro UDP protokol máme třídy DatagramSocket a DatagramPacket

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Pomocíé klientského socketu program přečte časový údaj z Časového serveru:
public class ASocketTimeClient {
    public static void main(String[] args) throws IOException {

        var hostname = "3.se.pool.ntp.org";
        int port = 13;
        try (var socket = new Socket(hostname, port)) {
            try (var reader = new InputStreamReader(socket.getInputStream())) {
                int character;
                var output = new StringBuilder();
                while ((character = reader.read()) != -1) {
                    output.append((char) character);
                }
                System.out.println(output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
