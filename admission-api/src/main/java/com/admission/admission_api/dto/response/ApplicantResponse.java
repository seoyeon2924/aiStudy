package com.admission.admission_api.dto.response;

import com.admission.admission_api.domain.entity.Applicant;
import com.admission.admission_api.domain.entity.ApplicationStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantResponse {
    private Long id;
    private String examId;
    private String name;
    private String birthDate;
    private String department;
    private String admissionType;
    private String phoneNumber;
    private String email;
    private ApplicationStatus status;

    public static ApplicantResponse from(Applicant applicant) {
        ApplicantResponse response = new ApplicantResponse();
        response.setId(applicant.getId());
        response.setExamId(applicant.getExamId());
        response.setName(applicant.getName());
        response.setBirthDate(applicant.getBirthDate());
        response.setDepartment(applicant.getDepartment());
        response.setAdmissionType(applicant.getAdmissionType());
        response.setPhoneNumber(applicant.getPhoneNumber());
        response.setEmail(applicant.getEmail());
        response.setStatus(applicant.getStatus());
        return response;
    }
}
