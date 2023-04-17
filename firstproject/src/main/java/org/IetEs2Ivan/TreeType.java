/*
Implementare le classi TreeType e Tree. TreeType rappresenta un tipo di albero (pino, melo, etc.),
mentre Tree rappresenta un particolare esemplare di albero. Ogni TreeType è caratterizzato dal
suo nome. Ogni Tree ha un tipo base ed eventualmente degli innesti di altri tipi di alberi. Il metodo
addGraft di Tree aggiunge un innesto ad un albero, purchè non sia dello stesso tipo dell’albero
stesso. Il metodo getCounter di Tree restituisce il numero di alberi che sono stati creati. Il metodo
getCounter di TreeType restituisce il numero di alberi di quel tipo che sono stati creati.
*/
package org.IetEs2Ivan;

import java.util.*;

public class TreeType {
    //ATTRIBUTI
    private String nome = "";
    private int counter = 0;
    //COSTRUTTORE
    public TreeType(String nome) {
        this.nome = nome;
        counter++;
    }
    //GETTER E SETTER
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeType treeType = (TreeType) o;
        return nome.equals(treeType.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    //METODI

}
