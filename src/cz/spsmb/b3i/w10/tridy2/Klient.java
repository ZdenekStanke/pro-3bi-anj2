package cz.spsmb.b3i.w10.tridy2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

//Vytvořte třídu Klient, která bude mít jako jednu členskou
// proměnnou referenci na objekt třídy BankovniUcet. Modifikujte třídu Banka,
// aby pracovala s klienty
// místo účty.
public class Klient {
    private String jmeno;
    private String prijmeni;
    private String adresa;
    private GregorianCalendar datumNarozeni;

    public Klient(String jmeno, String prijmeni, String adresa, GregorianCalendar datumNarozeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.adresa = adresa;
        this.datumNarozeni = datumNarozeni;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "jmeno='" + this.jmeno + '\'' +
                ", prijmeni='" + this.prijmeni + '\'' +
                ", adresa='" + this.adresa + '\'' +
                ", datumNarozeni=" +
                new SimpleDateFormat("dd.MM.YYYY hh:mm:ss a").format(this.datumNarozeni.getTime()) +
                '}';
    }
}
