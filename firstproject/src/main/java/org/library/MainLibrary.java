/*
Realizzare per una biblioteca le classi Library e Book. Un oggetto Book è caratterizzato dal suo
titolo. La classe Library offre le seguenti funzionalità:
• Un costruttore senza argomenti che crea una biblioteca vuota.
• Il metodo addBook aggiunge un libro alla biblioteca. Se il libro era già stato aggiunto,
restituisce false.
• Il metodo loanBook prende un libro come argomento e lo dà in prestito, a patto che sia
disponibile. Se quel libro è già in prestito, restituisce false. Se quel libro non è mai stato
inserito nella biblioteca, lancia un’eccezione.
• Il metodo returnBook prende un libro come argomento e restituisce quel libro alla biblioteca.
Se quel libro non era stato prestato col metodo loanBook, il metodo returnBook lancia
un’eccezione.
• Il metodo printLoans stampa la lista dei libri attualmente in prestito, in ordine temporale
(a partire dal libro in prestito da più tempo).
 */
package org.library;
public class MainLibrary {
    public static void main(String[] args) throws BookDoesntExistInTheLibrary {
        Book b1 = new Book("Intelligenza Emotiva");
        Book b2 = new Book("Intelligenza Emotiva");
        Book b3 = new Book("Siddharta");
        Book b4 = new Book("Guerra è Pace");
        Library l1 = new Library();
        l1.addBook(b1);
        l1.addBook(b2);
        l1.addBook(b3);
        l1.addBook(b4);
        System.out.println(l1); //Il b2 non viene aggiunto
        l1.loanBook(b1);
        System.out.println(l1); //loanBook funziona correttamente
        l1.returnBook(b1);
        System.out.println(l1); //returnBook funziona
        l1.loanBook(b3);
        l1.loanBook(b1);
        l1.printLoans(); //Deve stampare prima il b3  e poi il b1
    }
}













