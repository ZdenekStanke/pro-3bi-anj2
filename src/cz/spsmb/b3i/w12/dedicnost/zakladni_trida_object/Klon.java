package cz.spsmb.b3i.w12.dedicnost.zakladni_trida_object;

public class Klon implements  Cloneable {
    private int i;
    Klon(int i ) {this.i = i;}

    //překrytí metody clone()
    protected Object clone() {
        Klon k = null;
        try {
            k = (Klon) super.clone();
            k.i = this.i;
        }
        catch(CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return k;
    }
    public int getI() {
        return i;
    }
    public static void main(String[] args) {
        Klon kopie, orig = new Klon(5);
        //vytvoření instance, resp. kopie instance orig (Třída Klon) bez operátoru new
        kopie = (Klon) orig.clone();
        System.out.format("Original:%d%nKopie:%d%n",orig.getI(), kopie.getI() );
    }
}
