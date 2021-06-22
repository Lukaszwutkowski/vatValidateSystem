package com.tonsberg.devtest.vatvalidator;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

public class Test {

    public static void main(String[] args) throws ValidateVatException {

        VatValidator validator = new VatValidator();
        ValidateVat vat = validator.check("LU", "26375245");

        ValidateVat vat1 = validator.check("PL", "5291805477");

        System.out.println(String.format("%s = %s\n%s\n%s\n%s", vat1.getCodeCountry() + vat1.getNumber(), vat1.isValid() ? "valid" : "invalid", vat1.getName(), vat1.getAddress(), vat1.getDate()));
        System.out.println("");
        System.out.println(String.format("%s = %s\n%s\n%s\n%s", vat.getCodeCountry() + vat.getNumber(), vat.isValid() ? "valid" : "invalid", vat.getName(), vat.getAddress(), vat.getDate()));

    }
}
