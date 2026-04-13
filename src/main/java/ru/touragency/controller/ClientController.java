package ru.touragency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.touragency.repository.BookingRepository;
import ru.touragency.repository.ClientRepository;
import ru.touragency.repository.TouristRequestRepository;

@Controller
public class ClientController {
    private final ClientRepository clients;
    private final TouristRequestRepository requests;
    private final BookingRepository bookings;

    public ClientController(ClientRepository clients, TouristRequestRepository requests, BookingRepository bookings) {
        this.clients = clients;
        this.requests = requests;
        this.bookings = bookings;
    }

    @GetMapping("/clients")
    public String list(Model model) {
        model.addAttribute("clients", clients.findAll());
        return "clients/list";
    }

    @GetMapping("/clients/{id}")
    public String card(@PathVariable Integer id, Model model) {
        model.addAttribute("client", clients.findById(id).orElseThrow());
        model.addAttribute("requests", requests.findByClientId(id));
        model.addAttribute("bookings", bookings.findByRequestClientId(id));
        return "clients/card";
    }
}
