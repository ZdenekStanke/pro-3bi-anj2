package cz.spsmb.b3i.w06;
//Inicializace proměnných třídy (statických proměnných)
public class StaticInitializer {
    public static final int MAX = 1000 ;
    public static final int cisla[] = new int [MAX];
    //vlastní inicializace proměnné třídy pomocí static{}
    //statický inicializační blok (static initialization block)
    static {
        int pocet = 2;
        cisla[0] = 1;
        cisla[1] = 2;
        dalsi:
        for (int i = 3; pocet < MAX; i+=2) {
            //zjisti, zda i je prvocislo, tj. dělitelné jen samo sebou a jedničkou
            for (int j = 2; j<pocet; j++){
                if(i % cisla[j] == 0){
                    continue dalsi;
                }
            }
            cisla[pocet] = i;
            pocet ++;
        }
    } //konec staticky innicializovaného bloku

    public static void main(String[] args) {
        System.out.format("Prvních %d prvocisel:%n ", StaticInitializer.MAX);
        for(int prvocislo :StaticInitializer.cisla){
            System.out.format("%d ",prvocislo);
        }
    }
}
