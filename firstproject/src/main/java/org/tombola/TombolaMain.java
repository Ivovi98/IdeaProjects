/*
Realizzare la classe Cartella, che rappresenta una cartella nella Tombola. Una cartella contiene
15 numeri casuali diversi, compresi tra 1 e 90, disposti in 3 righe di 5 numeri, rispettando la
seguente regola:
• una riga non può contenere due numeri della stessa “decina”; ad esempio, una riga può
contenere 9 e 11, ma non 11 e 13.
Il metodo segna accetta il prossimo numero estratto, e controlla se questa cartella ha ottenuto
un premio, restituendo null, oppure un valore enumerato che rappresenta uno dei premi della
Tombola: AMBO, TERNO, QUATERNA, CINQUINA, TOMBOLA (implementare anche questa
enumerazione).
 */
/*
package org.tombola;
public class TombolaMain {
    public static void main(String[] args) {

        int[][] cartella = {{16, 21, 31, 42, 60},
                             {1, 18, 33, 53, 62},
                            {2, 38, 55, 69, 74}};
        Cartella c1 = new Cartella(cartella); //PERCHE NON CI POSSO BUTTARE LA MATRICE DIRETTAMENTE?
        System.out.println("1) " + c1.sign(16));
        System.out.println("2) " + c1.sign(15)); //NO
        System.out.println("3) " + c1.sign(21));
        System.out.println("4) " + c1.sign(31));
        System.out.println("5) " + c1.sign(42));
        System.out.println("6) " + c1.sign(60));
        System.out.println("7) " + c1.sign(1));
        System.out.println("8) " + c1.sign(18));
        System.out.println("9) " + c1.sign(33));
        System.out.println("10) " + c1.sign(53));
        System.out.println("11) " + c1.sign(62));
        System.out.println("12) " + c1.sign(2));
        System.out.println("13) " + c1.sign(38));
        System.out.println("14) " + c1.sign(55));
        System.out.println("15) " + c1.sign(69));
        System.out.println("16) " + c1.sign(74));
    }
}
    //ATTRIBUTI

    //COSTRUTTORE

    //ENUM

    //GETTER E SETTER

    //EQUALS E HASHCODE

    //TOSTRING

    //METODI
*/