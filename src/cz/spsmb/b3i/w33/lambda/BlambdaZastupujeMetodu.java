package cz.spsmb.b3i.w33.lambda;

// V řadě případů těla lambda-výrazů "degenerují" na pouhá zavolání některé
// metody, např.
// expr = x -> method(x);

import cz.spsmb.b3i.w09.GregorianCalendar_;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.GregorianCalendar;
import java.util.function.Supplier;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

// V takových situacích bývá často výhodnější označit lambda-výraz za
// zástupce dané metody. Používá se k tomu operátor čtyřtečka. Existují
// 3 podoby:
// inst::mtd        - kvalifikace názvu metody názvem instance
// Cls::mtd         - kvalifikace názvu metody názvem třídy
// Cls::new         - zvláštní forma, pokud konstgruktor zabalíme do lambda
//                    výrazu, tak již nevystupuje jako konstruktor, ale
//                    jako nějaká tovární metoda, která je nám schopna dodat
//                    na požádání nějaký objekt.

public class BlambdaZastupujeMetodu {
    public static void main(String[] args) {
        ToIntFunction<String> cmpI = "Prvni"::compareTo;
        int inst = cmpI.applyAsInt("Druhý");
        ToIntBiFunction<String, String> cmpC = String::compareTo;
        int cls = cmpC.applyAsInt("První", "Druhý");
        System.out.format("inst: %d, cls: %d%n", inst, cls);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(new SimpleDateFormat("dd.MM.YYYY HH:mm:ss").format(gc.getTime()));
        //Tovární metoda gc_factory.get() pro výrobu uinstance třídy GregorianCalendar
        Supplier<GregorianCalendar> gc_factory = GregorianCalendar::new;
        System.out.println(new SimpleDateFormat("dd.MM.YYYY HH:mm:ss").format(gc_factory.get().getTime()));

    }
}
