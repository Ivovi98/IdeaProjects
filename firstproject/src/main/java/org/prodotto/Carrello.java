package org.prodotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Carrello {
     private List<Prodotto> carrello = new ArrayList<>();
     public Carrello(){}
     public List<Prodotto> getCarrello() {
          return carrello;
     }
     public void setCarrello(List<Prodotto> carrello) {
          this.carrello = carrello;
     }
     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Carrello carrello1 = (Carrello) o;
          return carrello.equals(carrello1.carrello);
     }
     @Override
     public int hashCode() {
          return Objects.hash(carrello);
     }

     //metodo add
     public void add(Prodotto p){
          carrello.add(p);
     }
     //Metodo remove
     public boolean remove(Prodotto p){
          return carrello.remove(p);
     }
     //metodo somma
     public double sommatot(){
          double tot = 0.0;
          for ( Prodotto elem: carrello ) {
               tot += elem.getPrice();
          }
          return tot;
     }
}