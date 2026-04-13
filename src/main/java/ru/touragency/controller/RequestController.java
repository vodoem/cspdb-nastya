package ru.touragency.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.touragency.dto.BookingCreateForm;
import ru.touragency.dto.RequestCreateForm;
import ru.touragency.service.BookingService;
import ru.touragency.service.LookupService;
import ru.touragency.service.TouristRequestService;

@Controller
@RequestMapping("/requests")
public class RequestController {
    private final TouristRequestService requestService;
    private final LookupService lookup;
    private final BookingService bookingService;

    public RequestController(TouristRequestService requestService, LookupService lookup, BookingService bookingService) {
        this.requestService = requestService;
        this.lookup = lookup;
        this.bookingService = bookingService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("requests", requestService.findAll());
        return "requests/list";
    }

    @GetMapping("/{id}")
    public String card(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestService.findById(id));
        model.addAttribute("bookingForm", new BookingCreateForm());
        model.addAttribute("managers", lookup.managers().findAll());
        model.addAttribute("tours", lookup.tours().findAll());
        model.addAttribute("bookingStatuses", lookup.bookingStatuses().findAll());
        return "requests/card";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("form", new RequestCreateForm());
        fillFormLists(model);
        return "requests/new";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("form") RequestCreateForm form,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            fillFormLists(model);
            return "requests/new";
        }
        requestService.create(form);
        return "redirect:/requests";
    }

    @PostMapping("/{id}/booking")
    public String createBooking(@PathVariable Integer id,
                                @Valid @ModelAttribute("bookingForm") BookingCreateForm form,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        form.setRequestId(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("request", requestService.findById(id));
            model.addAttribute("managers", lookup.managers().findAll());
            model.addAttribute("tours", lookup.tours().findAll());
            model.addAttribute("bookingStatuses", lookup.bookingStatuses().findAll());
            return "requests/card";
        }
        try {
            bookingService.create(form);
            return "redirect:/bookings";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/requests/" + id;
        }
    }

    private void fillFormLists(Model model) {
        model.addAttribute("clients", lookup.clients().findAll());
        model.addAttribute("managers", lookup.managers().findAll());
        model.addAttribute("directions", lookup.directions().findAll());
    }
}
