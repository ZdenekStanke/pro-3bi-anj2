package cz.spsmb.b3i.w12.cviceni_kolo;

public class Test {
    public static void main(String[] args) {
        Kolo k = new Kolo("skoda",5000,true);
        HorskeKolo hk = new HorskeKolo("škoda",5000,5,2);
        System.out.println(k);
        System.out.println(hk);
    }
}
