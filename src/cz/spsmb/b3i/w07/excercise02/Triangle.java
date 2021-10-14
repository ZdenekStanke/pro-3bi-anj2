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
        if(!isTriangle()){
            this.stranaA=0;
            this.stranaB=0;
            this.stranaC=0;
        }
    }
    //Přetěžte konstruktor Triangle(int jednaStrana), který bude vytvářet rovnostranné trojúhelníky
    public Triangle(int jednaStrana){
        /*jedna možnost
        this.stranaA=jednaStrana;
        this.stranaB=jednaStrana;
        this.stranaC=jednaStrana;
        */
        //druhá, efektivnější možnost - volám předchozí konstruktor pomocí this()
        this(jednaStrana, jednaStrana, jednaStrana);
    }
    private boolean isTriangle(){
        return this.stranaA+this.stranaB > this.stranaC &&
            this.stranaB+this.stranaC > this.stranaA &&
            this.stranaC+this.stranaA > this.stranaB;
    }
    public int getStranaA() {
        return this.stranaA;
    }
    public double obvod(){
        return this.stranaA+this.stranaB+this.stranaC;//impicitni konverze na double
    }
    public boolean jePravouhly(){
        //plati Pythagorova veta
        return (this.stranaA*this.stranaA+this.stranaB*this.stranaB) == this.stranaC*this.stranaC;
    }

}
