package hotel.controller;

import hotel.entity.Utente;
import hotel.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
@CrossOrigin(allowedHeaders = {"*"})
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Utente>> getAllUtente(){
        try {
            List<Utente> listUtenti = utenteService.findAll();
            if(listUtenti.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listUtenti, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ BY ID (GET)
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id){
        Optional<Utente> existingUtente = utenteService.findById(id);
        try {
            if(existingUtente.isPresent()){
                return new ResponseEntity<>(existingUtente.get(), HttpStatus.OK); //200
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PostMapping //CREATE (POST)
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            utente.setData_creazione(timestamp);
            Utente u = utenteService.save(utente); //APPOGGINO
            if(u == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(u, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PutMapping("/{id}") //UPDATE BY ID
    public ResponseEntity<Utente> updateUtenteById(@PathVariable Long id, @RequestBody Utente u) {

        Optional<Utente> existingUtente = utenteService.findById(id);

        try {
            if (!existingUtente.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Utente utenteDiAppoggio = existingUtente.get();
                utenteDiAppoggio.setNome(u.getNome());
                utenteDiAppoggio.setCognome(u.getCognome());
                utenteDiAppoggio.setData_di_nascita(u.getData_di_nascita());
                utenteDiAppoggio.setNumero_telefono(u.getNumero_telefono());
                utenteDiAppoggio.setEmail(u.getEmail());
                utenteDiAppoggio.setVersione(u.getVersione());
                utenteDiAppoggio.setData_ultima_modifica(u.getData_ultima_modifica());
                Utente utenteAggiornato = utenteService.save(utenteDiAppoggio);
                return new ResponseEntity<>(utenteAggiornato, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}") //DELETE BY ID
    public ResponseEntity<Void> deleteUtenteById(@PathVariable Long id) {
        Optional<Utente> existingUtente = utenteService.findById(id);
        try {
            if (existingUtente.isPresent()) {
                utenteService.delete(existingUtente.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}
