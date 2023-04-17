package hotel.service;

import hotel.entity.Camera_Servizi;
import hotel.repository.Camera_ServiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Camera_ServiziService {

    @Autowired
    private Camera_ServiziRepository Camera_ServiziRepository;

    public Optional<Camera_Servizi> findById(Long id) {
        return Camera_ServiziRepository.findById(id);
    }

    public Camera_Servizi save(Camera_Servizi cs) {
        return Camera_ServiziRepository.save(cs);
    }

    public void delete(Camera_Servizi cs) {
        Camera_ServiziRepository.delete(cs);
    }

    public List<Camera_Servizi> findAll() {
        return Camera_ServiziRepository.findAll();
    }
}
