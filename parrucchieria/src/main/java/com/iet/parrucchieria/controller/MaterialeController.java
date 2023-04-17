package com.iet.parrucchieria.controller;

import com.iet.parrucchieria.entity.Materiale;
import com.iet.parrucchieria.service.MaterialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/materiale")
public class MaterialeController {

    @Autowired
    private MaterialeService materialeService;

    @GetMapping("/{id}")
    public ResponseEntity<Materiale> getMaterialeById(Long id){
        try {
            Optional<Materiale> materiale = materialeService.findById(id);
            if(materiale.isPresent()){
                return new ResponseEntity<>(materiale.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TODO POST, PUT, DELETE
}
