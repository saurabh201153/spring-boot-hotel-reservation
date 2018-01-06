package pl.ptroc.hotel.springhotelreservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ptroc.hotel.springhotelreservation.model.Booking;
import pl.ptroc.hotel.springhotelreservation.model.HotelRoom;
import pl.ptroc.hotel.springhotelreservation.repository.BookingRepository;
import pl.ptroc.hotel.springhotelreservation.service.BookingService;
import pl.ptroc.hotel.springhotelreservation.service.HotelRoomService;
import pl.ptroc.hotel.springhotelreservation.utils.BookingUtils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paweł Troć on 2018-01-06.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private HotelRoomService hotelRoomService;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking bookHotelRoom(int roomSize, LocalDate beginDate, LocalDate endDate) {
        HotelRoom hotelRoom = getHotelRoomForBooking(roomSize, beginDate, endDate);
        //TODO null-check for hotelRoom
        Booking booking = new Booking(hotelRoom, null, beginDate, endDate);
        return bookingRepository.save(booking);
    }

    @Override
    public HotelRoom getHotelRoomForBooking(int roomSize, LocalDate beginDate, LocalDate endDate) {
        List<HotelRoom> hotelRoomList = hotelRoomService.getHotelRoomBySize(roomSize);
        if (!hotelRoomList.isEmpty()) {
            Map<HotelRoom, List<Booking>> bookingsForHotelRoom = new HashMap<>();

            for (HotelRoom hotelRoom : hotelRoomList) {
                List<Booking> futureBookingsForHotelRoom = checkIsRoomHasActiveBookings(hotelRoom, beginDate);
                if (futureBookingsForHotelRoom.isEmpty()) return hotelRoom;
                bookingsForHotelRoom.put(hotelRoom, futureBookingsForHotelRoom);
            }

            for (Map.Entry<HotelRoom, List<Booking>> entry : bookingsForHotelRoom.entrySet()) {
                if (BookingUtils.isBookingAvailable(entry.getValue(), beginDate, endDate)) return entry.getKey();
            }

        }
        return null;
    }

    private List<Booking> checkIsRoomHasActiveBookings(HotelRoom hotelRoom, LocalDate startDate) {
        return bookingRepository.findByHotelRoomAndEndDateGreaterThanOrderByEndDateAsc(hotelRoom, startDate);
    }
}
