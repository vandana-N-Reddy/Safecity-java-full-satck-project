package com.safecity.repository;

import com.safecity.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {

    // ✅ Add this method for recent reports
    List<Report> findTop100ByOrderByCreatedAtDesc();
}
