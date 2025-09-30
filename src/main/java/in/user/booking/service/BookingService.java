package in.user.booking.service;

import in.user.booking.model.Booking;
import in.user.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    // Create booking
    public Booking createBooking(Booking booking) {
        booking.setStatus("confirmed"); // default status
        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get bookings by user
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // Get bookings by hotel
    public List<Booking> getBookingsByHotel(int hotelId) {
        return bookingRepository.findByHotelId(hotelId);
    }

    // Cancel booking
    public Booking cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Booking not found")
        );
        booking.setStatus("cancelled");
        return bookingRepository.save(booking);
    }
    
    //delete booking
    public void deleteBooking(Long id) {
    	bookingRepository.deleteById(id);
    }
    
    
}
