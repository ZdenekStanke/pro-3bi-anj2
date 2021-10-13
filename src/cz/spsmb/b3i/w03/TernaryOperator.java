package cz.spsmb.b3i.w03;

public class TernaryOperator {

    public static void main(String[] args) {
        for (int i = 0; i < 101; i++) {
            System.out.format("%02d%c", i, (i%10==0 ? '\n' : ' '));
        }
    }
}
