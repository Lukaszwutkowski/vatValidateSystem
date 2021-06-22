package com.tonsberg.devtest.vatvalidator;

import eu.europa.ec.taxud.vies.services.checkvat.CheckVatService;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceException;
import java.util.Date;

public class VatValidator {

    public static final String[] verificationStatus = {
            "VALID",
            "INVALID",
            "UNAVAIBLE"
    };

    private CheckVatService checkVatService;

    public VatValidator() {
            this.checkVatService = new CheckVatService();
    }

    public ValidateVat check(String codeCountry, String number) throws ValidateVatException {
       /* String correct = vatNumb.replaceFirst("\\W", "").toUpperCase();

        String country = correct.substring(0, 2);
        String number = correct.substring(2);

        */
        if (!countryCodeIsValid(codeCountry) && !vatNumberIsValid(number)){
            return new ValidateVat(codeCountry, number);
        }

        String correctCountryCode = codeCountry.toUpperCase();

        Holder<String> countryCode = new Holder<>(correctCountryCode);
        Holder<String> vatNumber = new Holder<>(number);
        Holder<XMLGregorianCalendar> reqDate = new Holder<>();
        Holder<Boolean> valid = new Holder<>();
        Holder<String> name = new Holder<>();
        Holder<String> address = new Holder<>();

        try {
            checkVatService.getCheckVatPort().checkVat(countryCode, vatNumber, reqDate, valid, name, address);
        } catch (WebServiceException ex) {
            return processException(codeCountry, number, ex);
        }

        Date date = reqDate.value.toGregorianCalendar().getTime();

        return new ValidateVat(codeCountry, number, date, valid.value, name.value, address.value);
    }

    private boolean countryCodeIsValid(String codeCountry) {
        return codeCountry != null && codeCountry.length() == 2;
    }
    private boolean vatNumberIsValid(String number) {
        return number != null && number.matches("[0-9]");
    }

    private ValidateVat processException(String codeCountry, String number, WebServiceException ex) throws ValidateVatException {
        if (ex.getMessage().contains("INVALID_INPUT")) {
            return new ValidateVat(codeCountry, number);
        }
        throw new ValidateVatException(verificationStatus[1]);
    }
}
