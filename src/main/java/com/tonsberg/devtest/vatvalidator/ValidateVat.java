package com.tonsberg.devtest.vatvalidator;

import java.util.Date;

public class ValidateVat {

    private String codeCountry;
    private String number;
    private Date date;
    private boolean valid;
    private String name;
    private String address;

    public ValidateVat(String codeCountry, String number) {
        this.codeCountry = codeCountry;
        this.number = number;
        this.date = new Date();
        this.valid = false;
        this.name = "";
        this.address = "";
    }

    public ValidateVat(String codeCountry, String number, Date date, boolean valid, String name, String address) {
        this.codeCountry = codeCountry;
        this.number = number;
        this.date = date;
        this.valid = valid;
        this.name = name;
        this.address = address;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ValidateVat{" +
                "codeCountry='" + codeCountry + '\'' +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", valid=" + valid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
