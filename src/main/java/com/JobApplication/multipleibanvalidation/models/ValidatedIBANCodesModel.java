package com.JobApplication.multipleibanvalidation.models;

import java.util.List;

public class ValidatedIBANCodesModel {

    private List<ValidatedIBANCodeModel> validatedIBANCodes;

    public List<ValidatedIBANCodeModel> getValidatedIBANCodes() {
        return validatedIBANCodes;
    }

    public void setValidatedIBANCodes(List<ValidatedIBANCodeModel> validatedIBANCodes) {
        this.validatedIBANCodes = validatedIBANCodes;
    }
}
