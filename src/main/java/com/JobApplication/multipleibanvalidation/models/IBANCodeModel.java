package com.JobApplication.multipleibanvalidation.models;

import org.springframework.web.bind.annotation.ModelAttribute;


public class IBANCodeModel {

    private String fullIBANCode;

    public String getFullIBANNumber() {
        return fullIBANCode;
    }

    public void setFullIBANNumber(String fullIBANCode) {
        this.fullIBANCode = fullIBANCode;
    }
}
