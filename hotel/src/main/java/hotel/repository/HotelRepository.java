package hotel.repository;

import hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

    //Per la findAll in Service non serve
    @Query("select h from Hotel h")
    List<Hotel> findAll();
}
