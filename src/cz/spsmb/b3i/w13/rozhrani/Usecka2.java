package cz.spsmb.b3i.w13.rozhrani;

public class Usecka2 implements Info, InfoDalsi {
    private int delka;

    public Usecka2(int delka) {
        this.delka = delka;
    }

    @Override
    public void kdoJsem() {
        System.out.print("Usecka");
    }

    @Override
    public void vlastnosti() {
        System.out.println(" = " + this.delka);
    }

    public int getDelka() {
        return delka;
    }

    public static void main(String[] args) {
        Usecka2 u = new Usecka2(5);
        u.kdoJsem(); u.vlastnosti();
        Info info = new Usecka2(2);
        info.kdoJsem();
        //Instance rozhraní může využívat jen metody rozhraní:
        //info.vlastnosti(); // toto nelze
        ((Usecka2) info).vlastnosti();// po přetypování ano
        //System.out.println(info.getDelka());//také nelze
        System.out.println(((Usecka2)info).getDelka());//to už lze
    }
}
