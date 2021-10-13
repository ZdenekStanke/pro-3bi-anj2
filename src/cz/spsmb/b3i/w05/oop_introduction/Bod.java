package cz.spsmb.b3i.w05.oop_introduction;

public class Bod {
    //Zapouzdření <=> Metody a členské proměnné jsou pohromadě j jedné třídě
    //členské proměnné - nejlépe k nim přistupovat přes metody
    private int x;
    private int y;
    private int barva;
    //metody
    public void nastavPolohu(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void nastavBarvu(int barva){
        this.barva = barva;
    }

    public int getBarva() {
        return barva;
    }
}
