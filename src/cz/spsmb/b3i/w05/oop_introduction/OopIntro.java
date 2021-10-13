package cz.spsmb.b3i.w05.oop_introduction;

public class OopIntro {
    public static void main(String[] args) {
        //Vytvoření instance třídy Bod
        Bod b = new Bod();
        Bod b1 = new Bod();
        b.nastavBarvu(255);
        b1.nastavBarvu(25);
        System.out.println(b.getBarva());
        System.out.println(b1.getBarva());
    }
}
