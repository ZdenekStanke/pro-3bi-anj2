package cz.spsmb.b3i.w07.excercise02;

//vytvořte třídu PravouhlyTrojuhelnik, kdy se jako parametry konstruktoru budou
//zadávat pouze odvěsny a přepona se dopočítá. Třída bude poskytovat metodu
//double delkaPrepony()

//Přetěžte konstruktor PravouhlyTrojuhelnik, který vytvoří rovnoramenný trojúhelník
//s odvěsnami délky1. Třída bude poskytovat metodu double obsah()
public class PravouhlyTrojuhelnik {
    private double stranaA;
    private double stranaB;
    private double stranaC;

    public PravouhlyTrojuhelnik(double stranaA, double stranaB, double stranaC) {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = stranaC;
    }

    public double delkaPrepony() {
        stranaC = Math.sqrt((this.stranaA * this.stranaA) + (this.stranaB * this.stranaB));;
        return stranaC;
    }

    public PravouhlyTrojuhelnik(double stranaA) {
        this(stranaA, stranaA, stranaA);
    }


    public double obsah() {
        double vyska = Math.sqrt((stranaA*stranaA) - ((stranaA / 2) * (stranaA / 2)));
        return ((stranaA * vyska) / 2);
    }
}



