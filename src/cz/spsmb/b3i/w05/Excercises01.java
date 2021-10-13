package cz.spsmb.b3i.w05;

import java.util.Arrays;
import java.util.Scanner;

public class Excercises01 {
    public class Main {
        //Napište program, který metodou Eratosthenova síta vypíše všechna
        // prvočísla od 1 do N, kdy N zadáme z klávesnice
        private static void eratosthenovoSito(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadej N");
            //int n = sc.nextInt();
            int n = Integer.MAX_VALUE/2;
            boolean[] eSito = new boolean[n];
            Arrays.fill(eSito,2,n-1,true);
            for (int i = 0; i < eSito.length; i++) {
                if(eSito[i]){
                    System.out.format("%d ",i);
                    for (int j = i*i; j < eSito.length ; j+=i) {
                        eSito[j]=false;
                    }
                }

            }

        }
        public static void main(String[] args) {
            eratosthenovoSito();

        }
    }
}
