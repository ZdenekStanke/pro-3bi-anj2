package cz.spsmb.b3i.w14.kolekce.cviceni_zolik_s_omezenim;

public class B extends A {
    private int i;

    @Override
    public void tisk() {
        System.out.println(this.str+" "+this.i);
    }

    public B(String str, int i) {
        super(str);
        this.i = i;
    }
}
