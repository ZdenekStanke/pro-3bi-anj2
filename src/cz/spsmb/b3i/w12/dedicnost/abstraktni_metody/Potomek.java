package cz.spsmb.b3i.w12.dedicnost.abstraktni_metody;

abstract class Rodic {
    public int i;
    public Rodic() { i = 1;}
    abstract int getI();
    final void setI(int i) {this.i = i;}
}

public class Potomek extends Rodic {
    int getI() {return i*2;} //překryli jsme, vyžadováno klíčovým slovem abstract v předkovi
    void setI( ) { i=5; } //přetížili jsme, nepřekryli

    public static void main(String[] args) {
        //Rodic r = new Rodic(); // nelze, abstraktní třída
        Potomek pot = new Potomek();
        //Rodic r = new Rodic(); // nelze vytvořit instanci abstraktní metody
        pot.setI(3);
        System.out.println(pot.getI());
        pot.setI(); //přetížená
        System.out.println(pot.getI());
    }

}
