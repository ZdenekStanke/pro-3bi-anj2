package cz.spsmb.b3i.w20.domaci_ukol;

public interface Info {
    default void kdoJsem (){
        System.out.println("[Info] Jsem " + this.getClass().getSimpleName());
    }
    static void kdoJsemStat(){
        System.out.println("[Info] Jsem " + Info.class.getSimpleName());
    }
}
