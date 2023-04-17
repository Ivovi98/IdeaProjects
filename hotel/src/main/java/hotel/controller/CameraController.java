package hotel.controller;

import hotel.entity.Camera;
import hotel.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/camera")
@CrossOrigin(allowedHeaders = {"*"})
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Camera>> getAllCamera(){
        try {
            List<Camera> listCamera = cameraService.findAll();
            if(listCamera.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listCamera, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Camera> getCamera (@PathVariable Long id) {
        Optional<Camera> existingCamera = cameraService.findById(id);
        try {
            if (existingCamera.isPresent()) {
                return new ResponseEntity<>(existingCamera.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Camera> createCamera(@RequestBody Camera camera) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            camera.setData_creazione(timestamp);
            Camera c = cameraService.save(camera); //APPOGGINO
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera> updateCamera(@PathVariable Long id, @RequestBody Camera camera) {
        Optional<Camera> existingCamera = cameraService.findById(id);

        try {
            if (!existingCamera.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Camera cameraDiAppoggio = existingCamera.get();
                cameraDiAppoggio.setTipologia(camera.getTipologia());
                cameraDiAppoggio.setNumero_camera(camera.getNumero_camera());
                cameraDiAppoggio.setCosto(camera.getCosto());
                cameraDiAppoggio.setHotel(camera.getHotel());
                cameraDiAppoggio.setVersione(camera.getVersione());
                cameraDiAppoggio.setData_ultima_modifica(camera.getData_ultima_modifica());
                Camera cameraAggiornata = cameraService.save(cameraDiAppoggio);
                return new ResponseEntity<>(cameraAggiornata, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCameraById(@PathVariable Long id) {
        Optional<Camera> existingCamera = cameraService.findById(id);
        try {
            if (existingCamera.isPresent()) {
                cameraService.delete(existingCamera.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}
