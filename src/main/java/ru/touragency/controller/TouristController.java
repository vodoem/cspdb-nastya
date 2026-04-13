package ru.touragency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.touragency.repository.BookingTouristRepository;
import ru.touragency.repository.TouristRepository;

@Controller
public class TouristController {
    private final TouristRepository tourists;
    private final BookingTouristRepository bookingTourists;

    public TouristController(TouristRepository tourists, BookingTouristRepository bookingTourists) {
        this.tourists = tourists;
        this.bookingTourists = bookingTourists;
    }

    @GetMapping("/tourists")
    public String list(Model model) {
        model.addAttribute("tourists", tourists.findAll());
        return "tourists/list";
    }

    @GetMapping("/tourists/{id}")
    public String card(@PathVariable Integer id, Model model) {
        model.addAttribute("tourist", tourists.findById(id).orElseThrow());
        model.addAttribute("bookings", bookingTourists.findByTouristId(id));
        return "tourists/card";
    }
}
