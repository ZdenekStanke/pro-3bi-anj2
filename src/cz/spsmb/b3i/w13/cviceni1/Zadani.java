package cz.spsmb.b3i.w13.cviceni1;
//Vytvořte třídy Ctverec a Usecka s vhodně zvolenými metodami a proměnnými.
//Vytvořte rozhraní Zobrazitelný s metodou void zobraz(). Zajistěte, aby třídy
//Ctverec a Usecka implementovaly toto rozhraní tak, že se vykreslí na obrazovku např.:
//      ***
//      ***             *************
//      ***
public class Zadani {
    public static void main(String[] args) {
        Ctverec c = new Ctverec(3);
        c.zobraz();
        Usecka u = new Usecka(6);
        u.zobraz();
    }
}
