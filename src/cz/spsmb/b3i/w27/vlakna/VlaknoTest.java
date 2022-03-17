package cz.spsmb.b3i.w27.vlakna;

// Vlakna - způsob, jak v jeden okamžik může v počítači běžet víc běhů programu (vláken) najednou.
// Využití:
// - časově náročné aplikace - trvá-li někjaký výpočet dlouhou dobu, je vhodné dát uživateli možnost
// provádět nějakou jinou činnost
// - čekání na vstupy uživatele
// - opakující se výpočty
// - úlohy typu producent - konzument

public class VlaknoTest extends Thread {

    public VlaknoTest(String jmeno) {
        super(jmeno);
    }

    public void run() {
        for (int i = 1; i <=3 ; i++) {
            System.out.println(i + ". " + this.getName());
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Předčasně probuzeno.");
            }
        }
    }

    public static void main(String[] args) {
        VlaknoTest vt = new VlaknoTest("ahoj");
        vt.start();
        new VlaknoTest("nazdar").start();
        new VlaknoTest("cao").start();
    }
}
