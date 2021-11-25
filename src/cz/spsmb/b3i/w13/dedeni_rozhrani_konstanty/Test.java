package cz.spsmb.b3i.w13.dedeni_rozhrani_konstanty;

import cz.spsmb.b3i.w13.rozhrani.Info;
import cz.spsmb.b3i.w13.rozhrani.InfoDalsi;
import cz.spsmb.b3i.w13.rozhrani.Obdelnik2;

public class Test {
    public static void main(String[] args) {
        Info i = new Obdelnik(3, 6);
        InfoDalsi id = new Obdelnik(5, 7);
        InfoOba io = new Obdelnik(2, 4);
        i.kdoJsem(); ((Obdelnik)i).vlastnosti();//3Obdelnik = 3, 6
        ((Obdelnik)id).kdoJsem(); id.vlastnosti();//3Obdelnik = 5, 7
        io.kdoJsem();io.vlastnosti();//3Obdelnik = 2, 4
        System.out.println("Pocet rozhrani = "+ InfoOba.POCET); //3
    }
}
