package cz.spsmb.b3i.w28.vlakna;

// Stavy vláken jsou:
// Nové vlákno - vlákno bylo vytvořeno (nejčastěji pomocí new), ale nebylo
//               spuštěno metodou start()
// Běhuschpné  - metoda start() již proběhla; těchto vláken může být více,
//               ale jen omezený počet (dle počtu cpu) může být běžící.
// Neběhuschopné - vlákno, které:
//                      - bylo uspáno  metodou sleep(),
//                      - čeká v rámci wait() na notify(),
//                      - čeká na I/O
// Mrtvé vlákno - vlákno, jehož metoda run() skončila.

// Priorita vlákna
// Každé vlákno má svou prioritu, podle které se řídí plánovač běhu
// vláken. Jsou li běhuschopná dvě vlákna, řízení předáno tomu s vyšší
// prioritou. Metodami getPriority() a setPriority() zjišťujeme/nastavujeme
// prioritu vlákna, přičemž priorita je celé nezáporné číslo.
// MIN_PRIORITY (1)  - nejnižší priorita,
// MAX_PRIORITY (10) - nejvyšší priorita,
// NORM_PRIORITY (5) - výchozí priorita vláken.

// Chování plánovače vláken:
// - Ze všech běhuschopných vláken běží vždy to, které má nejvyšší
//   prioritu ze všech běhuschopných vláken.
// - Pokud se do běhuschopného stavu dostane vlákno s vyšší prioritou,
//   než má vlákno běžící, je běžící vlákno okamžitě donuceno k předání
//   řízení ve prospěch vlákna s vyšší prioritou (tzv. preemptivní
//   plánování).
// - Pokud na přidělení procesoru čeká více vláken se stejnou prioritou,
//   plánovač je volí postupně tak, aby na každé vlákno pokud možno došlo.
// - Běžící vlákno pomocí metody yeld() dobrovolně předá řízení některému
//   běhuschopnému vláknu se stejnou prioritou.
// - Vlákno s nižší prioritou může získat řízení jen tehdy, když vlákna
//   s vyšší prioritou přejdou do neběhuschopného stavu.

public class AStavyVlaknaAPriorita {
}
