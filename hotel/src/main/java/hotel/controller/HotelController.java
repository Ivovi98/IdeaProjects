package hotel.controller;

import hotel.entity.Hotel;
import hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(allowedHeaders = {"*"})
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping //READ ALL (GET ALL)
    public ResponseEntity<List<Hotel>> getAllHotel(){
        try {
            List<Hotel> listHotel = hotelService.findAll();
            if(listHotel.isEmpty()){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); //204
            }
            else{
                return new ResponseEntity<>(listHotel, HttpStatus.OK); //200
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Optional<Hotel> existingHotel = hotelService.findById(id);
        try {
            if (existingHotel.isPresent()) {
                return new ResponseEntity<>(existingHotel.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            hotel.setData_creazione(timestamp);
            Hotel c = hotelService.save(hotel); //APPOGGINO
            if (c == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        Optional<Hotel> existingHotel = hotelService.findById(id);

        try {
            if (!existingHotel.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
            } else {
                Hotel hotelDiAppoggio = existingHotel.get();
                hotelDiAppoggio.setTipologia(hotel.getTipologia());
                hotelDiAppoggio.setNome(hotel.getNome());
                hotelDiAppoggio.setStelle(hotel.getStelle());
                hotelDiAppoggio.setVersione(hotel.getVersione());
                hotelDiAppoggio.setData_ultima_modifica(hotel.getData_ultima_modifica());
                Hotel hotelAggiornata = hotelService.save(hotelDiAppoggio);
                return new ResponseEntity<>(hotelAggiornata, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Long id) {
        Optional<Hotel> existingHotel = hotelService.findById(id);
        try {
            if (existingHotel.isPresent()) {
                hotelService.delete(existingHotel.get());
                return new ResponseEntity<>(HttpStatus.OK); // 200 eliminazione effettuata
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 non è stato trovato il dipendente da eliminare
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500
        }
    }
}
