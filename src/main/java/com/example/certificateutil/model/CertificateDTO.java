package com.example.certificateutil.model;

import lombok.Data;

@Data
public class CertificateDTO {
    private String name;
    private String surname;
    private String certificateName;
    private String company;
    private String date;
    private String signature;
}
