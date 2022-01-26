package cz.spsmb.b3i.w21.cviceni;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class VypisVnorenehoAdresare {
    public static File[] vypisAdresar(File addr){
        File[] seznam = addr.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (new File(dir, name)).isDirectory();
            }
        });
        return seznam;
    }
    public static void main(String[] args) {
        File[] seznam = vypisAdresar(new File("c:\\"));
        //File[] seznam = vypisAdresar(new File("/"));
        for (int i = 0; i < seznam.length; i++) {
            System.out.println(seznam[i].getName() + " " + Arrays.toString(vypisAdresar(seznam[i])));
        }
    }
}