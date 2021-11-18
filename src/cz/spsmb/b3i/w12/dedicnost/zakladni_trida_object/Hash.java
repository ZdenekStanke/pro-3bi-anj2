package cz.spsmb.b3i.w12.dedicnost.zakladni_trida_object;

// metoda .hashCode() vrací pro každý objekt číslo typu int, které je po dobu
// života objektu stále stejné. Tj. nemění se při změně stavu objektu.
// Nejedná se o jedinečné číslo.
public class Hash {
    public static void main(String[] args) {
        Pomocna p1 = new Pomocna(3.14);
        Pomocna p2 = new Pomocna(3.14);
        System.out.format("p1:%d%np2:%d%n",p1.hashCode(), p2.hashCode() );
        p1.d = 6.28;
        System.out.println("p1: "+ p1.hashCode());
        Integer i1 = Integer.valueOf(5);
        Integer i2 = Integer.valueOf(5);
        Byte b = Byte.valueOf((byte)5);
        System.out.println("i1: " + i1.hashCode());
        System.out.println("i2: " + i2.hashCode());
        System.out.println("b: " + b.hashCode());
    }
}
