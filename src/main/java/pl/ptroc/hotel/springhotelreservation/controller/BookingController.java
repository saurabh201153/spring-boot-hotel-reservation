package pl.ptroc.hotel.springhotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.ptroc.hotel.springhotelreservation.model.Booking;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;
import pl.ptroc.hotel.springhotelreservation.service.BookingService;
import pl.ptroc.hotel.springhotelreservation.service.HotelRoomService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/getBySize/{roomSize}/{startDate}/{endDate}")
    public Booking bookHotelRoom(@PathVariable(value = "roomSize") int roomSize, @PathVariable(value
            = "startDate") LocalDate startDate, @PathVariable(value = "endDate") LocalDate endDate) {
        return bookingService.bookHotelRoom(roomSize, startDate, endDate);
    }
}
