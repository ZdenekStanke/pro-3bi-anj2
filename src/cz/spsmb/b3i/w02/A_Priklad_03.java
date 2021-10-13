package cz.spsmb.b3i.w02;

import java.util.Scanner;

public class A_Priklad_03 {

    public static void main(String[] args) {
        // Napište program, který přečte reálné číslo a vypíše celou jeho část
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        System.out.format("%.0f", number);
    }
}
