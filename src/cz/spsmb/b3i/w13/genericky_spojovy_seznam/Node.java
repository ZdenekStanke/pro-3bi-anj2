package cz.spsmb.b3i.w13.genericky_spojovy_seznam;

public class Node {
    Integer data;
    Node prev;
    Node next;

    public Node(Integer d, Node prev) {
        this.data = d;
        this.next = null;
        this.prev = prev;
    }

    public Node(Integer d) {
        this(d, null);
    }

}
