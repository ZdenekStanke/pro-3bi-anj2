package cz.spsmb.b3i.w12.dedicnost.finalni_metody;

class Rodic {
    public int i;
    public Rodic() { i = 1; }
    //finální metody nelze překrýt.
    final int getI() { return i;}
}
public class Potomek extends Rodic {
    //chyba, finální metoda nelze překrýt:
    //int getI() { return i*2;}
    public static void main(String[] args) {
        Potomek pot = new Potomek();
        System.out.println(pot.getI());
    }
}