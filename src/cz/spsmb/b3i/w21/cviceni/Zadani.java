package cz.spsmb.b3i.w21.cviceni;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

// 1. Napište program, který vypisuje jména všech podadresářů v zadaném rodičovském adresáři.
// 2. Modifikujte předchozí program tak, že budou vypisovány i všechny vnořené adresáře
//    z těchto podadresářů.
// 3. Napište program, kreý vypíše podle zadané masky všechny soubory, které se nacházejí v zadaném
//    rodičovském adresáři.
// 4. Modifikujte předchozí program tak, že budou vypisovány i soubory ze všech vnořených adresářů
//    z těchto podadresářů.
public class Zadani {
    public static void main(String[] args) {

        String jmenoAdr = "c:\\";
        File aktDir = new File(jmenoAdr);
        String[] seznam = aktDir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return (new File(dir, name).isDirectory());
            }
        });
        System.out.println(Arrays.toString(seznam));
    }

}
