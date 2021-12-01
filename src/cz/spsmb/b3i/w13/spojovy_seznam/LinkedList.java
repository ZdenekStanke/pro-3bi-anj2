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
    public void bubbleSort(){
        Node current = this.head;
        int n = 0;
        while(current != null){
            n++;
            current=current.next;
        }
        for (int i = 0; i < n-1; i++) {
            current = this.head;
            for (int j = 0; j < n-i-1; j++) {
                if(current.compareTo(current.next)>0){
                    int tmp = current.data;
                    current.data = current.next.data;
                    current.next.data = tmp;
                }
                current = current.next;
            }

        }
    }

    Node paritionLast(Node start, Node end) {
        if (start == end || start == null || end == null)
            return start;

        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.getData();

        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.compareTo(end) < 0) {
                // keep tracks of last modified item
                pivot_prev = curr;
                int temp = curr.getData();
                curr.data = start.getData();
                start.data = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        // swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.data;
        curr.data = pivot;
        end.data = temp;

        // return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }

    void quickSort(Node start, Node end) {
        if(start == null || start == end|| start == end.next )
            return;

        // split list and partition recurse
        Node pivot_prev = paritionLast(start, end);
        quickSort(start, pivot_prev);

        // if pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            quickSort(pivot_prev.next, end);

            // if pivot is in between of the list,
            // start from next of pivot,
            // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                && pivot_prev.next != null)
            quickSort(pivot_prev.next.next, end);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node currentNode = head;
            @Override
            public boolean hasNext() {
                return this.currentNode != null;
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
