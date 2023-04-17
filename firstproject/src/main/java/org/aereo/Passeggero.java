package org.aereo;

import java.util.*;

public class Passeggero {
    //ATTRIBUTI
    String nome = "";
    private List<Volo> voloList = new ArrayList<>();
    //COSTRUTTORE
    public Passeggero(String nome) {
        this.nome = nome;
        this.voloList = new ArrayList<>();
    }
    //GETTER E SETTER
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Volo> getVoloList() {
        return voloList;
    }
    public void setVoloList(List<Volo> voloList) {
        this.voloList = voloList;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passeggero that = (Passeggero) o;
        return nome.equals(that.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
    //TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Volo v : voloList){
            sb.append(v);
        }
        return sb.toString();
    }
}
