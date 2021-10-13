package cz.spsmb.b3i.w06.encapsculation;
//metody instance, instanční členové, atributy,
//resp. proměnné
public class InstanceMethods {
    //proměnné instance
    public int x;
    public int y;
    //metody instance
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    //použití - vyžaduje vytvoření instance třídy
    //resp. objektu. Instancí může být libovolné
    // množství
    public static void main(String[] args) {
        InstanceMethods im = new InstanceMethods();
        InstanceMethods im1 = new InstanceMethods();
        im.setX(8);
        im1.x=20;
        System.out.println(im.getX());
        System.out.println(im1.getX());
    }
}
