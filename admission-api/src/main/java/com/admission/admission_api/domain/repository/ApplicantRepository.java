package com.admission.admission_api.domain.repository;

import com.admission.admission_api.domain.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ApplicantRepository extends JpaRepository<Applicant, Long>, JpaSpecificationExecutor<Applicant> {
    boolean existsByExamId(String examId);
}
