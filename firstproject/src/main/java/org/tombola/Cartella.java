/*
Realizzare la classe Cartella, che rappresenta una cartella nella Tombola. Una cartella contiene
15 numeri casuali diversi, compresi tra 1 e 90, disposti in 3 righe di 5 numeri, rispettando la
seguente regola:
• una riga non può contenere due numeri della stessa “decina”; ad esempio, una riga può
contenere 9 e 11, ma non 11 e 13.
Il metodo segna accetta il prossimo numero estratto, e controlla se questa cartella ha ottenuto
un premio, restituendo null, oppure un valore enumerato che rappresenta uno dei premi della
Tombola: AMBO, TERNO, QUATERNA, CINQUINA, TOMBOLA (implementare anche questa enumerazione).
 */
/*
package org.tombola;

import java.util.Arrays;
import java.util.List;

public class Cartella {
    //ATTRIBUTI
    private int[][] cartella; //[row][col]
    private List<Integer> cartellaPremi;
    //COSTRUTTORE
    public Cartella(int[][] cartella) {
        this.cartella = cartella;
        this.cartellaPremi. = cartella.length;
    }
    //GETTER E SETTER
    public int[][] getCartella() {
        return cartella;
    }
    public void setCartella(int[][] cartella) {
        this.cartella = cartella;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cartella cartella1 = (Cartella) o;
        return Arrays.equals(cartella, cartella1.cartella);
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(cartella);
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Cartella{" +
                "cartellaPremi=" + Arrays.toString(cartellaPremi) +
                '}';
    }
    //METODI
    public Premio sign(int n) {
        for (int i = 0; i < this.cartella.length; i++) {
            for (int j = 0; j < this.cartella[i].length; j++) {
                if (n == this.cartella[i][j]) {
                    checkPremi(i);
                    return checkPremi(i);
                }
            }
        }
        return null;
    }

    public Premio checkPremi(int iPassed) {
        cartellaPremi[iPassed] = cartellaPremi[iPassed]++;
        if(cartellaPremi[iPassed] < 2){
            return null;
        }else if(cartellaPremi[iPassed] == 2){
            return Premio.AMBO;
        }else if(cartellaPremi[iPassed] == 3){
            return Premio.TERNA;
        }else if(cartellaPremi[iPassed] == 4){
            return Premio.QUATERNA;
        }else if(cartellaPremi[iPassed] == 5){
            return Premio.CINQUINA;
        }else{
            return Premio.TOMBOLA;
        }
    }
}
 */