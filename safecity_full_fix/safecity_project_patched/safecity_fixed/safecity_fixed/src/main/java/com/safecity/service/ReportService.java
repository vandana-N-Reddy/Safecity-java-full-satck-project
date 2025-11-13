package com.safecity.service;

import com.safecity.model.Report;
import com.safecity.repository.ReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository repo;

    public ReportService(ReportRepository repo){
        this.repo = repo;
    }

    public Report save(Report r){
        return repo.save(r);
    }

    public List<Report> recent(){
        return repo.findTop100ByOrderByCreatedAtDesc();
    }

    public Optional<Report> findById(Long id){
        return repo.findById(id);
    }
}
