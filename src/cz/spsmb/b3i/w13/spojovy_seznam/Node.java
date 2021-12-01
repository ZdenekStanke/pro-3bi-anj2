package cz.spsmb.b3i.w13.spojovy_seznam;

public class Node {
    public int getData() {
        return data;
    }

    private int data;
    Node next;

    public Node(int d)
    {
        this.data = d;
        this.next = null;
    }
}
