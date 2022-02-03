package cz.spsmb.b3i.w22.soubory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HFormatovaniVystupu {
    public static void main(String[] args) throws IOException {
        FileWriter fwForm = new FileWriter("form.txt");
        PrintWriter form = new PrintWriter(fwForm);
        FileWriter fwNeForm = new FileWriter("neform.txt");
        for (int i = 65; i < 75; i++) {
            System.out.println(i + " ");
            form.print(i + " ");// resp. form.format("%d ", i);
            fwNeForm.write(i);
        }
        form.close();
        fwNeForm.close();
    }
}
