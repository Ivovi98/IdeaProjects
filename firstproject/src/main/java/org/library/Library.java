/*
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

import java.util.Objects;
import java.util.Vector;

public class Library {
    //ATTRIBUTI
    private Vector<Book> library = new Vector<>();
    //COSTRUTTORE
    public Library() {}
    //GETTER E SETTER
    public Vector<Book> getLibrary() {
        return library;
    }
    public void setLibrary(Vector<Book> library) {
        this.library = library;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library1 = (Library) o;
        return library.equals(library1.library);
    }
    @Override
    public int hashCode() {
        return Objects.hash(library);
    }
    //TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for(Book bookOfLibrary: library){
            sb.append(counter + ") " + bookOfLibrary.getTitle() + ", stato prestito: " + bookOfLibrary.isLoaned() +"\n");
            counter++;
        }
        return sb.toString();
    }

    //METODI

    //• Il metodo addBook aggiunge un libro alla biblioteca. Se il libro era già stato aggiunto, restituisce false.
    public boolean addBook(Book b){
        if(library.contains(b)){
            return false;
        }else {
            library.add(b);
            return true;
        }
    }

    //• Il metodo loanBook prende un libro come argomento e lo dà in prestito, a patto che sia
    //disponibile. Se quel libro è già in prestito, restituisce false. Se quel libro non è mai stato
    //inserito nella biblioteca, lancia un’eccezione.
    public boolean loanBook(Book b) throws BookDoesntExistInTheLibrary{
        if(library.contains(b)){
            if(b.isLoaned()){
                return false;
            }else{
                b.setLoaned(true);
                return true;
            }
        }else{
            throw new BookDoesntExistInTheLibrary();
        }
    }

    //• Il metodo returnBook prende un libro come argomento e restituisce quel libro alla biblioteca.
    //Se quel libro non era stato prestato col metodo loanBook, il metodo returnBook lancia
    //un’eccezione.
    public void returnBook(Book b) throws BookDoesntExistInTheLibrary{
        if(library.contains(b) && b.isLoaned()){
            b.setLoaned(false);
        }else{
            throw new BookDoesntExistInTheLibrary();
        }
    }

    //• Il metodo printLoans stampa la lista dei libri attualmente in prestito, in ordine temporale
    //(a partire dal libro in prestito da più tempo).
    public void printLoans(){
        int counter = 1;
        for(Book bookOfLibrary: library) {
            if(bookOfLibrary.isLoaned()){
                System.out.println(counter + ") " + bookOfLibrary.getTitle());
                counter++;
            }
        }
    }
}

