package org.IetEs4Ivan;

import java.util.*;

public abstract class Prodotto implements Negozio{
    //ATTRIBUTI
    private String nome = "";
    private double prezzo = 0;
    private TipoProdotto tp;
    private int key = 0;
    Map<Integer,Prodotto> mappaProdotti = new HashMap<Integer, Prodotto>();

    //COSTRUTTORE
    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    //ENUM
    public enum TipoProdotto {
    ALIMENTARE,
    ELETTRONICO,
    ABBIGLIAMENTO,
    SANITARIO;
    }

    //GETTER E SETTER
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Double.compare(prodotto.prezzo, prezzo) == 0 && nome.equals(prodotto.nome) && tp == prodotto.tp;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, prezzo, tp);
    }

    //METODI

    public void addProdotto(Prodotto p){
        mappaProdotti.put(key, p);
        key++;
    }

    public void removeProdotto(ProdottoAlimentare p){
        mappaProdotti.remove(p);
    }

    public Prodotto getProdotto(int index){
        return mappaProdotti.get(index);
    }
}
