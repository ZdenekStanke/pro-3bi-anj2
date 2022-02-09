package cz.spsmb.b3i.w23.soubory;
// Roury (pipes) známe z OS, např. příkazy spojené rourou
// dir|more zajistí, že výpis adresáře bude čekat po zaplnění
// obrazovky na stisk klávesy. Je možné komunikaovat přes rouru
// mezi metodami, či vlákny.

import java.io.*;

// Výhodou je, že získáme ideální zařízení pro uložení dočasných dat,
// která by se jinakukládala nejčastěji do pomocného souboru a ten
// by se pos končení programu vymazal. Roura tím, že je vzniká
// v paměti je však mnohem rychlejší.
public class RVstupVYstupRoura {
    public static Reader vyber(Reader vstup, int index, char znak) throws IOException {
        BufferedReader bufVstup = new BufferedReader(vstup);
        //Výstup do roury
        PipedWriter rouraVystup = new PipedWriter();
        PipedReader rouraVstup = new PipedReader(rouraVystup);
        PrintWriter formRouraVystup = new PrintWriter(rouraVystup);
        String radka;
        while((radka = bufVstup.readLine()) != null) {
            if(index < radka.length() && radka.charAt(index) == znak){
                formRouraVystup.println(radka);
            }
        }
        formRouraVystup.close();
        return rouraVstup;
    }

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("data120.txt");
        Reader jednaDevet = vyber(vyber(fr, 0, '1'), 2,'9');
        fr.close();
        String radka;
        BufferedReader br = new BufferedReader(jednaDevet);
        while((radka = br.readLine()) != null) {
            System.out.println(radka);
        }
        br.close();
    }
}
