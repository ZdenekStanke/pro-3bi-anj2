package cz.spsmb.b3i.w12.dedicnost.finalni_tridy;

final class Rodic {
    public int i;
    public Rodic(){
        i=i;
    }
    //abstract int getI();//nelze dávat abstraktní metodu do finální třídy
    void setI(int noveI) {i = noveI;}

}
//nelze dědit z finální třídy:
//public class Potomek extends Rodic{
//}
