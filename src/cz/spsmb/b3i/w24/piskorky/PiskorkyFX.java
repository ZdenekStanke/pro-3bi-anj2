package cz.spsmb.b3i.w24.piskorky;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//File->Project Structure->Libraries, Maven,  org.openjfx:javafx-maven-plugin:0.0.5
//org.openjfx:javafx-archetype-fxml:0.0.5
//add --module-path "C:\Users\stemb\Documents\javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml
public class PiskorkyFX extends Application {
    private final String VERSION = "1.0";
    private final String TITULEK = "Piškorky" + this.VERSION;
    private int rozmerHraciPlochy;
    //aktivni Hráč se zde automaticky inicializuje na 0 (LOJZA), netřeba inicializovat
    private byte aktivniHrac;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Label label = new Label("KdoHraje: ");
            GridPane gp = new GridPane();
            Node root = new VBox(label, gp);
            PiskorkyStatus ps = new PiskorkyStatus(10);
            for (int i = 0; i < this.rozmerHraciPlochy + 1; i++) {
                for (int j = 0; j < this.rozmerHraciPlochy + 1; j++) {
                    Button b = new Button();
                   // b.
                    b.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            System.out.format("i:%d, j:%d%n",i,j);
                        }
                    });
                    ps.herniTlacitka[i][j] = b;
                    gp.getChildren().add(b);
                    GridPane.setConstraints(b, i, j);
                }
            }
            Scene scene = new Scene(new Group(gp));
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}