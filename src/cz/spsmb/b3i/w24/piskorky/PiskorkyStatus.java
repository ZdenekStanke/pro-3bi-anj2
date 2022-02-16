package cz.spsmb.b3i.w24.piskorky;

import cz.spsmb.b3i.w13.spojovy_seznam.LinkedList;
import javafx.scene.control.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class PiskorkyStatus implements Serializable {
     int rozmerHraciPlochy;
     //int[][] herniPlochaHracu;
     ArrayList<String> hraci;
     Button[][] herniTlacitka;
    //aktivni Hráč se zde automaticky inicializuje na 0 (LOJZA), netřeba inicializovat
     int aktivniHrac;

    public PiskorkyStatus(int rozmerHraciPlochy) {
        this.rozmerHraciPlochy = rozmerHraciPlochy;
        //this.herniPlochaHracu = new int[this.rozmerHraciPlochy + 1][this.rozmerHraciPlochy + 1];
        //for (int i = 0; i < this.herniPlochaHracu.length; i++) {
        //    Arrays.fill(this.herniPlochaHracu[i], (byte) -1);
        // }
        this.herniTlacitka = new Button[this.rozmerHraciPlochy + 1][this.rozmerHraciPlochy + 1];
        this.hraci = new ArrayList<>();
        this.hraci.add("Franta");
        this.hraci.add("Lojza");
        //this.hraci.add("Pepa");

    }
}
