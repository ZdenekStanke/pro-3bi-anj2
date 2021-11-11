package cz.spsmb.b3i.w10.tridy2;

//Vytvořte třídu bankovní účet s potřebnými datovými prvky a metodami. Ve třídě Banka
//vytvořte pole účtů, které náhodně inicializujete. Vypište celkovou hotovost v bance.

import java.util.Arrays;
import java.util.Random;

public class Banka {
    final int N_UCTU = 14;
    private BankovniUcet[] ucty;

    public Banka() {
        Random rnd = new Random();
        //inicializace pole
        this.ucty = new BankovniUcet[N_UCTU];
        //vytvoříme instance třídy BankovniUcet a přidáme je do pole účtů
        for (int i = 0; i < this.ucty.length ; i++) {
            this.ucty[i] = new BankovniUcet(rnd.nextInt(10000),i);
        }
    }

    public BankovniUcet[] getUcty() {
        return ucty;
    }

    public static void main(String[] args) {
        Banka b = new Banka();
        for (BankovniUcet bu:b.getUcty()) {
            System.out.println(bu);
        }
        //Arrays.toString(b.getUcty());
    }
}