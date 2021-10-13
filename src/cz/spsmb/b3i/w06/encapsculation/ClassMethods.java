package cz.spsmb.b3i.w06.encapsculation;
//metody třídy, resp. statické metody,
// členové (atributy), resp. proměnné třídy
public class ClassMethods {
    //proměnné třídy
    public static int x;
    public static int y;
    //metody třídy
    public static int getX() {
        return x;
    }
    public static void setX(int x) {
        ClassMethods.x = x;
    }
    //použití
    public static void main(String[] args) {
        ClassMethods.x = 1; // s ClassMethods plně
        // kvalifikované jméno
        System.out.println(ClassMethods.getX());
    }
}
