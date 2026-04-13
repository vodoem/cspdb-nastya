package ru.touragency.service;

import org.springframework.stereotype.Service;
import ru.touragency.repository.*;

@Service
public class LookupService {
    private final ClientRepository clients;
    private final ManagerRepository managers;
    private final DirectionRepository directions;
    private final RequestStatusRepository requestStatuses;
    private final BookingStatusRepository bookingStatuses;
    private final TourRepository tours;
    private final TouristRepository tourists;
    private final BookingRepository bookings;

    public LookupService(ClientRepository clients, ManagerRepository managers, DirectionRepository directions,
                         RequestStatusRepository requestStatuses, BookingStatusRepository bookingStatuses,
                         TourRepository tours, TouristRepository tourists, BookingRepository bookings) {
        this.clients = clients;
        this.managers = managers;
        this.directions = directions;
        this.requestStatuses = requestStatuses;
        this.bookingStatuses = bookingStatuses;
        this.tours = tours;
        this.tourists = tourists;
        this.bookings = bookings;
    }

    public ClientRepository clients() { return clients; }
    public ManagerRepository managers() { return managers; }
    public DirectionRepository directions() { return directions; }
    public RequestStatusRepository requestStatuses() { return requestStatuses; }
    public BookingStatusRepository bookingStatuses() { return bookingStatuses; }
    public TourRepository tours() { return tours; }
    public TouristRepository tourists() { return tourists; }
    public BookingRepository bookings() { return bookings; }
}
