package cz.spsmb.b3i.w13.spojovy_seznam;

public class Node implements Comparable {
    public int getData() {
        return data;
    }

    int data;
    Node next;

    public Node(int d)
    {
        this.data = d;
        this.next = null;
    }

    //vrací záporné číslo, pokud je argument větší,
    //kladné, pokud je menší
    //0, pokud je stejné
    @Override
    public int compareTo(Object o) {
        return this.data - ((Node)o).data;
    }
}
