package cz.spsmb.b3i.w03;

public class ForEach {

    public static void main(String[] args) {
        int[] arrInt = {1, 2, 3, 5, 7};
        int sum = 0;
        for (int number: arrInt) {
            System.out.println(number);
            sum += number;
        }
        System.out.println(sum);
    }
}
