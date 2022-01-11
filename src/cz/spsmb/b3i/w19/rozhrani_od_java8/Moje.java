package cz.spsmb.b3i.w19.rozhrani_od_java8;

public class Moje implements RozhraniPoNovu{
    public static void main(String[] args) {
        RozhraniPoNovu.main(args);
        RozhraniPoNovu novy = new Moje();
        novy.abstractMethod();
        novy.defaultMethod();
    }

    @Override
    public void abstractMethod() {
        System.out.println("Mám rád řizky");
    }
}
