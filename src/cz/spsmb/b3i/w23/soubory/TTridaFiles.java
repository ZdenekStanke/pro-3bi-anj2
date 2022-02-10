package cz.spsmb.b3i.w23.soubory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

// Mnohé pro práci se soubory nabízí také třída Files se spoustou
// statických metod. Jako vstup pro informaci o cestě k souboru
// slouží instance třídy Path.
public class TTridaFiles {
    public static void main(String[] args) throws IOException {
        //deklarace cesty
        Path cesta = Paths.get("a.txt");

        List<String> al = Files.readAllLines(cesta);
        for (String line: al) {
            System.out.println(line);
        }
        Files.writeString(cesta, "\nToto je přidaný řádek", StandardOpenOption.APPEND);
    }
}
