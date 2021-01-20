package com.JobApplication.multipleibanvalidation.services;

import com.JobApplication.multipleibanvalidation.models.IBANCodeModel;
import com.JobApplication.multipleibanvalidation.models.ValidatedIBANCodesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MultipleIBANVerificationService {

    @Autowired
    RequestFileReader requestReader;
    @Autowired
    SingleIBANVerificationRequest ibanVerificationRequest;
    @Autowired
    FileGeneratorService fileGenerator;

    public byte[] validate(MultipartFile file){
        List<IBANCodeModel> ibanCodes = requestReader.getIBANCodeModels(file);
        ValidatedIBANCodesModel validatedIBANModels = new ValidatedIBANCodesModel();
        validatedIBANModels.setValidatedIBANCodes(new ArrayList<>());
        for(var iban : ibanCodes)
        {
            validatedIBANModels.getValidatedIBANCodes().add(ibanVerificationRequest.sendRequest(iban));
        }
        return fileGenerator.generateResultZip(validatedIBANModels.getValidatedIBANCodes(),
                                               file.getOriginalFilename().replaceFirst("[.][^.]+$", ""));
    }
}
