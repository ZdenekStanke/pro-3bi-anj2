package cz.spsmb.b3i.w24.piskorky;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class ServerThread extends Thread {
    private class Helper extends TimerTask implements Serializable {
        @Override
        public void run() {
         //   PiskorkyServer.ps.hraci.remove(PiskorkyServer.ps.aktivniHrac);
            System.out.format("Hrac %s dlouho nehral.%n", PiskorkyServer.ps.hraci.get(PiskorkyServer.ps.aktivniHrac));
        }
    }

    protected Socket socket;
    java.util.Timer timer = new Timer();
    int request = 0;
    int hrac ;

    /**
     * @param clientSocket instance socketu získaného pomocí metody accept() instance třídy ServerSocket
     */
    public ServerThread(Socket clientSocket) {
        this.hrac = PiskorkyServer.ps.hraci.size() - 1;
        this.socket = clientSocket;
        try {
            this.socket.setKeepAlive(true);
        } catch (SocketException e) {
            e.printStackTrace();
        }
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
        ObjectOutputStream oos = null;
        while (true) {
            try {

                inp = this.socket.getInputStream();
                int attempts = 0;
                while(inp.available() == 0 && attempts < 1000)
                {
                    if (this.hrac == PiskorkyServer.ps.aktivniHrac){
                        this.timer.schedule(new Helper(), PiskorkyServer.ps.TIMEOUT);
                    }else{
                        this.timer.cancel();
                    }

                    attempts++;
                    Thread.sleep(10);
                }

                request = inp.read();
                System.out.println(request);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Running,request:" + this.request);

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

                    try {
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        synchronized (PiskorkyServer.ps) {
                            oos.writeObject(PiskorkyServer.ps);
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
                    try {
                      //  inp = this.socket.getInputStream();
                        ois = new ObjectInputStream(inp);
                        PiskorkyStatus ps = (PiskorkyStatus) ois.readObject();
                        synchronized (PiskorkyServer.ps) {
                            if (!PiskorkyServer.ps.isEnded) {
                                PiskorkyServer.ps = ps;
                            }
                        }
                        lab_for1:
                        for (int radek1 = 0; radek1 < PiskorkyServer.ps.rozmerHraciPlochy; radek1++) {
                            for (int sloupec1 = 0; sloupec1 < PiskorkyServer.ps.rozmerHraciPlochy; sloupec1++) {
                                if (this.isVerticalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) || this.isHorizontalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) ||
                                        this.isDiagonalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych) || this.isReverseDiagonalWin(radek1, sloupec1, PiskorkyServer.ps.nViteznych)) {

                                    System.out.println("Win");
                                    PiskorkyServer.ps.isEnded = true;
//reset piskvorek po skonceni 3s
                                    timer.schedule(new TimerTask() {
                                                       @Override
                                                       public void run() {
                                                           PiskorkyServer.ps.clean();
                                                       }
                                                   }, 3000
                                    );

                                    break lab_for1;
                                }
                            }
                        }
                        PiskorkyServer.ps.prepnutiHrace();
                       /* if (ps.isStarted) {
                            //this.timer.cancel();
                            this.timer.schedule(new Helper(), PiskorkyServer.ps.TIMEOUT);
                        }*/
                        System.out.println(PiskorkyServer.ps.getHraci());
                        //        //vypis
                        for (int i = 0; i < PiskorkyServer.ps.rozmerHraciPlochy; i++) {
                            for (int j = 0; j < PiskorkyServer.ps.rozmerHraciPlochy; j++) {
                                //System.out.format(" %02d ",this.ps.herniPlochaHracu[i][j]);
                                int player = (int) PiskorkyServer.ps.herniTlacitka[i][j].get("player");
                                System.out.format("%02d ", player);
                            }
                            System.out.println();
                        }

                    } catch (ClassNotFoundException | IOException e) {
                        e.printStackTrace();
                        System.out.println("Tadik " + e.getMessage());
                    }
                    break;
            }
        }
    }
}
