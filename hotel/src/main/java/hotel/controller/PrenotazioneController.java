package hotel.controller;

import hotel.entity.Prenotazione;
import hotel.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prenotazione")
@CrossOrigin(allowedHeaders = {"*"})
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Prenotazione>> getAllPrenotazioni(){
        try {
            List<Prenotazione> listPrenotazioni = prenotazioneService.findAll();
            if(listPrenotazioni.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listPrenotazioni, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
    @GetMapping("/{id}") //READ BY ID (GET)
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id){
        Optional<Prenotazione> existingPrenotazione = prenotazioneService.findById(id);
        try {
            if(existingPrenotazione.isPresent()){
                return new ResponseEntity<>(existingPrenotazione.get(), HttpStatus.OK); //200
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PostMapping //CREATE (POST)
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione pr) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            pr.setData_creazione(timestamp);
            Prenotazione p = prenotazioneService.save(pr); //APPOGGINO
            if(p == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(p, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PutMapping("/{id}") //UPDATE BY ID
    public ResponseEntity<Prenotazione> updatePrenotazioneById(@PathVariable Long id, @RequestBody Prenotazione p) {

        Optional<Prenotazione> existingPrenotazione = prenotazioneService.findById(id);

        try {
            if (!existingPrenotazione.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Prenotazione prenotazioneDiAppoggio = existingPrenotazione.get();
                prenotazioneDiAppoggio.setData_inizio(p.getData_inizio());
                prenotazioneDiAppoggio.setData_fine(p.getData_fine());
                prenotazioneDiAppoggio.setUtente(p.getUtente());
                prenotazioneDiAppoggio.setCamera(p.getCamera());
                prenotazioneDiAppoggio.setVersione(p.getVersione());
                prenotazioneDiAppoggio.setData_ultima_modifica(p.getData_ultima_modifica());
                Prenotazione prenotazioneAggiornata = prenotazioneService.save(prenotazioneDiAppoggio);
                return new ResponseEntity<>(prenotazioneAggiornata, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}") //DELETE BY ID
    public ResponseEntity<Void> deletePrenotazioneById(@PathVariable Long id) {
        Optional<Prenotazione> existingPrenotazione = prenotazioneService.findById(id);
        try {
            if (existingPrenotazione.isPresent()) {
                prenotazioneService.delete(existingPrenotazione.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato la prenotazione da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}