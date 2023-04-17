package hotel.controller;

import hotel.entity.Camera_Servizi;
import hotel.service.Camera_ServiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/camera_servizi")
@CrossOrigin(allowedHeaders = {"*"})
public class Camera_ServiziController {

    @Autowired
    private Camera_ServiziService camera_ServiziService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Camera_Servizi>> getAllCamera_Servizi(){
        try {
            List<Camera_Servizi> listCamera_Servizi = camera_ServiziService.findAll();
            if(listCamera_Servizi.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listCamera_Servizi, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Camera_Servizi> getCamera_ServiziById(@PathVariable Long id) {
        Optional<Camera_Servizi> existingCamera_Servizi = camera_ServiziService.findById(id);
        try {
            if (existingCamera_Servizi.isPresent()) {
                return new ResponseEntity<>(existingCamera_Servizi.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Camera_Servizi> createCamera_Servizi(@RequestBody Camera_Servizi camera_Servizi) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            camera_Servizi.setData_creazione(timestamp);
            Camera_Servizi p = camera_ServiziService.save(camera_Servizi); //APPOGGINO
            if (p == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera_Servizi> updateCamera_Servizi(@PathVariable Long id, @RequestBody Camera_Servizi cs) {
        Optional<Camera_Servizi> existingCamera_Servizi = camera_ServiziService.findById(id);

        try {
            if (!existingCamera_Servizi.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Camera_Servizi csDiAppoggio = existingCamera_Servizi.get();
                csDiAppoggio.setServizi(cs.getServizi());
                csDiAppoggio.setCamera(cs.getCamera());
                csDiAppoggio.setVersione(cs.getVersione());
                csDiAppoggio.setData_ultima_modifica(cs.getData_ultima_modifica());
                Camera_Servizi csAggiornata = camera_ServiziService.save(csDiAppoggio);
                return new ResponseEntity<>(csAggiornata, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamera_ServiziById(@PathVariable Long id) {
        Optional<Camera_Servizi> existingCamera_Servizi = camera_ServiziService.findById(id);
        try {
            if (existingCamera_Servizi.isPresent()) {
                camera_ServiziService.delete(existingCamera_Servizi.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}