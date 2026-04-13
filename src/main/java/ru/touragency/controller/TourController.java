package ru.touragency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.touragency.repository.TourRepository;

@Controller
public class TourController {
    private final TourRepository tours;

    public TourController(TourRepository tours) { this.tours = tours; }

    @GetMapping("/tours")
    public String list(Model model) {
        model.addAttribute("tours", tours.findAll());
        return "tours/list";
    }

    @GetMapping("/tours/{id}")
    public String card(@PathVariable("id") String id, Model model) {
        model.addAttribute("tour", tours.findById(id).orElseThrow());
        return "tours/card";
    }
}
