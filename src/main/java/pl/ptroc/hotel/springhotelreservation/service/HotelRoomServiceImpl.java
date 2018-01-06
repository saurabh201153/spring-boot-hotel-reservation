package pl.ptroc.hotel.springhotelreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;
import pl.ptroc.hotel.springhotelreservation.repository.HotelRoomRepository;

import java.util.List;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
@Service
public class HotelRoomServiceImpl implements HotelRoomService {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @Override
    public void createCustomer() {

    }

    @Override
    public List<HotelRoom> getHotelRoomListBySize(int size) {
        return hotelRoomRepository.findBySize(size);
    }
}
