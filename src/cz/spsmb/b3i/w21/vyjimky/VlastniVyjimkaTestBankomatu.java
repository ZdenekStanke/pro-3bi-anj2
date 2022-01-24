package cz.spsmb.b3i.w21.vyjimky;

//vytvoření vlastní výjimky

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
        Bankomat b = new Bankomat(1000);
        try{
            System.out.println("Vydano: " + b.vydejPenize(200));
            System.out.println("Vydano: " + b.vydejPenize(1000));
        }
        catch(BankomatException be) {
            System.out.println("Vyhledejte jiny bankomat");
            System.out.println(be.getMessage());
            be.printStackTrace();
        }
    }
}
