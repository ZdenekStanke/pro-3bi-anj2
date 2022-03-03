package cz.spsmb.b3i.w24.piskorky;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PiskorkyClientTest {
    public static void main(String[] args) throws IOException {

        //var hostname = "3.se.pool.ntp.org";
        var hostname = "localhost";
        //var hostname = "192.168.112.109";
        //int port = 13;
        int port = 8081;
        int state = 0;
        while (state < 100) {
            try (var socket = new Socket(hostname, port)) {
                switch (state) {
                    case 0:
                        try (var writer = socket.getOutputStream()) {
                            writer.write(30);
                            //writer.flush();
                            state = 30;
                        }
                        break;
                    case 10:
                        try (var reader = new InputStreamReader(socket.getInputStream())) {
                            int character;
                            var output = new StringBuilder();
                            while ((character = reader.read()) != -1) {
                                output.append((char) character);
                            }
                            System.out.println(output);
                            state = 100;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 20:
                        try (var reader = new ObjectInputStream(socket.getInputStream())) {
                            PiskorkyStatus ps = (PiskorkyStatus) reader.readObject();
                            System.out.println(ps.aktivniHrac);
                            System.out.println(ps.hraci.toString());
                            for (int i = 0; i < ps.rozmerHraciPlochy; i++) {
                                for (int j = 0; j < ps.rozmerHraciPlochy; j++) {
                                    //System.out.format(" %02d ",this.ps.herniPlochaHracu[i][j]);
                                    int player = (int) ps.herniTlacitka[i][j].get("player");
                                    System.out.format("%02d ", player);
                                }
                                System.out.println();
                            }

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 30:
                        try (var writer = new ObjectOutputStream(socket.getOutputStream())) {
                            PiskorkyStatus ps = new PiskorkyStatus(10);
                            ps.herniTlacitka[3][3].put("player", 1);
                            writer.writeObject(ps);
                        }
                        break;
                }
            }
        }
    }
}
