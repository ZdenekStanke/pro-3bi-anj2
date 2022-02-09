package cz.spsmb.b3i.w23.soubory;
// možnost ukládání a čtení stavů objektů zajištují třídy
// ObjectInputStream a ObjectOutputStream, které disponují metodami
// readObject()
// writeObject()
//Takto lze však zapisovat pouze objekty tříd, které implementují rozhraní
// java.io.Serializable. Bez tohot dostasneme výjimku NotSerializableException

import java.io.*;
import java.util.Date;

class ImplSerializable implements Serializable {
    Date d;
    ImplSerializable() {
        d = new Date();
    }
}

public class OSerializace {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fwJm = new FileOutputStream("datum.bin");
        ObjectOutputStream fw = new ObjectOutputStream(fwJm);

        Date d = new Date();
        System.out.println("Vznik: " + d);
        ImplSerializable impl = new ImplSerializable();
        System.out.println(impl.d.toString());
        fw.writeObject(d);
        fw.writeObject(impl);
        fwJm.close();
        d = null; //zruseni instance
        impl = null;

        //čtení objektu
        FileInputStream frJm = new FileInputStream("datum.bin");
        ObjectInputStream fr = new ObjectInputStream(frJm);
        d = (Date) fr.readObject();
        impl = (ImplSerializable) fr.readObject();
        fwJm.close();
        System.out.println("Cteni: " + d);
        System.out.println(impl.d.toString());
    }
}
