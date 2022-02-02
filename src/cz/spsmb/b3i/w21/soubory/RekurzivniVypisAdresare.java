package cz.spsmb.b3i.w21.soubory;

import java.io.File;
import java.io.FilenameFilter;

public class RekurzivniVypisAdresare {
    static int depth = 0;
    public static File[] vypisAdresar(File addr){
        File[] seznam = addr.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File f =new File(dir, name);
                return f.isDirectory() && f.canRead() && f.exists() && ! f.isHidden();
            }
        });
        return seznam;
    }
    public static void rekVypis(File f){
        depth++;
        File[] af = vypisAdresar(f);
        if(af.length == 0){
            for (int i = depth; i >= 0 ; i--) {
                System.out.print("  ");
            }
            System.out.println(f.getName());
        } else {
            for (File ff : af) {
                if(ff.isDirectory())
                    rekVypis(ff);
            }
        }
        depth--;
    }
    public static void main(String[] args) {
        rekVypis(new File("C:\\Program Files\\dotnet"));
    }
}
