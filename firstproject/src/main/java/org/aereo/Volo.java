package org.aereo;
import java.util.*;

public class Volo {
    //ATTRIBUTI
    int partenza = 0;
    int arrivo = 0;
    //COSTRUTTORE
    public Volo(int partenza, int arrivo) throws VoliIntersecati {
        if(partenza >= arrivo)
            throw new VoliIntersecati();
        this.partenza = partenza;
        this.arrivo = arrivo;
    }
    //GETTER E SETTER
    public int getPartenza() {
        return partenza;
    }
    public void setPartenza(int partenza) {
        this.partenza = partenza;
    }
    public int getArrivo() {
        return arrivo;
    }
    public void setArrivo(int arrivo) {
        this.arrivo = arrivo;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Volo volo = (Volo) o;
        return partenza == volo.partenza && arrivo == volo.arrivo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(partenza, arrivo);
    }

    //METODI
    public boolean overposition(Passeggero p1){
        for(Volo v: p1.getVoloList()) {
            //Se l'orario di partenza è tra l'orario di partenza e di arrivo dell'altro volo
            //Se l'orario di arrivo è tra l'orario di partenza  e di arrivo dell'altro volo
            //return true
            if(this.partenza > v.partenza && this.partenza < v.arrivo || this.arrivo > v.partenza && this.arrivo < v.arrivo)
                return true;
        }
        return false;
    }

    public void add(Passeggero p1) throws VoliIntersecati{
        if(overposition(p1)){
            throw new VoliIntersecati();
        }else{
            p1.getVoloList().add(this);
        }
        /*for (Volo v: passeggeriDelVolo.keySet()) {
            for (Passeggero p: passeggeriDelVolo.values()) {
                if(p.equals(p1)){
                    throw new PasseggeroGiaPresente();
                }else if(passeggeriDelVolo.values().isEmpty()){
                    passeggeriDelVolo.put(this, p1);
                }else if(!passeggeriDelVolo.values().isEmpty())
                    passeggeriDelVolo.put(this, p1);
            }
        }*/
        //Controllo dell'esistenza del passeggero nel volo a cui si tenta di aggiungere: ????????????????????????????
        /*if(Passeggeri.isEmpty()){
            Passeggeri.add(p1);
        }else/* if(!Passeggeri.isEmpty())*//*{
            for (Passeggero p: Passeggeri) {
                if(p.equals(p1)){
                    throw new PasseggeroGiaPresente();
                }
            }
        }*/
    }
}
