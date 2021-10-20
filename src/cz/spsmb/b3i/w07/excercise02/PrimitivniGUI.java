package cz.spsmb.b3i.w07.excercise02;

import java.awt.*;

public class PrimitivniGUI {
    private Button ahojBT;
    private Label lab;

    PrimitivniGUI(Frame ramecek){
        //nastavíme Layou anonymní instancí třídy FlowLayout
        ramecek.setLayout(new FlowLayout());
        //vytvoříme instanci třídy Button
        this.ahojBT = new Button("Ahoj");
        //přidáme tlačítko do rozložení (layoutu) v rámečku
        ramecek.add(ahojBT);
        //vytvoříme instanci třídy Label
        this.lab = new Label("Ahoj ");
        //přidáme návěští (popisek) do rozložení (layoutu) v rámečku
        ramecek.add(lab);
        //nastavíme velikost rámečku
        ramecek.setSize(170,65);
    }

    public static void main(String[] args) {
        //vytvoříme novou instanci třídy ramec
        Frame ramec = new Frame("Muj ramecek");
        PrimitivniGUI n = new PrimitivniGUI(ramec);
        //nastavíme jako viditelný
        ramec.setVisible(true);
    }

}
