package com.admission.admission_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantCreateRequest {
    private String examId;          // 수험번호
    private String name;            // 이름
    private String birthDate;       // 생년월일
    private String department;      // 모집단위
    private String admissionType;   // 전형유형
    private String phoneNumber;     // 연락처
    private String email;           // 이메일
}
