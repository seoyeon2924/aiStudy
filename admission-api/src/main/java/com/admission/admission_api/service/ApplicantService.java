package com.admission.admission_api.service;

import com.admission.admission_api.domain.entity.Applicant;
import com.admission.admission_api.domain.repository.ApplicantRepository;
import com.admission.admission_api.dto.request.ApplicantCreateRequest;
import com.admission.admission_api.domain.entity.ApplicationStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApplicantService {
    
    private final ApplicantRepository applicantRepository;

    public Page<Applicant> getApplicants(String department, String admissionType, String searchText, Pageable pageable) {
        // TODO: 검색 조건 구현
        return applicantRepository.findAll(pageable);
    }

    @Transactional
    public Applicant createApplicant(ApplicantCreateRequest request) {
        log.info("Creating applicant with request: {}", request);
        try {
            // 수험번호 중복 체크
            if (applicantRepository.existsByExamId(request.getExamId())) {
                throw new IllegalArgumentException("이미 존재하는 수험번호입니다.");
            }

            Applicant applicant = new Applicant();
            applicant.setExamId(request.getExamId());
            applicant.setName(request.getName());
            applicant.setBirthDate(request.getBirthDate());
            applicant.setDepartment(request.getDepartment());
            applicant.setAdmissionType(request.getAdmissionType());
            applicant.setPhoneNumber(request.getPhoneNumber());
            applicant.setEmail(request.getEmail());
            applicant.setStatus(ApplicationStatus.PENDING);

            Applicant savedApplicant = applicantRepository.save(applicant);
            log.info("Successfully created applicant: {}", savedApplicant);
            return savedApplicant;
        } catch (Exception e) {
            log.error("Error creating applicant: ", e);
            throw e;
        }
    }

    @Transactional
    public void deleteApplicant(Long id) {
        Applicant applicant = applicantRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 지원자입니다."));
        applicantRepository.delete(applicant);
    }
}
