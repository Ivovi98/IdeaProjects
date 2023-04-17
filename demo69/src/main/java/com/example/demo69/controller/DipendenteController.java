package com.example.demo69.controller;

import com.example.demo69.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//CroOrigin è come RequestMapping e RestController come indirizzo e serve a indiciare
//su quale porta, su quale indirizzo girerà il servizio, questo perché il frontend di certi applicativi
//viene avviato su un'altra porta tipo sul 8081

//Dal controller si prendono i service e dai service si prendono le repository
@RequestMapping("/dipendente") //serve a creare le richieste http, in questo controller quando si va sul browser
//e si scrive local host: 8080 /dipendente, il browser va a richiamare il controller dove ci
//saranno messi dei metodi che replichino
//dei metodi GET POST PUT DELETE
@RestController
public class DipendenteController {

    @Autowired
    DipendenteService dipendenteService;

    @GetMapping
    //ResponseEntity è un oggetto di tipo risposta http, a una richiesta corrisponde una risposta
    //che sia un 200 o 400 sempre una risposta viene data, nei controller sempre una risposta
    public ResponseEntity<List<Dipendente>> getAllDipendenti(){
        //Bisogna prima creare la lista e poi la responseEntity che restituirà
        try{
            List<Dipdentente> dipendenteList = dipendenteService.findAll();
            if(dipendenteList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); //nulla da mettere
            }
            return new ResponseEntity<>(dipendenteList, HttpStatus.OK); //costruttore è a due parametri
        //Questo è il caso se tutto va bene, bisogna anche considerare casistiche in cui avremo un 500 internal server error, oppure 404 o 300 ecc

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    //Deve sempre tornare una responseEntity
    @PostMapping                                       //request body serve per passare un payload
    public ResponseEntity<Dipendente> insertDipendente(@RequestBody Dipendente dipendente){
        try {
            //al posto di Optional come abbiamo usato nei metodi prossimi, si può usare il seguente if
            Dipendente d = dipendenteService.insertDipendente(dipendente);
            if(d == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(d, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Per distinguere le richieste, si può modificare l'URL, per esempio nel rigo di sotto @PutMapping si può mettere un id
    //cosi per distinguere le richieste, per esempio in un caso si vuole modificare un dipendente tramite l'ausilio
    //di ricerca tramite nome e cognome sotto si può scrivere nome e cognome invece di id

    //Questo metodo non ha senso di esistere perché non si deve dare un permesso a un utente di modificare l'id, ossia la primary key
    @PutMapping// ("/(id)")  ("/(nome)/(cognome)")   cosi si cerca o tramite id o tramite nome e cognome
    // se due firme sono uguali con id, sul browser poi sarà un problema nella scelta di quale andare ad usare
    //quindi tocca dividerle e capire cosa usare
    //Come i due metodi che seguono
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente){
        Optional<Dipendente> existingDipendente = dipendenteService.findByID(id); //vedere se questo existingDipendente esiste effettivamente...
        if(existingDipendente.isPresent()){ //...altrimenti da null
            dipendente.setId(id);
            Dipendente updatedDipendente = dipendenteService.save(dipendente);
            return ResponseEntity<>(updatedDipendente, HttpStatus.OK);
        }else{
            return new ResponseEntity<Dipendente>(HttpStatus.NOT_FOUND);
        }
    }
    /*
    public ResponseEntity<Dipendente> updateDipendente(PathVariable Long id,
                                                       @RequestParam String nome, @RequestParam String cognome){
        Optional<Dipendente> existingDipendente = dipendenteService.findByID(id);
        if(existingDipendente.isPresent()){
            Dipendente dipendente = existingDipendente.get();
            dipendente.setNome(nome);
            dipendente.setCognome(cognome);
            Dipendente updatedDipendente = dipendenteService.save(dipendente);
            return ResponseEntity<>(updatedDipendente, HttpStatus.OK);
        }else{
            return new ResponseEntity<Dipendente>(HttpStatus.NOT_FOUND);
        }
    }
    */

    //Per risolvere i due metodi con la stessa call:
    @PutMapping("/{id}/{nome}/{cognome}")
    public ResponseEntity<Dipendente> updateDipendente(PathVariable Long id,
                                                       @RequestParam String nome, @RequestParam String cognome){
        try{
            Optional<Dipendente> existingDipendente = dipendenteService.findByID(id);
            if(existingDipendente.isPresent()){
                Dipendente dipendente = existingDipendente.get();
                dipendente.setNome(nome);
                dipendente.setCognome(cognome);
                Dipendente updatedDipendente = dipendenteService.save(dipendente);
                return ResponseEntity<>(updatedDipendente, HttpStatus.OK);
            }else{
                return new ResponseEntity<Dipendente>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //se si ha lo stesso URL ({id}) ma il tipo di richiesta differente (delete al posto di put), di default fa una get da browser.
    //bisogna specificare che tipo di operazione si vuole fare partendo dal solo URL
    //Dietro ogni bottoncino che vediamo in una pagina online sono operazioni di richieste put, delete o quel che siano
    //Il bottoncino che si preme (tipo elimina conversazione da ChatGPT) viene usato un URL per quel bottoncino
    //Se si prende quell'URL per usarlo nella barra di ricerca, non genererà risultati
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id){
        Optional<Dipendente> existingDipendente = dipendenteService.findByID(id);
        try{
            if (existingDipendente.isPresent()){
                dipendenteService.delete(existingDipendente.get());
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
