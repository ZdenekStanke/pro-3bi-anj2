package cz.spsmb.b3i.w13.spojovy_seznam;

public class Test {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(123);
        ll.append(13);
        ll.append(1);
        ll.printList();
        Node n = ll.getHead();
        System.out.println();
        while (n!=null){
            System.out.println(n.getData()+' ');
            n=n.next;
        }
        //Aby fungoval foreach typ cyklu, je potřeba implementovat rozhraní Iterable
        for (Node n1:ll
             ) {
            System.out.println(n.getData());
        }
    }



}
