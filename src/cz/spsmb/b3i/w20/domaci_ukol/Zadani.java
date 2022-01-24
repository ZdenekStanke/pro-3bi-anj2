package cz.spsmb.b3i.w20.domaci_ukol;
// Použijte znalosti z w19.rozhrani_od_java8 k vytvoření rozhraní Info, který
// bude implementovat implicitní (default) metodu kdoJsem() podobně jako v příkladu
// w19.vnorene_tridy.Test
public class Zadani extends Rodic implements Info{
    public static void main(String[] args) {
        Info i = new Zadani();
        Rodic r = new Zadani();
        i.kdoJsem();
        r.kdoJsemRodic();
        Info.kdoJsemStat();
        Zadani.kdoJsemRodicStat();
    }
}
