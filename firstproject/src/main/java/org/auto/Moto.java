package org.auto;
public class Moto extends VeicoloAbstract{
    public Moto(String marca, String modello, String targa, int anno, byte ruote, double km) {
        super(marca, modello, targa, anno, ruote, km);
    }
    //private final byte ruote = 2;
    public static void main(String[] args) {
        String marca = "Ducati";
        String modello = "Scrambler";
        String targa = "AB 12345";
        int anno = 2018;
        byte ruote = 2;
        double km = 5000;
        Auto m = new Auto(marca, modello, targa, anno, km);
        System.out.println(m);
	}
}


/*
 private String marca, modello, targa;
    private int anno;
    private byte ruote;
    private double km;
 */