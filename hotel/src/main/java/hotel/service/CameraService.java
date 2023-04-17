package hotel.service;

import hotel.entity.Camera;
import hotel.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepository CameraRepository;

    public Optional<Camera> findById(Long id) {
        return CameraRepository.findById(id);
    }

    public Camera save(Camera c) {
        return CameraRepository.save(c);
    }

    public void delete(Camera c) {
        CameraRepository.delete(c);
    }

    public List<Camera> findAll() {
        return CameraRepository.findAll();
    }
}
