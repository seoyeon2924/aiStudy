package com.admission.admission_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicantSearchRequest {
    private String department;
    private String admissionType;
    private String searchText;
}
