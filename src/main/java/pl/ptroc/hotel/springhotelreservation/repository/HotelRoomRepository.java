package pl.ptroc.hotel.springhotelreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;

import java.util.List;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {

    List<HotelRoom> findBySize(Integer size);
}
