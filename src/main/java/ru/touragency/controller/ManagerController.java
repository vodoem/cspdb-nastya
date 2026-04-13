package ru.touragency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.touragency.repository.BookingRepository;
import ru.touragency.repository.ManagerRepository;
import ru.touragency.repository.TouristRequestRepository;

@Controller
public class ManagerController {
    private final ManagerRepository managers;
    private final TouristRequestRepository requests;
    private final BookingRepository bookings;

    public ManagerController(ManagerRepository managers, TouristRequestRepository requests, BookingRepository bookings) {
        this.managers = managers;
        this.requests = requests;
        this.bookings = bookings;
    }

    @GetMapping("/managers")
    public String list(Model model) {
        model.addAttribute("managers", managers.findAll());
        return "managers/list";
    }

    @GetMapping("/managers/{id}")
    public String card(@PathVariable Integer id, Model model) {
        model.addAttribute("manager", managers.findById(id).orElseThrow());
        model.addAttribute("requests", requests.findByManagerId(id));
        model.addAttribute("bookings", bookings.findByBookingManagerId(id));
        return "managers/card";
    }
}
