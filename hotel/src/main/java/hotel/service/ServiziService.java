package hotel.service;

import hotel.entity.Servizi;
import hotel.repository.ServiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiziService {

    @Autowired
    private ServiziRepository ServiziRepository;

    public Optional<Servizi> findById(Long id) {
        return ServiziRepository.findById(id);
    }

    public Servizi save(Servizi s) {
        return ServiziRepository.save(s);
    }

    public void delete(Servizi s) {
        ServiziRepository.delete(s);
    }

    public List<Servizi> findAll() {
        return ServiziRepository.findAll();
    }

}
