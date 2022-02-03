package cz.spsmb.b3i.w22.soubory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
//Možnost  nadbytečně přečtený znak vrátit zpět do vstupního proudu
public class IVraceniPrectenehoZnaku {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("a.txt");
        PushbackReader in = new PushbackReader(fr);
        int c;

        c = in.read();
        System.out.print((char) c);
        //vrácení znaku
        in.unread(c);
        c = in.read();
        System.out.print((char) c);
    }
}
