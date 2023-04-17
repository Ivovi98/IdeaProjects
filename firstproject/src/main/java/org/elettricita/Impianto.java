package org.elettricita;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Impianto {
    private int potenzaMax = 0;
    private int potenzaCorrente = 0;
    List<Apparecchio> apparecchiCollegati = new ArrayList<>();

    public Impianto(int potenzaMax) {
        this.potenzaMax = potenzaMax;
    }

    public int getPotenzaMax() {
        return potenzaMax;
    }

    public void setPotenzaMax(int potenzaMax) {
        this.potenzaMax = potenzaMax;
    }

    public int getPotenzaCorrente() {
        return potenzaCorrente;
    }

    public void setPotenzaCorrente(int potenzaCorrente) {
        this.potenzaCorrente = potenzaCorrente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Impianto impianto = (Impianto) o;
        return potenzaMax == impianto.potenzaMax;
    }

    @Override
    public int hashCode() {
        return Objects.hash(potenzaMax);
    }

    //Metodo collega
    public void collega(Apparecchio a) {
        apparecchiCollegati.add(a);
        a.setImpianto(this);
    }


}
