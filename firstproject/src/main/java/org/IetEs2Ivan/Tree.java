/*
Implementare le classi TreeType e Tree.
Mentre Tree rappresenta un particolare esemplare di albero.
Ogni Tree ha un tipo base ed eventualmente degli innesti di altri tipi di alberi.
Il metodoaddGraft di Tree aggiunge un innesto ad un albero, purchè non sia dello stesso tipo dell’albero
stesso.
Il metodo getCounter di Tree restituisce il numero di alberi che sono stati creati.
*/
package org.IetEs2Ivan;

import java.util.*;

public class Tree {
    //ATTRIBUTI
    private static int counter = 0;
    private String tipoAlbero = "";
    private List<String> innesti = new ArrayList<String>();
    //COSTRUTTORE
    public Tree(TreeType tt) {
        tipoAlbero = tt.getNome();
        innesti.add(tt.getNome());
        this.counter++;
    }
    //GETTER E SETTER
    public static int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter = counter;
    }
    public String getTipoAlbero() {
        return tipoAlbero;
    }
    public void setTipoAlbero(String tipoAlbero) {
        this.tipoAlbero = tipoAlbero;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Objects.equals(tipoAlbero, tree.tipoAlbero) && Objects.equals(innesti, tree.innesti);
    }
    @Override
    public int hashCode() {
        return Objects.hash(tipoAlbero, innesti);
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Tree{" +
                "tipoAlbero='" + tipoAlbero + '\'' +
                ", innesti=" + innesti +
                '}';
    }

    //METODI

    //Il metodo addGraft di Tree aggiunge un innesto ad un albero, purchè non sia dello stesso tipo dell’albero stesso.
    public void addGraft(TreeType tt) throws InnestoDelloStessoTipo{
        if(tt.getNome().equals(this.tipoAlbero)){
            throw new InnestoDelloStessoTipo();
        }else{
            innesti.add(tt.getNome());
        }

    }

}
