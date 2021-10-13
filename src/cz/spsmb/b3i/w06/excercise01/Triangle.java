package cz.spsmb.b3i.w06.excercise01;
//Napište třídu trojúhelník, která bude poskytovat metody double
//obvod(), a boolean jePravouhly(). Členské proměnné budou celá čísla
//stranaA, stranaB, stranaC
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
