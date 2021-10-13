package cz.spsmb.b3i.w06.Rectangle;
/***
 * Objekt - datový prvek, který je vytvořen dle vzoru třídy => objekt = instance třídy

 */
//Deklarace třídy Obdelník. Názvy tříd píšeme v Javě s velkým prvním písmenem kvůli kompatibilitě
//Zde použit implicitní konstruktor Obdelnik()
//Implicitní konstruktor se použije, pokud žádný
//nenapíšeme. Pokud napíšeme, implicitní se
    //nevytvoří.

//  JDK  API
    /*
public class Obdelnik {
    public int sirka;
    public int vyska;

    public int obvod(){
        int pom;
        pom = 2*(this.sirka+this.vyska);
        return pom;
    }
    public int obsah(){
        return this.vyska*this.sirka;
    }
*/

// Deklarace třídy s konstruktorem
    /*
public class Obdelnik {
    private int sirka;
    private int vyska;
    //Konstruktor - jmenuje se stejně jako třída,
    // nemá návratovou hodnotu, tj.
    //nesmí se uvádět typ void ani používat return
    public Obdelnik(int vyska, int sirka){
        //this se uvádět nemusí, pokud se ale neuvede,
        //vystavujeme se nebezpečí nechtěné záměně
        //proměnných
        this.vyska=vyska;
        this.sirka=sirka;
    }
    public int getSirka() {
        return this.sirka;
    }
    public int getVyska() {
        return this.vyska;
    }
    public void setVyska(int vyska) {
        this.vyska = vyska;
    }
    public void setSirka(int sirka) {
        if(sirka>0) {
            this.sirka = sirka;
        }
    }

    public int obvod(){
        int pom;
        pom = 2*(this.sirka+this.vyska);
        return pom;
    }
    public int obsah(){
        return this.vyska*this.sirka;
    }
}*/
//Třída s přetíženými konstruktory + volání již
//definovaného konstruktoru v přetěžovaném
//konstruktoru
public class Obdelnik {
    public int sirka;
    public int vyska;
    public Obdelnik(int vyska, int sirka){
        this.vyska=vyska;
        this.sirka=sirka;
    }
    public Obdelnik(){
        //volání původního konstruktoru z téže
        // třídy pomocí this(). Musí být na prvním
        // místě
        this(9,9);
    }
    public Obdelnik(int vyska){
        this(vyska,9);
    }
    public int getSirka() {
        return this.sirka;
    }
    public int getVyska() {
        return this.vyska;
    }
    public int obvod() {
        int pom;
        pom = 2 * (this.sirka + this.vyska);
        return pom;
    }

    public int obsah() {
        return this.vyska * this.sirka;
    }
}