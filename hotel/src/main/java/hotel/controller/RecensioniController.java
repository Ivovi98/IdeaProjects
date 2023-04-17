package hotel.controller;

import hotel.entity.Recensioni;
import hotel.service.RecensioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recensioni")
@CrossOrigin(allowedHeaders = {"*"})
public class RecensioniController {

    @Autowired
    private RecensioniService recensioniService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Recensioni>> getAllRecensioni(){
        try {
            List<Recensioni> listRecensioni = recensioniService.findAll();
            if(listRecensioni.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listRecensioni, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ BY ID (GET)
    public ResponseEntity<Recensioni> getRecensioneById(@PathVariable Long id){
        Optional<Recensioni> existingRecensione = recensioniService.findById(id);
        try {
            if(existingRecensione.isPresent()){
                return new ResponseEntity<>(existingRecensione.get(), HttpStatus.OK); //200
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PostMapping //CREATE (POST)
    public ResponseEntity<Recensioni> createRecensione(@RequestBody Recensioni recensione) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            recensione.setData_creazione(timestamp);
            Recensioni r = recensioniService.save(recensione); //APPOGGINO
            if(r == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(r, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PutMapping("/{id}") //UPDATE BY ID
    public ResponseEntity<Recensioni> updateRecensioneById(@PathVariable Long id, @RequestBody Recensioni recensione) {

        Optional<Recensioni> existingRecensione = recensioniService.findById(id);

        try {
            if (!existingRecensione.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Recensioni recensioneDiAppoggio = existingRecensione.get();
                recensioneDiAppoggio.setRecensione(recensione.getRecensione());
                recensioneDiAppoggio.setNumero_stelle(recensione.getNumero_stelle());
                recensioneDiAppoggio.setUtente(recensione.getUtente());
                recensioneDiAppoggio.setHotel(recensione.getHotel());
                recensioneDiAppoggio.setVersione(recensione.getVersione());
                recensioneDiAppoggio.setData_ultima_modifica(recensione.getData_ultima_modifica());
                Recensioni recensioneAggiornata = recensioniService.save(recensioneDiAppoggio);
                return new ResponseEntity<>(recensioneAggiornata, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}") //DELETE
    public ResponseEntity<Void> deleteRecensioneById(@PathVariable Long id) {
        Optional<Recensioni> existingRecensioni = recensioniService.findById(id);
        try {
            if (existingRecensioni.isPresent()) {
                recensioniService.delete(existingRecensioni.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato la recensione da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}