package cz.spsmb.b3i.w07.excercise02;

//vytvořte třídu PravouhlyTrojuhelnik, kdy se jako parametry konstruktoru budou
//zadávat pouze odvěsny a přepona se dopočítá. Třída bude poskytovat metodu
//double delkaPrepony()

//Přetěžte konstruktor PravouhlyTrojuhelnik, který vytvoří rovnoramenný trojúhelník
//s odvěsnami délky1. Třída bude poskytovat metodu double obsah()
public class PravouhlyTrojuhelnik {
    private double stranaA;
    private double stranaB;

    public PravouhlyTrojuhelnik(double odvesnaA, double odvesnaB) {
        this.stranaA = odvesnaA;
        this.stranaB = odvesnaB;
    }
    public double delkaPrepony() {
        return Math.sqrt((stranaA * stranaA) + (stranaB * stranaB));
    }

    public PravouhlyTrojuhelnik(double odvesnaA) {
        this(odvesnaA,odvesnaA);
    }
    public double obsah() {
        return (stranaA * stranaA)/2;
    }

}



