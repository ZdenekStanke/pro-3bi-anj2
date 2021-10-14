package cz.spsmb.b3i.w07.excercise02;

public class Main {
    public static void main(String[] args) {
        PravouhlyTrojuhelnik pravouhly = new PravouhlyTrojuhelnik(20, 10);
        PravouhlyTrojuhelnik rovnoramenny = new PravouhlyTrojuhelnik(5);
        System.out.println("Přepona pravoúhlého Trojúhelníku je = " + pravouhly.delkaPrepony());
        System.out.println("Přepona pravoúhlého rovnoramenného  " + rovnoramenny.delkaPrepony());
        System.out.println("obsah pravoúhlého rovnoramenného " + rovnoramenny.obsah());
    }
}

