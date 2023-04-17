package com.iet.parrucchieria.repository;

import com.iet.parrucchieria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}