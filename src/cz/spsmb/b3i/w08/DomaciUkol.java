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


//     Karban
//     public static double obsahKruhu(double polomer)

//     Kraušner
//     public static double obvodKruhu(double polomer)
     public static double obvodKruhu(double polomer){
         return 2*3.14*polomer;
     }

//     Krouský
//     public static int povrchKrychle(int hranaA)

//     Matoušek
//     public static int objemKrychle(int hranaA)
     
    public static int objem (){
        return hranaA*hranaA*hranaA;
    }

//     Merhaut
//     public static int obvodPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB)

    public static int obvodPravouhlehoTrojuhelnika(int odvesnaA, int odvesnaB){
      return (int) Math.sqrt(Math.pow(odvesnaA, 2)+Math.pow(odvesnaB, 2)+odvesnaA+odvesnaB);
    }

//     Skalický
//     public static long faktorial(byte n)

//     Stanke
//     Výpočet fibbonaciho posloupnosti
//     private static int fibonacci(int n)
        private static  int fibonacci(int n){
            if (n<=1) return n;
            else return fibonacci(n-2)+fibonacci(n-1);
        }
//     Šípek
//     public static double povrchKoule(double polomer)
/*    public class Main {
        private static double polomer;
        public Main (double polomer){
            this.polomer = polomer;
        }
        public static double obsah(){
            return  4*Math.PI*polomer*polomer;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadej polomer: ");
            Double d = sc.nextDouble();
            Main obsah = new Main (d);
            System.out.format("Povrch koule je: %.3f m²", obsah.obsah());
        }
    }*/
//     Zajíček
//     public static double objemKoule(double polomer)
    
    public static double obsah() {
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
