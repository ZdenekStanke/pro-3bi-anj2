package cz.spsmb.b3i.w09;

public class MereniDobyBehu {
    public static void main(String[] args) {
        //currentTimeMillis vrací počet milisekund od 1.1.1970
        //význam při hledání doby běhu programu
        long t1 = System.currentTimeMillis();
        cz.spsmb.b3i.w08.DomaciUkol.faktorial((byte)20);
        long t2 = System.currentTimeMillis();
        cz.spsmb.b3i.w08.DomaciUkol.faktorialRekurzivne((byte)20);
        long t3 = System.currentTimeMillis();
    }

}
