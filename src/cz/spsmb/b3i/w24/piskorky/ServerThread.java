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
    private boolean isVerticalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) PiskorkyServer.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        for (int i = radek; i < radek + n; i++) {
            if (PiskorkyServer.ps.rozmerHraciPlochy < i) {
                return false;
            }
            if (aktualniHrac != (int) PiskorkyServer.ps.herniTlacitka[i][sloupec].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isHorizontalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) PiskorkyServer.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        for (int j = sloupec; j < sloupec + n; j++) {
            if (PiskorkyServer.ps.rozmerHraciPlochy < j) {
                return false;
            }
            if (aktualniHrac != (int) PiskorkyServer.ps.herniTlacitka[radek][j].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) PiskorkyServer.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i > radek - n; i--, j++) {
            if (i <= 0) {
                return false;
            }
            if (j > PiskorkyServer.ps.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != (int) PiskorkyServer.ps.herniTlacitka[i][j].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isReverseDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) PiskorkyServer.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i < radek + n; i++, j++) {
            if (i > PiskorkyServer.ps.rozmerHraciPlochy) {
                return false;
            }
            if (j > PiskorkyServer.ps.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != (int) PiskorkyServer.ps.herniTlacitka[i][j].get("player")) {
                return false;
            }
        }
        return true;
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
                    synchronized (PiskorkyServer.ps){
                        pw.writeObject(PiskorkyServer.ps);
                    }
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
                    synchronized (PiskorkyServer.ps){
                        if(!PiskorkyServer.ps.isEnded) {
                            PiskorkyServer.ps = ps;
                        }
                    }
                    lab_for1:
                    for (int radek1 = 0; radek1 < PiskorkyServer.ps.rozmerHraciPlochy; radek1++) {
                        for (int sloupec1 = 0; sloupec1 < PiskorkyServer.ps.rozmerHraciPlochy; sloupec1++) {
                            if (this.isVerticalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) || this.isHorizontalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) ||
                                    this.isDiagonalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) || this.isReverseDiagonalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych))  {

                                System.out.println("Win");
                                PiskorkyServer.ps.isEnded = true;
                                break lab_for1;
                            }
                        }
                    }
                    if(!PiskorkyServer.ps.isEnded){
                        //přepnutí hráče
                        if (++PiskorkyServer.ps.aktivniHrac >= PiskorkyServer.ps.hraci.size()) {
                            PiskorkyServer.ps.aktivniHrac = 0;
                        }
                        //stisknuteTlacitko.getProperties().put("player", this.ps.aktivniHrac);
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
