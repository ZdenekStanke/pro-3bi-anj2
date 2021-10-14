package cz.spsmb.b3i.w07.excercise02;
//Napište třídu trojúhelník, která bude poskytovat metody double
//obvod(), a boolean jePravouhly(). Členské proměnné budou celá čísla
//stranaA, stranaB, stranaC

//Modifikujte třídu trojúhelník tak, aby konstruktor ošetřil případy,
// kdy zadávané strany netvoří trojúhelník (tj. součet dvou stran je menší, než
// třetí strana). V tomto případě konstruktor nastaví všechny strany na nulu
public class Triangle {
    private int stranaA;
    private int stranaB;
    private int stranaC;
    public Triangle(int stranaA, int stranaB, int stranaC){
        this.stranaA=stranaA;
        this.stranaB=stranaB;
        this.stranaC=stranaC;
    }
    public double obvod(){
        return this.stranaA+this.stranaB+this.stranaC;//impicitni konverze na double
    }
    public boolean jePravouhly(){
        //plati Pythagorova veta
        return (this.stranaA*this.stranaA+this.stranaB*this.stranaB) == this.stranaC*this.stranaC;
    }
}
