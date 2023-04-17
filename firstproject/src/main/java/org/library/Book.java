package org.library;

import java.util.Objects;

public class Book {
    //ATTRIBUTI
    private String title = "";
    private boolean loaned = false;
    //COSTRUTTORE
    public Book(String title) {
        this.title = title;
    }
    //GETTER E SETTER
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isLoaned() {
        return loaned;
    }
    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }
    //EQUALS E HASHCODE
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title);
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
