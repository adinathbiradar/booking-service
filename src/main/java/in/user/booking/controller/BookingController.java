package in.user.booking.controller;

import in.user.booking.model.Booking;
import in.user.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // Create a booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    // Get bookings by user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    // Get bookings by hotel
    @GetMapping("/hotel/{hotelId}")
    public List<Booking> getBookingsByHotel(@PathVariable int hotelId) {
        return bookingService.getBookingsByHotel(hotelId);
    }

    // Cancel a booking
    @PutMapping("/cancel/{id}")
    public Booking cancelBooking(@PathVariable Long id) {
        return bookingService.cancelBooking(id);
    }
    
    @DeleteMapping("{id}")
    public void deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
    }

    
}
