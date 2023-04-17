package com.iet.parrucchieria.controller;

import com.iet.parrucchieria.entity.Dipendente;
import com.iet.parrucchieria.entity.Servizio;
import com.iet.parrucchieria.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RequestMapping("/dipendente")
@RestController
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public ResponseEntity<List<Dipendente>> getAllDipendenti(){
        try {
            List<Dipendente> dipendenteList = dipendenteService.findAll();
            if(dipendenteList.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dipendenteList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}/servizi")
    public ResponseEntity<List<Servizio>> getAllServiziByDipendente(@PathVariable Long id){
        try {
            List<Servizio> servizioList = dipendenteService.findAllServiziByDipendente(id);
            if(servizioList.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(servizioList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id){
        Optional<Dipendente> existingDipendente = dipendenteService.findById(id);
        try {
            if(existingDipendente.isPresent()){
                return new ResponseEntity<>(existingDipendente.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Dipendente> insertDipendente(@RequestBody Dipendente dipendente){
        try {
            Dipendente d = dipendenteService.insertDipendente(dipendente);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}/{nome}/{cognome}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id,
                                                       @PathVariable String nome, @PathVariable String cognome){
        Optional<Dipendente> existingDipendente = dipendenteService.findById(id);
        try {
            if(existingDipendente.isPresent()){
                Dipendente dipendente = existingDipendente.get();
                dipendente.setNome(nome);
                dipendente.setCognome(cognome);
                dipendente.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                dipendente.setVersione(dipendente.getVersione() + 1);
                Dipendente updatedDipendente = dipendenteService.save(dipendente);
                return new ResponseEntity<>(updatedDipendente, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id){
        Optional<Dipendente> existingDipendente = dipendenteService.findById(id);
        try {
            if(existingDipendente.isPresent()){
                dipendenteService.delete(existingDipendente.get());
                return new ResponseEntity<>(HttpStatus.OK); //eliminazione effettuata
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
