package hotel.service;

import hotel.entity.Utente;
import hotel.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository UtenteRepository;

    public Optional<Utente> findById(Long id) {
        return UtenteRepository.findById(id);
    }

    public Utente save(Utente u) {
        return UtenteRepository.save(u);
    }

    public void delete(Utente u) {
        UtenteRepository.delete(u);
    }

    public List<Utente> findAll() {
        return UtenteRepository.findAll();
    }
}
