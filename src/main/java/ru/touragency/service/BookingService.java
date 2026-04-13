package ru.touragency.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.touragency.dto.BookingCreateForm;
import ru.touragency.dto.BookingTouristCreateForm;
import ru.touragency.entity.*;
import ru.touragency.repository.*;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookings;
    private final TouristRequestRepository requests;
    private final ManagerRepository managers;
    private final TourRepository tours;
    private final BookingStatusRepository statuses;
    private final BookingTouristRepository bookingTourists;
    private final TouristRepository tourists;

    public BookingService(BookingRepository bookings, TouristRequestRepository requests, ManagerRepository managers,
                          TourRepository tours, BookingStatusRepository statuses,
                          BookingTouristRepository bookingTourists, TouristRepository tourists) {
        this.bookings = bookings;
        this.requests = requests;
        this.managers = managers;
        this.tours = tours;
        this.statuses = statuses;
        this.bookingTourists = bookingTourists;
        this.tourists = tourists;
    }

    public List<Booking> findAll() { return bookings.findAll(); }
    public Booking findById(Integer id) { return bookings.findById(id).orElseThrow(); }
    public List<BookingTourist> findTouristsByBookingId(Integer bookingId) { return bookingTourists.findByBookingId(bookingId); }

    @Transactional
    public Booking create(BookingCreateForm form) {
        if (bookings.existsByRequestId(form.getRequestId())) {
            throw new IllegalStateException("Для обращения уже существует бронирование");
        }
        Booking booking = new Booking();
        booking.setRequest(requests.findById(form.getRequestId()).orElseThrow());
        booking.setBookingManager(managers.findById(form.getManagerId()).orElseThrow());
        Tour tour = tours.findById(form.getTourCode()).orElseThrow();
        booking.setTour(tour);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus(statuses.findById(form.getStatusName()).orElseThrow());
        booking.setTotalPrice(tour.getPrice());
        booking.setManagerComment(form.getManagerComment());
        return bookings.save(booking);
    }

    @Transactional
    public void addTourist(BookingTouristCreateForm form) {
        Booking booking = bookings.findById(form.getBookingId()).orElseThrow();
        Tourist tourist = tourists.findById(form.getTouristId()).orElseThrow();

        BookingTourist link = new BookingTourist();
        BookingTouristId id = new BookingTouristId();
        id.setBookingId(booking.getId());
        id.setTouristId(tourist.getId());
        link.setId(id);
        link.setBooking(booking);
        link.setTourist(tourist);
        bookingTourists.save(link);
    }
}
