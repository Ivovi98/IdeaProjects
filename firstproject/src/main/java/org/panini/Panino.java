package org.panini;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Panino {
    //ATTRIBUTI
    private Set<Ingredienti> composizionePanino = new HashSet<>();
//    private Ingredienti ingrediente

    //COSTRUTTORE
    public Panino(){

    }
    public Panino(Set<Ingredienti> composizionePanino) {
        this.composizionePanino = composizionePanino;
    }
    //GETTER E SETTER
    public Set<Ingredienti> getComposizionePanino() {
        return composizionePanino;
    }
    public void setComposizionePanino(Set<Ingredienti> composizionePanino) {
        this.composizionePanino = composizionePanino;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panino panino = (Panino) o;
        return composizionePanino.equals(panino.composizionePanino);
    }
    @Override
    public int hashCode() {
        return Objects.hash(composizionePanino);
    }
    //TOSTRING
    @Override
    public String toString() {
        return "Panino{" +
                "composizionePanino=" + composizionePanino +
                '}';
    }

    //METODI

    /*
    Implementare la classe Panino, il cui metodo addIngrediente aggiunge un ingrediente, scelto da
    un elenco fisso. Gli ingredienti sono divisi in categorie. Se si tenta di aggiungere più di un
    ingrediente della stessa categoria, il metodo addIngrediente solleva un’eccezione.
    */
    public boolean addIngrediente(Ingredienti i) throws GiaPresente {
        if(composizionePanino.contains(i)){
            throw new GiaPresente();
        }
        composizionePanino.add(i);
        return true;
        /*boolean ripieno = false;
        boolean formaggio = false;
        boolean salsa = false;
        if (getComposizionePanino().contains(Ingredienti.Formaggi.SOTTILETTA) ||
                getComposizionePanino().contains(Ingredienti.Formaggi.MOZZARELLA)) {
            formaggio = true; //cerco di aggiungere un formaggino
        }
        if (getComposizionePanino().contains(Ingredienti.Salse.MAIONESE) ||
                getComposizionePanino().contains(Ingredienti.Salse.KETCHUP)) {
            salsa = true; //cerco di aggiungere un salsa
        }
        if (getComposizionePanino().contains(Ingredienti.Ripieni.SALAME) ||
                getComposizionePanino().contains(Ingredienti.Ripieni.PORCHETTA)) {
            ripieno = true; //cerco di aggiungere un ripieno
        }
        if(ripieno || salsa || formaggio){
            throw new GiaPresente();
        }*/
    }

    public void stampaPanino(){
        int count = 1;
        for (Ingredienti i: composizionePanino) {
            System.out.println(count + ") " + i);
            count++;
        }
    }
}