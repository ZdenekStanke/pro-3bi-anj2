package cz.spsmb.b3i.w16;

import java.util.SortedSet;
import java.util.TreeSet;

public class HruskyVSerazeneMnozine {
    public static void main(String[] args) {
        SortedSet<Hruska> st = new TreeSet<>();
        for (int i = 29; i >=20 ; i--) {
            st.add(new Hruska(i));
        }
        System.out.println("Cely kosik: " + st);
        System.out.println("Nejlevnejsi hruska: " + st.first());
        ////System.out.println("Nejdrazsi hruska: " + );
        //SortedSet subSet(E dolniMez, E horniMez) - vrací podmnožinu prvků
        //v zadaných mezích
        SortedSet<Hruska> pom = st.subSet(new Hruska(23), new Hruska(26));
        System.out.println("Od 23 do 26: " + pom.size()+" "+pom);
        //SortedSet headSet( E hranicniPrvek) - vrací podmnožinu prvků,
        //které jsou uloženy před hraničním prvkem
        //pom =
        System.out.println("Pod 25: " + pom.size()+" "+pom);
        //SortedSet tailSet( E hranicniPrvek) - vrací podmnožinu prvků,
        //které jsou uloženy za hraničním prvkem včetně
        //pom =
        System.out.println("Nad 25 včetně: " + pom.size()+" "+pom);
        //Podmnožina z množiny je tzv. mělká kopie, tzn., že modifikace
        // modifikace množiny ovlivní podmnožinu a naopak. Oproti seznamům
        //a podseznamům je možné do nadřazených množin přidávat, resp. ubírat
        //prvky
    }
}
