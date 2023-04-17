/*
Si implementino la classe Volo e la classe Passeggero. Il costruttore della classe Volo prende come
argomenti l’istante di partenza e l’istante di arrivo del volo (due numeri interi). Il metodo add
permette di aggiungere un passeggero a questo volo. Se il passeggero che si tenta di inserire è
già presente in un volo che si accavalla con questo, il metodo add lancia un’eccezione.
 */
package org.aereo;
public class VoloMain {
    public static void main(String[] args) throws VoliIntersecati {
        Volo v1 = new Volo(1000, 2000);
        Volo v2 = new Volo(1500, 3500);
        Volo v3 = new Volo(3000, 5000);
        Passeggero mario = new Passeggero("Mario");
        Passeggero luigi = new Passeggero("Luigi");
        v1.add(mario);
        v1.add(luigi);
        v3.add(mario);
        //v2.add(mario); // Questa istruzione provoca l ’ eccezione
        System.out.println(v1 + "\n");
        System.out.println(v2 + "\n");
        System.out.println(v3 + "\n");
    }
}
    //ATTRIBUTI

    //COSTRUTTORE

    //ENUM

    //GETTER E SETTER

    //EQUALS E HASHCODE

    //TOSTRING

    //METODI