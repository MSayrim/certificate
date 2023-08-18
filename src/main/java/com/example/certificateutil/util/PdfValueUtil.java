package com.example.certificateutil.util;


import com.example.certificateutil.model.CertificateDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class PdfValueUtil {

    public Map<String,String> certificatePdfValues(CertificateDTO certificateDTO){
        HashMap<String,String> pdfValues = new HashMap<>();
        if (Objects.nonNull(certificateDTO.getName()) && Objects.nonNull(certificateDTO.getSurname())){
            pdfValues.put("nameSurname",certificateDTO.getName()+" "+certificateDTO.getSurname());
        }
        if (Objects.nonNull(certificateDTO.getDate())){
            pdfValues.put("date",certificateDTO.getDate());
        }
        if (Objects.nonNull(certificateDTO.getSignature())){
            pdfValues.put("signature",certificateDTO.getSignature());
        }
        if (Objects.nonNull(certificateDTO.getCertificateName())){
            pdfValues.put("certificateName",certificateDTO.getCertificateName());
        }
        if (Objects.nonNull(certificateDTO.getCompany())){
            pdfValues.put("company",certificateDTO.getCompany());
        }
        return pdfValues;
    }
}

