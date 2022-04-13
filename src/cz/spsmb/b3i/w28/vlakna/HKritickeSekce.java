package cz.spsmb.b3i.w28.vlakna;
// Program s více vlákny, která pracujá nad stejnými daty nás uvádí do problému, který nazýváme kritické sekce
// (critical sections). Jedná se o úseky kódu, které mohou z důvodu přístupu více vláken ke stejným datům
// ve stejný okamžik způsobit problémy. Z tohoto důvodu je nutné kritické sekce synchronizovat, jinými slovy
// zajistit místo paralelního běhu běh sériový.

// K tomuto se používá klíčové slovo synchronized. Při vstupu do synchronizované kritické sekce vlákno získá
// tzv. monitor (uzamkne data) a po jejím opuštění monitor uvolní (odemkne data). Po získání monitoru jedním
// vláknem nemůže jiné vlákno zahájit kritické sekce patřící k témuž objektu.

class Bod {
    private int[] xy = {0, 0};

    public void setBod(int x, int y) {
        this.xy[0] = x;
        this.xy[1] = y;
    }

    public int[] getXy() {
        return new int[] {xy[0], xy[1]};
    }
}
class BodSynchronized {
    private int[] xy = {0, 0};

    public synchronized void setBod(int x, int y) {
        this.xy[0] = x;
        this.xy[1] = y;
    }

    public synchronized  int[] getXy() {
        return new int[] {xy[0], xy[1]};
    }
}
public class HKritickeSekce {
}
