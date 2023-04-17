package org.elettricita;

public class ElettricitaMain {
    public static void main(String[] args) throws PotenzaSuperataException {

        Impianto i1 = new Impianto(3000);
        Apparecchio a1 = new Apparecchio(1500);
        Apparecchio a2 = new Apparecchio(500);
        Apparecchio a3 = new Apparecchio(1001);
        i1.collega(a1);
        i1.collega(a2);
        i1.collega(a3);
        a1.on();
        //a1.off();
        a2.on();
        a3.on();
    }
}
