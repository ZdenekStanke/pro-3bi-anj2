package cz.spsmb.b3i.w05;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays_ {
    public class Main {
        //Proměnné v Javě jsou 2 typů: primitivní datové typy a referenční proměnné
        //Pole je referenční proměnná, obsahuje tzv. "odkaz" do paměti, který je programátorovi va Javě
        //důmyslně ukryt
        //Hodnota neplatného odkazu má konstantu null
        //Pole vznikají dynamicky (operátor new), zanikají, jakmile na ně neexistuje žádný odkaz

        public static void main(String[] args) {
            //deklarace pole. Java zaručuje, že pole se inicializuje vždy na nulové hodnoty, resp. false
            int[] poleInt;
            poleInt = new int[20];//alokování 20 intů v paměti
            //délka pole:
            System.out.format("Délka pole poleInt=%d%n",poleInt.length);
            poleInt[1]=12;
            poleInt[poleInt[1]]++;
            Scanner sc = new Scanner(System.in);
            //poleInt[sc.nextInt()]=44;
            //výpis pole iterací
            for (int i = 0; i <poleInt.length ; i++) {
                System.out.format("%d ",poleInt[i]);
            }
            System.out.println();
            //výpis pole pomocí třídy Arrays (od JDK1.5)
            System.out.println(Arrays.toString(poleInt));
            //inicializované pole:
            int[] prvocisla={1,2,3,5,7,11};
            //porovnání dvou polí:
            System.out.println(Arrays.equals(poleInt, poleInt));
            //naplění celého, nebo části pole konstatntní hodnotou:
            Arrays.fill(poleInt,99);
            int[] poleInt2=new int[20];
            Arrays.fill(poleInt2,10,15,11);
            System.out.println(Arrays.toString(poleInt));
            System.out.println(Arrays.toString(poleInt2));
            //Seřazení pole
            for (int i = 0; i <poleInt.length ; i++) {
                poleInt[i]=poleInt.length-i;
            }
            System.out.println(Arrays.toString(poleInt));
            Arrays.sort(poleInt);
            System.out.println(Arrays.toString(poleInt));
            //nalezení indexu v seřeazeném poli. Vrací zápornou hodnotu, pokud prvek nenalezne
            System.out.println(Arrays.binarySearch(poleInt,3));
            //průchod všemi prvky pole pomocí modifikovaného for "for-each"
        /*for(int hodnota:prvocisla){
            System.out.print(hodnota+", ");
            //hodnota+=1;//nebude to fungovat, hodnota je lokální proměnná a do pole se nijak nevrací
        }*/
            //Dvourozměrná pole
        /*int[][] a = new int[5][4];
        System.out.format("Pocet radek pole :%d%n", a.length);
        System.out.format("Pocet sloupcu pole :%d%n", a[0].length);
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a[0].length ; j++) {
                a[i][j]=i*10+j;
                System.out.format("%2d ",a[i][j]);
            }
            System.out.println();
        }*/
            //Dvourozměrné pole s proměnnou délkou řádek:
            int[][] a = new int[4][];
            for (int i = 0; i < a.length; i++) {
                a[i] = new int[i+1];
                for (int j = 0; j < a[i].length; j++) {
                    a[i][j]=i+10*j;
                    System.out.format("%2d ",a[i][j]);
                }
                System.out.println();
            }
            // Inicializace dvourozměrného pole
            int[][] b = {{1,2,3},{11,12,13}, {21,22,23}}; //obdelníkové pole
            int[][] b1 = {{1,2,3},{11,12}, {21}}; //pole s proměnnou délkou řádek
            //Více rozměrů v jednorozměrném poli - vhodné, pokud je potřeba spojitý úsek paměti
            final int N_RADKU = 24;
            final int N_SLOUPCU = 80;
            int[] obrazovka = new int[N_RADKU*N_SLOUPCU];
            for (int i = 0; i < N_RADKU; i++) {
                for (int j = 0; j < N_SLOUPCU; j++) {
                    obrazovka[i*N_SLOUPCU+j] = 100*i+j;
                    System.out.format("%4d ",obrazovka[i*N_SLOUPCU+j]);
                }
                System.out.println();
            }
        }
    }
}
