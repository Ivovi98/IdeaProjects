/*
Scrivere un metodo in Java che prenda come input una stringa che rappresenta una frase e
restituisca la parola più lunga della frase. Si faccia uso della classe StringTokenizer (o
eventualmente del metodo charAt(i) della classe String) e del metodo length() della classe String.
Di seguito un main di esempio:
public static void main(String[] args) {
 String sentence = "The quick brown fox jumps over the lazy dog";
 System.out.println("Longest word: " + findLongestWord(sentence));
}
che restituisce la parola più lunga.
*/
package org.IetEs1Ivan;

import java.util.StringTokenizer;

public class StringMain {
    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println("Longest word: " + findLongestWord(sentence));
    }

    public static String findLongestWord(String s){
        String longestWord = "";
        StringTokenizer st = new StringTokenizer(s);

        while (st.hasMoreTokens()) {
            String nextWord = st.nextToken();
            if (nextWord.length() > longestWord.length()) {
                longestWord = nextWord;
            }
        }

        return longestWord;
    }
}
