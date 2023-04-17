package com.example.demo69.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@Entity //presa da persistance, che permetterà di collegare la classe a una tabella del database, il database è creato ma non si ha la tabella
//Diferenza tra query e named query è che le named sono "predefinite" che vengono inserite direttamente uslle entity
    //(vedere nell'interface DipendenteRepository ha lo stesso commento a riguardo, qui c'è l'esempio solo
@NamedQueries({ //Questa è una named query
        @NamedQuery(name ="Dipendente.findAll", query = "SELECT d FROM Dipendente d"),
        @NamedQuery(name = "Dipendente.countBy", query = "SELECT COUNT(d) FROM Dipendente d"),
        @NamedQuery(name = "Dipendente.deleteBy", query = "DELETE FROM Dipendente d") //questa non dovrebbe starci
        //tutte queste named query sono come dei template/ predefiniti sulle operazioni che possiamo fare
})

public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //SEQUENCE permette di autogenerare l'ID nel momento della riga dellatabella viene generata
    @Column(name = "id", nullable = false) //nullable è per l'id in quanto non può mai essere false
    private Long id;
    @Basic
    @Column //Queste sono colonne della tabella
    private String nome; //il nome variabile deve essere uguale a quello del database altrimenti si può fare
    @Basic       // così come sta sotto questo rigo
    @Column(name = "NAME")
    private String cognome;
    @Basic
    @Column
    private String cf;
    @CreatedDate
    @Column
    private Timestamp dataCreazione;
    @LastModifiedDate
    @Column
    private Timestamp dataUltimaModifica;
    @Version
    @Column
    private int versione;

}
