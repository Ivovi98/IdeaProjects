package com.iet.parrucchieria.repository;

import com.iet.parrucchieria.entity.Materiale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialeRepository extends JpaRepository<Materiale, Long> {
}