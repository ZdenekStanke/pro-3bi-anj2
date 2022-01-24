package cz.spsmb.b3i.w20.domaci_ukol;

public class Rodic {
    public void kdoJsemRodic (){
        System.out.println("[Rodic] Jsem " + this.getClass().getSimpleName());
    }
    public static void kdoJsemRodicStat(){
        System.out.println("[Rodic] Jsem " + Rodic.class.getSimpleName());
    }
}
