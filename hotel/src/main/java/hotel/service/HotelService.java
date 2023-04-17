package hotel.service;

import hotel.entity.Hotel;
import hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository HotelRepository;

    public Optional<Hotel> findById(Long id) {
        return HotelRepository.findById(id);
    }

    public Hotel save(Hotel h) {
        return HotelRepository.save(h);
    }

    public void delete(Hotel h) {
        HotelRepository.delete(h);
    }

    public List<Hotel> findAll() {
        return HotelRepository.findAll();
    }
}
