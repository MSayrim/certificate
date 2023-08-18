package com.example.certificateutil.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@Component
@Slf4j
public class PdfUtil {

    public InputStreamResource getFillPdf(Map<String,String> pdfValues, String pdfName) throws Exception {
        log.info("getFillPdf ===> ");

        try (InputStream inputStream = PdfUtil.class.getClassLoader().getResourceAsStream("pdf/"+pdfName)) {
            PDDocument pDDocument = PDDocument.load(inputStream);
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();


            pdfValues.forEach((key, value) -> {
                try {
                    getField(pDAcroForm, key, value);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });


            ByteArrayOutputStream output = new ByteArrayOutputStream();
            pDDocument.save(output);
            pDDocument.close();


            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(output.toByteArray());


            return new InputStreamResource(byteArrayInputStream);


        } catch (IOException e) {
            e.printStackTrace();

            throw new Exception("Exception: Occured error pdf converting");
        }


    }

    private void getField(PDAcroForm pDAcroForm, String fullQualifiedName, String value) throws IOException {
        log.info("getField ===> ");
        if(Objects.nonNull(pDAcroForm.getField(fullQualifiedName))){
            pDAcroForm.getField(fullQualifiedName).setValue(value);
            log.info("pDAcroForm ==> FullyQualifiedName={}, ValueAsString={}",pDAcroForm.getField(fullQualifiedName).getFullyQualifiedName(),pDAcroForm.getField(fullQualifiedName).getValueAsString());
        }else
            log.info("Değerler Pdf üzerinde bulunamadı !! ==> fullQualifiedName={}, value={}",fullQualifiedName,value);
    }
}