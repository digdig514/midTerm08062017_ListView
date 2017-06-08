package com.example.digdig.miditermjun2017.model;

import java.io.Serializable;

/**
 * Created by digdig on 17-06-08.
 */

public class Cities implements Serializable {
    private String name;
    private int countryCode;
    private String countryName;

    public Cities(int countryCode,String name, String countryName) {
        this.name = name;
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return  name + " " +countryName;
    }
}
