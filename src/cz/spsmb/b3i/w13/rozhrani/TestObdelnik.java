package cz.spsmb.b3i.w13.rozhrani;

public class TestObdelnik {
    public static void main(String[] args) {
        Usecka u = new Usecka(5);
        Obdelnik o = new Obdelnik(2, 4);
        Info iu = new Usecka(6);
        Info io = new Obdelnik(3, 6);
        u.kdoJsem();
        o.kdoJsem();
        iu.kdoJsem();
        io.kdoJsem();
    }
}
