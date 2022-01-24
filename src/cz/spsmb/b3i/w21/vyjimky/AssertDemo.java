package cz.spsmb.b3i.w21.vyjimky;

public class AssertDemo {
    public static void main(String[] args) {
        int i = 1;
        System.out.println("i = " + i + ": ");
        try{
            //aby toto fungovalo, je potřeba do VMOptions přidat parametr
            //-enableassertions, resp. -ea
            assert(i == 0)  //Test splnění požadované podmínky
                    : "\nPříkaz assert vyhodil výjimku"; // Zpráva při nespnění
        }
        catch (AssertionError ae){
            System.out.println("Byla vyhozena výjimka " + ae);
            System.exit(0);
        }
        System.out.println("Nebyla vyhozena žádná výjimka");
        System.exit(0);
    }
}
