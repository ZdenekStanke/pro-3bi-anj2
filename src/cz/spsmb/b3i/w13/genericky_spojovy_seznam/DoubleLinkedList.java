package cz.spsmb.b3i.w13.genericky_spojovy_seznam;

import java.util.Iterator;

public class DoubleLinkedList implements Iterable<Integer> {
    Node head;

    void addNode(int data)
    {
        if (head == null) {
            head = new Node(data);
            return;
        }

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        Node newNode = new Node(data, curr);
        curr.next = newNode;
    }

    void printList(Node n)
    {
        int i = 0;
        while (n != null) {
            System.out.print(((i%10==0)?"\n":" ") + n.data);
            n = n.next;
            i++;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node currentNode = head;
            @Override
            public boolean hasNext() {
                return this.currentNode != null;
            }

            @Override
            public Integer next() {
                if(this.hasNext()){
                    int data = this.currentNode.data;
                    this.currentNode = this.currentNode.next;
                    return data;
                }
                return null;
            }
        };
    }
}
