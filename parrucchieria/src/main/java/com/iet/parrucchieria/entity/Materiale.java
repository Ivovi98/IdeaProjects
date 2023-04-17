package com.iet.parrucchieria.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Materiale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    @Basic
    @Column
    private String nome;
    @Basic
    @Column
    private Double prezzo;
    @Basic
    @Column
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "id_dipendente", nullable = true)
    private Dipendente dipendenteProprietario;
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
