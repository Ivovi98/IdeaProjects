package hotel.controller;

import hotel.entity.Servizi;
import hotel.service.ServiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servizi")
@CrossOrigin(allowedHeaders = {"*"})
public class ServiziController {

    @Autowired
    private ServiziService serviziService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Servizi>> getAllServizi(){
        try {
            List<Servizi> listServizi = serviziService.findAll();
            if(listServizi.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listServizi, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ BY ID (GET)
    public ResponseEntity<Servizi> getServizioById(@PathVariable Long id){
        Optional<Servizi> existingServizio = serviziService.findById(id);
        try {
            if(existingServizio.isPresent()){
                return new ResponseEntity<>(existingServizio.get(), HttpStatus.OK); //200
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PostMapping //CREATE (POST)
    public ResponseEntity<Servizi> createServizio(@RequestBody Servizi servizio) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            servizio.setData_creazione(timestamp);
            Servizi s = serviziService.save(servizio); //APPOGGINO
            if(s == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
            }
            return new ResponseEntity<>(s, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @PutMapping("/{id}") //UPDATE BY ID
    public ResponseEntity<Servizi> updateServizioById(@PathVariable Long id, @RequestBody Servizi s) {

        Optional<Servizi> existingServizio = serviziService.findById(id);

        try {
            if (!existingServizio.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Servizi servizioDiAppoggio = existingServizio.get();
                servizioDiAppoggio.setNome(s.getNome());
                servizioDiAppoggio.setVersione(s.getVersione());
                servizioDiAppoggio.setData_ultima_modifica(s.getData_ultima_modifica());
                Servizi servizioAggiornato = serviziService.save(servizioDiAppoggio);
                return new ResponseEntity<>(servizioAggiornato, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}") //DELETE
    public ResponseEntity<Void> deleteServiziById(@PathVariable Long id) {
        Optional<Servizi> existingServizi = serviziService.findById(id);
        try {
            if (existingServizi.isPresent()) {
                serviziService.delete(existingServizi.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}
