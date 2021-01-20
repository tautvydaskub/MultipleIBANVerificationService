package com.JobApplication.multipleibanvalidation.services;

import com.JobApplication.multipleibanvalidation.models.ValidatedIBANCodeModel;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileGeneratorService {

    private static final String CSV_SEPARATOR = ";";

    public byte[] generateResultZip(List<ValidatedIBANCodeModel> validatedIBANs, String fileName) {
        byte[] resultZipBytes = null;
        try {
            File resultZip = File.createTempFile(fileName, ".zip");

            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(resultZip));

            ZipEntry valid = new ZipEntry(fileName + "_valid.csv");
            out.putNextEntry(valid);
            byte[] validIBANData = generateValidIBANCSV(validatedIBANs);
            out.write(validIBANData, 0, validIBANData.length);
            out.closeEntry();

            ZipEntry bank = new ZipEntry(fileName + "_bank.csv");
            out.putNextEntry(bank);
            byte[] ibanBankData = generateFoundBankCSV(validatedIBANs);
            out.write(ibanBankData, 0, ibanBankData.length);
            out.closeEntry();

            out.close();

            resultZipBytes = Files.readAllBytes(resultZip.toPath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultZipBytes;
    }

    private byte[] generateValidIBANCSV(List<ValidatedIBANCodeModel> validatedIBANs) {

        StringBuilder data = new StringBuilder();
        for (ValidatedIBANCodeModel validatedIBAN : validatedIBANs) {

            data.append(validatedIBAN.getFullIBANNumber());
            data.append(CSV_SEPARATOR);
            if (validatedIBAN.getValidationStatus().getStatus().equals("valid")) {
                data.append("true");
            } else {
                data.append("false");
            }
            data.append(System.lineSeparator());
        }
        return data.toString().getBytes(StandardCharsets.UTF_8);
    }

    private byte[] generateFoundBankCSV(List<ValidatedIBANCodeModel> validatedIBANs) {

        StringBuilder data = new StringBuilder();
        for (ValidatedIBANCodeModel validatedIBAN : validatedIBANs) {

            data.append(validatedIBAN.getFullIBANNumber());
            data.append(CSV_SEPARATOR);
            if (validatedIBAN.getRecognizableBank() != null) {
                data.append(validatedIBAN.getRecognizableBank().getRecognizedBank());
            }
            data.append(";" + System.lineSeparator());
        }
        return data.toString().getBytes(StandardCharsets.UTF_8);
    }
}
