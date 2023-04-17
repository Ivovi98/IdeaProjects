/*
Implementare la classe Cellphone, che rappresenta un’utenza telefonica dotata di un gestore (stringa)
e un numero di telefono (stringa). La classe è in grado di calcolare il costo di una telefonata,
in base al gestore di partenza, al gestore di arrivo, e alla durata.
Il metodo setCost consente di impostare il costo al minuto di una telefonata con un dato gestore
di partenza e un dato gestore di arrivo. Il metodo getCost calcola il costo di una telefonata verso
una data utenza e di una data durata (in minuti).
 */
package org.cellphone;

public class MainCellphone {
    public static void main(String[] args) {
        Cellphone a = new Cellphone("TIMMY", "3341234");
        Cellphone b = new Cellphone("Megafon", "3355678");
        Cellphone c = new Cellphone("Odissey", "3384343");
        Cellphone.setCost("TIMMY", "TIMMY");
        Cellphone.setCost("TIMMY", "Megafon");
        System.out.println(a.getCost(a.getOperator(), b.getOperator(), 10));
        System.out.println(b.getCost(b.getOperator(), a.getOperator(), 8));
    }
}
    /*
    Output:
    -1.5
    -2.0
    */
