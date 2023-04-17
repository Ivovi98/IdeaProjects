package hotel.service;

import hotel.entity.Recensioni;
import hotel.repository.RecensioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensioniService {

    @Autowired
    private RecensioniRepository RecensioniRepository;

    public Optional<Recensioni> findById(Long id) {
        return RecensioniRepository.findById(id);
    }

    public Recensioni save(Recensioni r) {
        return RecensioniRepository.save(r);
    }

    public void delete(Recensioni r) {
        RecensioniRepository.delete(r);
    }

    public List<Recensioni> findAll() {
        return RecensioniRepository.findAll();
    }

}
