package cz.spsmb.b3i.w15.trida_linked_list;

public class PouzitiZasobniku {
    public static void main(String[] args) {
        Zasobnik<String> zs = new Zasobnik<>();
        zs.add("prvni");
        zs.add("druhy");
        zs.add("treti");
        System.out.println(zs.get());
        while(zs.isEmpty() == false) {
            System.out.println(zs.remove()+", ");
        }
        System.out.println();
    }
}
