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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;

//File->Project Structure->Libraries, Maven,  org.openjfx:javafx-maven-plugi
// n:0.0.5
//org.openjfx:javafx-archetype-fxml:0.0.5
//add --module-path "Y:\stemberk\verejne_zaci\javafx-sdk-17.0.1\lib" --add-modules javafx.controls,javafx.fxml
public class PiskorkyFX extends Application {
    private final String VERSION = "1.14";
    private final int MAX_PLAYER_LENGHT = 8;
    private final int MIN_PLAYER_LENGHT = 3;
    private final String TITULEK = "Piškorky" + this.VERSION;
    private PiskorkyStatus ps;
    private Button[][] herniTlacitka;
    private String hostname = "192.168.9.43";
    //private String hostname = "192.168.31.162";
    // private String hostname = "localhost";
    private int port = 8081;
    private Timeline tl;
    private Stage playerNameStage;
    private TextField playerNameTextField;
    private String playerName;
    private Socket socket;

    public PiskorkyFX() {
        this.initSocket();
        this.setPiskvorkyStatusFromServer();
        if (!this.ps.VERSION.equals(this.VERSION)){
            Stage kick = new Stage();
            Label lkick = new Label("Spatna verze!");
            HBox hkick = new HBox(lkick);
            Scene skick = new Scene(hkick);
            kick.setScene(skick);
            kick.showAndWait();
            Platform.exit();
        }

        this.playerNameStage = new Stage();
        Label playerNameLabel = new Label("jmeno hráče: ");
        this.playerNameTextField = new TextField();
        playerNameTextField.setOnKeyPressed(PiskorkyFX.this::handle);
        HBox playerNameRoot = new HBox(playerNameLabel,playerNameTextField);
        Scene playerName = new Scene(playerNameRoot);
        this.playerNameStage.setScene(playerName);
        this.playerNameStage.showAndWait();
        this.tl = new Timeline(new KeyFrame(Duration.millis(1000), this::animationHandler));
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

    public void initSocket(){
        try {
            this.socket = new Socket(this.hostname, this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sputPiskvorkyStatusToServer(){
        try {
            OutputStream writer = socket.getOutputStream();
            writer.write(30);
            ObjectOutputStream oos = new ObjectOutputStream(writer);
            oos.writeObject(this.ps);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setPiskvorkyStatusFromServer() {
        try {
            OutputStream writer = socket.getOutputStream();
            writer.write(20);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            this.ps = (PiskorkyStatus) ois.readObject();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void refreshPiskvorkyStatus() {
        if(this.ps.isEnded) {
            this.winScreen(this.ps.hraci.get(this.ps.aktivniHrac).toString());
        } else if (this.ps.isStarted) {
            this.startBtn.setText("Started...");
            this.startBtn.setDisable(true);
        }
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
        System.out.println("Transparency SET");
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
                    if(PiskorkyFX.this.ps.getHraci().size() >= 1){
                        PiskorkyFX.this.ps.start();
                        PiskorkyFX.this.sputPiskvorkyStatusToServer();
                    }
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
        st.initModality(Modality.APPLICATION_MODAL);
        st.onCloseRequestProperty().set(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
            }
        });
        this.tl.stop();
        st.show();
    }

    private void handle(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER){
            this.playerName = this.playerNameTextField.getText().trim();
            if(this.playerName.length() > MAX_PLAYER_LENGHT || this.playerName.length() < MIN_PLAYER_LENGHT){
                e.consume();
                return;
            }
            this.setPiskvorkyStatusFromServer();
            if(this.ps.pridatHrace(this.playerName)){
                e.consume();
                return;
            }
            this.sputPiskvorkyStatusToServer();
            this.playerNameStage.close();
        }
    }

    public void tlacitkoStisknuto(ActionEvent actionEvent) {
        this.tl.stop();
        //aktuální souřadnice tlačítka
        int i = 0, j = 0;
        Button stisknuteTlacitko = ((Button) actionEvent.getSource());
        i = (int) stisknuteTlacitko.getProperties().get("i");
        j = (int) stisknuteTlacitko.getProperties().get("j");
        System.out.format("i:%d, j:%d%n", i, j);

        //this.ps.herniPlochaHracu[i][j] = this.ps.aktivniHrac;
        //stisknuteTlacitko.getProperties().put("player",Integer.valueOf(this.ps.aktivniHrac));
        this.ps.herniTlacitka[i][j].put("player", this.ps.aktivniHrac);
        System.out.println();
        System.out.println("Vypis");
//        //vypis
        for (i = 0; i < this.ps.rozmerHraciPlochy; i++) {
            for (j = 0; j < this.ps.rozmerHraciPlochy; j++) {
                //System.out.format(" %02d ",this.ps.herniPlochaHracu[i][j]);
                int player = (int) this.ps.herniTlacitka[i][j].get("player");
                System.out.format("%02d ", player);
            }
            System.out.println();
        }

        this.sputPiskvorkyStatusToServer();
        //zabránění stisku více políček mezi stisknutím prvního a refreshem pomocí timeru
        if(!this.ps.isEnded){
            //přepnutí hráče
            if (++this.ps.aktivniHrac >= this.ps.hraci.size()) {
                this.ps.aktivniHrac = 0;
            }
            //stisknuteTlacitko.getProperties().put("player", this.ps.aktivniHrac);
        }
        this.refreshPiskvorkyStatus();
        this.setPiskvorkyStatusFromServer();
        this.tl.play();
    }


}