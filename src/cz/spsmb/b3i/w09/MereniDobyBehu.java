package cz.spsmb.b3i.w09;

public class MereniDobyBehu {
    public static void main(String[] args) {
        //currentTimeMillis() vrací počet milisekund od 1.1.1970
        //význam při hledání doby běhu programu
        //System.nanoTime(); - vrátí počet nanosekund od specfické události
        //(zapnutí počítače)
        long f1=0, f2=0;
        int i;
        for (int j = 0; j < 10; j++) {
            long t1 = System.nanoTime();
            for (i = 0; i < 100 ; i++) {
                f1 = cz.spsmb.b3i.w08.DomaciUkol.faktorial((byte)19);
            }
            long t2 = System.nanoTime();
            for (i = 0; i < 100 ; i++) {
                f2 = cz.spsmb.b3i.w08.DomaciUkol.faktorialRekurzivne((byte) 19);
            }
            long t3 = System.nanoTime();
            System.out.format("20!=%d (%dns), rekurzivně:20!=%d (%dns)",
                    f1, t2-t1, f2, t3-t1);
            System.out.println();
        }
    }

}
