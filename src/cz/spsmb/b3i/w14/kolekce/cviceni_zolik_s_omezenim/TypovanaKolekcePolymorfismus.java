package cz.spsmb.b3i.w14.kolekce.cviceni_zolik_s_omezenim;

import java.util.ArrayList;

//Vytvořte jednoduché rozhraní Tisknutelny s metodou void tiskni() a dvě třídy A a B, které ho
// budou implementovat. V hlavní metodě main pak vytvořte seznam kombinující
// instance těchto tříd a nakonec pomocí statické metody tisk tento seznam
// vytiskněte
public class TypovanaKolekcePolymorfismus {
    public static  void tisk(ArrayList<? extends Tisknutelny> ar){
    //public static  void tisk(ArrayList<Tisknutelny> ar){
        for (Tisknutelny t:ar) {
            t.tisk();
        }
    }
    public static void main(String[] args) {
        ArrayList<Tisknutelny> ar = new ArrayList<Tisknutelny>();
        ar.add(new A("AS"));
        ar.add(new B("sada", 23));
        tisk(ar);
    }
}
