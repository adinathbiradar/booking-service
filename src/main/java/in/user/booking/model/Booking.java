package in.user.booking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;  
    private int hotelId;  

    private int rooms;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int guests;
    private double totalPrice;
    private String status;  // confirmed, cancelled, pending
}
