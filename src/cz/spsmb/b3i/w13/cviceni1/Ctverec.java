package cz.spsmb.b3i.w13.cviceni1;

public class Ctverec implements IZobrazitelny{
    protected int a;

    public Ctverec(int a) {
        this.a = a;
    }

    @Override
    public void zobraz() {
        for (int i = 0; i <a; i++) {
            for (int j = 0; j <a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
