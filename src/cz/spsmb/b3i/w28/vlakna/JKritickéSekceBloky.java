package cz.spsmb.b3i.w28.vlakna;

import java.io.IOException;
import java.io.RandomAccessFile;
// Nepotřebujeme-li označit celou metodu jako kritickou sekci,
// může nám postačit označit pouze menší úsek.
public class JKritickéSekceBloky {
    RandomAccessFile file;
    JKritickéSekceBloky (RandomAccessFile f) {
        this.file = f;
    }
    public void presun(long kam) throws IOException {
        // blok kritické sekce:
        synchronized (this.file) {
            file.seek(kam);
        }
    }
    public int ctiInt() throws IOException {
        synchronized (this.file) {
            return file.readInt();
        }
    }
}
