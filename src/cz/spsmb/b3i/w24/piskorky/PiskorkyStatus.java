package cz.spsmb.b3i.w24.piskorky;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PiskorkyStatus implements Serializable {
    public final String VERSION = "1.5";
    public final int nViteznych = 4;
    int rozmerHraciPlochy;
    int nTah = 1;
    //int[][] herniPlochaHracu;
    ArrayList<String> hraci;
    Map[][] herniTlacitka;
    //aktivni Hráč se zde automaticky inicializuje na 0 (LOJZA), netřeba inicializovat
    int aktivniHrac;
    boolean isStarted;
    boolean isEnded;

    public PiskorkyStatus(int rozmerHraciPlochy) {
        this.rozmerHraciPlochy = rozmerHraciPlochy;
        //this.herniPlochaHracu = new int[this.rozmerHraciPlochy + 1][this.rozmerHraciPlochy + 1];
        //for (int i = 0; i < this.herniPlochaHracu.length; i++) {
        //    Arrays.fill(this.herniPlochaHracu[i], (byte) -1);
        // }
        this.herniTlacitka = new HashMap[this.rozmerHraciPlochy + 1][this.rozmerHraciPlochy + 1];
        this.hraci = new ArrayList<>();
        //this.hraci.add("Lojza");
        //this.hraci.add("Franta");
        //this.hraci.add("Pepa");
        this.inicializaceTlacitek();
    }

    public boolean pridatHrace(String jmeno){
        for (String hrac : this.hraci) {
            if(hrac.charAt(0) == jmeno.charAt(0)){
                return true;
            }
        }
        this.hraci.add(jmeno);
        return false;
    }



    public void inicializaceTlacitek(){
        for (int i = 0; i < this.rozmerHraciPlochy + 1; i++) {
            for (int j = 0; j < this.rozmerHraciPlochy + 1; j++) {
                HashMap om =new HashMap();
                this.herniTlacitka[i][j] = om;
                om.put("i", Integer.valueOf(i));
                om.put("j", Integer.valueOf(j));
                om.put("player", Integer.valueOf(-1));
            }
        }
    }
    public ArrayList<String> getHraci(){
        return this.hraci;
    }
}
