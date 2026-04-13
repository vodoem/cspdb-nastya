package ru.touragency.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.touragency.dto.BookingTouristCreateForm;
import ru.touragency.service.BookingService;
import ru.touragency.service.LookupService;

@Controller
public class BookingController {
    private final BookingService bookings;
    private final LookupService lookup;

    public BookingController(BookingService bookings, LookupService lookup) {
        this.bookings = bookings;
        this.lookup = lookup;
    }

    @GetMapping("/bookings")
    public String list(Model model) {
        model.addAttribute("bookings", bookings.findAll());
        return "bookings/list";
    }

    @GetMapping("/bookings/{id}")
    public String card(@PathVariable Integer id, Model model) {
        model.addAttribute("booking", bookings.findById(id));
        model.addAttribute("tourists", bookings.findTouristsByBookingId(id));
        return "bookings/card";
    }

    @GetMapping("/booking-tourists/new")
    public String addTouristForm(Model model) {
        model.addAttribute("form", new BookingTouristCreateForm());
        model.addAttribute("bookings", lookup.bookings().findAll());
        model.addAttribute("tourists", lookup.tourists().findAll());
        return "bookings/add-tourist";
    }

    @PostMapping("/booking-tourists")
    public String addTourist(@Valid @ModelAttribute("form") BookingTouristCreateForm form,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("bookings", lookup.bookings().findAll());
            model.addAttribute("tourists", lookup.tourists().findAll());
            return "bookings/add-tourist";
        }
        bookings.addTourist(form);
        return "redirect:/bookings/" + form.getBookingId();
    }
}
