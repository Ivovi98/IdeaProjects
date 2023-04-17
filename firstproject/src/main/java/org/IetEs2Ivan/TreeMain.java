/*
Implementare le classi TreeType e Tree.
TreeType rappresenta un tipo di albero (pino, melo, etc.),
mentre Tree rappresenta un particolare esemplare di albero.
Ogni TreeType è caratterizzato dal suo nome.
Ogni Tree ha un tipo base ed eventualmente degli innesti di altri tipi di alberi.
Il metodoaddGraft di Tree aggiunge un innesto ad un albero, purchè non sia dello stesso tipo dell’albero
stesso.
Il metodo getCounter di Tree restituisce il numero di alberi che sono stati creati.
Il metodo getCounter di TreeType restituisce il numero di alberi di quel tipo che sono stati creati.
*/
package org.IetEs2Ivan;

public class TreeMain {
    public static void main(String[] args) throws InnestoDelloStessoTipo {
        TreeType melo = new TreeType("melo");
        TreeType pero = new TreeType("pero");
        Tree unMelo = new Tree(melo);
        Tree unAltroMelo = new Tree(melo);
        unAltroMelo.addGraft(pero);
        unAltroMelo.addGraft(pero);
        System.out.println("Sono stati creati " + melo.getCounter() + " meli fino a questo momento.");
        System.out.println("Sono stati creati " + Tree.getCounter() + " alberi fino a questo momento.");
        System.out.println(unAltroMelo);
        //unAltroMelo.addGraft(melo);
    }
}
