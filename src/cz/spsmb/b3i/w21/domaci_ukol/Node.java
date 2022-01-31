package cz.spsmb.b3i.w21.domaci_ukol;

public class Node {
    Object data;
    Node next;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(Object data) {
        this(data, null);
        //this.data = data;
        //this.next = null;
    }
}
