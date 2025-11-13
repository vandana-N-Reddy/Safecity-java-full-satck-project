package com.safecity.controller;

import com.safecity.model.Report;
import com.safecity.repository.ReportRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final ReportRepository reportRepo;

    public AdminController(ReportRepository reportRepo) {
        this.reportRepo = reportRepo;
    }

    // ✅ GET ALL REPORTS FOR ADMIN
    @GetMapping("/reports")
    public List<Report> getAllReports(HttpSession session) {

        return reportRepo.findAll();
    }

    // ✅ UPDATE STATUS
    @PutMapping("/report/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam String status) {
        Report r = reportRepo.findById(id).orElse(null);

        if (r == null) return "NOT_FOUND";

        r.setStatus(status);
        reportRepo.save(r);

        return "UPDATED";
    }

    // ✅ DELETE REPORT
    @DeleteMapping("/report/{id}")
    public String delete(@PathVariable Long id) {
        if (!reportRepo.existsById(id)) return "NOT_FOUND";

        reportRepo.deleteById(id);
        return "DELETED";
    }
}
