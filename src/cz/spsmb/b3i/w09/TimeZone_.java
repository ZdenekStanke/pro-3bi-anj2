package cz.spsmb.b3i.w09;

import java.util.TimeZone;
//Třída TimeZone je možný vstup pro konstruktor třídy GregorianCalendar

public class TimeZone_ {
    public static void main(String[] args) {
        TimeZone tz = TimeZone.getDefault();
        TimeZone tz1 = TimeZone.getTimeZone("Europe/Prague");
        //Užitečnmé metody zjištění aktuální časové zóny:
        System.out.println(tz.getID());
        System.out.println(tz.getDisplayName());
    }
}
