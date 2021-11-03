package cz.spsmb.b3i.w09;

public class MereniDobyBehu {
    public static void main(String[] args) {
        //currentTimeMillis vrací počet milisekund od 1.1.1970
        //význam při hledání doby běhu programu
        long t1 = System.currentTimeMillis();
        long f1 = cz.spsmb.b3i.w08.DomaciUkol.faktorial((byte)19);
        long t2 = System.currentTimeMillis();
        long f2 = cz.spsmb.b3i.w08.DomaciUkol.faktorialRekurzivne((byte)19);
        long t3 = System.currentTimeMillis();
        System.out.format("20!=%d (%dms), rekurzivně:20!=%d (%dms)",
                f1, t2-t1, f2, t3-t1);
    }

}
