package cz.spsmb.b3i.w21.vyjimky;

//vytvoření vlastní výjimky

import java.util.InputMismatchException;
import java.util.Scanner;

class BankomatException extends Exception {
    public BankomatException() {
        super("Bankomat mimo provoz");
    }
}

class Bankomat {
    private int penize = 0;
    Bankomat (int kolik) {
        this.penize = kolik;
    }
    public int vydejPenize(int kolik) throws BankomatException {
        if(kolik > this.penize){
            System.out.println("Nedostatek hotovosti");
            throw new BankomatException();
        } else {
            penize -= kolik;
            return kolik;
        }
    }
}
public class VlastniVyjimkaTestBankomatu {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Bankomat b = new Bankomat(1000);
        try{
            //System.out.println("Vydano: " + b.vydejPenize(200));
            System.out.println("kolik?");
            System.out.println("Vydano: " + b.vydejPenize(sc.nextInt()));
        }
        catch(BankomatException be) {
            System.out.println("Vyhledejte jiny bankomat");
            System.out.println(be.getMessage());
            be.printStackTrace();
        }
        catch(InputMismatchException ime){
            System.out.println("Špatně zadaná částka");
            throw new RuntimeException("Špatně zadaná částka", ime);
        }
    }
}
