package cz.spsmb.b3i.w13.cviceni2;

import cz.spsmb.b3i.w13.cviceni1.Ctverec;
import cz.spsmb.b3i.w13.cviceni1.IZobrazitelny;

public class DutyCtverec extends Ctverec implements IZobrazitelny {

    public DutyCtverec(int a) {
        super(a);
    }

    @Override
    public void zobraz() {
        for (int i = 0; i < a; i++ )
        {
            for (int j = 0 ; j < a; j++ )
            {
                if (i == 0 || i == a - 1 || j == 0 || j == a - 1)
                {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
