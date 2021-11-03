package cz.spsmb.b3i.w09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

//Gregoriánský kalendář se používá od 15.10.1582, roky dělitené 100 nejsou přestupné,
// roky dělitelné 400 přestupné jsou.
public class GregorianCalendar_ {
    public static void main(String[] args) {
        //aktuální datum a čas
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(new SimpleDateFormat("dd.MM.YYYY hh:mm:ss").format(gc.getTime()));
        //k vytvoření instance pomocí třídy Calendar nemusíme používat operátor new,
        // namísto toho je použita statická metoda .getInstance()
        //Calendar praveTed = Calendar.getInstance();
        //System.out.format("praveTed: %s%n",praveTed);


        //.setLenient(bool) - (schovívavý, mírný) stanoví, jak se bude instance chovat, pokud  zadáme nesprávný údaj
        //Do instance pak lze např. uložit datum 32.1. Při použití .get() se v případě
        // lenient = true údaj znormalizuje na 1.2. V případě lenient = false dostaneme výjimku
        gc.setLenient(true);
        gc.set(2021, Calendar.OCTOBER, 32);
        System.out.format("%d.%d.%d%n",gc.get(Calendar.DAY_OF_MONTH),
                //opravdu u měsíce přidávat jedničku v případě metody get()
                gc.get(Calendar.MONTH)+1,
                gc.get(Calendar.YEAR));
        gc.setLenient(false);
        gc.set(2021, Calendar.OCTOBER, 31);
        System.out.format("%d.%d.%d%n",gc.get(Calendar.DAY_OF_MONTH),
                gc.get(Calendar.MONTH)+1,
                gc.get(Calendar.YEAR));

        //metody:
        GregorianCalendar gc1 = new GregorianCalendar();//aktuální datum a čas
        System.out.println(gc1.get(Calendar.HOUR));//Měsíce indexované od nuly

        //Správné formátování výpisu pomocí SimpleDateFormat
        SimpleDateFormat sdfD = new SimpleDateFormat("MMMM");//listopad
        String dlouhyMesic = sdfD.format(gc1.getTime());
        System.out.println("MMMM:" + dlouhyMesic); //listopad
        System.out.println(new SimpleDateFormat("MMM").format(gc1.getTime()));//lis
        System.out.println(new SimpleDateFormat("MM").format(gc1.getTime()));//11
        //klasický zápis
        System.out.println(new SimpleDateFormat("dd.MM.YYYY").format(gc1.getTime()));
        //přidání hodnoty s kumulativní změnou metoda .add()
        gc1.add(GregorianCalendar.HOUR_OF_DAY, 15);
        System.out.println(new SimpleDateFormat("dd.MM.YYYY HH:mm:ss").format(gc1.getTime()));
        System.out.println(new SimpleDateFormat("dd.MM.YYYY hh:mm:ss a").format(gc1.getTime()));
        gc1=new GregorianCalendar();
        //přidání hodnoty bez kumulativní změny .roll()
        gc1.roll(GregorianCalendar.HOUR_OF_DAY, 15);
        System.out.println(new SimpleDateFormat("dd.MM.YYYY HH:mm:ss a").format(gc1.getTime()));
        //minimální / maximální hodnoty - mohu nahradit konstantami
        System.out.format("abs min: %d, abs max: %d%n",
                gc1.getMinimum(Calendar.DAY_OF_YEAR),
                gc1.getMaximum(Calendar.DAY_OF_YEAR)
        );
        //Akruální minimální / maximální hodnoty
        System.out.format(" abs min aktuálního měsíce: %d, abs max aktuálního měsíce: %d%n",
                gc1.getActualMinimum(Calendar.DAY_OF_YEAR),
                gc1.getActualMaximum(Calendar.DAY_OF_YEAR)
        );
        //FORMÁTOVÁNÍ
        //HH - hodiny 24 hod. formát
        //hh - hodiny 12 hod. formát
        //DD - dny v roce (Calendar.DAY_OF_YEAR)
        //G - ERA "n.l." "před n.l."
        //E - DAY_OF_WEEK
        //a - AM_PM "dop.", "odp."
        gc1.add(GregorianCalendar.YEAR, -2052);
        System.out.println(new SimpleDateFormat("EEEE dd.MMMM.YYYY HH:mm:ss G").format(gc1.getTime()));
        System.out.println(new SimpleDateFormat("EE dd.MM.YYYY HH:mm:ss a G").format(gc1.getTime()));
        //Další konstruktory třídy GregorianCalendar

        GregorianCalendar gc2 = new GregorianCalendar(new Locale("CZ"));
        GregorianCalendar gc3 = new GregorianCalendar(TimeZone.getTimeZone("Europe/Prague"));
        GregorianCalendar gc4 = new GregorianCalendar(2022,Calendar.APRIL, 5);
        System.out.println(new SimpleDateFormat("EE dd.MM.YYYY HH:mm:ss a G").format(gc4.getTime()));
    }

}
