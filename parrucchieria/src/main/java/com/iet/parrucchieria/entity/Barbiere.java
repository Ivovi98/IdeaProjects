package com.iet.parrucchieria.entity;

import lombok.*;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Barbiere extends Dipendente {
    @Basic
    @Column
    private boolean haLaBarba;

}
