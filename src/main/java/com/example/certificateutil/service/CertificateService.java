package com.example.certificateutil.service;

import com.example.certificateutil.model.CertificateDTO;
import com.example.certificateutil.util.PdfUtil;
import com.example.certificateutil.util.PdfValueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CertificateService {
    @Autowired
    private PdfUtil pdfUtil;
    @Autowired
    private PdfValueUtil pdfValueUtil;
    public InputStreamResource generateCertificate(CertificateDTO certificateDTO) throws Exception {
        return pdfUtil.getFillPdf(pdfValueUtil.certificatePdfValues(certificateDTO),"certificate.pdf");
    }
}

