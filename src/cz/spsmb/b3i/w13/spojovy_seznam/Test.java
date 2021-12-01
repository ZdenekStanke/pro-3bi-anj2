package cz.spsmb.b3i.w13.spojovy_seznam;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        LinkedList ll = new LinkedList();
        ll.append(123);
        ll.append(13);
        ll.append(1);
        for (int i = 0; i < 150; i++) {
            ll.append(r.nextInt(200));
        }
        /*
        ll.printList();
        Node n = ll.getHead();
        System.out.println();
        while (n!=null){
            System.out.println(n.getData()+' ');
            n=n.next;
        }*/
        //Aby fungoval foreach typ cyklu, je potřeba implementovat rozhraní Iterable
        int i=0;
        for (Object n1:ll
             ) {
            System.out.print(((i%10==0)?"\n":" ") + n1);
            i++;
        }
        Node n = ll.getHead();
        while (n.next != null)
            n = n.next;
        ll.quickSort(ll.getHead(), n);
        ll.printList();
    }



}
