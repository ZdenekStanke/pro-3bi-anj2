package cz.spsmb.b3i.w12.dedicnost.zakladni_trida_object;

public class AnonTrida {
    public static void main(String[] args) {
        //Vytvoření instance anonymní třídy
        Object mojeInstance = new Object() {
            public int i;
        };
        System.out.println(mojeInstance.getClass().getName());
    }
}
