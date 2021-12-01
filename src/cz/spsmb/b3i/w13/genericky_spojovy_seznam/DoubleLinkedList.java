package cz.spsmb.b3i.w13.genericky_spojovy_seznam;

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
}
