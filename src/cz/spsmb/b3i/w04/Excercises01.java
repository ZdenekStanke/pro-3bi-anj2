package cz.spsmb.b3i.w04;

public class Excercises01 {
    public class Main {
        //Napište statickou metodu void power(double x, int n),
        // která vypíše tabulku mocnin x od 1 do n
        private static void power(final double x, final int n){
            double tmp=x;
            for(int i=1; i<=n; i++){
                System.out.format("(%1.0f^%d):%4.0f ",x,i,tmp);
                tmp*=x;
            }
        }
        //Napište statickou metodu boolean jePrvocislo(int i), která zjistí,
        // zda její parametr je prvočíslo (je dělitelné jen samo sebou a jedničkou)
        private static boolean jePrvocislo(int in){
            for (int i = in-1; i >1 ; i--) {
                if(in % i == 0) {
                    return false;
                }
            }
            return true;
        }
        public static void main(String[] args) {
            System.out.println(jePrvocislo(8));
            power(2,10);
        }
    }
}
