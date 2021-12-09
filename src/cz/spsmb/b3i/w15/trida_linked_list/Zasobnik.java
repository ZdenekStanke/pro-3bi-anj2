package cz.spsmb.b3i.w15.trida_linked_list;


import java.util.LinkedList;

//Z hlediska efektiovnosti nemusí být třída ArrayList vždy ideální. Jedná se o tyto případy:
//- časté změny v seznamu, tj. přidávání a ubírání prvků kdekoliv v seznamu
//- implemntace abstraktního datového typu zásobník (stack - LIFO)
//- implemntace abstraktního datového typu fronta (queue - FIFO)
public class Zasobnik<E> {
    private LinkedList<E> stack = new LinkedList<E>();

    public void add(E elem) {
        stack.addFirst(elem);
    }

    public E remove() {
        return stack.removeFirst();
    }

    public E get() {
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
