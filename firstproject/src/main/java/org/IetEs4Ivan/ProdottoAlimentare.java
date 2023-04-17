package org.IetEs4Ivan;
public class ProdottoAlimentare extends Prodotto{
    //ATTRIBUTI
    int dataDiScadenza = 0;

    //COSTRUTTORE
    //Il costruttore del prodotto alimentare lancia
    //un’eccezione se l’anno di scadenza è negativo.
    public ProdottoAlimentare(String nome, double prezzo, int dataDiScadenza) throws DataDiScadenzaNegativa{
        super(nome, prezzo);

        if(dataDiScadenza < 0){
            throw new DataDiScadenzaNegativa();
        }else{
            this.dataDiScadenza = dataDiScadenza;
        }
    }

    //GETTER E SETTER
    public int getDataDiScadenza() {
        return dataDiScadenza;
    }
    public void setDataDiScadenza(int dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
    }

    //METODI

    //Sul prodotto alimentare è presente il metodo boolean isScaduto() che
    //ritorna true se l’anno di scadenza è inferiore al 2023.
    public boolean isScaduto(int i){
        if(i < 2023){
            return true;
        }
        return false;
    }
}
