package cz.spsmb.b3i.w23.soubory;
// Roury (pipes) jsou paměti typu FIFO a známe z OS, např. příkazy spojené rourou
// dir|more zajistí, že výpis adresáře bude čekat po zaplnění
// obrazovky na stisk klávesy. Je možné komunikovat přes rouru
// mezi metodami, či vlákny.

import java.io.*;

// Výhodou je, že získáme ideální zařízení pro uložení dočasných dat,
// která by se jinakukládala nejčastěji do pomocného souboru a ten
// by se pos končení programu vymazal. Roura tím, že je vzniká
// v paměti je však mnohem rychlejší.

//Příklad: Čtěte soubor, který obsahuje na každé řádce jedno celé číslo. Vypište
// z něj čísla, která mají jako první znak 1. Z těchto čísel pak dalším čtením
// vyberte pouze ta, jejichž třetí znak je 9.
public class RVstupVYstupRoura {
    //Návratový typ bude roura
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
        FileWriter fw =new FileWriter("data120.txt");
        for (int i = 0; i <= 1100; i++) {
            fw.write(String.format("%d%n",i));
        }
        fw.close();
        FileReader fr = new FileReader("data120.txt");
        //1. hledám znak '1' na pozici 0
        //2. hledám znak '9' na pozici 2
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
