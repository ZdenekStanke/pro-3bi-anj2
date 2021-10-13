package cz.spsmb.b3i.w06.encapsculation;

//Ukončení práce s objekty
public class Customer {
    //proměnná třídy, resp. statická proměnná
    public static int pocetZakazniku = 0; //=0 nemusí být, ale pro přehlednost uveďme
    public int utratil = 0;
    public Customer(){
        Customer.pocetZakazniku++;
        this.utratil = 0; //nemusí být
    }
    //finalizer - protected a super se týká dědění, zatím jsme neprobírali,
    // práci s výjimkami (throws Throwable) také ne
    protected void finalize() throws Throwable{
        Customer.pocetZakazniku--;
        System.out.println("Konec zákazníka");
        super.finalize();
    }
    public void platil(int cena){
        this.utratil += cena;
    }

}
