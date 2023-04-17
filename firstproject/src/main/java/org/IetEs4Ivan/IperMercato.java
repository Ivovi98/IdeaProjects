/*
Nell’ambito di un ipermercato (package), si deve implementare una soluzione che comprenda i
seguenti file: una classe astratta Prodotto, un’interfaccia Negozio, un’implementazione
NegozioImpl, una classe concreta ProdottoAlimentare.
Un prodotto è caratterizzato da un nome, un prezzo ed un tipo, definito secondo l’enum
TipoProdotto { ALIMENTARE, ELETTRONICO,ABBIGLIAMENTO, SANITARIO }.

Un ProdottoAlimentare è un Prodotto che, oltre ad un nome ed un prezzo, ha anche una
dataDiScadenza (per semplicità rappresentata come anno).
Il tipo del prodotto, in questo caso, è forzatamente ALIMENTARE.

Sul prodotto alimentare è presente il metodo boolean isScaduto() che
ritorna true se l’anno di scadenza è inferiore al 2023.

Il costruttore del prodotto alimentare lancia un’eccezione se l’anno di scadenza è negativo.

L’interfaccia Negozio definisce i metodi addProdotto(Prodotto p), removeProdotto(Prodotto p) e
getProdotto(int index).
I primi due metodi, rispettivamente, aggiungono e rimuovono un prodotto
da una collezione di prodotti.
Si noti che possono esistere più prodotti aventi stesso nome, stesso
prezzo e stesso tipo.

L’ultimo metodo restituisce un prodotto a partire dalla posizione in cui si
trova nella collezione.

La classe che implementa l’interfaccia Negozio, cioè NegozioImpl,
implementa anche i metodi:
1. calcolaTotale(TipoProdotto tipo), che calcola il totale dei prezzi dei prodotti in vendita in
base al tipo in input

2. rimuoviProdottiScaduti(), che rimuove tutti i prodotti alimentari che hanno raggiunto la
scadenza.
 */
package org.IetEs4Ivan;

public class IperMercato {
    public static void main(String[] args) throws DataDiScadenzaNegativa{
        ProdottoAlimentare p1 = new ProdottoAlimentare("Oreo", 2.0, 2022);
        //ProdottoAlimentare p2 = new ProdottoAlimentare("Twix", 1.0, -20);
        ProdottoAlimentare p3 = new ProdottoAlimentare("Snickers", 1.5, 2022);
        ProdottoAlimentare p4 = new ProdottoAlimentare("Lion", 1.0, 2023);

        Negozio.addProdotto(p1);
        Negozio.addProdotto(p3);
        Negozio.addProdotto(p4);
    }
}
