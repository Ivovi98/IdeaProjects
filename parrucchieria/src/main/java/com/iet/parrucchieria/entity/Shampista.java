package com.iet.parrucchieria.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Shampista extends Dipendente{
    @Basic
    @Column
    private char sesso;
}
