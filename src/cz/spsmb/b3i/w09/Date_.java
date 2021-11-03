package cz.spsmb.b3i.w09;

import java.util.Date;

//deprecated (zavrhovaná, nepodporovaná) třída. Používat raději java.util.Calendar.
//používat pouze pro uložení data a času s přesností na milisekundy.
//ms = 1.1.1970. Dobrá spolupráce s metodou System.currentTimemillis()
public class Date_ {
    public static void main(String[] args) {
        Date d1 = new Date ();
        Date d2 = new Date (System.currentTimeMillis()+2000);
        System.out.format("d1 = %s%n", d1);
        System.out.format("d2 = %s%n", d2);
        System.out.format("d1 v poctu ms od 1.1.1970:%d%n", d1.getTime());
    }
}
