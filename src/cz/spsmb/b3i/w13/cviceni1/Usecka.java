package cz.spsmb.b3i.w13.cviceni1;

public class Usecka implements IZobrazitelny{
    protected int a;

    public Usecka(int a) {
        this.a = a;
    }

    @Override
    public void zobraz() {
        System.out.println();
        for (int i = 0; i <a; i++) {
            System.out.print("*");
        }
    }
}
