package com.iet.parrucchieria.service;

import com.iet.parrucchieria.entity.Materiale;
import com.iet.parrucchieria.repository.MaterialeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialeService {

    @Autowired
    private MaterialeRepository materialeRepository;

    public Optional<Materiale> findById(Long id) {
        return materialeRepository.findById(id);
    }
}
