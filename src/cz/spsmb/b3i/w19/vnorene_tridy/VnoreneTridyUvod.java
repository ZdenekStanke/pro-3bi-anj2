package cz.spsmb.b3i.w19.vnorene_tridy;

//Prvkem třídy může být i jiná třída - opravdu se tím myslí dřída deklarovaná uvnitř třídy.
//Taková třída se označuje jako vnořená (nested class, top-less class). Třída, která obsahuje
//vnořenou třídu se pak označuje jako třída nejvyšší úrovně (top level class), nebo vnější třída.

//Vnořená třída se použije, má-li své opodstatnění pouze v rámci své vnější třídy a nikde jinde.
//Stejně jako u proměnných a metod třídy může být vnořená třída deklarována s modifikátorem
//static - tzv. statická vnořená třída. Bez static pak nazýváme vnitřní třída, což je mnohem
// používanější případ.
public class VnoreneTridyUvod {
    static  class StatickaVnorena {
        // ...
    }
    class Vnitrni {
        //...
    }

}
