package com.example.certificateutil.controller;

import com.example.certificateutil.model.CertificateDTO;
import com.example.certificateutil.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @PostMapping
    public InputStreamResource generateCertificate(@RequestBody CertificateDTO certificateDTO) throws Exception {
        return certificateService.generateCertificate(certificateDTO);
    }
}
