package cz.spsmb.b3i.w03;

import java.util.Scanner;

public class Loops {
    public class Main {
        public static void main(String[] args) {
            int x=0;
            char c;
            Scanner sc = new Scanner(System.in);
            navesti:
            for(int n =0; n<4; n++){
                for(int m=0; m<2; m++){
                    if(n == 2 && m==0){
                        continue navesti;
                    }
                    System.out.print(n+"-"+m+" ");
                }
            }
            System.out.println("Zacatek");
            odskok:
            {
                for (int i=1; i<10; i++){
                    if(i==5){
                        //break;
                        break odskok;
                    }
                    System.out.print(i+" ");
                }
                System.out.println("Stred");
            }
            System.out.println("Konec");
    /*
    int sum = 0;

    for(int i = 1; i<=10; i++){
        sum += i;
        System.out.println(i);
    }
    System.out.format("suma: %d%n", sum);

    for(;;){
        System.out.println(i);
    }
    int i = 1;
    while(i<=10){
        System.out.println(i);
        i++;
    }*/
    /*while((c=sc.nextLine().charAt(0))!='z') {
        if(c>='a'){
            System.out.println(c);
        }
    }*/
        /*
    while(true){
        if( (c=sc.nextLine().charAt(0)) == 'z'){
            break;
        }
        if(c < 'a') {
            continue;
        }
        System.out.println(c);
    }

    int i=10;
    do {
        i--;
        System.out.println(i);
    } while(i>0);
    do {
        if((c=sc.nextLine().charAt(0)) >= 'a'){
            System.out.println(c);
        }
    } while(c != 'z');
    */
    /*
    while (x<10) {
        x++;
    }
    System.out.println(x);*/
        }
    }
}
