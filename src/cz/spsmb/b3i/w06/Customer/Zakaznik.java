package cz.spsmb.b3i.w06.Customer;

public class Zakaznik {
    //proměnná třídy, resp. statická proměnná
    public static int pocetZakazniku = 0; //=0 nemusí být, ale pro přehlednost uveďme
    public int utratil = 0;
    public Zakaznik(){
        Zakaznik.pocetZakazniku++;
        this.utratil = 0; //nemusí být
    }
    public void platil(int cena){
        this.utratil += cena;
    }

}
