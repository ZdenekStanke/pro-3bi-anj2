package cz.spsmb.b3i.w27.vlakna;

public class Vlakno2 extends  Thread {
    @Override
    public void run() {
        while(ReadVl.hotovo == false ) {
            System.out.print(ReadVl.suma + "\r");
            Thread.yield();
        }
        System.out.println(ReadVl.suma);
    }

    public static void main(String[] args) {
        ReadVl vlCteni = new ReadVl("data.txt");
        vlCteni.start();
        Vlakno2 vlVypis = new Vlakno2();
        vlVypis.start();
    }
}
