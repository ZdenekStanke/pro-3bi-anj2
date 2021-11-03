package cz.spsmb.b3i.w08;

public class DomaciUkol {

    // Každý sem napište metodu třídy dle zadání
    //Černý
    public static int obsahObdelnika(int stranaA, int stranaB) {
        return stranaA * stranaB;
    }

//     Haken
//     public static int obsahPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB)
    public static int obsahPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB) {
        return odvesnaA * odvesnaB / 2;
    }

//     Chomanič
//     public static int obvodObdelnika(int stranaA, int stranaB)
    public static int obvodObdelnika(int stranaA, int stranaB){
        return ((stranaA+stranaB)*2);
    }

//     Janošík
//     může si vybrat svou úlohu
    public static double objemLichobezniku(double stranaA,double stranaC, double Vyska){
        double Sp = ((stranaA+stranaC)*Vyska)/2;
        double V = Sp*Vyska;
        return V;
    }
//     Karban
//     public static double obsahKruhu(double polomer)
    public static double obsahKruhu(double polomer) {  return Math.PI*polomer*polomer;}
//     Kraušner
//     public static double obvodKruhu(double polomer)
     public static double obvodKruhu(double polomer){
         return 2*3.14*polomer;
     }
//     Krouský
//     public static int povrchKrychle(int hranaA)
    public static int povrchKrychle(int hranaA) {
        int vysledek = hranaA * hranaA * hranaA;
        return vysledek;
    }

//     Matoušek
//     public static int objemKrychle(int hranaA)
     
    public static int objemKrychle (int hranaA){
        return hranaA*hranaA*hranaA;
    }
//     Merhaut
//     public static int obvodPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB)

    public static int obvodPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB){
      return (int) Math.sqrt(Math.pow(odvesnaA, 2)+Math.pow(odvesnaB, 2)+odvesnaA+odvesnaB);
    }
//     Skalický
//     public static long faktorial(byte n)
        public static long faktorialRekurzivne(byte n){
            int vysledek;
            if(n == 1)
                return 1;
            return faktorialRekurzivne((byte) (n-1)) * n;
        }
        public static long faktorial(byte n) {
            //if (n == 0) return 1; zbytečné
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result = result * i;
            }
            return result;
        }
//     Stanke
//     Výpočet fibbonaciho posloupnosti
//     private static int fibonacci(int n)
        private static  int fibonacci(int n){
            if (n<=1) return n;
            else return fibonacci(n-2)+fibonacci(n-1);
        }
//     Šípek
//     public static double povrchKoule(double polomer)
        public static double povrchKoule(double polomer){
            return  4*Math.PI*polomer*polomer;
        }
//     Zajíček
//     public static double objemKoule(double polomer)
    public static double objemKoule(double polomer) {
        return (1.333 * Math.PI * (polomer * polomer * polomer)); //V = 4/3*PI*r³
    }
//     Žárský
//     public static long mocnina(int cislo, byte mocnitel)
    public static long mocnina(int cislo, byte mocnitel){
        int a;
        a= (int) Math.pow(cislo, mocnitel);
        return a;
    }
}
