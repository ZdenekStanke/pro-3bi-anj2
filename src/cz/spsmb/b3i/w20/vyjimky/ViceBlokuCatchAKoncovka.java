package cz.spsmb.b3i.w20.vyjimky;

public class ViceBlokuCatchAKoncovka {
    //generátor 4 různých výjimek
    public static void  multiThrow(int h) {
        if(h<0) {
            throw new Error("Chyba - podteklo to");
        }
        int     h0 = 1/h;                   //h=0 => ArithmeticException
        String  h7 = (h%3 == 0) ? null : "";
                h7.toString();              //h=3 => NullPointerException
        char    hM = "ABCDEF".charAt(h+3);  //h>1 => IndexOutOfBoundException
        System.out.println("   Pto h="+h+" metoda multiThrow prošla");
    }
    public static void catchTest(int level) {
        System.out.println("++++ prichod na h= " + level);
        String zprava =    "     h= " + level+": ";
        try{
            multiThrow(level);
            zprava +="Test OK";
        }
        catch (ArithmeticException|NullPointerException e) {
            zprava += "Nastala výjimka typu " + e;
        }
        catch (IndexOutOfBoundsException e) {
            zprava += "Index mimo meze";
        }
        catch (RuntimeException e) {
            zprava += "Někde se stala chyba typu " + e.getClass().getSimpleName();
        }
        catch (Throwable e) {
            zprava += "Něco se stalo - " + e.getClass().getName()
                    + "\n příčina: " + e.getLocalizedMessage();
            // a pošleme dále jako nekontrolovanou výjimku
            throw new RuntimeException("Utíkám z h " + level);
        } //blok finally se provede vždy (vhodné např. na uzavření otevřených souborů)
        finally {
            System.out.println(zprava);
        }
        System.out.println("konec akce v h="+level);
        catchTest(level-1);
    }

    public static void main(String[] args) {
        catchTest(4);
    }

}
