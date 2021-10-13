package cz.spsmb.b3i.w06.excercise01;

public class ExcMain {
    public static void main(String[] args) {
        Triangle t = new Triangle(5,5,5);
        System.out.format("Trojuhelnik ma obvod %2.2f a %s pravouhly%n", t.obvod(),
                t.jePravouhly()?"je":"neni");
    }
}
