package com.JobApplication.multipleibanvalidation.services;

import com.JobApplication.multipleibanvalidation.models.IBANCodeModel;
import com.JobApplication.multipleibanvalidation.models.ValidatedIBANCodeModel;
import com.JobApplication.multipleibanvalidation.models.WebClientForSingleIBANVerification;
import org.springframework.stereotype.Service;

@Service
public class SingleIBANVerificationRequest {

    private WebClientForSingleIBANVerification client = new WebClientForSingleIBANVerification();

    public ValidatedIBANCodeModel sendRequest(IBANCodeModel model) {

        var a =  client
                .getClient()
                .post()
                .uri("/ibanvalidation")
                .bodyValue(model)
                .retrieve()
                .bodyToMono(ValidatedIBANCodeModel.class)
                .block();
        return a;
    }
}
