package org.panini;

public class Ingredienti {
    //ATTRIBUTI
    private Salse salsa;
    private Ripieni ripieno;
    private Formaggi formaggio;
    //COSTRUTTORE
    public Ingredienti(Salse s, Ripieni r, Formaggi f) {
        this.salsa = s;
        this.formaggio = f;
        this.ripieno = r;
    }
    ///ENUM
    public enum Ripieni {
        SALAME,
        PORCHETTA;
    }
    public enum Formaggi {
        SOTTILETTA,
        MOZZARELLA;
    }
    public enum Salse {
        MAIONESE,
        KETCHUP;
    }
    //TOSTRING

    @Override
    public String toString() {
        return "Ingredienti{" +
                "salsa " + salsa +
                ", ripieno " + ripieno +
                ", formaggio " + formaggio +
                '}';
    }
}
