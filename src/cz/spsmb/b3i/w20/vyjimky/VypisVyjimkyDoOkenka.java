package cz.spsmb.b3i.w20.vyjimky;

import javax.swing.*;

public class VypisVyjimkyDoOkenka {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            int c = a / b;
        }
        catch(ArithmeticException e) {
            JOptionPane.showMessageDialog(
                    null, //odkaz na nadř. komponentu
                    e.getLocalizedMessage(), //vlastní zpráva
                    "Chyba při dělení",  //titulek okna
                JOptionPane.ERROR_MESSAGE  //typ okna
            );
        }
    }
}
