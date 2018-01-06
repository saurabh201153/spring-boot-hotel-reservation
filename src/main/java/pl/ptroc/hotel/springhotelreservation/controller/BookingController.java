package pl.ptroc.hotel.springhotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.ptroc.hotel.springhotelreservation.exception.NoAvailableRoomsException;
import pl.ptroc.hotel.springhotelreservation.model.Booking;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;
import pl.ptroc.hotel.springhotelreservation.repository.BookingRepository;
import pl.ptroc.hotel.springhotelreservation.repository.HotelRoomRepository;
import pl.ptroc.hotel.springhotelreservation.service.BookingService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @GetMapping("/bookRoom")
    @ResponseBody
    public String bookHotelRoom(@RequestParam(value = "roomSize") int roomSize, @RequestParam(value
            = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam(value =
            "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) throws NoAvailableRoomsException {
        bookingService.bookHotelRoom(roomSize, startDate, endDate);
        return "OK";
    }

    @GetMapping("/getAllBookings")
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @GetMapping("/getAllRooms")
    public List<HotelRoom> getAllRooms() {
        return hotelRoomRepository.findAll();
    }
}
