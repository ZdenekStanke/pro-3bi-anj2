package cz.spsmb.b3i.w05.methods;

public class Excercises01 {
    public class Main {
        //Napište statickou metodu void power(double x, int n), která vypíše tabulku mocnin x od 1 do n
        private static void power(final double x, final int n){
            double tmp = 1;
            for(int i=1; i<=n; i++){
                tmp *= x;
                System.out.format("(%5.3f^%d)=%5.3g ",x,i,tmp);
            }
        }
        //Napište statickou metodu boolean jePrvocislo(int i), která zjistí, zda její parametr je prvočíslo
        //prvočíslo - je celočíselně dělitelné jen samo sebou a 1
        private static boolean jePrvocislo(int i){
            for(int cislo=i-1; cislo>1; cislo--){
                if(i%cislo == 0){ //alespoň jednou platí, že i je dělitelné cislo, kde cislo je od 2 do i-1
                    return false;
                }
            }
            return true;
        }
        //Napište rekurzivní statickou metodu double mocnina(double x, int n), která vypočítá x^n podle
        //vztahu x^n=x*x^(n-1)
        private static double mocnina(double x, int n){
            if(n==1){
                return x;
            } else {
                return x*mocnina(x,n-1);
            }
        }
        //Napite metodu, která vypočte Eulerovo číslo e podle vzorce e=1+1/1!+1/2!+1/3!+... se zadanou p5esnost9
        // přesnost eps např. 1*10^-7
        private static double e(float eps){
            double fakt=1;
            double clen=1;
            double e=0;
            for(int i=1; clen>eps; i++){
                clen=1/fakt;
                e+=clen;
                fakt*=i;
                //System.out.println(fakt);
                //System.out.println(clen);
            }
            return e;
        }
        public static void main(String[] args) {
            //power(3.14,10);
            //System.out.format("%b", jePrvocislo(31));
            //System.out.print(mocnina(3.14,6));
            System.out.println(e(1e-9f));
            System.out.println(Math.E);
            // write your code here
        }
    }
}
