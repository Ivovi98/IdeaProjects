package org.auto;
public class Auto extends VeicoloAbstract{
    public Auto(String marca, String modello, String targa, int anno, double km) {
        super(marca, modello, targa, anno, (byte) 4, km);
    }
    //private final byte ruote = 4;
    public static void main(String[] args) {

        String marca = "BMW";
        String modello = "M5";
        String targa = "FU111GA";
        int anno = 2015;
        byte ruote = 4;
        double km = 10000;
        VeicoloAbstract a = new Auto(marca, modello, targa, anno, km);
        System.out.println(a);

        marca = "Dodge";
        modello = "Charger";
        targa = "CA222II";
        anno = 1969;
        ruote = 4;
        km = 0;
        VeicoloAbstract a2 = new Auto(marca, modello, targa, anno, km);
        System.out.println(a2);
	}
}
/*
implementare una classe figlio rispetto alle classi fatte per oggi
es:
auto marche modello targa
darle una sopracategoria "veicolo"
e una sottocategoria di veicolo che sta per moto
interfaccia, classe astratta e classe concreta da vedere
da vedere gli attributi  ereditati dalla classe padre
*/