package cz.spsmb.b3i.w07.excercise02;

public class Main {
    public static void main(String[] args) {
        PravouhlyTrojuhelnik pravouhly = new PravouhlyTrojuhelnik(20, 10);
        PravouhlyTrojuhelnik rovnoramenny = new PravouhlyTrojuhelnik(5, 5);
        System.out.format("Přepona pravoúhlého trojúhelníku = %.2f%n", pravouhly.delkaPrepony());
        System.out.format("Přepona rovnoramenného = %.2f%n", rovnoramenny.delkaPrepony());
        System.out.format("Obsah rovnoramenného = %.2f%n", rovnoramenny.obsah());
        System.out.format("Obsah pravoúhlého v rovnoramenným = %.2f%n ", rovnoramenny.obsahPravouhleho());


    }
}

