package cz.spsmb.b3i.w19.polymorfizmus;

public abstract class Zivocich {
    String typ;

    public Zivocich(String typ) {
        this.typ = typ;
    }

    public void vypisInfo() {
        //System.out.print(typ + ", ");
        //členská proměnná typ ani není potřeba
        System.out.print(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".")+1) + ", ");
        vypisDelku();
    }
    //nemusí být abstraktní, ale v tomto případě je použití abstract vhodnější
    public abstract void vypisDelku();
}
