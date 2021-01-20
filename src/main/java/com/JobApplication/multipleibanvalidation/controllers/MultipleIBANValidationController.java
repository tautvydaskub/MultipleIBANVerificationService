package com.JobApplication.multipleibanvalidation.controllers;

import com.JobApplication.multipleibanvalidation.services.MultipleIBANVerificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MultipleIBANValidationController {

    @Autowired
    MultipleIBANVerificationService ibanVerificator;

    @PostMapping(value = "/multipleibanvalidation")
    public ResponseEntity createPost(@RequestParam("file") MultipartFile file) {

        return ResponseEntity.ok().body(ibanVerificator.validate(file));
    }


}
