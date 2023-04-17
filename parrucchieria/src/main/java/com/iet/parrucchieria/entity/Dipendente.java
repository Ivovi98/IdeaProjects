package com.iet.parrucchieria.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries({
        @NamedQuery(name = "Dipendente.findAll", query = "select d from Dipendente d"),
        @NamedQuery(name = "Dipendente.countBy", query = "select count(d) from Dipendente d"),
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Basic
    @Column
    private String nome;
    @Basic
    @Column
    private String cognome;
    @Basic
    @Column
    private String cf;
    @OneToMany(mappedBy = "dipendenteProprietario")
    private List<Materiale> listaMateriali = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_dipendente")
    private List<Servizio> listaServizi = new ArrayList<>();

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
