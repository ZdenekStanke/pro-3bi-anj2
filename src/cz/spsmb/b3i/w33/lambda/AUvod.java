package cz.spsmb.b3i.w33.lambda;

// Anonymní třídy vyžadují zbytečně mnoho "syntaktické vaty", která znepřehledňuje výsledný kód.
// Java 8 přišla s konceptem lambda výrazů, které většinu této "vaty" eliminují. Navíc i samotná
// implementace lambda výrazů, resp. jejich použití často vede na efektivnější kód.

// Lambda výrazy nahrazují anonymní třídy implementující funkční rozhraní, tj. rozhraní
// deklarující právě jednu abstraktní metodu. Lambda výrazy se pak vydávají za instance
// tohoto rozhraní a jimi reprezentovaný kód se spustí tak, že se příslušná metoda zavolá.

// Funkční  rozhraní mají deklarovánu právě jednu abstraktní metodu. Počet implicitních a
// statických metod u nich není omezen. Pokud chceme mít jistotu, že jde opravdu o funční
// rozhraní, anotujeme jo pomocí @FunctionalInterface.

// V knihovně java.util.function je definováno 43 obecných rozhraní. Jsou rozděleny do následujících
// skupin:
// Konzumenti (Consumers) - zpracují parametry a nic nevrátí:

// Jednoparametričtí:
// Consumer<T>                      void accepd(T       value)
// DoubleConsumer                   void accept(double  value)
// IntConsumer                      void accept(int     value)
// LongConsumer                     void accept(long    value)

// Dvouparametričtí:
// BiConsumer<T>                    void accept(T t, U      value)
// ObjDoubleConsumer                void accept(T t, double value)
// ObjIntConsumer                   void accept(T t, int    value)
// ObjLongConsumer                  void accept(T t, long   value)

// Producenti (Suppliers) - nepotřebují žádné argumenty, naopak vrátí hodnotu zadaného typu
// Supplier<T>              T       get()
// BooleanSupplier          boolean getAsBoolean()
// DoubleSupplier           double  getAsDouble()
// IntSupplier              int     getAsInt()
// LongSupplier             long    getAsLong()

// Funkce (Functions) - zpracují argument a vrátí hodnotu:
// Jednoparametrické vracející Objekt
// Function             <T, R>      R apply(T       value)
// DoubleFunction       <   R>      R apply(double  value)
// IntFunction          <   R>      R apply(int     value)
// LongFunction         <   R>      R apply(long    value)

// Jednparametrické vracející hodnotu primitivního typu
// ToIntFunction        <T>         int     applyAsInt   (T      value)
// ToDoubleFunction     <T>         double  applyAsDouble(T      value)
// ToLongFunction       <T>         long    applyAsLong  (T      value)
// DoubleToInt                      int     applyAsInt   (double value)
// DoubleToLong                     long    applyAsLong  (double value)
// IntToDoubleFunction              double  applyAsDouble(int    value)
// IntToLongFunction                long    applyAsLong  (int    value)
// LongToDoubleFunction             double  applyAsDouble(long   value)
// LongToIntFunction                int     applyAsDouble(long   value)

// Dvouparametrické
// BiFunction           <T, U, R>   R       apply         (T t, U u)
// ToDoubleBiFunction   <T, U>      double  applyAsDouble (T t, U u)
// ToIntBiFunction      <T, U>      int     applyAsInt    (T t, U u)
// ToLongBiFunction     <T, U>      long    applyAsLong   (T t, U u)

// Unární operátory (UnaryOperators) - definovány pomocí funkcí, jejichž návratová hodnota je stejného
// typu, jako parametr.
// UnaryOperator<T>     T       apply        (T      value)
// DoubleUnaryOperator  double  applyAsDouble(double value)
// IntUnaryOperator     int     applyAsInt   (double value)
// LongUnaryOperator    long    applyAsLong  (double value)

// Binární operátory (BinaryOperators) - definovány pomocí dvouparametrických funkcí, kde typy parametrů
// i návratový typ jsou shodné.
// BinaryOperator<T>     T       apply        (T      left, T      right)
// DoubleBinaryOperator  double  applyAsDouble(double left, double right)
// IntBinaryOperator     int     applyAsInt   (int    left, int    right)
// LongBinaryOperator    long    applyAsLong  (long   left, long   right)

// Predikáty (Predicates) - sloužé k získání logické hodnoty odvozené z hodnoty jejich arhumentu
// Predicate<T>           boolean test(T      value)
// DoublePredicate        boolean test(double value)
// IntPredicate           boolean test(int    value)
// LongPredicate          boolean test(long   value)
// BiPredicate<T, U>      boolean test(T t ,U u)

// Důležitá funkční rozhraní:
// Balíček java.awt.event:
// ActionListener               void actionPerformed(ActionEvent e)

// Balíček java.io:
// Closeable                    void close()
// FileFilter                   boolean accept(File pathname)
// FilenameFilter               boolean accept(File dir, String name)
// Flushable                    void flush()

// Balíček java.lang
// AutoCloseable                void close()
// Comparable<T>                int compareTo(T o)
// Iterable<T>                  Iterator<T> iterator()
// Runnable                     void run()

// Balíček java.util
// Comparator<T>                boolean equals(T o)
// Observer                     void update(Observable o, Object arg)

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.*;

// Překladač definuje  lambda výraz jako instanci funkčního rozhraní,
// jehož metoda má odpovídající parametry a vrací hodnotu odpovídajícího typu. Obecný zápis
// -------------------------------------------
// ( parametry ) -> { příkazy }
// -------------------------------------------
// Ve většině případů, kdy si umí překladač domyslet typ parametru se typy uvádět nemusí, pokud je
// navíc parametr než jede, první závorky psát nemusíme:
// parametr -> { příkazy }
// Tvoří-li tělo pouze jeden příkaz, lze vynechat složené závorky:
// ( parametry ) -> příkaz
// Nejjednodušší podoba tedy je:
// parametr -> výraz
public class AUvod {
    public static void main(String[] args) {
        //Použití binárního operátoru
        IntBinaryOperator ibo;
        int result;
        ibo = (a, b) -> a + b;
        result = ibo.applyAsInt(5,6);
        System.out.println(result);
        ibo = (a, b) -> a - b;
        result = ibo.applyAsInt(5,6);
        System.out.println(result);
        //iterace seznamu pomocí třídy Consumer
        ArrayList<String> als = new ArrayList<>();
        als.add("ahoj"); als.add("cau"); als.add("nazdar");
        als.forEach(s -> System.out.println(s));
        //Supplier pro získání aktuálního času
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        System.out.println(s.get());
        //Funkce pro vrácení stringu s velkými písmeny
        Function<String, String> capitalize = val -> val.toUpperCase();
        System.out.println(capitalize.apply("sji"));
        //Použití unárního operátoru
        UnaryOperator<Integer> xor = a -> a ^ 1;
        System.out.println(xor.apply(2));
        //Použití predikátoru
        Predicate<Integer> pr = a -> (a > 18);
        System.out.println(pr.test(18));
    }
}
