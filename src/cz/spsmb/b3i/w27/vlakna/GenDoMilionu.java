package cz.spsmb.b3i.w27.vlakna;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GenDoMilionu {
    public static void main(String[] args) throws IOException {
        int k = 10;
        Random r = new Random();
        FileWriter write = new FileWriter("data2.txt");
        PrintWriter print = new PrintWriter(write);
        for (int j = 0; j < 10000000; j++) {
            print.println(r.nextInt());
            //System.out.print(j+1 + " ");
        }
        print.close();
    }
}
