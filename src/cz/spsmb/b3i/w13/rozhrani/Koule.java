package cz.spsmb.b3i.w13.rozhrani;

public class Koule implements Info{
    int polomer;

    public Koule(int polomer) {
        this.polomer = polomer;
    }

    @Override
    public void kdoJsem() {
        System.out.println("Koule");
    }
}
