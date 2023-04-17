package com.example.demo69.service;

import com.example.demo69.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository; //Dependency injection, si tratta di iniettare/ passare alla nostra classe
    //in questo caso al service, un bin java, o comunque file java dandogli tutti i parametri, attributi e quant'altro propri
    //di quella classe java, file java

    //Nei service si scrivono metodi che richiamano le operazioni fatte nella repository
    //Ad es
    public Dipendente findByID(Long id){
        return dipendenteRepository.findByID(id);
    }

    public List<Dipendente> findAll(){
        return dipendenteRepository.findAll();
    }

    public List<Dipendente> findAllByCf(String cf){
        return dipendenteRepository.findAllByCf(cf);
    }

    public Dipendente insertDipendente(Dipendente dipendente){
        return dipendenteRepository.save(dipendente); //save restituirà un generico s, lo stesso che si ottiene in ingresso, quindi si restituisce ciò che si salva
    }                                               //per questo si restituisce Dipendente in questo metodo

    public Dipendente updateDipendente(STring nome, String cognome){
        //prima si deve trovare il dipendente che si vuole aggiornare e poi aggiornarlo
        //per assicurarsi di trovare quello giusto si può cercare il suo ID
        return dipendenteRepository.save(dipendente);
    }

    public Optional<Dipendente> findById(Long id){
        return dipendenteRepository.findById(id);
    }

    public Dipendente save(Dipendente d){
        return DipendenteRepository.save(d);
    }

    public void delete(Dipendente d){
        dipendenteRepository.delete(d);
    }
}
