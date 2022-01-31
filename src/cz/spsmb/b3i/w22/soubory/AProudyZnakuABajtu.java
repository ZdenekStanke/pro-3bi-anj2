package cz.spsmb.b3i.w22.soubory;
//Pro jakýkoliv přenos informace je nutné otevřít tzv. prud (stream).
// vstupní proud - čtení
// výstupní proud - zápis
// Java rozlišuje proudy znaků, kde základní jednotka je 16bitová pro Unicode znaky
// a proub bytů, kte je zákl. jednotka 8bitová.

// Znakově orientované proudy:
// základní abstraktní třídy Reader, Writer

// Bytově orientované proudy:
// základní abstraktní třídy InputStream a OutputStream

// Od výše uvedených tříd se dědí další, které se již běžně používají.
// Všechny poskytují druh 3x přetížené metody, kterou si pracovně nazvema jako rw():
// rw() - práce s jedním prvkem
// rw(typ[] pole) - práce s celým polem prvků
// rw(typ[] pole, int index, int pocet) - práce s částí pole
// týká se to metod read() a write() u všech tříd. Tyto metody vrací hodnotu -1,
// pokud bylo dosaženo konce proudu (tj. už není co číst).
// Třída Writer obsahuje navíc ještě tyto 2 metody:
// void write(String retez)
// void write(String retez, int index, int pocet)


public class AProudyZnakuABajtu {
}
