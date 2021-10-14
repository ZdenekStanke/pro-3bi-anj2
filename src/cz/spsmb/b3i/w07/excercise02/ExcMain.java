package cz.spsmb.b3i.w07.excercise02;

public class ExcMain {
    public static void main(String[] args) {
        Triangle t = new Triangle(1,3,5);
        System.out.format("Trojuhelnik ma obvod %2.2f, strana a je %d a %s pravouhly%n", t.obvod(),
                t.getStranaA(),
                t.jePravouhly()?"je":"neni");
    }
}
