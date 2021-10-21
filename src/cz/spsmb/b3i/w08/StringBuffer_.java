package cz.spsmb.b3i.w08;

public class StringBuffer_ {
    public static void main(String[] args) {
        //inicializace, k dispozici 3 konstruktory
        StringBuffer b1, b2, b3;
        //inicializuje řetězec o kapacitě 16 znaků
        b1 = new StringBuffer();
        //inicializuje řetězec o kapacitě 100 znaků
        b2 = new StringBuffer(100);
        //inicializuje řetězec o kapacitě 20 znaků - 4 pro Ahoj a 16 jako rezervu
        b3 = new StringBuffer("Ahoj");

        //Kapacitu řetězce je možné změnit 2 metodami
        // 1. ensureCapacity(int k) - pro k větší, než je současná kapacita zajistí, že řetězec bude mít
        //buď kapacitu o velikosti k, nebo dvojnásobek současné kapacity + 2 znaky navíc. Záleží na tom,
        //co z toho je větší.
        //2. setLength(int k) - pro k větší, než současná kapacita zvětší aktuální délku řetězce na k a
        //kapacitu na dvojnásobek současné kapacity + 2 znaky.
        //                    - pro k menší, nebo rovno současné kapacitě bude kapacita nezměněna a aktuální
        //                    délka se nastaví na k

        System.out.format("b1 délka:%d, kapacita:%d%n", b1.length(), b1.capacity()); //0 16
        System.out.format("b2 délka:%d, kapacita:%d%n", b2.length(), b2.capacity()); //0 100
        System.out.format("b3 délka:%d, kapacita:%d%n", b3.length(), b3.capacity()); //4 20
        b1.setLength(18);
        b2.ensureCapacity(110);
        b3.setLength(3);
        System.out.format("b1 délka:%d, kapacita:%d%n", b1.length(), b1.capacity());//18 34
        System.out.format("b2 délka:%d, kapacita:%d%n", b2.length(), b2.capacity());//0 202
        System.out.format("b3 délka:%d, kapacita:%d%n", b3.length(), b3.capacity());//3 20
        //Změny celého řetězce
        StringBuffer b = new StringBuffer("Ahoj");
        System.out.println(b);
        b.reverse();
        System.out.println(b);
        //Změny části řetězce
        b = new StringBuffer("Ahoj ");
        b.append("lidi");
        System.out.println(b);
        b.append(8);
        System.out.println(b);//Ahoj lidi8
        //vyříznutí části řetězce - poč index, konc. index - nepatří tam
        b.delete(5,9);//Ahoj 8
        System.out.println(b);
        //Mazání jednotlivých znaků
        b.deleteCharAt(0);//hoj 8
        System.out.println(b);
        //Vkládání čehokoliv do řetězce (nejen Stringů)
        b.insert(0, 3.14);//3.14hoj 8
        System.out.println(b);
        b.insert(1, "HOJ");//3HOJ.14hoj 8
        System.out.println(b);
        //Nahrazení jednoho podřetězce jiným
        //b.
    }
}
