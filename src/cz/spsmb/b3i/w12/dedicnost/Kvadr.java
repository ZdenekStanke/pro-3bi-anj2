package cz.spsmb.b3i.w12.dedicnost;

public class Kvadr extends Obdelnik {
    private int hloubka;
    //pokud se konstruktor předka pomocí super() nezavolá,
    // doplní si překladač volání konstruktoru předka bez parametrů.
    // Ten však musí (klidně i implicitní) existovat
    public Kvadr(int sirka, int vyska, int hloubka) {
        super(sirka, vyska);
        this.hloubka = hloubka;
    }
    //Překrytí metody delkaUhlopricky - změna vlastnosti zděděného objektu.
    //dekorátor @Override - doporučuji používat, vyhneme se probémům
    // s překlepy v názvu metody
    @Override
    public double delkaUhlopricky(){
        return Math.sqrt(
                super.delkaUhlopricky()*super.delkaUhlopricky()
                        +
                        this.hloubka*this.hloubka);
    }

    public int getHloubka() {
        return hloubka;
    }
    public static void main(String[] args) {
        Kvadr kva = new Kvadr(6,8,10);
        System.out.println("uhlopricka = " + kva.delkaUhlopricky());
        System.out.println("sirka = " + kva.getSirka());
        System.out.println("vyska = " + kva.getVyska());
        System.out.println("hloubka = " + kva.getHloubka());
    }
}
