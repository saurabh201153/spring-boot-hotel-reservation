package pl.ptroc.hotel.springhotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;
import pl.ptroc.hotel.springhotelreservation.service.HotelRoomService;

import java.util.List;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
@RestController
public class HotelRoomController {

    @Autowired
    private HotelRoomService hotelRoomService;

    @GetMapping("/getBySize/{roomSize}")
    public List<HotelRoom> getHotelRoomListBySize(@PathVariable(value = "roomSize") int roomSize) {
        return hotelRoomService.getHotelRoomListBySize(roomSize);
    }
}
