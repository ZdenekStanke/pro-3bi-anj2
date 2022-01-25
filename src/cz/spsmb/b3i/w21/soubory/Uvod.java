package cz.spsmb.b3i.w21.soubory;
// Pro práci se soubory slouží třída File. Jedná se pouze o jakýsi
// manažer souborů.
// Základní statické proměnné:
// File.separatorChar - oddělovač adresářů (ve win \)
// File.separator  - totéž, ale String
// File.pathSeparatorChar - oddělovač cest (ve win ;)
// File.pathSeparator - totéž, ale String
// ke zjištění aktuálního adresáře lze použít volání
// System.getProperty("user.dir")

import java.io.File;

public class Uvod {
    public static void main(String[] args) {
        String aktDir = System.getProperty("user.dir");
        File soubAbs = new File(aktDir, "a.txt");
        File soubRel = new File("TMP" + File.separator + "a.txt");
        System.out.println(soubRel.getAbsolutePath());
        System.out.println(soubRel.getName());
        System.out.println(soubRel.getParent());

        System.out.println(soubAbs.getAbsolutePath());
        System.out.println(soubAbs.getName());
        System.out.println(soubAbs.getParent());
    }
}
