package cz.spsmb.b3i.w13.spojovy_seznam;

import java.util.Iterator;

public class LinkedList implements Iterable {
    private Node head;

    public Node getHead() {
        return head;
    }
    void printList()
    {
        Node n = this.head;
        int i = 0;
        while (n != null) {
            System.out.print(((i%10==0)?"\n":" ") + n.getData());
            n = n.next;
            i++;
        }
    }
    public void append(int data){
        //spojový seznam je prázdný, v hlavičce je null
        if (this.head == null) {
            this.head = new Node(data);
            return;
        }
        //pokud není prázdný, najdu konec a přidám nový Node

        Node curr = this.head;
        while (curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data);
        curr.next = newNode;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode.next != null;
            }

            @Override
            public Object next() {
                if(this.hasNext()){
                    int data = this.currentNode.getData();
                    this.currentNode = this.currentNode.next;
                    return data;
                }
                return null;
            }
        };
    }
}
