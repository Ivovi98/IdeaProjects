package org.prodotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Prodotto {

    private String descr = "";
    private double price = 0;
    private Map<String, Prodotto> mapProd = new HashMap<>();

    public Prodotto(String descr, double price) throws ProductAlreadyExistException {

        if(mapProd.containsKey(descr)){//desc in map lancia eccezione
            throw new ProductAlreadyExistException();
        }
        this.descr = descr;
        this.price = price;
        mapProd.put(descr, this);//il this passa l'intero oggetto prodotto con tutti i valori descr e price
    }
    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Double.compare(prodotto.price, price) == 0 && Objects.equals(descr, prodotto.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descr, price);
    }

}
