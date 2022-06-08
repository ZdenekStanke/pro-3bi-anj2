package cz.spsmb.b3i.w36.graph_traverse;

import java.util.ArrayList;

public class Node implements Comparable {
    int data;
    ArrayList<Node> nextNodeList;
    boolean isFinal;

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", isFinal=" + isFinal +
                '}';
    }

    public Node(int data, boolean isFinal) {
        this(data);
        this.isFinal = isFinal;
    }

    Node(int d)
    {
        this.data = d;
        this.nextNodeList = new ArrayList<>();
    }
    //vrací záporné číslo, pokud je argument větší,
    //kladné, pokud je menší
    //0, pokud je stejné
    @Override
    public int compareTo(Object o) {
        return this.data - ((Node)o).data;
    }
}
