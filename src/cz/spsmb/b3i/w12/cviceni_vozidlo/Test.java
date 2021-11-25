package cz.spsmb.b3i.w12.cviceni_vozidlo;

public class Test {
    public static void main(String[] args) {
        Kolo k = new Kolo("chevrolet", "jízdní");
        Motorka m = new Motorka(30,"enduro");
        System.out.println(k);
        System.out.println(m);
        k.vypisCoJsiZac();
        m.vypisCoJsiZac();
    }
}
