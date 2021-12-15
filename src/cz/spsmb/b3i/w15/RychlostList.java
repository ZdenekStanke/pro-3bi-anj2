package cz.spsmb.b3i.w15;

import java.util.*;

class TypyTestu {
    public static final int POCET_RADU = 5;
    public static final boolean DEBUG = false;
    public static int pocetPrvku = 1000;

    private List<Integer> li;
    private String typListu;

    public TypyTestu(List<Integer> li) {
        this.li = li;
        this.typListu = li.getClass().getName();
        typListu = typListu.substring(typListu.lastIndexOf(".") +1);
    }

    private void tisk(){
        if (DEBUG == true){
            System.out.println(li + " ");
        }
    }
    private abstract class Akce {
        String typ;

        public Akce(String typ) {
            this.typ = typ;
        }
        abstract void akce();
    }
    private Akce[] poleAkci = {
            new Akce("naplneni") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    for (int i = 0; i < pocetPrvku; i++) {
                        li.add(Integer.valueOf(i));
                    }
                    tisk();
                }
            },

            new Akce("pruchodIndexaci") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size();
                    for (int i = 0; i < vel; i++) {
                        li.get(i);
                    }
                    tisk();
                }
            },

            new Akce("pruchodIteratorem") {
                void akce() {
                    for (Iterator<Integer> it = li.iterator(); it.hasNext(); ) {
                        it.next();
                    }
                    tisk();
                }
            },

            new Akce("vypusteniPolovinyIndexaciZezadu") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size();
                    for (int i = vel - 2; i >= vel; i -= 2) {
                        li.remove(i);
                    }
                    tisk();
                }
            },
            new Akce("vlozeniPolovinyIndexaci") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size() * 2;
                    for (int i = 0; i < vel; i += 2) {
                        li.add(i, Integer.valueOf(i));
                    }
                    tisk();
                }
            },
            new Akce("vypusteniPolovinyIndexaciZepredu") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    for (int i = 0; i < li.size(); i++) {
                        li.remove(i);
                    }
                    tisk();
                }
            },

            new Akce("clearANaplneni") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    li.clear();
                    for (int i = 0; i < pocetPrvku; i++) {
                        li.add(Integer.valueOf(i));
                    }
                    tisk();
                }
            },
            new Akce("vypusteniPolovinyIteratorem") {
                void akce() {
                    for (Iterator<Integer> it = li.iterator(); it.hasNext(); ) {
                        it.next();
                        it.remove();
                        if (it.hasNext()) it.next();
                    }
                    tisk();
                }
            },
            new Akce("clearANaplneni") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    li.clear();
                    for (int i = 0; i < pocetPrvku; i++) {
                        li.add(Integer.valueOf(i));
                    }
                    tisk();
                }
            },

            new Akce("serazeniSestupne") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    Collections.sort(li, Collections.reverseOrder());
                    tisk();
                }
            },

            new Akce("serazeniVzestupne") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    Collections.sort(li);
                    tisk();
                }
            },

            new Akce("zamichani") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    Collections.shuffle(li);
                    tisk();
                }
            },

            new Akce("binarniHledaniOdzadu") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size() - 1;
                    for (int i = 0; i <= vel; i++) {
                        Collections.binarySearch(li, Integer.valueOf(vel - i));
                    }
                    tisk();
                }
            },

            new Akce("otoceniPoradi") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    Collections.reverse(li);
                    tisk();
                }
            },

            new Akce("hledaniOdzadu") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size();
                    for (int i = 0; i < vel; i++) {
                        li.indexOf(Integer.valueOf(vel - i));
                    }
                    tisk();
                }
            },

            new Akce("hledani") {
                void akce() {
                    //jsme ve vnitřní tříde, nesmí být this
                    int vel = li.size();
                    for (int i = 0; i < vel; i++) {
                        li.indexOf(Integer.valueOf(i));
                    }
                    tisk();
                }
            }
    };

    void testy() {
        System.out.println(typListu);
        for (int i = 0; i < poleAkci.length; i++) {
            long zac = System.currentTimeMillis();
            poleAkci[i].akce();
            long kon = System.currentTimeMillis();
            System.out.println(poleAkci[i].typ + ": " + (kon - zac));
        }

        System.out.println();
        //výmaz seznamu
        li.clear();
        li = null;
        System.gc();
    }
}

public class RychlostList {
    public static void main(String[] args) {
        for (int i = 1; i < TypyTestu.POCET_RADU ; i++) {
            System.out.println("Velikost pole: "+TypyTestu.pocetPrvku);
            new TypyTestu(new ArrayList<Integer>()).testy();
            new TypyTestu(new ArrayList<Integer>(TypyTestu.pocetPrvku)).testy();
            new TypyTestu(new LinkedList<Integer>()).testy();
            TypyTestu.pocetPrvku *= 10;
        }
    }
//Závěr: Linked list používat v případě, že:
//    - potřebujeme vytvořit zásobník, či frontu,
//    - budeme přidávat prvky na konec, či jen na začátek,
//    - potřebujeme ze seznamu pouze ubírat.
}