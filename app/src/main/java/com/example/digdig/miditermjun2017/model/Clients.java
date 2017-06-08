package com.example.digdig.miditermjun2017.model;

import com.example.digdig.miditermjun2017.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by digdig on 17-06-08.
 */

public class Clients  implements Serializable{
    private int pictures;
    private String clientName;
    private String clientAddress;
    private String clientNumber;
    private ArrayList<Cities> cityPrefer;

    public ArrayList<Cities> getCityPrefer() {
        return cityPrefer;
    }

    public void setCityPrefer(ArrayList<Cities> cityPrefer) {
        this.cityPrefer = cityPrefer;
    }

    public Clients(int pictures, String clientName, String clientAddress, String clientNumber) {
        this.pictures = pictures;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientNumber = clientNumber;
    }

    public int getPictures() {
        return pictures;
    }

    public void setPictures(int pictures) {
        this.pictures = pictures;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return clientName +"\n" +clientNumber;
    }
}
