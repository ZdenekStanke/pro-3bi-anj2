package cz.spsmb.b3i.w01;

public class EnumType {

    enum Karty {CERVENA, ZELENA, KULE, ZALUDY};
    public static void main(String[] args) {
        Karty k = Karty.KULE;
        System.out.println(k);
    }
}
