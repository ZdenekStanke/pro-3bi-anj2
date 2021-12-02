package cz.spsmb.b3i.w14.kolekce;

public class RozhraniList {
    /**
     * Změny v kolekci:
     * void add(int index, E element) - přidání prvku; prvky se stejným a
     *      s vyššími indexy budou posunuty o jeden výše
     * E set(int index, E element) - změna prvku na daném indexu; prvkům
     *      s vyšším indexem se indexy nemění
     * E remove(int index) - odstranění prvku; prvky s vyšším indexem budou
     *      posunuty o jeden níže.
     *
     * Získání obsahu kolekce
     * E get(int index) - vrátí prvek s daným indexem, ale narozdíl od remove
     *      ho v kolekci ponechá;
     * int indexOf(Object o) - vrátí index prvního nalezeného prvku shodného
     *      objektem o, nebo -1, není li prvek v kolekci. Porovnává se pomocí
     *      metody equals()
     * int lastIndexOf(Object o) - totéž co indexOf, ale hledá od konce
     * List<E> subList(int startIndex, int endIndex) - vrátí podseznam,
     *      ve kterém budou prvky od startIndex včetně do lastIndex-1
     *      včetně
     *
     */
}
