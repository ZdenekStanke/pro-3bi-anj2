package cz.spsmb.b3i.w24.piskorky;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;

//File->Project Structure->Libraries, Maven,  org.openjfx:javafx-maven-plugin:0.0.5
//org.openjfx:javafx-archetype-fxml:0.0.5
//add --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
public class PiskorkyFX extends Application {
    private final String VERSION = "1.0";
    private final String TITULEK = "Piškorky" + this.VERSION;
    private PiskorkyStatus ps;
    private Button[][] herniTlacitka;
    private String hostname = "192.168.9.43";
    private int port = 8081;
    private Timeline tl;
    private Stage playerNameStage;
    private TextField playerNameTextField;
    private String playerName;

    public PiskorkyFX() {
        this.setPiskvorkyStatusFromServer();
        this.playerNameStage = new Stage();
        Label playerNameLabel = new Label("jmeno hráče: ");
        this.playerNameTextField = new TextField();
        playerNameTextField.setOnKeyPressed(e -> handle(e));
        HBox playerNameRoot = new HBox(playerNameLabel,playerNameTextField);
        Scene playerName = new Scene(playerNameRoot);
        this.playerNameStage.setScene(playerName);
        this.playerNameStage.showAndWait();
        this.tl = new Timeline(new KeyFrame(Duration.millis(3000), this::animationHandler));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
    }

    private void animationHandler(ActionEvent actionEvent) {
        this.setPiskvorkyStatusFromServer();
        this.refreshPiskvorkyStatus();
    }

    private Label labelKdoTahne = new Label("Táhne: ");
    private Label labelKdoTahne2 = new Label();
    private Label labelSeznamHracu = new Label();
    private Button startBtn = new Button("start");
    private HBox panelKdoHraje = new HBox(startBtn,labelKdoTahne, labelKdoTahne2,labelSeznamHracu);

    public void sputPiskvorkyStatusToServer(){
        try (var socket = new Socket(this.hostname, this.port)) {
            try (var writer = socket.getOutputStream()) {
                writer.write(30);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (var socket = new Socket(this.hostname, this.port)) {
            try (var writer = new ObjectOutputStream(socket.getOutputStream())) {
               writer.writeObject(this.ps);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPiskvorkyStatusFromServer() {
        try (var socket = new Socket(this.hostname, this.port)) {
            try (var writer = socket.getOutputStream()) {
                writer.write(20);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (var socket = new Socket(this.hostname, this.port)) {


            try (var reader = new ObjectInputStream(socket.getInputStream())) {
                this.ps = (PiskorkyStatus) reader.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshPiskvorkyStatus() {
        System.out.println(this.ps.hraci.get(ps.aktivniHrac) + " "+ this.playerName+"<");
        System.out.println(!this.ps.hraci.get(ps.aktivniHrac).equals(this.playerName));
        //aktualizace panelu kdo táhne
        this.labelKdoTahne2.setText(this.ps.hraci.get(this.ps.aktivniHrac).toString());
        this.labelSeznamHracu.setText(this.ps.getHraci().toString());
        for (int i = 0; i < this.ps.rozmerHraciPlochy + 1; i++) {
            for (int j = 0; j < this.ps.rozmerHraciPlochy + 1; j++) {
                Button b = this.herniTlacitka[i][j];
//                b.getProperties().clear();
                b.getProperties().putAll(this.ps.herniTlacitka[i][j]);
                int player = (int) this.ps.herniTlacitka[i][j].get("player");
                if(player >=0){
                    b.setOnAction(null);
                    b.setText(this.ps.hraci.get(player).toString().substring(0, 1));
                }

                b.setMouseTransparent(!(this.ps.hraci.get(ps.aktivniHrac).equals(this.playerName) && this.ps.isStarted));
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            GridPane gp = new GridPane();
            this.herniTlacitka = new Button[this.ps.rozmerHraciPlochy + 1][this.ps.rozmerHraciPlochy + 1];
            for (int i = 0; i < this.ps.rozmerHraciPlochy + 1; i++) {
                for (int j = 0; j < this.ps.rozmerHraciPlochy + 1; j++) {
                    Button b = new Button();
                    b.setPrefSize(28, 28);
                    this.herniTlacitka[i][j] = b;

                    //node, sloupec, řádek - ano je to obráceně oproti dosavaním principům
                    gp.add(b, j, i);
                    //Aktivní budou tlačítka, která nejsou na okraji
                    if (i != 0 && j != 0) {
                        b.setOnAction(this::tlacitkoStisknuto);
                    } else {
                        //b.setStyle("-fx-border-width: 10.0; -fx-border-color: navy;");
                        // b.setStyle(" -fx-background-color: navy;");
                        b.setStyle("-fx-border-color: navy;");
                        b.setText(i == 0 ? String.valueOf(j) : String.valueOf(i));
                    }
                }
            }
            BorderPane root = new BorderPane();
            this.startBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    PiskorkyFX.this.ps.isStarted = true;
                    PiskorkyFX.this.sputPiskvorkyStatusToServer();
                }
            });
            root.setTop(this.panelKdoHraje);
            root.setCenter(gp);
            Scene scene = new Scene(new Group(root));
            stage.setScene(scene);
            stage.setTitle("hráč: "+this.playerName);
            stage.show();

            this.refreshPiskvorkyStatus();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    private void winScreen(String player){
        Label lb = new Label(player + " Vyhrál");
        HBox hb = new HBox(lb);
        Scene sc = new Scene(hb);
        Stage st = new Stage();
        st.setScene(sc);
        st.showAndWait();
        Platform.exit();


    }

    private void handle(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER){
            this.playerName = this.playerNameTextField.getText();
            System.out.println(this.playerName);
            this.ps.pridatHrace(this.playerName);
            this.sputPiskvorkyStatusToServer();
            this.playerNameStage.close();
        }
    }

    public void tlacitkoStisknuto(ActionEvent actionEvent) {
        //aktuální souřadnice tlačítka
        int i = 0, j = 0;
        Button stisknuteTlacitko = ((Button) actionEvent.getSource());
        i = (int) stisknuteTlacitko.getProperties().get("i");
        j = (int) stisknuteTlacitko.getProperties().get("j");
        System.out.format("i:%d, j:%d%n", i, j);

        //this.ps.herniPlochaHracu[i][j] = this.ps.aktivniHrac;
        //stisknuteTlacitko.getProperties().put("player",Integer.valueOf(this.ps.aktivniHrac));
        this.ps.herniTlacitka[i][j].put("player", this.ps.aktivniHrac);

        //přepnutí hráče
        if (++this.ps.aktivniHrac >= this.ps.hraci.size()) {
            this.ps.aktivniHrac = 0;
        }
        stisknuteTlacitko.getProperties().put("player", this.ps.aktivniHrac);
        System.out.println();
        int N = 5;
        System.out.format("verticalWin:%b, horizontalWin:%b, diagonalwin:%b, isReverseDiagonalWin:%b%n",
                this.isVerticalWin(i, j, N),
                this.isHorizontalWin(i, j, N),
                this.isDiagonalWin(i, j, N),
                this.isReverseDiagonalWin(i, j, N));
        int y = i;
        int x = j;
        //pozor, potřeba použít operátor úplného vyhodnocení
        while (--y > 0 & --x > 0) ;
        //System.out.format("x:%d, y:%d%n", x,y);
        for (; y < this.ps.rozmerHraciPlochy && x < this.ps.rozmerHraciPlochy; y++, x++) {
            if (this.isReverseDiagonalWin(y, x, N)) {
                System.out.println("ReverseDiagonal");
                break;
            }
        }
        y = i;
        x = j;
        if (y != this.ps.rozmerHraciPlochy) {
            while (++y < this.ps.rozmerHraciPlochy & --x > 0) ;
        }
        System.out.format("x:%d, y:%d%n", x, y);
        for (; y > 0 && x < this.ps.rozmerHraciPlochy; y--, x++) {
            if (this.isDiagonalWin(y, x, N)) {
                System.out.println("Diagonal");
                break;
            }
        }
        for (int radek1 = 0; radek1 < this.ps.rozmerHraciPlochy; radek1++) {
            for (int sloupec1 = 0; sloupec1 < this.ps.rozmerHraciPlochy; sloupec1++) {
                if (this.isVerticalWin(radek1, sloupec1, N)) {
                    System.out.println("Win vertical");
                    this.winScreen(this.playerName);
                }
                if (this.isHorizontalWin(radek1, sloupec1, N)) {
                    System.out.println("Win horizontal");
                    this.winScreen(this.playerName);
                }
                if (this.isDiagonalWin(radek1, sloupec1, N)) {
                    System.out.println("Win diagonal");
                    this.winScreen(this.playerName);

                }
                if (this.isReverseDiagonalWin(radek1, sloupec1, N)) {
                    System.out.println("Win reverseDiagonal");
                    this.winScreen(this.playerName);
                }
            }
        }

        System.out.println("Vypis");
        //vypis
        for (i = 0; i < this.ps.rozmerHraciPlochy; i++) {
            for (j = 0; j < this.ps.rozmerHraciPlochy; j++) {
                //System.out.format(" %02d ",this.ps.herniPlochaHracu[i][j]);
                int player = (int) this.ps.herniTlacitka[i][j].get("player");
                System.out.format("%02d ", player);
            }
            System.out.println();
        }
        this.refreshPiskvorkyStatus();
        this.sputPiskvorkyStatusToServer();
    }

    private boolean isVerticalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) this.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        for (int i = radek; i < radek + n; i++) {
            if (this.ps.rozmerHraciPlochy < i) {
                return false;
            }
            if (aktualniHrac != (int) this.ps.herniTlacitka[i][sloupec].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isHorizontalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) this.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        for (int j = sloupec; j < sloupec + n; j++) {
            if (this.ps.rozmerHraciPlochy < j) {
                return false;
            }
            if (aktualniHrac != (int) this.ps.herniTlacitka[radek][j].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) this.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i > radek - n; i--, j++) {
            if (i <= 0) {
                return false;
            }
            if (j > this.ps.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != (int) this.ps.herniTlacitka[i][j].get("player")) {
                return false;
            }
        }
        return true;
    }

    private boolean isReverseDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = (int) this.ps.herniTlacitka[radek][sloupec].get("player");
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i < radek + n; i++, j++) {
            if (i > this.ps.rozmerHraciPlochy) {
                return false;
            }
            if (j > this.ps.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != (int) this.ps.herniTlacitka[i][j].get("player")) {
                return false;
            }
        }
        return true;
    }

}