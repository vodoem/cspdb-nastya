package ru.touragency.service;

import org.springframework.stereotype.Service;
import ru.touragency.dto.ClientReportRow;
import ru.touragency.dto.ManagerReportRow;
import ru.touragency.dto.TourReportRow;
import ru.touragency.repository.BookingRepository;
import ru.touragency.repository.ManagerRepository;
import ru.touragency.repository.TourRepository;
import ru.touragency.repository.TouristRequestRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final TourRepository tours;
    private final BookingRepository bookings;
    private final ManagerRepository managers;
    private final TouristRequestRepository requests;
    private final ru.touragency.repository.ClientRepository clients;

    public ReportService(TourRepository tours, BookingRepository bookings, ManagerRepository managers,
                         TouristRequestRepository requests, ru.touragency.repository.ClientRepository clients) {
        this.tours = tours;
        this.bookings = bookings;
        this.managers = managers;
        this.requests = requests;
        this.clients = clients;
    }

    public List<TourReportRow> toursReport() {
        var allBookings = bookings.findAll();
        return tours.findAll().stream().map(t -> new TourReportRow(
                t.getTourCode(), t.getTourName(), t.getDirection().getDirectionName(), t.getPrice(),
                allBookings.stream().filter(b -> b.getTour().getTourCode().equals(t.getTourCode())).count()
        )).collect(Collectors.toList());
    }

    public List<ManagerReportRow> managersReport() {
        var allRequests = requests.findAll();
        var allBookings = bookings.findAll();
        return managers.findAll().stream().map(m -> new ManagerReportRow(
                m.getId(), m.getFullName(),
                allRequests.stream().filter(r -> r.getManager().getId().equals(m.getId())).count(),
                allBookings.stream().filter(b -> b.getBookingManager().getId().equals(m.getId())).count()
        )).collect(Collectors.toList());
    }

    public List<ClientReportRow> clientsReport() {
        var allBookings = bookings.findAll();
        return clients.findAll().stream().map(c -> {
            var clientBookings = allBookings.stream().filter(b -> b.getRequest().getClient().getId().equals(c.getId())).toList();
            BigDecimal sum = clientBookings.stream().map(b -> b.getTotalPrice() == null ? BigDecimal.ZERO : b.getTotalPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return new ClientReportRow(c.getId(), c.getFullName(), (long) clientBookings.size(), sum);
        }).collect(Collectors.toList());
    }
}
