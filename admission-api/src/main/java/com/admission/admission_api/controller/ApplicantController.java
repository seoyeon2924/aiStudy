package com.admission.admission_api.controller;

import com.admission.admission_api.domain.entity.Applicant;
import com.admission.admission_api.dto.response.ApplicantResponse;
import com.admission.admission_api.dto.request.ApplicantCreateRequest;
import com.admission.admission_api.service.ApplicantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/applicants")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {
    RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, 
    RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.PATCH
})
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService applicantService;

    @GetMapping
    public ResponseEntity<Page<ApplicantResponse>> getApplicants(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String admissionType,
            @RequestParam(required = false) String searchText,
            @PageableDefault(size = 10) Pageable pageable
    ) {
        Page<Applicant> applicants = applicantService.getApplicants(department, admissionType, searchText, pageable);
        Page<ApplicantResponse> response = applicants.map(ApplicantResponse::from);
        return ResponseEntity.ok(response);
    }
     @PostMapping
    public ResponseEntity<ApplicantResponse> createApplicant(@RequestBody ApplicantCreateRequest request) {
        log.info("Creating applicant: {}", request);
        Applicant applicant = applicantService.createApplicant(request);
        return ResponseEntity.ok(ApplicantResponse.from(applicant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        log.info("Deleting applicant with id: {}", id);
        applicantService.deleteApplicant(id);
        return ResponseEntity.noContent().build();
    }
}
