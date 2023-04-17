package hotel.service;

import hotel.entity.Prenotazione;
import hotel.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository PrenotazioneRepository;

    public Optional<Prenotazione> findById(Long id) {
        return PrenotazioneRepository.findById(id);
    }

    public Prenotazione save(Prenotazione p) {
        return PrenotazioneRepository.save(p);
    }

    public void delete(Prenotazione p) {
        PrenotazioneRepository.delete(p);
    }

    public List<Prenotazione> findAll() {
        return PrenotazioneRepository.findAll();
    }

}
