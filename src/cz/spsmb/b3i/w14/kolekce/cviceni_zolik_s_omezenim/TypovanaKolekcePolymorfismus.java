package cz.spsmb.b3i.w14.kolekce.cviceni_zolik_s_omezenim;

import java.util.ArrayList;

//Vytvořte jednoduché rozhraní Tisknutelny s metodou void tiskni() a dvě třídy A a B, které ho
// budou implementovat. V hlavní metodě main pak vytvořte seznam kombinující
// instance těchto tříd a nakonec pomocí statické metody tisk tento seznam
// vytiskněte
public class TypovanaKolekcePolymorfismus {
    public static <E extends  Tisknutelny> void tisk(ArrayList<E> ar){
    //public static  void tisk(ArrayList<Tisknutelny> ar){
        for (E t:ar) {
            t.tisk();
        }
    }
    public static void main(String[] args) {
        ArrayList<A> ar = new ArrayList<>();
        ar.add(new A("AS"));
        ar.add(new B("sada", 23));
        tisk(ar);
    }
}
