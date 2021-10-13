package cz.spsmb.b3i.w03;

public class StdInput {
    public class Main {

        public static void main(String[] args) {
            int ai=1, bi=2, ci=3;
            char a='a', b='b', c='c';
        /*
        Scanner sc = new Scanner(System.in);
        switch (sc.nextLine().charAt(0)){
            case 'a':
            case 'b':
            case 'c': System.out.print("1");
                    break;
            case 'd': System.out.print("2");
                    break;
            default: System.out.print("3");
                    break; //zbytečný, ale píše se
        }
        /*
        for(int i=1; i<=100; i++){
            //System.out.format("%d%c",i, (i%10==0 ? '\n': ' ' ));
            System.out.print(i+(i%10==0 ? "\n": " " ));
        }
*/
            //if(!(c=='a' || c=='b' || c=='c')){ //nevhodné (negace)
            if(c!='a' && c!='b' && c!='c'){ //OK (aserce)
                System.out.println("c neni a, b, ani c");
                if (c != 'd')
                    System.out.println("c neni d");
            } else {
                System.out.println("c je bud a, b, nebo c");
            }
            if(c!='a' && c!='b' && c!='c') //OK (aserce)
                System.out.println("c neni a, b, ani c");
            if (c != 'd')
                System.out.println("c neni d");
            else
                System.out.println("c je bud a, b, nebo c");

        }
    }
}
