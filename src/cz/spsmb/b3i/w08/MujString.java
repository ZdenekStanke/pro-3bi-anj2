package cz.spsmb.b3i.w08;

//každá třída, kterou vytvoříme
//automaticky dědí vlastnosti třídy
//Object. Tzn. extends Object zde nemusím
//psát
public class MujString extends Object {
    int hodnota;
    public MujString(int h){
        this.hodnota = h;
    }
    //vytvoření vlastní metody toString(),
    //která je standartně přítomná ve třídě
    //Objekt. Zde jí tzv. překrýváme
    // (override)
    public String toString() {
        //Pomocí getClass().getName() zjistíme jméno třídy, ve které jsme
        String jmenoTridy = new String(getClass().getName());
        return (jmenoTridy + ": " + hodnota);
    }
    public void puvodniToString() {
        //pomocí super zavoláme metodu předka - budeme brát v dědičnosti objektů
        System.out.println(super.toString());
    }
    public static void main(String[] args) {
        MujString s1 = new MujString(5);
        s1.puvodniToString();
        //oba příkazy dělají totěž:
        System.out.println(s1.toString());
        System.out.println(s1);
    }
}
