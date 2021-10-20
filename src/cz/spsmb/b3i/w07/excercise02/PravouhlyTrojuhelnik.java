package cz.spsmb.b3i.w07.excercise02;

//vytvořte třídu PravouhlyTrojuhelnik, kdy se jako parametry konstruktoru budou
//zadávat pouze odvěsny a přepona se dopočítá. Třída bude poskytovat metodu
//double delkaPrepony()

//Přetěžte konstruktor PravouhlyTrojuhelnik, který vytvoří rovnoramenný trojúhelník
//s odvěsnami délky 1. Třída bude poskytovat metodu double obsah()
public class PravouhlyTrojuhelnik {
    private double stranaA;
    private double stranaB;
    private double stranaC;

    public PravouhlyTrojuhelnik(double stranaA, double stranaB) {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        //není důvod používat setter v konstruktoru, lepší this.stranaC = delkaPrepony()
        //setStranaC(delkaPrepony());
        this.stranaC = this.delkaPrepony();
    }


    public PravouhlyTrojuhelnik() {
        this(1,1);
        //tohle je zbytečná duplikace kódu. Lepší zavolat předchozí konstruktor pomocí this(1,1);
        //setStranaC(Math.sqrt(this.stranaA * this.stranaA) + ((this.stranaB) * (this.stranaB)));
    }

    //není důvod tu mít tuto metodu
    public void setStranaC(double stranaC) {
        this.stranaC = stranaC;
    }


    public double delkaPrepony() {
        return Math.sqrt((this.stranaA * this.stranaA) + (this.stranaB * this.stranaB));
    }
    public double obsah() {
        return this.stranaA*this.stranaB/2;
    }
    /*
    //jaký je rozdíl mezi těmito metodami? Proč jsou dvě? Třída se jmenuje Pravouhly Trojuhelnik,
    //tudíž počítám obsah = this.stranaA*this.stranaB/2
    public double obsah() {
        double pom = (stranaC / 2);
        return ((stranaC * pom) / 2);
    }

    public double obsahPravouhleho() {
       double pom = ((stranaC / 4));
        return ((stranaC * pom) / 2);
    }
     */


}



