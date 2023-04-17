package org.elettricita;

import java.util.Objects;

public class Apparecchio {
    private int potenzaAssorbita = 0;
    private Impianto impianto;

    public Apparecchio(int potenzaAssorbita) {
        this.potenzaAssorbita = potenzaAssorbita;
    }

    public int getPotenzaAssorbita() {
        return potenzaAssorbita;
    }

    public void setPotenzaAssorbita(int potenzaAssorbita) {
        this.potenzaAssorbita = potenzaAssorbita;
    }

    public Impianto getImpianto() {
        return impianto;
    }

    public void setImpianto(Impianto impianto) {
        this.impianto = impianto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparecchio that = (Apparecchio) o;
        return potenzaAssorbita == that.potenzaAssorbita;
    }

    @Override
    public int hashCode() {
        return Objects.hash(potenzaAssorbita);
    }

    //Metodo potenza che restituisce la potenza attualmente assorbita da tutti gli apparecchi collegati all'impianto ed accesi
    //metodo on e off
    // questo lanca l'eccezione
    public void on() throws PotenzaSuperataException {
        this.impianto.setPotenzaCorrente(this.impianto.getPotenzaCorrente() + getPotenzaAssorbita());
        if(this.impianto.getPotenzaMax() < this.impianto.getPotenzaCorrente()) {
            throw new PotenzaSuperataException();
        }
    }
    public void off(){
        this.impianto.setPotenzaCorrente(this.impianto.getPotenzaCorrente() - getPotenzaAssorbita());
    }

}
