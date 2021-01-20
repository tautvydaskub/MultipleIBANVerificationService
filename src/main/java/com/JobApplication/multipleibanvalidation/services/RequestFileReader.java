package com.JobApplication.multipleibanvalidation.services;

import com.JobApplication.multipleibanvalidation.models.IBANCodeModel;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Service
public class RequestFileReader {

    public List<IBANCodeModel> getIBANCodeModels(MultipartFile file)
    {
        String data = convertFileToDataString(file);
        String[] ibans = data.split(System.lineSeparator());
        List<IBANCodeModel> ibanCodes = new ArrayList<>();
        for (String iban : ibans) {
            IBANCodeModel model = new IBANCodeModel();
            model.setFullIBANNumber(iban.replaceAll("\\s",""));
            ibanCodes.add(model);
        }
        return ibanCodes;
    }

    private String convertFileToDataString(MultipartFile file)
    {
        String data = "";
        try {
            InputStream inputStream = file.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            data = new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
