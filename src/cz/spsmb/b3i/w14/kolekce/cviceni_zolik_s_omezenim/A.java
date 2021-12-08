package cz.spsmb.b3i.w14.kolekce.cviceni_zolik_s_omezenim;

public class A implements Tisknutelny {
    String str;

    public A(String str) {
        this.str = str;
    }

    @Override
    public void tisk() {
        System.out.println(this.str);
    }
}
