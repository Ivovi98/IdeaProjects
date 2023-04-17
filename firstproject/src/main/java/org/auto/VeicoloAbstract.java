package org.auto;

import java.util.Objects;

public abstract class VeicoloAbstract implements VeicoloInterface{
    private String marca, modello, targa;
    private int anno;
    private byte ruote;
    private double km;
    private boolean veicoloUsato;

    public VeicoloAbstract(String marca, String modello, String targa, int anno, byte ruote, double km) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.anno = anno;
        this.ruote = ruote;
        this.km = km;
        this.veicoloUsato = VeicoloUsato(getKm());
    }
    public VeicoloAbstract() {

    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModello() {
        return modello;
    }
    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getTarga() {
        return targa;
    }
    public void setTarga(String targa) {
        this.targa = targa;
    }
    public int getAnno() {
        return anno;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public double getKm() {
        return km;
    }
    public void setKm(double km) {
        this.km = km;
    }
    public boolean getVeicoloUsato() {
        return veicoloUsato;
    }
    public void setVeicoloUsato(boolean veicoloUsato) {
        this.veicoloUsato = veicoloUsato;
    }
    public void setRuote(byte ruote) {
        this.ruote = ruote;
    }
    public byte getRuote() {
        return ruote;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeicoloAbstract that = (VeicoloAbstract) o;
        return targa.equals(that.targa);
    }
    @Override
    public int hashCode() {
        return Objects.hash(targa);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(getRuote() == 4){
            sb.append("L'auto ha queste caratteristiche: " + "\n");
        }else{
            sb.append("La moto ha queste caratteristiche: " + "\n");
        }
        sb.append("Marca: "   + getMarca() + "\n");
        sb.append("Modello: " + getModello() + "\n");
        sb.append("Anno: "    + getAnno() + "\n");
        sb.append("Targa: "   + getTarga() + "\n");
        sb.append("Km: "      + getKm() + "\n");
        sb.append("Usato: "   + getVeicoloUsato() + "\n");
        return sb.toString();
    }
    public boolean VeicoloUsato(double km){
        return km > 0;
    }

}










