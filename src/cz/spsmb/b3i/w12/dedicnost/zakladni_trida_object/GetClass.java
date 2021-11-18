package cz.spsmb.b3i.w12.dedicnost.zakladni_trida_object;
// Finální metoda .getClass() dokáže poskytnout za běhu programu aktuální
// informace o libovolném objektu. Vrací objekt třídy Class, což je přímý
// potomek třídy Object

class Rodic{
    public int i;
    public Rodic() {
        this.i = 1;
    }
}
public class GetClass extends Rodic {
    public static void main(String[] args) {
        GetClass dite = new GetClass();
        System.out.format("Jmeno tridy je: %s%n", dite.getClass().getName());
        System.out.format("Jmeno rodicovske tridy ja: "
                + dite.getClass().getSuperclass().getName());
    }
}