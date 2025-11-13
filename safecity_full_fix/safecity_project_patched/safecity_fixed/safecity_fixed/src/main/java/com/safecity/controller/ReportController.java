package com.safecity.controller;

import com.safecity.model.Report;
import com.safecity.service.ReportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "*")
public class ReportController {

    private final ReportService service;

    public ReportController(ReportService service) {
        this.service = service;
    }

    // ✅ SUBMIT REPORT
    @PostMapping
    public Report create(@RequestBody Report report) {
        return service.save(report);
    }

    // ✅ GET RECENT REPORTS
    @GetMapping
    public List<Report> getRecent() {
        return service.recent();
    }

    // ✅ GET A SINGLE REPORT
    @GetMapping("/{id}")
    public Optional<Report> getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
