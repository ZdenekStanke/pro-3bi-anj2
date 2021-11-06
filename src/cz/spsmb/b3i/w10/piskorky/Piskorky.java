package cz.spsmb.b3i.w10.piskorky;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class Piskorky implements ActionListener {
    private final String VERSION = "1.0";
    private final String TITULEK = "Piškorky" + this.VERSION;
    private int rozmerHraciPlochy;
    //jména a ikony hráčů
    private enum Hraci {FRANTA, LOJZA};
    //aktivni Hráč se zde automaticky inicializuje na 0 (LOJZA), netřeba inicializovat
    private byte aktivniHrac;
    private Icon[] ikonyHracu;

    private JPanel panelHlavni;
    private JPanel panelKdoHraje;
    private JPanel panelHraciPlocha;

    private JLabel labelKdoTahne;
    private JLabel labelKdoTahne2;
    private JButton[][] herniPlochaTlacitek;

    private byte[][] herniPlochaHracu;

    private JFrame ramecekHlavni;

    //private BorderLayout bl = new BorderLayout(1,1);

    //Hlavní konstruktor třídy Piškorky
    public Piskorky(int rozmerHraciPlochy){
        this.rozmerHraciPlochy = rozmerHraciPlochy;
        this.ikonyHracu = new Icon[Hraci.values().length];
        this.panelKdoHraje = new JPanel(new FlowLayout());
        this.panelHraciPlocha = new JPanel(new GridLayout(
                this.rozmerHraciPlochy+1, this.rozmerHraciPlochy+1));
        this.labelKdoTahne = new JLabel("Na tahu je ");
        this.labelKdoTahne2 = new JLabel(Hraci.values()[this.aktivniHrac].toString() );
        this.herniPlochaTlacitek = new JButton[this.rozmerHraciPlochy+1][this.rozmerHraciPlochy+1];
        //pole se zápornou hodnotou budou ta nevyužitá
        this.herniPlochaHracu = new byte[this.rozmerHraciPlochy+1][this.rozmerHraciPlochy+1];
        for (int i = 0; i < this.herniPlochaHracu.length ; i++) {
            Arrays.fill(this.herniPlochaHracu[i], (byte) -1);
        }

        this.inicializaceGUI();
    }
    private void inicializaceGUI(){
        //Vytvoření hlavního okna (rámečku)
        this.ramecekHlavni = new JFrame();
        //zjištění rozlišení monitoru
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        //použití rozlišení pro nastavení velikosti a polohy hlavního okna.
        this.ramecekHlavni.setSize(new Dimension(size.width/2, size.height/2+50));
        this.ramecekHlavni.setLocation(size.width/4, size.height/4);
        //nastavení viditelnosti hlavního okna
        this.ramecekHlavni.setVisible(true);
        //funkční křížek pro ukončení aplikace
        this.ramecekHlavni.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.ramecekHlavni.setTitle(this.TITULEK);
        this.ramecekHlavni.setLayout(new BorderLayout(1,1));
        this.ramecekHlavni.add(this.panelKdoHraje, BorderLayout.NORTH);
        this.ramecekHlavni.add(this.panelHraciPlocha, BorderLayout.CENTER);
        this.panelKdoHraje.add(this.labelKdoTahne, null);
        this.labelKdoTahne.setFont(new java.awt.Font("Dialog", Font.PLAIN, 20));
        this.panelKdoHraje.add(this.labelKdoTahne2, null);
        this.panelKdoHraje.setBackground(new Color(200, 200, 200));
        this.hraciTlacitka();
    }
    private void hraciTlacitka(){
        Color barvaOkraje = new Color(0xA0, 0xA0, 0xA0);
        for (int i = 0; i < this.rozmerHraciPlochy + 1; i++) {
            for (int j = 0; j < this.rozmerHraciPlochy +1 ; j++) {
                JButton b = new JButton();
                this.herniPlochaTlacitek[i][j] = b;
                this.panelHraciPlocha.add(b, null);
                //Aktivní budou tlačítka, která nejsou na okraji
                if(i != 0 && j != 0){
                    //tlačítku přidáme posluchače událostí. Pokud posluchač zachytí nějakou akci,
                    //dojde k vyvolání metody tlacitkoStisknuto s parametrem e, kde je uloženo, co to bylo
                    //za událost a jaká kompanenta jí vyvolala.
                    b.addActionListener(this);
                }
            }
        }
        for (int i = 1; i < this.rozmerHraciPlochy + 1 ; i++) {
            this.herniPlochaTlacitek[i][0].setBackground(barvaOkraje);
            this.herniPlochaTlacitek[i][0].setText(""+i);
            this.herniPlochaTlacitek[0][i].setBackground(barvaOkraje);
            this.herniPlochaTlacitek[0][i].setText(""+(char)('A'+i-1));
        }
    }
    //Metoda nutná pro implementaci rozhraní ActionListener
    // nutné pro obsluhu události stisku tlačítka
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tlacitkoStisknuto(e);
    }
    public void tlacitkoStisknuto(ActionEvent e){
        //aktuální souřadnice tlačítka
        int i=0, j=0;
        JButton stisknuteTlacitko = ((JButton)e.getSource());
        stisknuteTlacitko.setText(Hraci.values()[this.aktivniHrac].toString().substring(0,1));
        //nalezení souřadnic tlačítka a nastavení hráče do pole hráčů;
        label01:
        for ( i = 0; i < this.rozmerHraciPlochy + 1; i++) {
            for ( j = 0; j < this.rozmerHraciPlochy + 1; j++) {
                if(this.herniPlochaTlacitek[i][j] == stisknuteTlacitko){
                    this.herniPlochaHracu[i][j] = this.aktivniHrac;
                    break label01;
                }
            }
        }
        //přepnutí hráče
        if(++this.aktivniHrac >= Hraci.values().length){
            this.aktivniHrac = 0;
        }
        //aktualizace panelu kdo táhne
        this.labelKdoTahne2.setText(Hraci.values()[this.aktivniHrac].toString());
        System.out.println();
        for (int k = 0; k < this.herniPlochaHracu.length; k++) {
            System.out.println(Arrays.toString(this.herniPlochaHracu[k]));
        }
        int N = 3;
        System.out.format("verticalWin:%b, horizontalWin:%b, diagonalwin:%b, isReverseDiagonalWin:%b%n",
                this.isVerticalWin(i, j, N),
                this.isHorizontalWin(i, j, N),
                this.isDiagonalWin(i, j, N),
                this.isReverseDiagonalWin(i, j, N));
        /*
        for (int k = 0; k < j; k++) {
            if(this.isHorizontalWin(i,k,2)){
                System.out.println("OK");
            }
        }*/
        stisknuteTlacitko.removeActionListener(this);
    }
    private boolean isVerticalWin(int radek, int sloupec, int n){
        int aktualniHrac = this.herniPlochaHracu[radek][sloupec];
        if(aktualniHrac < 0){
            return false;
        }
        for (int i = radek; i < radek+n; i++) {
            if (this.rozmerHraciPlochy < i) {
                return false;
            }
            if (aktualniHrac != this.herniPlochaHracu[i][sloupec]) {
                return false;
            }
        }
        return true;
    }
    private boolean isHorizontalWin(int radek, int sloupec, int n){
        int aktualniHrac = this.herniPlochaHracu[radek][sloupec];
        if(aktualniHrac < 0){
            return false;
        }
        for (int j = sloupec; j < sloupec+n; j++) {
            if (this.rozmerHraciPlochy < j) {
                return false;
            }
            if (aktualniHrac != this.herniPlochaHracu[radek][j]) {
                return false;
            }
        }
        return true;
    }
    private boolean isDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = this.herniPlochaHracu[radek][sloupec];
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i > radek - n; i--, j++) {
            if (i <= 0) {
                return false;
            }
            if (j > this.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != this.herniPlochaHracu[i][j]) {
                return false;
            }
        }
        return true;
    }
    private boolean isReverseDiagonalWin(int radek, int sloupec, int n) {
        int aktualniHrac = this.herniPlochaHracu[radek][sloupec];
        if (aktualniHrac < 0) {
            return false;
        }
        int j = sloupec;
        for (int i = radek; i < radek + n; i++, j++) {
            if (i > this.rozmerHraciPlochy) {
                return false;
            }
            if (j > this.rozmerHraciPlochy) {
                return false;
            }
            if (aktualniHrac != this.herniPlochaHracu[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Piskorky p = new Piskorky(7);
    }
}