package com.JobApplication.multipleibanvalidation.models;

public class ValidatedIBANCodeModel extends IBANCodeModel{

    private ValidationStatus validationStatus;
    private BankStatus recognizableBank;

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public void setValidationStatus(ValidationStatus validationStatus) {
        this.validationStatus = validationStatus;
    }

    public BankStatus getRecognizableBank() {
        return recognizableBank;
    }

    public void setRecognizableBank(BankStatus recognizableBank) {
        this.recognizableBank = recognizableBank;
    }
}
