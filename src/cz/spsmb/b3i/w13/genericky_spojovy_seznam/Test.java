package cz.spsmb.b3i.w13.genericky_spojovy_seznam;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();
        dll.addNode(1);
        dll.addNode(2);
        dll.addNode(3);

        for (Integer n:dll) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
