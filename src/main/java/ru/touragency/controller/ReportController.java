package ru.touragency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.touragency.service.ReportService;

@Controller
public class ReportController {
    private final ReportService reports;

    public ReportController(ReportService reports) {
        this.reports = reports;
    }

    @GetMapping("/reports")
    public String index() {
        return "reports/index";
    }

    @GetMapping("/reports/tours")
    public String tours(Model model) {
        model.addAttribute("rows", reports.toursReport());
        return "reports/tours";
    }

    @GetMapping("/reports/managers")
    public String managers(Model model) {
        model.addAttribute("rows", reports.managersReport());
        return "reports/managers";
    }

    @GetMapping("/reports/clients")
    public String clients(Model model) {
        model.addAttribute("rows", reports.clientsReport());
        return "reports/clients";
    }
}
