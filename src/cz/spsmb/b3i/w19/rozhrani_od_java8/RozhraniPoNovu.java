package cz.spsmb.b3i.w19.rozhrani_od_java8;
// Od Java 8 je možné do rozhraní implementovat výchozí těla metod (default)
// Od Java 9 je možné do rozhraní implementovat privátní fumkce použitelné v default
// metodách daného rozhraní
public interface RozhraniPoNovu {
    //Toto rochraní demonstruje všechny možnosti Javy 9

    // všechny atributy získávají automaticky modifikátory public static
    String CONSTANT = "Konstanta je implicitně statická a veřejná";

    // modifikátory sice napsat můžeme, ale pouze public a static
    public static final String CONST_EXP = "Konstanta explicitně statická a veřejná";

    //rozhraní umožňuje definovat statické metody, a to včetně metody sloužící jako
    //vstupní bod celé aplikace. Není-li označena jako private, je automaticky public
    static void main(String[] args) {
        System.out.println("Veřejná statická metoda rozhraní");
        staticPrivateMethod();
    }

    //rozhraní umožňuje definovat i private statické metody
    private static void staticPrivateMethod() {
        System.out.println("  Soukromá (private) statická metoda rozhraní");
    }

    //metoda, která je pouze deklarovaná je automaticky veřejná a abstraktní
    void abstractMethod();

    //rozhraní umožňuje definovat implicitní (default) verze metod. I ty jsou automaticky
    //veřejné
    default void defaultMethod() {
        System.out.println("Implicitní instanční metoda v rozhraní");
        staticPrivateMethod();
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("  Soukromá (private) instanční metoda v rozhraní");
    }
}
