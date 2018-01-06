package pl.ptroc.hotel.springhotelreservation.service;

import pl.ptroc.hotel.springhotelreservation.exception.NoAvailableRoomsException;
import pl.ptroc.hotel.springhotelreservation.model.Booking;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;

import java.time.LocalDate;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
public interface BookingService {

    Booking bookHotelRoom(int roomSize, LocalDate beginDate, LocalDate endDate) throws NoAvailableRoomsException;

    HotelRoom getHotelRoomForBooking(int roomSize, LocalDate beginDate, LocalDate endDate) throws NoAvailableRoomsException;
}
