package cz.spsmb.b3i.w14.kolekce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PoleNaKolekci {
    public static void main(String[] args) {
        String[] pole = {"1", "2", "3"};
        //Takto vytvořený seznam nelze zvětšovat ani zmenšovat

        //Vhodné pro seznam pevné velikosti. Např.:
        List<String> karty = Arrays.asList(new String[8]);

        List<String> seznam = Arrays.asList(pole);
        System.out.println(seznam);
        //NELZE (UnsupportedOperationException) !!!
        //seznam.remove(0);
        //NELZE (UnsupportedOperationException) !!!
        //seznam.add("5");
        System.out.println(seznam);//1, 2, 3
        pole[1] = "osm";
        //Změněný prvek v poli se automaticky promítne do výsledného seznamu
        System.out.println(seznam);
        //Takto lze přidávat (vytvoříme nový seznam pomocí konstruktoru a pův. seznamu)
        List<String> ar = new ArrayList<String>(seznam);
        ar.add("5");
        System.out.println(ar);
    }
}
